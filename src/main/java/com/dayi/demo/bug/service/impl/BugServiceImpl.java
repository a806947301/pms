package com.dayi.demo.bug.service.impl;

import com.dayi.demo.bug.dao.BugDao;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * @Author wut
 */
@Service
public class BugServiceImpl implements BugService {

    @Resource
    private BugDao bugDao;

    @Override
    public String addBug(Bug bug) {
        bug.setId(IdUtils.getPrimaryKey());
        bug.setAddTime(new Date());
        bug.setUpdateTime(new Date());
        bug.setBugStatus(0);
        bug.setNoProcessing(false);
        int countAdd = bugDao.addBug(bug);
        if(countAdd != 0) {
            return bug.getId();
        }
        return "";
    }

    @Override
    public Map<String, String> bugImgUpload(MultipartFile file, String projectId, String realPath) {
        Map<String,String> result = new HashMap<String,String>();
        /** 获取文件上传目录，如不存在，创建新目录 */
        File imgFilePath = new File(realPath+"\\imgs\\"+projectId);
        if(!imgFilePath.exists()) {
            imgFilePath.mkdirs();
        }
        String filename = UUID.randomUUID().toString()+file.getOriginalFilename();
        try {
            file.transferTo(new File(imgFilePath,filename));
            result.put("success","true");
            /** 拼接图片src */
            String imgSrc = "/imgs/"+projectId+"/"+filename;
            result.put("file_path", imgSrc);
        }catch (Exception e) {
            result.put("success", "false");
        }
        return result;
    }

    @Override
    public PageInfo<Bug> findBugByProjectPage(int currentPage, int pageSize, String projectId) {
        PageHelper.startPage(currentPage,pageSize);
        List<Bug> list = bugDao.findBugByProject(projectId);
        PageInfo<Bug> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Bug getBug(String id) {
        return bugDao.getBug(id);
    }

    @Override
    public int doRedesignate(String bugId, String userId) {
        int bugStatus = 0;
        Date updateTime = new Date();
        return bugDao.updateBugStatue(bugId,bugStatus,userId,false,updateTime);
    }

    @Override
    public int doProcessSelf(String bugId) {
        int bugStatus = 1;
        Date updateTime = new Date();
        return bugDao.updateBugStatue(bugId,bugStatus,null,false,updateTime);
    }

    @Override
    public int doNoProcessing(String bugId) {
        int bugStatus = 2;
        Date updateTime = new Date();
        return bugDao.updateBugStatue(bugId,bugStatus,null,true,updateTime);
    }

    @Override
    public int doCloseBug(String bugId) {
        Bug bug = getBug(bugId);
        int bugStatus = 3;
        Date updateTime = new Date();
        return bugDao.updateBugStatue(bugId,bugStatus,null,bug.isNoProcessing(),updateTime);
    }
}
