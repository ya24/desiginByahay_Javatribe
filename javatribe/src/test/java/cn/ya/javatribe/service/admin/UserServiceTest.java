package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.Menus;
import cn.ya.javatribe.model.generator.Permission;
import cn.ya.javatribe.model.generator.TeamMembers;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectByMemberNameTest(){
        TeamMembers teamMembers = userService.selectByMemberName("叶雅芳");
        System.out.println(teamMembers);
    }

    @Test
    public void selectMenuByMemberNameTest(){
        List<Menus> menusList = userService.selectMenuByMemberName("叶雅芳");
        for (Menus menus : menusList){
            System.out.println("父菜单："+menus.getPermissionId() + "-" + menus.getPermissionName());
            List<Menus> childs = menus.getChildMenus();
            for (Menus child : childs){
                System.out.println("\t子菜单：" + child.getPermissionName() + "-父id：" +child.getParentid());
            }
        }
    }


   // @Test
//    public void selectMenuByMemberNameTest(){
//        List<Permission> menus  = userService.selectMenuByMemberName("叶雅芳");
//        System.out.println(menus);
//    }

    @Test
    public void selectPermissionByMemberNameTest(){
        List<Permission> permissions  = userService.selectPermissionByMemberName("叶雅芳");
        System.out.println(permissions);
    }


}






