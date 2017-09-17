package cn.ya.javatribe.model.admin;

import cn.ya.javatribe.model.generator.Permission;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/23.
 */
public class Menus extends Permission {

    private List<Menus> childMenus;    //子菜单

    public List<Menus> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menus> childMenus) {
        this.childMenus = childMenus;
    }

    /* 注释原因：用更友好的命名方式
    private List<Permission> permissionList;    // 菜单下属的权限（即子菜单）

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
*/
}
