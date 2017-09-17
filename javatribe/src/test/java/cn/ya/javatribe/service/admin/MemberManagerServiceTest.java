package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.MemberInfo;
import cn.ya.javatribe.model.generator.*;
import cn.ya.javatribe.utils.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class MemberManagerServiceTest {

    @Autowired
    private MemberManagerService memberManagerService;

    @Test
    public void queryAllMembersTest(){
        List<MemberInfo> memberInfos = memberManagerService.queryAllMembers();
        for (MemberInfo memberInfo : memberInfos){
            System.out.println(memberInfo.getMemberId());
            System.out.println(memberInfo.getGradeName());
            System.out.println(memberInfo.getGroupName());
            System.out.println(memberInfo.getMemberName());
            System.out.println(memberInfo.getPhoneNumber());
            System.out.println(memberInfo.getShortPhoneNumber());
            System.out.println(memberInfo.getWechat());
            System.out.println(memberInfo.getQq());
            System.out.println(memberInfo.getDutyName());
            System.out.println(memberInfo.getRoleName());
            System.out.println("========================");
        }
    }

    @Test
    // 考核人员查询(不涉及分页)
    public void queryAllExamineMembersTest(){

        List<MemberInfo> memberInfos = memberManagerService.queryAllExamineMembers();
        for (MemberInfo memberInfo : memberInfos){
            System.out.println(memberInfo.getMemberId());
            System.out.println(memberInfo.getGradeName());
            System.out.println(memberInfo.getMemberName());
            System.out.println(memberInfo.getPhoneNumber());
            System.out.println(memberInfo.getShortPhoneNumber());
            System.out.println(memberInfo.getWechat());
            System.out.println(memberInfo.getQq());
            System.out.println(memberInfo.getRoleName());
            System.out.println("========================");
        }

    }


    @Test
    public void insertSelectiveTest(){
        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setMemberName("曾佳俊");
        teamMembers.setMemberPassword("123456");
        teamMembers.setGradeId(7);
        teamMembers.setGroupId(3);
        teamMembers.setRoleId(4);
        System.out.println(memberManagerService.insertMembers(teamMembers));
    }

    @Test
    public void updateMembersTest(){
        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setMemberId(5);
        teamMembers.setMemberPassword("123456");
        System.out.println(memberManagerService.updateMembers(teamMembers));
    }

    @Test
    public void deleteByPrimaryKeyTest(){
        System.out.println(memberManagerService.deleteMemberByPrimaryKey(4));
    }

    //添加年级
    @Test
    public void insertGrade(){
        System.out.println(memberManagerService.insertGrade("第九届（17级）"));
    }

    // 添加组别
    @Test
    public void insertGroup(){
        System.out.println(memberManagerService.insertGroup("研发部"));
    }

    // 添加角色
    @Test
    public void insertRole(){
        System.out.println(memberManagerService.insertRole("准成员"));
    }

    // 添加职务
    @Test
    public void insertDuty(){
        System.out.println(memberManagerService.insertDuty("算法交流组组长"));
    }

    @Test
    public  void  queryAllMembersByPageTest(){
        System.out.println(memberManagerService.queryAllMembersByPage(1));
    }

    @Test
    public void testList(){
        System.out.println(memberManagerService.queryAllDuty());
        System.out.println(memberManagerService.queryAllGrade());
        System.out.println(memberManagerService.queryAllRole());
        System.out.println(memberManagerService.queryAllTeamGroup());
    }

    @Test
    // 根据成员编号查询成员信息
    public void queryMemberByIdTest(){
        System.out.println(memberManagerService.queryMemberById(3));
    }


    @Test
    public void encryptionTest(){
        String salt = Encryption.createSalt();
        String password = Encryption.md5encryption("123456", salt);
        System.out.println(password);
    }

    @Test
    public void t(){
        int x=(int)(Math.random()*100);
        long timeMillis = System.currentTimeMillis();
        String salt = x + "" + timeMillis;
        System.out.println(salt);//621490059821055      351490059837102

        // 产生1-100的随机数
//        int x=(int)(Math.random()*100);
//        System.out.println("第一次");
//        System.out.println(x);
//        System.out.println(System.currentTimeMillis());
//        System.out.println("第二次");
//        x=(int)(Math.random()*100);
//        System.out.println(x);
//        System.out.println(System.currentTimeMillis());

         /*
    * 第一次运行
    * 第一次
        25
        1490059559100
        第二次
        81
        1490059559100
    * */

    /*
    第二次运行
    第一次
    41
    1490059600432
    第二次
    44
    1490059600432

     */


    }



}
