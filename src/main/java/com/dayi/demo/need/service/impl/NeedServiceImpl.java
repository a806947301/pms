package com.dayi.demo.need.service.impl;

import com.dayi.demo.need.dao.NeedDao;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Author wut
 * @Date 2019-03-04
 */
@Service
public class NeedServiceImpl implements NeedService {

    @Resource
    private NeedDao needDao;

    @Override
    public String addNeed(MultipartFile needDescriptionFile, MultipartFile needFile, Need need,String realPath) {
        need.setId(IdUtils.getPrimaryKey());
        /** 处理需求说明文件 */
        String descriptionFilepath = "";
        String descriptionFilename = "";
        if(null != needDescriptionFile) {
            descriptionFilename = needDescriptionFile.getOriginalFilename();
            descriptionFilepath = doSaveFile(needDescriptionFile,need.getId(),realPath);
        }
        need.setDescriptionFilepath(descriptionFilepath);
        need.setDescriptionFilename(descriptionFilename);

        /** 处理需求文件 */
        String needFilepath = "";
        String needFilename = "";
        if(null != needFile) {
            needFilename = needFile.getOriginalFilename();
            needFilepath = doSaveFile(needFile,need.getId(),realPath);
        }
        need.setNeedFilepath(needFilepath);
        need.setNeedFilename(needFilename);

        need.setAddTime(new Date());
        need.setUpdateTime(new Date());
        need.setUser(getCurrentUser());
        int countAdd = needDao.addNeed(need);
        if(countAdd != 0) {
            return need.getId();
        }
        return "";
    }

    /**
     * 保存文件
     * @param file
     * @param needId
     * @param realPath
     * @return  文件真实地址
     */
    private String doSaveFile(MultipartFile file,String needId,String realPath) {
        /** 获取文件上传目录，如不存在，创建新目录 */
        File newFilePath = new File(realPath+"\\needFile\\"+needId);
        if(!newFilePath.exists()) {
            newFilePath.mkdirs();
        }
        String filename = file.getOriginalFilename();
        try {
            file.transferTo(new File(newFilePath,filename));
            return "\\needFile\\"+ needId + "\\" + filename;
        }catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取当前用户
     * @return
     */
    private User getCurrentUser() {
        User user = new User();
        user.setId("0RJpq3vXMd0m");
        return user;
    }

    @Override
    public PageInfo<Need> findNeedByProjectId(String projectId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Need> list = needDao.findNeedByprojectId(projectId);
        PageInfo<Need> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Need getNeed(String id) {
        return needDao.getNeed(id);
    }
}
