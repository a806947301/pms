package com.dayi.demo.need.service;

import com.dayi.demo.need.model.Need;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author wut
 * @Date 2019-03-04
 */
public interface NeedService {

    /**
     * 添加需求
     * @param needDescriptionFile   需求描述文件
     * @param needFile  需求文件
     * @param need
     * @return
     */
    String addNeed(MultipartFile needDescriptionFile, MultipartFile needFile, Need need,String realPath);

    /**
     * 分页查找项目下的需求
     * @param projectId
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Need> findNeedByProjectId(String projectId,int currentPage,int pageSize);

    /**
     * 根据id，查找指定需求
     * @param id
     * @return
     */
    Need getNeed(String id);
}
