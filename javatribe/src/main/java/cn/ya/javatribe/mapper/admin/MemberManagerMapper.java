package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.admin.MemberInfo;
import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.Duty;
import cn.ya.javatribe.model.generator.Grade;
import cn.ya.javatribe.model.generator.Role;
import cn.ya.javatribe.model.generator.TeamGroup;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/20.
 * 成员管理
 */
public interface MemberManagerMapper {

    // 查询正式成员总数
    int countMembers();

    // 查询考核人员总数
    int countExamineMembers();

    // 正式成员查询(不涉及分页)
    List<MemberInfo> queryAllMembers();

    // 考核人员查询(不涉及分页)
    List<MemberInfo> queryAllExamineMembers();

    // 正式成员查询(涉及分页)
    List<MemberInfo> queryAllMembersByPage(Page<MemberInfo> memberInfoPage);

    // 考核人员查询(涉及分页)
    List<MemberInfo> queryAllExamineMembersByPage(Page<MemberInfo> memberInfoPage);

    // 查询数据库现有的所有年级
    List<Grade> queryAllGrade();

    // 查询数据库现有的所有组别
    List<TeamGroup> queryAllTeamGroup();

    // 查询数据库现有的所有角色
    List<Role> queryAllRole();

    // 查询数据库现有的所有职务
    List<Duty> queryAllDuty();

}
