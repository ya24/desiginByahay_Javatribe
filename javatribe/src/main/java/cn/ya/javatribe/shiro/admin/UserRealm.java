package cn.ya.javatribe.shiro.admin;


import cn.ya.javatribe.model.admin.Menus;
import cn.ya.javatribe.model.admin.User;
import cn.ya.javatribe.model.generator.Permission;
import cn.ya.javatribe.model.generator.TeamMembers;
import cn.ya.javatribe.service.admin.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/18.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1.从token中取出用户名
        String username = (String) token.getPrincipal();
        // 2.从数据库中查询用户信息
        TeamMembers teamMembers = userService.selectByMemberName(username);
        // 3.如果查询不到返回null
        if (teamMembers == null)
            return null;
        // 4.取出密码和盐
        String password = teamMembers.getMemberPassword();
        String salt = teamMembers.getSalt();

        // 5.根据用户名查找用户的权限菜单列表
        List<Menus> menusList = userService.selectMenuByMemberName(username);

        // 8.封装用户信息
        User user = new User();
        user.setUserId(teamMembers.getMemberId());
        user.setUserName(teamMembers.getMemberName());
        user.setRoleId(teamMembers.getRoleId());
        user.setMenusList(menusList);

        // 7.将用户信息user设置在simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user, password, ByteSource.Util.bytes(salt), this.getName()
        );

        return simpleAuthenticationInfo;

    }


    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 1.获取主身份信息（这个主身份信息是在认证结束后填充到SimpleAuthenticationInfo中的那个user）
        User user = (User) principals.getPrimaryPrincipal();

        // 2.取用户的权限信息
        List<Permission> permissionList = userService.selectPermissionByMemberName(user.getUserName());

        // 3.取出权限中多余信息，只取权限代码
        List<String> permissions = new ArrayList<String>();
        for (Permission permission : permissionList){
            permissions.add(permission.getPermissionCode());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    public void setName(String name) {
        super.setName("userRealm");
    }

/*
注释的原因：这个方法没有分清菜单和权限关系，是最初的设计，完善后不再适用了。
    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        // 1.从token中取出用户名
        String username = (String) token.getPrincipal();
        // 2.从数据库中查询用户信息
        TeamMembers teamMembers = userService.selectByMemberName(username);
        // 3.如果查询不到返回null
        if (teamMembers == null)
            return null;
        // 4.取出密码和盐
        String password = teamMembers.getMemberPassword();
        String salt = teamMembers.getSalt();

        // 5.根据用户名查找用户的权限菜单列表
        List<Menus> menusList = userService.selectMenuByMemberName(username);
        // 6.根据用户名查找用户的权限列表
        List<Permission> permissionList = userService.selectPermissionByMemberName(username);
        // 7.将用户菜单及其下的子权限列表做映射
        for (int i=0; i<menusList.size(); i++){
            Menus menu = menusList.get(i);  //取出一个菜单
            List<Permission> childPermission = new ArrayList<Permission>();
            // 遍历permissionList,父id是menu的id的，即装进childPermission中
            for (int j=0; j<permissionList.size(); j++){
                Permission permission = permissionList.get(j);
                if (menu.getPermissionId() == permission.getParentid()){
                    childPermission.add(permission);
                }
            }
            menu.setPermissionList(childPermission);
        }

        // 8.封装用户信息
        User user = new User();
        user.setUserId(teamMembers.getMemberId());
        user.setUserName(teamMembers.getMemberName());
        user.setMenusList(menusList);

        // 7.将用户信息user设置在simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user, password, ByteSource.Util.bytes(salt), this.getName()
        );
        return simpleAuthenticationInfo;
    }
    */


}