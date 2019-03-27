package com.dayi.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.controller.BaseController;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
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
    public String addNeedPage(@PathVariable("projectId") String projectId) {
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
    public Result addNeed(MultipartFile needDescriptionFile, MultipartFile needFile,
                              Need need, HttpServletRequest request) {
        //获取真实地址
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String needId = null;
        try {
            //保存需求
            needId = needService.add(need, needDescriptionFile, needFile, realPath, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, needId);
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
    public Result findNeedByProjectId(String projectId, int currentPage, int pageSize) {
        PageInfo<Need> pageInfo = needService.findByProjectId(projectId, currentPage, pageSize);
        return new Result(true, "", pageInfo);
    }

    /**
     * 跳转到需求页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/getNeedPage/{id}")
    public String getNeedPage(@PathVariable("id") String id) {
        return "getNeed";
    }

    /**
     * 获取需求
     *
     * @param id
     * @return
     */
    @RequestMapping("/getNeed")
    @ResponseBody
    @RequiresPermissions("select:need")
    public Result getNeed(String id) {
        Need need = needService.get(id);
        return new Result(true, "", need);
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
    public Result previewNeedFile(String needId, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        JSONObject jsonObject = needService.doPreview(needId, realPath);
        return new Result(true, "", jsonObject);
    }

    /**
     * 删除需求
     *
     * @param needId
     * @param request
     * @return
     */
    @RequestMapping("/deleteNeed")
    @ResponseBody
    public Result deleteNeed(String needId, HttpServletRequest request) {
        //判断非空
        if (null == needId || "".equals(needId)) {
            return new Result(false, "需求Id不能为空");
        }

        //删除需求
        String realPath = request.getSession().getServletContext().getRealPath("/needFile");
        try {
            needService.delete(needId, realPath, getCurrentUser());
        } catch (SystemException e) {
            return new Result(false, e.getMessage());
        }
        return new Result(true, "删除需求成功");
    }
}
