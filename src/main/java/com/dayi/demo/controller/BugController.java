package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugOperatingRecordService;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Bug控制器
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
@Controller
@RequestMapping("/bug")
public class BugController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(BugController.class);

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
    public JSONObject addBug(Bug bug) {
        //判断是否有属性为空
        if (Bug.hasEmpty(bug, false, false)) {
            return JsonUtil.packageJson(false, "", "有字段为空");
        }
        User user = getCurrentUser();
        String bugId = null;
        boolean success = true;
        try {
            bugId = bugService.add(bug, user);
        } catch (Exception e) {
            logger.error(BugController.class.toString() + "_" + e.getMessage(), e);
        }
        boolean addSuccess = (null != bugId && (!"".equals(bugId)));
        return JsonUtil.packageJson(addSuccess, bugId, "添加失败");
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
        //获取真实路径
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
        return bugService.findByProject(currentPage, pageSize, projectId,
                begin, end, status, processerId, proposerId);
    }

    /**
     * 跳转bug页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getBugPage/{id}")
    public String getBugPage(String id) {
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
        return bugService.get(id);
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
    public JSONObject redesignate(String bugId, String userId) {
        //判断是否为空
        if (null == bugId || "".equals(bugId)) {
            return JsonUtil.packageJson(false, "", "Bug Id不能为空");
        }
        if (null == userId || "".equals(userId)) {
            return JsonUtil.packageJson(false, "", "被指派人不能为空");
        }

        //执行重新指派
        User user = getCurrentUser();
        try {
            bugService.doRedesignate(bugId, userId, user);
        } catch (Exception e) {
            logger.error(BugController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, "重新指派成功", "");
    }

    /**
     * 设置自己处理Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/processSelf")
    @ResponseBody
    public JSONObject processSelf(String bugId) {
        //判断是否为空
        if (null == bugId || "".equals(bugId)) {
            return JsonUtil.packageJson(false, "", "Bug Id不能为空");
        }

        //执行自己处理Bug
        User user = getCurrentUser();
        boolean success = true;
        try {
            bugService.doProcessSelf(bugId, user);
        } catch (Exception e) {
            logger.error(BugController.class.toString() + "_" + e.getMessage(), e);
            success = false;
        }
        return JsonUtil.packageJson(success, "设置自己处理", "设置自己处理失败");
    }

    /**
     * 设置不予处理Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/noProcessing")
    @ResponseBody
    public JSONObject noProcessing(String bugId) {
        //判断非空
        if (null == bugId || "".equals(bugId)) {
            return JsonUtil.packageJson(false, "", "Bug Id不能为空");
        }

        //设置不予处理
        boolean success = true;
        User user = getCurrentUser();
        try {
            bugService.doNoProcessing(bugId, user);
        } catch (Exception e) {
            logger.error(BugController.class.toString() + "_" + e.getMessage(), e);
            success = false;
        }
        return JsonUtil.packageJson(true, "不予处理Bug", "操作失败");
    }

    /**
     * 设置关闭Bug
     *
     * @param bugId
     * @return
     */
    @RequestMapping("/closeBug")
    @ResponseBody
    public JSONObject closeBug(String bugId) {
        //判断非空
        if (null == bugId || "".equals(bugId)) {
            return JsonUtil.packageJson(false, "", "Bug Id不能为空");
        }

        //关闭Bug
        User user = getCurrentUser();
        try {
            bugService.doCloseBug(bugId, user);
        } catch (Exception e) {
            logger.error(BugController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", "操作失败");
        }
        return JsonUtil.packageJson(true, "关闭Bug成功", "");
    }

    /**
     * 添加Bug说明
     *
     * @param bugDescription
     * @return
     */
    @RequestMapping("/addBugDescription")
    @ResponseBody
    public JSONObject addBugDescription(BugDescription bugDescription) {
        if (BugDescription.hasEmpty(bugDescription, false)) {
            return JsonUtil.packageJson(false, "", "有字段为空，添加失败");
        }
        User user = getCurrentUser();
        try {
            bugService.addBugDescription(bugDescription, user);
        } catch (Exception e) {
            logger.error(BugController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false, "", "操作失败");
        }
        return JsonUtil.packageJson(true, "添加说明成功", "");
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
    public PageInfo<BugOperatingRecord> findBugOperatingRecord(String bugId, int currentPage, int pageSize) {
        return bugOperatingRecordService.findByBugId(bugId, currentPage, pageSize);
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
    public PageInfo<Bug> findBugByCurrentUserDesignee(int currentPage, int pageSize) {
        User user = getCurrentUser();
        return bugService.findByUserDesignee(user.getId(), currentPage, pageSize);
    }

}
