package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
@Controller
@RequestMapping("/bug")
public class BugController {

    @Resource
    private BugService bugService;

    /**
     * 添加bug
     *
     * @param bug
     * @return
     */
    @RequestMapping("/addBug")
    @ResponseBody
    @RequiresPermissions("add:bug")
    public JSONObject addBug(Bug bug) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String bugId = bugService.addBug(bug, user);
        boolean addSuccess = (null != bugId && (!"".equals(bugId))) ;
        return JsonUtil.packageJson(addSuccess,bugId,"添加失败");
    }

    /**
     * 跳转添加bug页面
     *
     * @return
     */
    @RequestMapping("/addBugPage/{productId}/{projectId}")
    public String addBugPage(String productId, String projectId) {
        return "addBug";
    }

    @RequestMapping("/bugImgUpload")
    @ResponseBody
    public Map<String, String> bugImgUpload(MultipartFile file, String projectId, HttpServletRequest request) {
        // 校验
        if (file == null) {
            Map<String, String> map = new HashMap<String, String>(16);
            map.put("success", "false");
            map.put("msg", "图片上传失败");
            System.out.println("file is null");
            return map;
        }
        String realPath = request.getSession().getServletContext().getRealPath("/");
        return bugService.bugImgUpload(file, projectId, realPath);
    }

    /**
     * 分页查找项目下的bug
     *
     * @param currentPage
     * @param projectId
     * @return
     */
    @RequestMapping("/findBugByProject")
    @ResponseBody
    @RequiresPermissions("select:bug")
    public PageInfo<Bug> findBugByProject(int currentPage, int pageSize, String projectId, Date begin,
                                          Date end, int status, String processerId, String proposerId) {
        return bugService.findBugByProject(currentPage, pageSize, projectId, begin, end, status, processerId, proposerId);
    }

    /**
     * 跳转bug页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getBugPage/{productId}/{projectId}/{id}")
    public String getBugPage(String productId, String projectId, String id) {
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
    public Bug getBug(String id) {
        return bugService.getBug(id);
    }

    /**
     * 重新指派
     *
     * @param bugId
     * @param userId
     * @return
     */
    @RequestMapping("/redesignate")
    @ResponseBody
    public int redesignate(String bugId, String userId) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return bugService.doRedesignate(bugId, userId, user);
    }

    /**
     * 设置自己处理Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/processSelf")
    @ResponseBody
    public int processSelf(String bugId) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return bugService.doProcessSelf(bugId, user);
    }

    /**
     * 设置不予处理Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/noProcessing")
    @ResponseBody
    public int noProcessing(String bugId) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return bugService.doNoProcessing(bugId, user);
    }

    /**
     * 设置关闭Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/closeBug")
    @ResponseBody
    public int closeBug(String bugId) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return bugService.doCloseBug(bugId, user);
    }

    /**
     * 添加Bug说明
     *
     * @param bugDescription
     * @return
     */
    @RequestMapping("/addBugDescription")
    @ResponseBody
    public int addBugDescription(BugDescription bugDescription) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return bugService.addBugDescription(bugDescription, user);
    }

    /**
     * 分页查找Bug说明
     *
     * @param bugId
     * @param currentPage
     * @return
     */
    @RequestMapping("/findDescription")
    @ResponseBody
    public PageInfo<BugDescription> findDescription(String bugId, int currentPage, int pageSize) {
        return bugService.findDescriptionByBugId(bugId, currentPage, pageSize);
    }

    /**
     * 分页查找Bug操作记录
     *
     * @param bugId
     * @param currentPage
     * @return
     */
    @RequestMapping("/findBugOperatingRecord")
    @ResponseBody
    public PageInfo<BugOperatingRecord> findBugOperatingRecord(String bugId, int currentPage) {
        return bugService.findBugOperationRecordByBugId(bugId, currentPage, 5);
    }

    /**
     * 获取指定项目没完成Bug数
     *
     * @param id
     * @return
     */
    @RequestMapping("/countBugByProjectNoFinished")
    @ResponseBody
    public int countBugByProjectNoFinished(String id) {
        return bugService.countBugByProjectNoFinished(id);
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
    @RequiresPermissions("select:bug")
    public PageInfo<Bug> findBugByCurrentUserDesignee(int currentPage, int pageSize) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return bugService.findBugByUserDesignee(user.getId(), currentPage, pageSize);
    }

}
