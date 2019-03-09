package com.dayi.demo.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.user.dao.PremissionDao;
import com.dayi.demo.user.model.Premission;
import com.dayi.demo.user.service.PremissionService;
import com.dayi.demo.util.IdUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author wut
 * @Date 2019-03-06
 */
@Service
public class PremissionServiceImpl implements PremissionService {

    @Resource
    private PremissionDao premissionDao;

    @Override
    public int addPremission(Premission premission) {
        premission.setId(IdUtils.getPrimaryKey());
        premission.setAddTime(new Date());
        premission.setUpdateTime(new Date());
        return premissionDao.addPremission(premission);
    }

    @Override
    public PageInfo<Premission> findByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
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
    public int updatePremission(Premission premission) {
        premission.setUpdateTime(new Date());
        return premissionDao.updatePremission(premission);
    }

    @Override
    public JSONArray doPremissionTree(String roleId) {
        /** 封装树结构权限，保存所有节点 */
        LinkedHashMap<String, JSONObject> assistMap = new LinkedHashMap<String,JSONObject>();
        List<Premission> list = findAll();
        for(Premission p : list) {
            JSONObject node = new JSONObject();
            /** 如果是菜单，需要加一个数组 */
            if(p.isMenu()) {
                node.put("nodes",new JSONArray());
            }
            node.put("id",p.getId());
            node.put("text",p.getPremissionName());
            node.put("parent",p.getParentId());

            /** 如果有父节点，则加入到父节点 */
            boolean hasParent = !("".equals(p.getParentId()));
            if(hasParent) {
                JSONArray parentNodes = (JSONArray)(assistMap.get(p.getParentId()).get("nodes"));
                parentNodes.add(node);
            }
            assistMap.put(p.getId(),node);
        }

        /** 给角色已有的权限加上checked */
        List<Premission> rolePremission = findByRoleId(roleId);
        for(Premission p : rolePremission) {
            JSONObject checked = new JSONObject ();
            checked.put("checked",true);
            assistMap.get(p.getId()).put("state",checked);
        }

        /** 循环遍历，把没有父节点的加到tree上 */
        JSONArray tree = new JSONArray();
        Iterator<String> iter = assistMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            JSONObject val = assistMap.get(key);
            if("".equals(val.get("parent"))) {
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
        premissionDao.deleteRolePremission(roleId,null);
        int countAdd = 0;
        for(String premissionId : premissionsId) {
            countAdd += premissionDao.addRolePremission(IdUtils.getPrimaryKey(),new Date(),new Date(),roleId,premissionId);
        }
        return countAdd;
    }

    @Override
    public int deletePremission(String id) {
        int countDelete = premissionDao.deletePremission(id);
        countDelete += premissionDao.deleteRolePremission(null,id);
        return countDelete;
    }

    @Override
    public int deleteRolePremission(String roleId,String premissionId) {
        return premissionDao.deleteRolePremission(roleId,premissionId);
    }
}
