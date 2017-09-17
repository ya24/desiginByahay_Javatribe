package cn.ya.javatribe.service.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 叶雅芳 on 2017/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class CommunicationShowServiceTest {

    @Autowired
    private CommunicationShowService communicationShowService;

    @Test
    public void queryCommunicationShowByLimitTest(){
        System.out.println(communicationShowService.queryCommunicationShowByLimit(1));
    }

}
