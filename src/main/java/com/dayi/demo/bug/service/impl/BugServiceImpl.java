package com.dayi.demo.bug.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.dao.BugDao;
import com.dayi.demo.bug.dao.BugDescriptionDao;
import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.IdUtil;
import com.dayi.demo.util.MailUtil;
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
 * @author WuTong<wut @ pvc123.com>
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
    private UserService userService;

    @Override
    public String add(Bug bug, User currentUser) throws SystemException {
        //设置Bug
        bug.setBugStatus(Bug.Status.DESIGNATE.getValue());
        bug.setNoProcessing(false);
        bug.setBugProposer(currentUser);
        //添加Bug
        int countAdd = bugDao.addBug(bug);
        //添加成功
        if (countAdd != 0) {
            //发送邮件
            User processer = userService.get(bug.getBugProcesser().getId());
            String email = processer.getEmail();
            String title = "您被指派一个Bug";
            String content = "请您登陆主页查看自己被指派的Bug，Bug Id为：" + bug.getId();
            sendMail(email, title, content);
            return bug.getId();
        }
        throw new SystemException("添加失败");
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
    public PageInfo<Bug> findByProject(int currentPage, int pageSize, String projectId, Date begin, Date end,
                                          int status, String processerId, String proposerId) {
        PageHelper.startPage(currentPage, pageSize);
        List<Bug> list = bugDao.findBugByProject(projectId, begin, end, status, processerId, proposerId);
        PageInfo<Bug> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Bug get(String id) {
        return bugDao.getBug(id);
    }

    @Override
    public int doRedesignate(String bugId, String userId, User currentUser) throws SystemException {
        Bug bug = get(bugId);
        // 是否合法处理者 （Bug状态为指派中，且Bug的处理者为当前用户）
        boolean isLegalProcesser = bug.getBugStatus() == Bug.Status.DESIGNATE.getValue() &&
                bug.getBugProcesser().getId().equals(currentUser.getId());
        // 是否合法提出者 （Bug状态为验收中，且Bug提出者为当年用户）
        boolean isLegalProposer = bug.getBugStatus() == Bug.Status.CHECKING.getValue() &&
                bug.getBugProposer().getId().equals(currentUser.getId());
        if(!(isLegalProcesser || isLegalProposer)) {
            throw new SystemException("违法操作");
        }

        //更新Bug状态
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, Bug.Status.DESIGNATE.getValue(),
                userId, false, updateTime);

        //更新成功
        if (countAdd != 0) {
            //发送邮件
            User processer = userService.get(userId);
            String email = processer.getEmail();
            String title = "您被指派一个Bug";
            String content = "请您登陆主页查看自己被指派的Bug，Bug Id为：" + bugId;
            sendMail(email, title, content);
            return countAdd;
        }
        throw new SystemException("重新指派失败");
    }

    @Override
    public int doProcessSelf(String bugId, User currentUser) throws SystemException{
        Bug bug = get(bugId);
        // 是否合法处理者 （Bug状态为指派中，且Bug的处理者为当前用户）
        boolean isLegalProcesser = bug.getBugStatus() == Bug.Status.DESIGNATE.getValue() &&
                bug.getBugProcesser().getId().equals(currentUser.getId());
        if (!isLegalProcesser) {
            throw new SystemException("非法操作");
        }

        //更新Bug状态
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, Bug.Status.PROCESSER.getValue(),
                null, false, updateTime);
        if (countAdd != 0) {
           return countAdd;
        }
        throw new SystemException("操作失败");
    }

    @Override
    public int doNoProcessing(String bugId, User currentUser) throws SystemException {
        Bug bug = get(bugId);
        // 是否合法处理者 （Bug状态为处理中，且Bug的处理者为当前用户）
        boolean isLegalProcesser = bug.getBugStatus() == Bug.Status.PROCESSER.getValue() &&
                bug.getBugProcesser().getId().equals(currentUser.getId());
        if (!isLegalProcesser) {
            throw new SystemException("非法操作");
        }

        //修改Bug状态
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, Bug.Status.CHECKING.getValue(),
                null, true, updateTime);

        if (countAdd != 0) {
            //发送邮箱
            String title = "您的Bug已处理完毕";
            String content = "您好，您的Bug Id：" + bugId + "，被设置不予处理，请您查收。";
            sendMail(bug.getBugProposer().getEmail(), title, content);
            return countAdd;
        }
        throw new SystemException("操作失败");
    }

    @Override
    public int doCloseBug(String bugId, User currentUser) throws SystemException {
        Bug bug = get(bugId);
        //判断是合法用户（Bug当前状态为验收中，且提出者为当前用户）
        boolean isLegalProposer = Bug.Status.CHECKING.getValue() == bug.getBugStatus() &&
                bug.getBugProposer().getId().equals(currentUser.getId());
        if(!isLegalProposer) {
            throw new SystemException("非法操作");
        }

        //修改Bug状态
        Date updateTime = new Date();
        int countAdd = bugDao.updateBugStatue(bugId, Bug.Status.FINISHED.getValue(),
                null, bug.isNoProcessing(), updateTime);

        if (countAdd != 0) {
            //发送邮件
            String email = bug.getBugProcesser().getEmail();
            String title = "您的Bug已完成";
            String content = "您的Bug已完成，bug id：" + bugId;
            sendMail(email, title, content);
            return countAdd;
        }
        throw new SystemException("操作失败");
    }

    @Override
    public int addBugDescription(BugDescription bugDescription, User currentUser) throws SystemException{
        Bug bug = get(bugDescription.getBugId());
        // 判断是否合法处理者（Bug当前状态为处理中，且处理者为当前用户）
        boolean isLegalProcesser = bug.getBugStatus() == Bug.Status.PROCESSER.getValue() &&
                bug.getBugProcesser().getId().equals(currentUser.getId());
        if(!isLegalProcesser) {
            throw new SystemException("非法操作");
        }

        // 添加Bug说明
        bugDescription.setId(IdUtil.getPrimaryKey());
        bugDescription.setAddTime(new Date());
        bugDescription.setUpdateTime(new Date());
        int countAdd = bugDescriptionDao.addBugDescription(bugDescription);
        if (countAdd != 0) {
            //更新Bug状态
            int countUpdate = bugDao.updateBugStatue(bugDescription.getBugId(), Bug.Status.CHECKING.getValue(),
                    null, false, new Date());
            if (0 == countUpdate) {
                throw new SystemException("操作失败");
            }

            //发送邮件
            String email = bug.getBugProposer().getEmail();
            String title = "您的Bug已处理完毕";
            String content = "您的Bug已经被处理，请查收。";
            sendMail(email, title, content);
            return countAdd;
        }
        throw new SystemException("操作失败");
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
            MailUtil.sendMail(email, title, content);
            return true;
        } catch (Exception e) {
            logger.error(MailUtil.class.toString() + "_" + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public PageInfo<BugDescription> findDescriptionByBugId(String bugId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<BugDescription> list = bugDescriptionDao.findByBugId(bugId);
        PageInfo<BugDescription> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }



    @Override
    public Map<String, JSONObject> countBugByProject() {
        HashMap<String, JSONObject> result = new LinkedHashMap<String, JSONObject>(32);
        // 多个产品Map封装成一个map
        List<Map<String, Object>> maps = bugDao.countBugByProject();
        for (Map<String, Object> map : maps) {
            JSONObject project = new JSONObject();
            project.put("bugNumber", ((Long) map.get("bugNumber")).intValue());
            project.put("allBug", ((Long) map.get("allBug")).intValue());
            result.put((String) map.get("projectId"), project);
        }
        return result;
    }
    @Override
    public Map<String, JSONObject> countBugByProcesser() {
        HashMap<String, JSONObject> result = new LinkedHashMap<String, JSONObject>(32);
        // 多个开发人员bugMap
        List<Map<String, Object>> maps = bugDao.countBugByProcesser();
        for (Map<String, Object> map : maps) {
            // 把开发人员Bug数据存入Json
            JSONObject json = new JSONObject();
            json.put("bugNumber", ((Long) map.get("bugNumber")).intValue());
            json.put("designate", ((Long) map.get("designate")).intValue());
            json.put("processing", ((Long) map.get("processing")).intValue());
            json.put("checking", ((Long) map.get("checking")).intValue());
            json.put("finished", ((Long) map.get("finished")).intValue());
            //测试人员Json存进队列
            result.put((String) map.get("processer"), json);
        }
        return result;
    }

    @Override
    public Map<String, JSONObject> countBugByProposer() {
        HashMap<String, JSONObject> result = new LinkedHashMap<String, JSONObject>(32);
        // 多个测试人员bugMap
        List<Map<String, Object>> maps = bugDao.countBugByProposer();
        for (Map<String, Object> map : maps) {
            // 把测试人员Bug数据封装Json
            JSONObject json = new JSONObject();
            json.put("bugNumber", ((Long) map.get("bugNumber")).intValue());
            json.put("designate", ((Long) map.get("designate")).intValue());
            json.put("processing", ((Long) map.get("processing")).intValue());
            json.put("checking", ((Long) map.get("checking")).intValue());
            json.put("finished", ((Long) map.get("finished")).intValue());
            //测试人员Json存进队列
            result.put((String) map.get("proposer"), json);
        }
        return result;
    }

    @Override
    public int countBugByProjectNoFinished(String projectId) {
        return bugDao.countBugByProjectNoFinished(projectId);
    }

    @Override
    public PageInfo<Bug> findByUserDesignee(String userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Bug> list = bugDao.findBugByUserDesignee(userId);
        PageInfo<Bug> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
