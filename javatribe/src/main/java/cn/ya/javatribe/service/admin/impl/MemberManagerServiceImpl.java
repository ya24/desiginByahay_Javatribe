package cn.ya.javatribe.service.admin.impl;

import cn.ya.javatribe.mapper.admin.MemberManagerMapper;
import cn.ya.javatribe.mapper.generator.*;
import cn.ya.javatribe.model.admin.MemberInfo;
import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.*;
import cn.ya.javatribe.service.admin.MemberManagerService;
import cn.ya.javatribe.utils.Encryption;
import cn.ya.javatribe.utils.PageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/21.
 */
@Service("memberManagerService")
public class MemberManagerServiceImpl implements MemberManagerService{

    @Autowired
    private MemberManagerMapper memberManagerMapper;
    @Autowired
    private TeamMembersMapper teamMembersMapper;
    @Autowired
    public DutyMapper dutyMapper;
    @Autowired
    public GradeMapper gradeMapper;
    @Autowired
    public RoleMapper roleMapper;
    @Autowired
    public TeamGroupMapper teamGroupMapper;

    // 正式成员查询(涉及分页)
    public Page<MemberInfo> queryAllMembersByPage(int currentPage){

        // 先实例化分页model
        Page<MemberInfo> memberInfoPage = new Page<MemberInfo>();
        memberInfoPage.setCurrentPage(currentPage);
        memberInfoPage.setTotalRecord(memberManagerMapper.countMembers());
        memberInfoPage.setPageSize(PageConstants.MEMBER_PAGE_SIZE);

        List<MemberInfo> memberInfoList = memberManagerMapper.queryAllMembersByPage(memberInfoPage);

        for (MemberInfo memberInfo : memberInfoList){
            if (memberInfo.getDutyId() != null){
                // 取出memberInfo中的职务id，去查职务名称
                Duty duty = dutyMapper.selectByPrimaryKey(memberInfo.getDutyId());
                memberInfo.setDutyName(duty.getDutyName());
            }
        }

        memberInfoPage.setDatas(memberInfoList);
        return memberInfoPage;
    }

    // 考核人员查询(涉及分页)
    public Page<MemberInfo> queryAllExamineMembersByPage(int currentPage){

        // 先实例化分页model
        Page<MemberInfo> memberInfoPage = new Page<MemberInfo>();
        memberInfoPage.setCurrentPage(currentPage);
        memberInfoPage.setTotalRecord(memberManagerMapper.countExamineMembers());
        memberInfoPage.setPageSize(PageConstants.MEMBER_PAGE_SIZE);

        List<MemberInfo> memberInfoList = memberManagerMapper.queryAllExamineMembersByPage(memberInfoPage);
        for (MemberInfo memberInfo : memberInfoList){
            if (memberInfo.getDutyId() != null){
                // 取出memberInfo中的职务id，去查职务名称
                Duty duty = dutyMapper.selectByPrimaryKey(memberInfo.getDutyId());
                memberInfo.setDutyName(duty.getDutyName());
            }
        }

        memberInfoPage.setDatas(memberInfoList);
        return memberInfoPage;
    }

    // 正式成员查询(不涉及分页)
    public List<MemberInfo> queryAllMembers(){
        List<MemberInfo> memberInfoList = memberManagerMapper.queryAllMembers();

        for (MemberInfo memberInfo : memberInfoList){
            // 取出memberInfo中的职务id，去查职务名称
            Duty duty = dutyMapper.selectByPrimaryKey(memberInfo.getDutyId());
            memberInfo.setDutyName(duty.getDutyName());
        }
        return memberInfoList;
    }

    // 考核人员查询(不涉及分页)
    public List<MemberInfo> queryAllExamineMembers(){
        return memberManagerMapper.queryAllExamineMembers();

    }

    // 添加成员
    public int insertMembers(TeamMembers teamMembers){
        //需要先对盐进行填充，以及密码进行加密
        String salt = Encryption.createSalt();
        String password = Encryption.md5encryption(teamMembers.getMemberPassword(), salt);
        teamMembers.setSalt(salt);
        teamMembers.setMemberPassword(password);
        return teamMembersMapper.insertSelective(teamMembers);
    }

    // 成员信息更新（根据成员唯一标识）
    public int updateMembers(TeamMembers teamMembers){
        //需要 先从数据库中取出盐，然后对密码做加密(不需要做这步了)
//        String salt = teamMembersMapper.selectByPrimaryKey(teamMembers.getMemberId()).getSalt();
//        String password = Encryption.md5encryption(teamMembers.getMemberPassword(), salt);
//        teamMembers.setMemberPassword(password);
        return teamMembersMapper.updateByPrimaryKeySelective(teamMembers);
    }

    // 成员移除
    public int deleteMemberByPrimaryKey(Integer memberId){
        return teamMembersMapper.deleteByPrimaryKey(memberId);
    }

    //添加年级
    public int insertGrade(String gradeName){
        Grade grade = new Grade();
        grade.setGradeName(gradeName);
        return gradeMapper.insertSelective(grade);
    }

    // 添加组别
    public int insertGroup(String groupName){
        TeamGroup teamGroup = new TeamGroup();
        teamGroup.setGroupName(groupName);
        return teamGroupMapper.insertSelective(teamGroup);
    }

    // 添加角色
    public int insertRole(String roleName){
        Role role = new Role();
        role.setRoleName(roleName);
        return roleMapper.insertSelective(role);
    }

    // 添加职务
    public int insertDuty(String dutyName){
        Duty duty = new Duty();
        duty.setDutyName(dutyName);
        return dutyMapper.insertSelective(duty);
    }

    // 查询数据库现有的所有年级
    public List<Grade> queryAllGrade(){
        return memberManagerMapper.queryAllGrade();
    }

    // 查询数据库现有的所有组别
    public List<TeamGroup> queryAllTeamGroup(){
        return memberManagerMapper.queryAllTeamGroup();
    }

    // 查询数据库现有的所有角色
    public List<Role> queryAllRole(){
        return memberManagerMapper.queryAllRole();
    }

    // 查询数据库现有的所有职务
    public List<Duty> queryAllDuty(){
        return memberManagerMapper.queryAllDuty();
    }

    // 根据成员编号查询成员信息
    public TeamMembers queryMemberById(Integer memberId){
        return teamMembersMapper.selectByPrimaryKey(memberId);
    }
}
