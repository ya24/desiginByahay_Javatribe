package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.admin.MemberInfo;
import cn.ya.javatribe.model.admin.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class MemberManagerMapperTest {

    @Autowired
    private MemberManagerMapper memberManagerMapper;

    @Test
    public void queryAllMembersByPageTest(){
        Page<MemberInfo> memberInfoPage = new Page<MemberInfo>();
        memberInfoPage.setCurrentPage(1);
        memberInfoPage.setPageSize(4);
        //memberInfoPage.setIndex((memberInfoPage.getCurrentPage() - 1) * memberInfoPage.getPageSize());
        List<MemberInfo> memberInfoList = memberManagerMapper.queryAllMembersByPage(memberInfoPage);
        System.out.println(memberInfoList);
    }

    @Test
    public void countTest(){
        System.out.println(memberManagerMapper.countMembers());
        System.out.println(memberManagerMapper.countExamineMembers());
    }

    @Test
    public  void  queryAllMembers(){
        List<MemberInfo> memberInfos = memberManagerMapper.queryAllMembers();
        for (MemberInfo memberInfo : memberInfos){
            System.out.println(memberInfo.getMemberName());
            System.out.println(memberInfo.getDutyName());
        }
    }

    @Test
    public void queryAllExamineMembersTest(){
        List<MemberInfo> memberInfos = memberManagerMapper.queryAllExamineMembers();
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
}
