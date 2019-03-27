package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.Result;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Bug模块控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
@Controller
@RequestMapping("/bug")
public class BugController extends BaseController {

    @Resource
    private BugService bugService;

    @Resource
    BugOperatingRecordService bugOperatingRecordService;

    /**
     * 添加bug
     *
     * @param bug
     * @return
     */
    @RequestMapping("/addBug")
    @ResponseBody
    @RequiresPermissions("add:bug")
    public Result addBug(Bug bug) {
        //判断是否有属性为空
        if (Bug.hasEmpty(bug, false, false)) {
            return new Result(false, "字段不能为空");
        }

        //添加Bug
        User user = getCurrentUser();
        String bugId = null;
        try {
            //添加Bug，并返回Bug的ID
            bugId = bugService.add(bug, user);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        //如果添加成功，则返回Bug Id
        boolean addSuccess = (null != bugId && (!"".equals(bugId)));
        return new Result(addSuccess, bugId, "添加失败", "");
    }

    /**
     * 跳转添加bug页面
     *
     * @return
     */
    @RequestMapping("/addBugPage/{productId}/{projectId}")
    public String addBugPage(@PathVariable("productId") String productId, @PathVariable("projectId") String projectId) {
        return "addBug";
    }

    /**
     * Bug图片上传
     *
     * @param file
     * @param projectId
     * @param request
     * @return
     */
    @RequestMapping("/bugImgUpload")
    @ResponseBody
    public Map<String, String> bugImgUpload(MultipartFile file, String projectId, HttpServletRequest request) {
        // 校验
        if (null == file) {
            Map<String, String> map = new HashMap<String, String>(16);
            map.put("success", "false");
            map.put("msg", "图片上传失败");
            return map;
        }
        //获取真实路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        Map<String, String> stringStringMap = bugService.doBugImgUpload(file, projectId, realPath);

        return stringStringMap;
    }

    /**
     * 分页查找项目下的bug
     *
     * @param currentPage   当前页数
     * @param pageSize  每页记录数
     * @param projectId 项目id，如不筛选则为null
     * @param begin 开始时间，如不筛选则为null
     * @param end   结束时间，如不筛选则为null
     * @param status    Bug状态，如不筛选则为-1
     * @param processerId   Bug处理者Id，如不筛选则为null
     * @param proposerId    Bug提出者Id，如不筛选则为null
     * @return
     */
    @RequestMapping("/findBugByProject")
    @ResponseBody
    @RequiresPermissions("select:bug")
    public Result findBugByProject(int currentPage, int pageSize, String projectId, Date begin,
                                          Date end, int status, String processerId, String proposerId) {
        PageInfo<Bug> pageInfo = bugService.findByProject(currentPage, pageSize, projectId,
                begin, end, status, processerId, proposerId);
        return new Result(true, "", pageInfo);
    }

    /**
     * 跳转bug页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getBugPage/{id}")
    public String getBugPage(@PathVariable("id") String id) {
        return "getBug";
    }

    /**
     * 根据id 获取 Bug
     *
     * @param id
     * @return
     */
    @RequestMapping("/getBug")
    @ResponseBody
    @RequiresPermissions("select:bug")
    public Result getBug(String id) {
        Bug bug = bugService.get(id);
        return new Result(true, "", bug);
    }

    /**
     * 更新Bug状态
     *
     * @param bug
     * @return
     */
    @RequestMapping("/updateBugStatus")
    @ResponseBody
    public Result updateBugStatus(Bug bug) {
        try {
            bugService.updateStatus(bug, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "成功！");
    }

    /**
     * 添加Bug说明
     *
     * @param bugDescription
     * @return
     */
    @RequestMapping("/addBugDescription")
    @ResponseBody
    public Result addBugDescription(BugDescription bugDescription) {
        //判断非空
        if (BugDescription.hasEmpty(bugDescription, false)) {
            return new Result(false, "字段不能为空");
        }

        //添加说明
        User user = getCurrentUser();
        try {
            bugService.addBugDescription(bugDescription, user);
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "添加说明成功");
    }

    /**
     * 分页查找指定Bug的说明
     *
     * @param bugId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findDescription")
    @ResponseBody
    public Result findDescription(String bugId, int currentPage, int pageSize) {
        PageInfo<BugDescription> pageInfo = bugService.findDescriptionByBugId(bugId, currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 分页查找Bug操作记录
     *
     * @param bugId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findBugOperatingRecord")
    @ResponseBody
    public Result findBugOperatingRecord(String bugId, int currentPage, int pageSize) {
        PageInfo<BugOperatingRecord> pageInfo = bugOperatingRecordService.findByBugId(bugId, currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 获取指定项目没完成Bug数
     *
     * @param id
     * @return
     */
    @RequestMapping("/countBugByProjectNoFinished")
    @ResponseBody
    public Result countBugByProjectNoFinished(String id) {
        int countBug = bugService.countBugByProjectNoFinished(id);
        return new Result(true, "", countBug);
    }

    /**
     * 获取当前用户被指派的Bug
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findBugByCurrentUserDesignee")
    @ResponseBody
    public Result findBugByCurrentUserDesignee(int currentPage, int pageSize) {
        User user = getCurrentUser();
        PageInfo<Bug> pageInfo = bugService.findByUserDesignee(user.getId(), currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 更新Bug信息
     *
     * @param bug
     * @return
     */
    @RequestMapping("/updateBug")
    @ResponseBody
    public Result updateBug(Bug bug) {
        //判断非空
        if (BaseEntity.hasEmpty(bug, true)) {
            return new Result(false, "id不能为空");
        }
        String title = bug.getBugTitle();
        if (null == title || "".equals(title)) {
            return new Result(false, "标题不能为空");
        }
        String content = bug.getBugContent();
        if (null == content || "".equals(content)) {
            return new Result(false, "内容不能为空");
        }

        //更新Bug
        try {
            bugService.update(bug, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "更新Bug成功");
    }

    /**
     * 删除Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/deleteBug")
    @ResponseBody
    public Result deleteBug(String bugId) {
        //判断非空
        if (null == bugId || "".equals(bugId)) {
            return new Result(false, "Bug id不能为空");
        }

        //删除Bug
        try {
            bugService.delete(bugId, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除Bug成功");
    }
}
