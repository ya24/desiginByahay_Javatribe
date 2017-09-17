package cn.ya.javatribe.model.admin;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/20.
 * 用户类User，专门存储用户的信息，包括用户主键，用户名，菜单列表，权限列表。
 */
public class User {
    private int userId;
    private String userName;
    private int roleId;
//    private List<Permission> menus;
//    private List<Permission> permissions;
    private List<Menus> menusList;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<Menus> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menus> menusList) {
        this.menusList = menusList;
    }
}
