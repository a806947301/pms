package com.dayi.demo.bug.service.impl;

import com.dayi.demo.bug.dao.BugDao;
import com.dayi.demo.bug.dao.BugDescriptionDao;
import com.dayi.demo.bug.dao.BugOperatingRecordDao;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
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

    @Resource
    private BugDescriptionDao bugDescriptionDao;

    @Resource
    private BugOperatingRecordDao bugOperatingRecordDao;

    @Resource
    private UserService userService;

    @Override
    public String addBug(Bug bug) {
        bug.setId(IdUtils.getPrimaryKey());
        bug.setAddTime(new Date());
        bug.setUpdateTime(new Date());
        bug.setBugStatus(0);
        bug.setNoProcessing(false);
        bug.setBugProposer(getCurrentUser());
        int countAdd = bugDao.addBug(bug);
        if(countAdd != 0) {
            /** 添加Bug记录 */
            BugOperatingRecord record = doPackageOperatingRecord(bug.getId(),bug.getBugProcesser().getId(),0);
            bugOperatingRecordDao.addBugOperatingRecord(record);
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
    public PageInfo<Bug> findBugByProject(int currentPage, int pageSize, String projectId) {
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
        int countAdd = bugDao.updateBugStatue(bugId,bugStatus,userId,false,updateTime);
        if(countAdd != 0) {
            /** 添加Bug记录 */
            BugOperatingRecord record = doPackageOperatingRecord(bugId,userId,0);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int doProcessSelf(String bugId) {
        int bugStatus = 1;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, bugStatus, null, false, updateTime);
        if(countAdd != 0) {
            /** 添加Bug记录 */
            BugOperatingRecord record = doPackageOperatingRecord(bugId,"",1);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int doNoProcessing(String bugId) {
        int bugStatus = 2;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId,bugStatus,null,true,updateTime);
        if(countAdd != 0) {
            /** 添加Bug记录 */
            BugOperatingRecord record = doPackageOperatingRecord(bugId,"",2);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int doCloseBug(String bugId) {
        Bug bug = getBug(bugId);
        int bugStatus = 3;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId,bugStatus,null,bug.isNoProcessing(),updateTime);
        if(countAdd != 0) {
            /** 添加Bug记录 */
            BugOperatingRecord record = doPackageOperatingRecord(bugId,"",4);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int addBugDescription(BugDescription bugDescription) {
        bugDescription.setId(IdUtils.getPrimaryKey());
        bugDescription.setAddTime(new Date());
        bugDescription.setUpdateTime(new Date());
        int countAdd = bugDescriptionDao.addBugDescription(bugDescription);
        if(countAdd != 0) {
            /** 更新bug状态 */
            bugDao.updateBugStatue(bugDescription.getBugId(),2,null,false,new Date());
            /** 添加Bug记录 */
            BugOperatingRecord record = doPackageOperatingRecord(bugDescription.getBugId(),"",3);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public PageInfo<BugDescription> findDescriptionByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<BugDescription> list = bugDescriptionDao.findByBugId(bugId);
        PageInfo<BugDescription> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<BugOperatingRecord> findBugOperationRecordByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<BugOperatingRecord> list = bugOperatingRecordDao.findBugOperatingRecordByBugId(bugId);
        PageInfo<BugOperatingRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 获取当前用户
     * @return
     */
    private User getCurrentUser() {
        User user = new User();
        user.setId("0RJA8qMVJNCF");
        return user;
    }

    /**
     * 打包Bug操作记录
     * @param bugId bug id
     * @param operationUserId   被操作用户的id
     * @param operationNumber   操作数
     * @return
     */
    private BugOperatingRecord doPackageOperatingRecord(String bugId,String operationUserId,int operationNumber) {
        BugOperatingRecord record = new BugOperatingRecord();
        User operationUser;
        if("".equals(operationUserId)) {
            operationUser = new User();
            operationUser.setId("");
        } else {
            operationUser = userService.getUser(operationUserId);
        }
        record.setOperationUser(operationUser);
        record.setOperationNumber(operationNumber);
        record.setUser(getCurrentUser());
        record.setBugId(bugId);
        record.setUpdateTime(new Date());
        record.setAddTime(new Date());
        record.setId(IdUtils.getPrimaryKey());
        return record;
    }
}
