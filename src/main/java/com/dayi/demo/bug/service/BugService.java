package com.dayi.demo.bug.service;

import com.dayi.demo.bug.model.Bug;
import com.dayi.demo.bug.model.BugDescription;
import com.dayi.demo.bug.model.BugOperatingRecord;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author wut
 */
public interface BugService {

    /**
     * 添加bug
     * @param bug
     * @return
     */
    String addBug(Bug bug);

    /**
     * 上传bug图片
     * @param file 图片文件
     * @param projectId 项目id
     * @param realPath  webapp地址
     * @return
     */
    Map<String,String> bugImgUpload(MultipartFile file, String projectId,String realPath);

    /**
     * 分页查看产品下的bug
     * @param currentPage
     * @param pageSize
     * @param projectId
     * @return
     */
    PageInfo<Bug> findBugByProject(int currentPage,int pageSize,String projectId);

    /**
     * 根据id获取Bug
     * @param id
     * @return
     */
    Bug getBug(String id);

    /**
     * 重新指派Bug
     * @param bugId
     * @param userId
     * @return
     */
    int doRedesignate(String bugId,String userId);

    /**
     * 设置自己处理Bug
     * @param bugId
     * @return
     */
    int doProcessSelf(String bugId);

    /**
     * 设置不予处理ug
     * @param bugId
     * @return
     */
    int doNoProcessing(String bugId);

    /**
     * 设置关闭Bug
     * @param bugId
     * @return
     */
    int doCloseBug(String bugId);

    /**
     * 添加Bug说明
     * @param bugDescription
     * @return
     */
    int addBugDescription(BugDescription bugDescription);

    /**
     * 分页查找Bug说明
     * @param bugId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<BugDescription> findDescriptionByBugId(String bugId,int currentPage,int pageSize);

    /**
     * 分页查找Bug操作记录
     * @param bugId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<BugOperatingRecord> findBugOperationRecordByBugId(String bugId,int currentPage,int pageSize);
}
