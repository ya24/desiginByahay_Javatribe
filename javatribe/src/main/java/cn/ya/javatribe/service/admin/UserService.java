package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.Menus;
import cn.ya.javatribe.model.generator.Permission;
import cn.ya.javatribe.model.generator.TeamMembers;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/18.
 */
public interface UserService {

    TeamMembers selectByMemberName(String memberName);

    List<Menus> selectMenuByMemberName(String memberName);

    // 根据用户名查找用户拥有的权限权限列表
    List<Permission> selectPermissionByMemberName(String memberName);
}
