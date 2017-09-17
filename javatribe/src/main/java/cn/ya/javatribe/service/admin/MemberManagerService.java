package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.MemberInfo;
import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.*;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/21.
 * 成员管理
 */
public interface MemberManagerService {

    // 正式成员查询(涉及分页)
    Page<MemberInfo> queryAllMembersByPage(int currentPage);

    Page<MemberInfo> queryAllExamineMembersByPage(int currentPage);

    // 正式成员查询(不涉及分页)
    List<MemberInfo> queryAllMembers();

    // 考核人员查询(不涉及分页)
    List<MemberInfo> queryAllExamineMembers();

    // 添加成员
    int insertMembers(TeamMembers teamMembers);

    // 成员信息更新（根据成员唯一标识）
    int updateMembers(TeamMembers teamMembers);

    // 成员移除
    int deleteMemberByPrimaryKey(Integer memberId);

    //添加年级
    int insertGrade(String gradeName);

    // 添加组别
    int insertGroup(String groupName);

    // 添加角色
    int insertRole(String roleName);

    // 添加职务
    int insertDuty(String dutyName);


    // 查询数据库现有的所有年级
    List<Grade> queryAllGrade();

    // 查询数据库现有的所有组别
    List<TeamGroup> queryAllTeamGroup();

    // 查询数据库现有的所有角色
    List<Role> queryAllRole();

    // 查询数据库现有的所有职务
    List<Duty> queryAllDuty();

    // 根据成员编号查询成员信息
    TeamMembers queryMemberById(Integer memberId);

}
