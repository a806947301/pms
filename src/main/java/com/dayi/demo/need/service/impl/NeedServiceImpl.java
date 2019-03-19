package com.dayi.demo.need.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.need.dao.NeedDao;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.need.service.NeedService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.util.WordUtil;
import com.dayi.demo.util.ZipUtil;
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
 * @author WuTong<wut @ pvc123.com>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              @                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               pvc123.com>
 * @date 2019-03-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NeedServiceImpl implements NeedService {

    Logger logger = LoggerFactory.getLogger(NeedServiceImpl.class);

    @Resource
    private NeedDao needDao;

    /**
     * 保存转换后html文件所需的图片保存的相对路径
     */
    private static final String IMAGE_FILE_PATH = "image";

    @Override
    public String add(Need need, MultipartFile needDescriptionFile, MultipartFile needFile,
                      String realPath, User currentUser) throws SystemException {
        if (null == needDescriptionFile) {
            throw new SystemException("需求说明文件不能为空");
        }
        if (null == needFile) {
            throw new SystemException("需求文件不能为空");
        }
        need.setUser(currentUser);

        // 处理需求说明文件
        String descriptionFilepath = "";
        String descriptionFilename = "";
        if (null != needDescriptionFile) {
            descriptionFilename = needDescriptionFile.getOriginalFilename();
            descriptionFilepath = doSaveFile(needDescriptionFile, need.getId(), realPath, false);
        }
        need.setDescriptionFilepath(descriptionFilepath);
        need.setDescriptionFilename(descriptionFilename);

        // 处理需求文件
        String needFilepath = "";
        String needFilename = "";
        if (null != needFile) {
            needFilename = needFile.getOriginalFilename();
            needFilepath = doSaveFile(needFile, need.getId(), realPath, true);
        }
        need.setNeedFilepath(needFilepath);
        need.setNeedFilename(needFilename);

        //保存需求
        int countAdd = needDao.add(need);
        if (0 != countAdd) {
            return need.getId();
        }
        throw new SystemException("保存失败");
    }

    /**
     * 保存上传的文件
     *
     * @param file
     * @param needId
     * @param realPath
     * @param isNeedFile
     * @return 返回文件真实地址
     * @throws Exception
     */
    private String doSaveFile(MultipartFile file, String needId, String realPath,
                              boolean isNeedFile) throws SystemException {
        // 获取文件上传目录，如不存在，创建新目录
        File newFilePath = new File(realPath + "\\needFile\\" + needId);
        if (!newFilePath.exists()) {
            newFilePath.mkdirs();
        }
        String filename = file.getOriginalFilename();
        File saveFile = new File(newFilePath, filename);
        try {
            file.transferTo(saveFile);
        } catch (Exception e) {
            throw new SystemException("文件保存失败");
        }
        if (isNeedFile) {
            //拼接解压后路径
            String unZipPath = newFilePath + "\\" + filename.substring(0, filename.lastIndexOf('.'));
            ZipUtil.unZip(saveFile, unZipPath);
        } else {
            WordUtil.wordToHtml(newFilePath.getAbsolutePath(), IMAGE_FILE_PATH, filename);
        }
        return "\\needFile\\" + needId + "\\" + filename;

    }


    @Override
    public PageInfo<Need> findByProjectId(String projectId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Need> list = needDao.findByprojectId(projectId);
        PageInfo<Need> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Need get(String id) {
        return needDao.get(id);
    }

    @Override
    public JSONObject doPreview(String id, String realpath) {
        String descriptionFilepath = get(id).getNeedFilepath();
        String unZipPath = descriptionFilepath.substring(0, descriptionFilepath.lastIndexOf('.'));
        return doPackageTreeFile(unZipPath, realpath);
    }

    public static void main(String[] args) {
        String realPath = "D:\\考核内容\\Newbie-master-ceda5f96f9dcd2dffdca3c15197669fd6c36308a\\demo\\src\\main\\webapp";
        String base = "\\needFile\\0RKkRdiBOX8C\\jf";
        File file = new File(realPath + "\\" + base);
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath.substring(realPath.length(), absolutePath.length()));
    }

    /**
     * 把文件夹封装成树状Json
     *
     * @param base
     * @param realPath
     * @return
     */
    public JSONObject doPackageTreeFile(String base, String realPath) {
        //封装最外层文件
        File file = new File(realPath + "\\" + base);
        JSONObject baseFileJson = new JSONObject();
        Stack<JSONObject> stack = new Stack<JSONObject>();
        baseFileJson.put("file", file);
        baseFileJson.put("filename", file.getName());
        baseFileJson.put("isDirection", true);
        baseFileJson.put("children", new JSONArray());
        stack.push(baseFileJson);
        //循环封装里层文件夹
        do {
            //取出一个文件夹
            JSONObject direction = stack.pop();
            File derectionFile = (File) direction.get("file");
            //把Json文件修改为网络访问路径
            String absolutePath = file.getAbsolutePath();
            String filePath = absolutePath.substring(realPath.length(), absolutePath.length());
            direction.put("file", filePath);
            JSONArray childrenArray = (JSONArray) direction.get("children");
            //处理的子文件
            for (File childrenFile : derectionFile.listFiles()) {
                JSONObject childrenJson = new JSONObject();
                childrenJson.put("file", childrenFile);
                childrenJson.put("filename", childrenFile.getName());
                //如果子文件为一个文件夹，把子文件入栈
                if (childrenFile.isDirectory()) {
                    childrenJson.put("children", new JSONArray());
                    childrenJson.put("isDirection", true);
                    stack.push(childrenJson);
                } else {
                    //把文件地址改为网络访问地址
                    String childrenAbsolutePath = childrenFile.getAbsolutePath();
                    String childFilePath = childrenAbsolutePath
                            .substring(realPath.length(), childrenAbsolutePath.length());
                    childrenJson.put("file", childFilePath);
                    childrenJson.put("isDirection", false);
                }
                //把子文件添加进父文件Json的childrenArray中
                childrenArray.add(childrenJson);
            }

        } while (!stack.isEmpty());
        return baseFileJson;
    }
}
