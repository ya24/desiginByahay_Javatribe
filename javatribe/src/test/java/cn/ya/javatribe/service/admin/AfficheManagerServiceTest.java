package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.Affiche;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AfficheManagerServiceTest {

    @Autowired
    private AfficheManagerService afficheManagerService;

    @Test
    public void queryAllAfficheByPageTest(){
        Page<Affiche> affichePage =afficheManagerService.queryAllAfficheByPage(1);
        System.out.println(affichePage.getIndex()+"index");
        System.out.println(affichePage.getPageSize()+"pagesize");
        List<Affiche> afficheList = affichePage.getDatas();
        for (Affiche affiche : afficheList){
            System.out.println(affiche);
        }

    }

    @Test
    public void queryAffiche(){
        Affiche affiche = afficheManagerService.queryAfficheById(1);
        System.out.println(affiche);
        System.out.println(affiche.getAttachfileId() == null);
    }

    @Test
    public void delAffiche(){
        System.out.println(afficheManagerService.delAfficheById(4));
    }
}
