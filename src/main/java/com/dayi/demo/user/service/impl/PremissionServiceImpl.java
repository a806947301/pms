package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.common.entity.BaseEntity;
import com.dayi.demo.common.exception.SystemException;
import com.dayi.demo.user.dao.PremissionDao;
import com.dayi.demo.user.model.Premission;
import com.dayi.demo.user.service.PremissionService;
import com.dayi.demo.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 权限模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PremissionServiceImpl implements PremissionService {

    @Resource
    private PremissionDao premissionDao;

    @Override
    public void add(Premission premission) throws SystemException {
        int countAdd = premissionDao.add(premission);
        if (0 == countAdd) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public PageInfo<Premission> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Premission> list = premissionDao.findPremission();
        PageInfo<Premission> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Premission> findAll() {
        return premissionDao.findPremission();
    }

    @Override
    public List<Premission> findPremissionMenu() {
        return premissionDao.findByIsMenu(true);
    }

    @Override
    public void update(Premission premission) throws SystemException {
        int countUpdate = premissionDao.update(premission);
        if (0 == countUpdate) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public JSONArray doPremissionTree(String roleId) {
        // 封装树结构权限，保存所有节点
        LinkedHashMap<String, JSONObject> assistMap = new LinkedHashMap<String, JSONObject>();
        List<Premission> list = findAll();
        for (Premission p : list) {
            JSONObject node = new JSONObject();
            // 如果是菜单，需要加一个数组
            if (p.isMenu()) {
                node.put("nodes", new JSONArray());
            }
            node.put("id", p.getId());
            node.put("text", p.getPremissionName());
            node.put("parent", p.getParentId());

            // 如果有父节点，则加入到父节点
            boolean hasParent = !("".equals(p.getParentId()));
            if (hasParent) {
                JSONArray parentNodes = (JSONArray) (assistMap.get(p.getParentId()).get("nodes"));
                parentNodes.add(node);
            }
            assistMap.put(p.getId(), node);
        }

        // 给角色已有的权限加上checked
        List<Premission> rolePremission = findByRoleId(roleId);
        for (Premission p : rolePremission) {
            JSONObject checked = new JSONObject();
            checked.put("checked", true);
            assistMap.get(p.getId()).put("state", checked);
        }

        // 循环遍历，把没有父节点的加到tree上
        JSONArray tree = new JSONArray();
        Iterator<String> iter = assistMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            JSONObject val = assistMap.get(key);
            if ("".equals(val.get("parent"))) {
                tree.add(val);
            }
        }
        return tree;
    }

    @Override
    public List<Premission> findByRoleId(String roleId) {
        return premissionDao.findByRoleId(roleId);
    }

    @Override
    public int doAuthorization(String roleId, String[] premissionsId) {
        //删除已有权限
        premissionDao.deleteRolePremission(roleId, null);

        //授权
        int countAdd = 0;
        BaseEntity entity;
        PremissionService proxyService = (PremissionService) AopContext.currentProxy();
        for (String premissionId : premissionsId) {
            entity = new BaseEntity();
            countAdd += proxyService.addRolePremission(entity, roleId, premissionId);
        }
        return countAdd;
    }

    @Override
    public int addRolePremission(BaseEntity entity, String roleId, String premissionId) {
        return premissionDao.addRolePremission(entity.getId(), entity.getAddTime(), entity.getUpdateTime(),
                roleId, premissionId);
    }

    @Override
    public void delete(String id) throws SystemException {
        int countDelete = premissionDao.delete(id);
        premissionDao.deleteRolePremission(null, id);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }

    @Override
    public void deleteRolePremission(String roleId, String premissionId) throws SystemException {
        int countDelete = premissionDao.deleteRolePremission(roleId, premissionId);
        if (0 == countDelete) {
            throw new SystemException("操作失败");
        }
    }
}
