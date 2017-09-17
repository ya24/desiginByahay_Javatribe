package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.CommunicationMeeting;
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
public class CommunicationShowMapperTest {

    @Autowired
    private CommunicationShowMapper communicationShowMapper;

    @Test
    public void countCommunicationShowTest(){
        System.out.println(communicationShowMapper.countCommunicationShow());
    }

    @Test
    public void queryCommunicationShowByLimit(){
        Page<CommunicationMeeting> communicationMeetingPage = new Page<CommunicationMeeting>();
        communicationMeetingPage.setCurrentPage(1);
//        communicationMeetingPage.setTotalRecord(communicationShowMapper.countCommunicationShow());
        communicationMeetingPage.setPageSize(10);
        System.out.println(communicationShowMapper.queryCommunicationShowByLimit(communicationMeetingPage));
    }
}
