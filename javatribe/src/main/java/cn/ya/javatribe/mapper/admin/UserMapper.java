package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.admin.Menus;
import cn.ya.javatribe.model.generator.Permission;
import cn.ya.javatribe.model.generator.TeamMembers;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/18.
 */
public interface UserMapper {
    // 根据用户名查找用户登录相关的信息
    TeamMembers selectByMemberName(String memberName);

    // 根据用户名查找用户拥有的权限菜单列表
    List<Menus> selectMenuByMemberName(String memberName);

    // 根据用户名查找用户拥有的权限列表
    List<Permission> selectPermissionByMemberName(String memberName);
}
