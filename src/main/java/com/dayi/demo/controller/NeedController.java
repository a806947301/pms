package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
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

/**
 * @author WuTong<wut   @   pvc123.com>
 * @date 2019-03-04
 */
@Controller
@RequestMapping("/need")
public class NeedController {

    Logger logger = LoggerFactory.getLogger(NeedController.class);

    @Resource
    private NeedService needService;

    /**
     * 跳转添加需求页面
     *
     * @param projectId
     * @return
     */
    @RequestMapping("/addNeedPage/{projectId}")
    public String addNeedPage(String projectId) {
        return "addNeed";
    }

    /**
     * 添加需求
     *
     * @param needDescriptionFile 需求说明文件
     * @param needFile            需求文件
     * @param need
     * @param request
     * @return
     */
    @RequestMapping("/addNeed")
    @ResponseBody
    @RequiresPermissions("add:need")
    public JSONObject addNeed(MultipartFile needDescriptionFile, MultipartFile needFile,
                              Need need, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        boolean addSuccess = false;
        String needId = null;
        try {
            needId = needService.addNeed(needDescriptionFile, needFile, need, realPath, getCurrentUser());
            addSuccess = (null != needId && (!"".equals(needId)));
        } catch (Exception e) {
            logger.error(NeedController.class.toString() + "_" + e.getMessage(), e);
            return JsonUtil.packageJson(false,"","保存文件失败");
        }
        return JsonUtil.packageJson(addSuccess, needId, "添加失败");
    }

    /**
     * 分页查找项目的需求
     *
     * @param projectId
     * @param currentPage
     * @return
     */
    @RequestMapping("/findNeedByProjectId")
    @ResponseBody
    @RequiresPermissions("select:need")
    public PageInfo<Need> findNeedByProjectId(String projectId, int currentPage) {
        return needService.findNeedByProjectId(projectId, currentPage, 5);
    }

    /**
     * 跳转到需求页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getNeedPage/{id}")
    public String getNeedPage(String id) {
        return "getNeed";
    }

    /**
     * 查找需求数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/getNeed")
    @ResponseBody
    @RequiresPermissions("select:need")
    public Need getNeed(String id) {
        return needService.getNeed(id);
    }

    /**
     * 获取当前用户
     *
     * @return
     */
    private User getCurrentUser() {
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }
}
