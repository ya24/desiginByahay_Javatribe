package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.mapper.generator.AfficheMapper;
import cn.ya.javatribe.model.generator.Affiche;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 叶雅芳 on 2017/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AfficheManagerMapperTest {

    @Autowired
    private AfficheMapper afficheMapper;
    @Autowired
    private AfficheManagerMapper afficheManagerMapper;

    @Test
    public void updateAfficheTest(){
        Affiche affiche = new Affiche();
        affiche.setAfficheId(6);
        affiche.setStatus(1);
        affiche.setAttachfileId(null);
        System.out.println(afficheMapper.updateByPrimaryKeyWithBLOBs(affiche));
    }

    @Test
    public void delAfficheTest(){
        Affiche affiche = new Affiche();
        affiche.setStatus(0);
        affiche.setAfficheId(7);
        System.out.println(afficheManagerMapper.delAfficheById(affiche));
    }
}
