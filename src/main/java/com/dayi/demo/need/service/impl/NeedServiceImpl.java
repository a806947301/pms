package com.dayi.demo.need.service.impl;

import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.need.dao.NeedDao;
import com.dayi.demo.need.model.Need;
import com.dayi.demo.util.NeedFileNode;
import com.dayi.demo.need.service.NeedService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.dayi.demo.util.WordUtil;
import com.dayi.demo.util.ZipUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * 需求模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              @                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               pvc123.com>
 * @date 2019-03-04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NeedServiceImpl implements NeedService {

    private final static Logger logger = LoggerFactory.getLogger(NeedServiceImpl.class);

    @Resource
    private NeedDao needDao;

    @Resource
    private UserService userService;


    /**
     * 保存转换后html文件所需的图片保存的相对路径
     */
    private static final String IMAGE_FILE_PATH = "image";

    @Override
    public String add(Need need, MultipartFile needDescriptionFile, MultipartFile needFile,
                      String realPath, User currentUser) throws SystemException {
        //判断用户是否参与此产品
        String productId = need.getProject().getProduct().getId();
        String userId = currentUser.getId();
        if (!userService.isInProduct(userId, productId)) {
            throw new SystemException("当前用户没参与此产品");
        }

        //判断需求说明文件是否为空
        if (null == needDescriptionFile) {
            throw new SystemException("需求说明文件不能为空");
        }

        //判断需求文件是否为空
        if (null == needFile) {
            throw new SystemException("需求文件不能为空");
        }
        //添加需求提出者为当前用户
        need.setUser(currentUser);

        //添加Debug日志
        if (logger.isDebugEnabled()) {
            logger.debug("保存需求所需文件");
        }

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

        //添加Debug日志
        if (logger.isDebugEnabled()) {
            logger.debug("保存需求到数据库");
        }
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
            //添加错误日志
            if (logger.isErrorEnabled()) {
                logger.error(saveFile.toString() + "_" + e.getMessage(), e);
            }

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
        List<Need> list = needDao.findByProjectId(projectId);
        PageInfo<Need> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Need get(String id) {
        return needDao.get(id);
    }

    @Override
    public void delete(String id, String realPath, User currentUser) throws SystemException {
        //判断非空
        Need need = get(id);
        if (null == need) {
            throw new SystemException("需求不存在");
        }
        //判断是否本人
        boolean isProposer = currentUser.getId().equals(need.getUser().getId());
        if(!isProposer) {
            throw new SystemException("您不是需求提出者");
        }

        //添加Debug日志
        if (logger.isDebugEnabled()) {
            logger.debug("删除需求，id：{}", id);
        }
        //删除需求文件
        String needFilePath = realPath + "/" + id;
        FileUtils.deleteQuietly(new File(needFilePath));
        //删除需求
        int countDelete = needDao.delete(id);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public NeedFileNode doPreview(String id, String realpath) {
        String descriptionFilepath = get(id).getNeedFilepath();
        String unZipPath = descriptionFilepath.substring(0, descriptionFilepath.lastIndexOf('.'));
        return doPackageTreeFile(unZipPath, realpath);
    }

    /**
     * 把文件夹封装成树状Json
     *
     * @param base
     * @param realPath
     * @return
     */
    public NeedFileNode doPackageTreeFile(String base, String realPath) {
        //获取最外层文件
        File file = new File(realPath + "\\" + base);
        //创建用于遍历文件的栈
        Stack<NeedFileNode> stack = new Stack<NeedFileNode>();
        //创建最外层文件节点
        NeedFileNode baseFileTree = new NeedFileNode(file.getAbsolutePath(), file.getName(),
                true, new LinkedList<NeedFileNode>());
        //最外层文件入栈
        stack.push(baseFileTree);

        //循环封装里层文件夹
        do {
            //取出一个文件夹
            NeedFileNode direction = stack.pop();
            File directionFile = new File(direction.getFile());

            //把目录节点文件路径修改为网络访问路径
            String absolutePath = directionFile.getAbsolutePath();
            String filePath = absolutePath.substring(realPath.length());
            direction.setFile(filePath);
            List<NeedFileNode> children = direction.getChildren();

            //处理的子文件
            for (File childrenFile : directionFile.listFiles()) {
                NeedFileNode node = new NeedFileNode();
                node.setFile(childrenFile.getAbsolutePath());
                node.setFileName(childrenFile.getName());

                //如果子文件为一个文件夹，把子文件入栈
                if (childrenFile.isDirectory()) {
                    node.setChildren(new LinkedList<NeedFileNode>());
                    node.setDirection(true);
                    stack.push(node);
                } else {
                    //把文件节点文件路径修改为网络访问路径
                    String childrenAbsolutePath = childrenFile.getAbsolutePath();
                    String childFilePath = childrenAbsolutePath.substring(realPath.length());
                    node.setFile(childFilePath);
                    node.setDirection(false);
                }
                //把子文件添加进父文件children中
                children.add(node);
            }

        } while (!stack.isEmpty());
        return baseFileTree;
    }
}
