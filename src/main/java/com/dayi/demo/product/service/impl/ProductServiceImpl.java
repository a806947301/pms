package com.dayi.demo.product.service.impl;

import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.product.dao.ProductDao;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.user.model.User;
import com.dayi.demo.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 产品模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-2-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    private final  static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    ProductDao productDao;

    @Resource
    UserService userService;

    @Resource
    ProjectService projectService;

    @Override
    public String add(Product product, String[] participators) throws SystemException{
        // 添加产品
        logger.info("添加产品，产品ID：{}", product.getId());
        int countAdd = productDao.add(product);

        // 判断产品是否添加成功
        if (countAdd != 0) {
            //  添加产品成员
            addParticipator(product.getId(), participators);
            return product.getId();
        }
        throw new SystemException("操作失败");
    }

    @Override
    public PageInfo<Product> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product> list = productDao.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Product get(String id) {
        return productDao.get(id);
    }

    @Override
    public List<User> getParticipator(String id) {
        List<User> paticipator = userService.findByProductId(id);
        return paticipator;
    }

    @Override
    public int addParticipator(String id, String[] newParticipator) throws SystemException{
        //判断是否存在产品
        Product product = get(id);
        if(null == product) {
            throw new SystemException("没有该产品");
        }
        // 添加产品成员
        int countAdd = 0;
        ProductService serviceProxy = (ProductService) AopContext.currentProxy();
        BaseEntity entity;
        for (String participator : newParticipator) {
            entity = new BaseEntity() ;
            countAdd += serviceProxy.addParticipator(entity, id, participator);
        }
        return countAdd;
    }

    @Override
    public int addParticipator(BaseEntity entity, String productId, String participatorId) {
        return productDao.addParticipator(entity.getId(), productId,
                participatorId, entity.getAddTime(), entity.getUpdateTime());
    }

    @Override
    public void deleteParticipator(String productId, String userId) throws SystemException{
        int countDelete = productDao.deleteParticipator(productId, userId);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void update(Product product) throws SystemException{
        //判断产品是否存在
        Product oldProduct = get(product.getId());
        if(null == oldProduct) {
            throw new SystemException("不存在该产品");
        }

        //更新产品
        int countUpdate = productDao.update(product);
        if(0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public PageInfo<Product> findByUser(String userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Product> list = productDao.findByUser(userId);
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void delete(String id) throws SystemException {
        //判断产品参与者是否为空
        List<User> participant = userService.findByProductId(id);
        if (0 != participant.size()) {
            throw new SystemException("参与者不为空");
        }
        //判断产品下项目是否为空
        PageInfo<Project> projects = projectService.findByProductIdPage(id, 1, 1);
        if (0 != projects.getSize()) {
            throw new SystemException("该产品下还有项目");
        }

        //删除产品
        logger.info("删除产品，产品Id：{}", id);
        int countDelete = productDao.delete(id);
        if (0 == countDelete) {
            throw new SystemException("删除失败");
        }
    }
}
