package cn.ya.javatribe.model.admin;

import cn.ya.javatribe.model.generator.TeamMembers;

/**
 * Created by 叶雅芳 on 2017/3/20.
 * 成员信息,继承TeamMembers
 */
public class MemberInfo extends TeamMembers {
//    年级，组别，姓名，手机，短号，微信，QQ，职务，角色

    private String gradeName;
    private String groupName;
    private String dutyName;
    private String roleName;

//    @Override
//    public String toString() {
//        super.toString();
//        return "MemberInfo{" +
//                "gradeName='" + gradeName + '\'' +
//                ", groupName='" + groupName + '\'' +
//                ", dutyName='" + dutyName + '\'' +
//                ", roleName='" + roleName + '\'' +
//                '}';
//    }

    public MemberInfo() {
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}







