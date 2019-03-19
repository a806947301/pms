package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
import com.dayi.demo.util.JsonUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 需求控制器
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-04
 */
@Controller
@RequestMapping("/need")
public class NeedController extends BaseController {

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
        //获取真实地址
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String needId = null;
        try {
            //保存需求
            needId = needService.add(need, needDescriptionFile, needFile, realPath, getCurrentUser());
        } catch (SystemException e) {
            return JsonUtil.packageJson(false, "", e.getMessage());
        }
        return JsonUtil.packageJson(true, needId, "");
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
    public PageInfo<Need> findNeedByProjectId(String projectId, int currentPage, int pageSize) {
        return needService.findByProjectId(projectId, currentPage, pageSize);
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
        return needService.get(id);
    }

    /**
     * 在线预览需求文件
     *
     * @param needId
     * @param request
     * @return
     */
    @RequestMapping("/previewNeedFile")
    @ResponseBody
    public JSONObject previewNeedFile(String needId, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        return needService.doPreview(needId, realPath);
    }
}
