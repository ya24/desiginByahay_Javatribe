package cn.ya.javatribe.service.admin.impl;

import cn.ya.javatribe.mapper.admin.UserMapper;
import cn.ya.javatribe.model.admin.Menus;
import cn.ya.javatribe.model.generator.Permission;
import cn.ya.javatribe.model.generator.TeamMembers;
import cn.ya.javatribe.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/18.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public TeamMembers selectByMemberName(String memberName){
        return userMapper.selectByMemberName(memberName);
    }

    // 查询某用户的菜单列表（已封装好子父菜单关系）
    public List<Menus> selectMenuByMemberName(String memberName){
        List<Menus> menusList = userMapper.selectMenuByMemberName(memberName);
        List<Menus> parentMenusList = new ArrayList<Menus>();    // 一级菜单
        // 取一级菜单，即parentid为null的菜单
        for (Menus menus : menusList){
            if (menus.getParentid() == null){
                parentMenusList.add(menus);
            }
        }

        // 取二级菜单(并给父菜单找其子菜单)
        for (Menus parentMenus : parentMenusList){
            List<Menus> childMenus = new ArrayList<Menus>();
            for (Menus menus : menusList){
                if (parentMenus.getPermissionId() == menus.getParentid()){
                    childMenus.add(menus);  //二级菜单
                }
            }
            parentMenus.setChildMenus(childMenus);
        }


        return parentMenusList;
    }

    // 根据用户名查找用户拥有的权限权限列表
    public List<Permission> selectPermissionByMemberName(String memberName){
        return userMapper.selectPermissionByMemberName(memberName);
    }

}
