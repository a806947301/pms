package com.dayi.demo.bug.service.impl;

import com.alibaba.fastjson.JSONObject;
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
import com.dayi.demo.util.MailUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BugServiceImpl implements BugService {

    private final static Logger logger = LoggerFactory.getLogger(BugServiceImpl.class);

    @Resource
    private BugDao bugDao;

    @Resource
    private BugDescriptionDao bugDescriptionDao;

    @Resource
    private BugOperatingRecordDao bugOperatingRecordDao;

    @Resource
    private UserService userService;

    @Override
    public String addBug(Bug bug, User currentUser) {
        bug.setId(IdUtils.getPrimaryKey());
        bug.setAddTime(new Date());
        bug.setUpdateTime(new Date());
        bug.setBugStatus(0);
        bug.setNoProcessing(false);
        bug.setBugProposer(currentUser);
        int countAdd = bugDao.addBug(bug);
        if (countAdd != 0) {
            // 发送邮件
            User processer = userService.getUser(bug.getBugProcesser().getId());
            sendMail(processer.getEmail(), "您被指派一个Bug",
                    "您被指派一个Bug，被指派的Bug Id为：" + bug.getId());
            // 添加Bug记录
            BugOperatingRecord record = doPackageOperatingRecord(bug.getId(), bug.getBugProcesser().getId(),
                    0, currentUser);
            bugOperatingRecordDao.addBugOperatingRecord(record);
            return bug.getId();
        }
        return "";
    }

    @Override
    public Map<String, String> bugImgUpload(MultipartFile file, String projectId, String realPath) {
        Map<String, String> result = new HashMap<String, String>(16);
        // 获取文件上传目录，如不存在，创建新目录
        File imgFilePath = new File(realPath + "\\imgs\\" + projectId);
        if (!imgFilePath.exists()) {
            imgFilePath.mkdirs();
        }
        String filename = UUID.randomUUID().toString() + file.getOriginalFilename();
        try {
            file.transferTo(new File(imgFilePath, filename));
            result.put("success", "true");
            // 拼接图片src
            String imgSrc = "/imgs/" + projectId + "/" + filename;
            result.put("file_path", imgSrc);
        } catch (Exception e) {
            result.put("success", "false");
        }
        return result;
    }

    @Override
    public PageInfo<Bug> findBugByProject(int currentPage, int pageSize, String projectId, Date begin, Date end,
                                          int status, String processerId, String proposerId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Bug> list = bugDao.findBugByProject(projectId, begin, end, status, processerId, proposerId);
        PageInfo<Bug> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Bug getBug(String id) {
        return bugDao.getBug(id);
    }

    @Override
    public int doRedesignate(String bugId, String userId, User currentUser) {
        int bugStatus = 0;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, bugStatus, userId, false, updateTime);
        if (countAdd != 0) {
            // 发送邮件
            User processer = userService.getUser(userId);
            StringBuilder emailContent = new StringBuilder();
            emailContent.append(currentUser.getDepartment().getDepartmentName() + "-" + currentUser.getName());
            emailContent.append(" 指派您处理Bug，Bug Id：" + bugId);
            sendMail(processer.getEmail(), "您被指派一个Bug", emailContent.toString());
            // 添加Bug记录
            BugOperatingRecord record = doPackageOperatingRecord(bugId, userId, 0, currentUser);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int doProcessSelf(String bugId, User currentUser) {
        int bugStatus = 1;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, bugStatus, null, false, updateTime);
        if (countAdd != 0) {
            // 添加Bug记录
            BugOperatingRecord record = doPackageOperatingRecord(bugId, "", 1, currentUser);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int doNoProcessing(String bugId, User currentUser) {
        int bugStatus = 2;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, bugStatus, null, true, updateTime);
        if (countAdd != 0) {
            // 发送邮件
            Bug bug = getBug(bugId);
            String mailContent = "您好，您的Bug Id：" + bugId + "，被设置不予处理，请您查收。";
            sendMail(bug.getBugProposer().getEmail(), "您的Bug已处理完毕", mailContent);
            // 添加Bug记录
            BugOperatingRecord record;
            record = doPackageOperatingRecord(bugId, "", 2, currentUser);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int doCloseBug(String bugId, User currentUser) {
        Bug bug = getBug(bugId);
        int bugStatus = 3;
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, bugStatus, null, bug.isNoProcessing(), updateTime);
        if (countAdd != 0) {
            // 发送邮件
            sendMail(bug.getBugProcesser().getEmail(),
                    "您的bug已完成", "您的Bug已完成，bug id：" + bug.getId());
            // 添加Bug记录
            BugOperatingRecord record;
            record = doPackageOperatingRecord(bugId, "", 4, currentUser);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public int addBugDescription(BugDescription bugDescription, User currentUser) {
        bugDescription.setId(IdUtils.getPrimaryKey());
        bugDescription.setAddTime(new Date());
        bugDescription.setUpdateTime(new Date());
        int countAdd = bugDescriptionDao.addBugDescription(bugDescription);
        if (countAdd != 0) {
            // 发送邮件
            Bug bug = getBug(bugDescription.getBugId());
            sendMail(bug.getBugProcesser().getEmail(),
                    "您的Bug已处理完毕", "您的Bug已经被处理，请查收。");
            // 更新bug状态
            bugDao.updateBugStatue(bugDescription.getBugId(), 2,
                    null, false, new Date());
            // 添加Bug记录
            BugOperatingRecord record;
            record = doPackageOperatingRecord(bugDescription.getBugId(), "",
                    3, currentUser);
            bugOperatingRecordDao.addBugOperatingRecord(record);
        }
        return countAdd;
    }

    @Override
    public PageInfo<BugDescription> findDescriptionByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<BugDescription> list = bugDescriptionDao.findByBugId(bugId);
        PageInfo<BugDescription> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<BugOperatingRecord> findBugOperationRecordByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<BugOperatingRecord> list = bugOperatingRecordDao.findBugOperatingRecordByBugId(bugId);
        PageInfo<BugOperatingRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 打包Bug操作记录
     *
     * @param bugId           bug id
     * @param operationUserId 被操作用户的id
     * @param operationNumber 操作数
     * @return
     */
    private BugOperatingRecord doPackageOperatingRecord(String bugId, String operationUserId,
                                                        int operationNumber, User currentUser) {
        BugOperatingRecord record = new BugOperatingRecord();
        //判断是否有操作对象，如果有，则从数据库获取操作对象
        User operationUser;
        if ("".equals(operationUserId)) {
            operationUser = new User();
            operationUser.setId("");
        } else {
            operationUser = userService.getUser(operationUserId);
        }
        record.setOperationUser(operationUser);
        record.setOperationNumber(operationNumber);
        record.setUser(currentUser);
        record.setBugId(bugId);
        record.setUpdateTime(new Date());
        record.setAddTime(new Date());
        record.setId(IdUtils.getPrimaryKey());
        return record;
    }

    /**
     * 发送邮件
     *
     * @param email   邮箱号
     * @param title   邮件标题
     * @param content 邮件内容
     * @return
     */
    private boolean sendMail(String email, String title, String content) {
        try {
            MailUtils.sendMail(email, title, content);
            return true;
        } catch (Exception e) {
            logger.error(MailUtils.class.toString() + "_" + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Map<String, Integer> countBugByProject() {
        HashMap<String, Integer> result = new LinkedHashMap<String, Integer>(32);
        // 多个产品Map封装成一个map
        List<Map<String, Object>> maps = bugDao.countBugByProject();
        for (Map<String, Object> map : maps) {
            result.put((String) map.get("projectId"), ((Long) map.get("bugNumber")).intValue());
        }
        return result;
    }

    @Override
    public Map<String, JSONObject> countBugByProcesser() {
        HashMap<String, JSONObject> result = new LinkedHashMap<String, JSONObject>(32);
        // 多个开发人员bugMap封装成一个map
        List<Map<String, Object>> maps = bugDao.countBugByProcesser();
        for (Map<String, Object> map : maps) {
            // 把开发人员Bug数据存入Json
            JSONObject json = new JSONObject();
            json.put("bugNumber",((Long)map.get("bugNumber")).intValue());
            json.put("designate",((Long)map.get("designate")).intValue());
            json.put("processing",((Long)map.get("processing")).intValue());
            json.put("checking",((Long)map.get("checking")).intValue());
            json.put("finished",((Long)map.get("finished")).intValue());
            result.put((String)map.get("processer"),json);
        }
        return result;
    }

    @Override
    public Map<String, JSONObject> countBugByProposer() {
        HashMap<String, JSONObject> result = new LinkedHashMap<String, JSONObject>(32);
        // 多个测试人员bugMap封装成一个map
        List<Map<String, Object>> maps = bugDao.countBugByProposer();
        for (Map<String, Object> map : maps) {
            // 把测试人员Bug数据存进Json
            JSONObject json = new JSONObject();
            json.put("bugNumber",((Long)map.get("bugNumber")).intValue());
            json.put("designate",((Long)map.get("designate")).intValue());
            json.put("processing",((Long)map.get("processing")).intValue());
            json.put("checking",((Long)map.get("checking")).intValue());
            json.put("finished",((Long)map.get("finished")).intValue());
            result.put((String)map.get("proposer"),json);
        }
        return result;
    }

    @Override
    public int countBugByProjectNoFinished(String projectId) {
        return bugDao.countBugByProjectNoFinished(projectId);
    }
}
