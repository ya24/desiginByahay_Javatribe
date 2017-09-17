package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.generator.TeamMembers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 叶雅芳 on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public  void  selectByMemberNameTest(){
        TeamMembers teamMembers = userMapper.selectByMemberName("曾佳俊");
        System.out.println(teamMembers);
    }

    @Test
    public void selectMenuByMemberNameTest(){
        System.out.println(userMapper.selectMenuByMemberName("叶雅芳"));
    }

//    @Test
//    public void selectByMemberNameTest(){
//        String name ="ahay";
//        String password = "123456";
//
//        //TeamMembers teamMembers = userMapper.selectByMemberName(name);
//
//       // System.out.println(teamMembers);
//    }

}
