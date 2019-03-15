package com.dayi.demo.need.service;

import com.dayi.demo.need.model.Need;
import com.dayi.demo.user.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-04
 */
public interface NeedService {

    /**
     * 添加需求
     * @param needDescriptionFile   需求描述文件
     * @param needFile  需求文件
     * @param need  需求
     * @param realPath  本地真实路径
     * @param currentUser   当前用户
     * @return
     */
    String addNeed(MultipartFile needDescriptionFile, MultipartFile needFile, Need need,
                   String realPath, User currentUser) throws Exception;

    /**
     * 分页查找项目下的需求
     *
     * @param projectId 项目Id
     * @param currentPage   当前页数
     * @param pageSize  每页的size
     * @return
     */
    PageInfo<Need> findNeedByProjectId(String projectId, int currentPage, int pageSize);

    /**
     * 根据id，查找指定需求
     *
     * @param id
     * @return
     */
    Need getNeed(String id);
}
