package cn.ya.javatribe.service.admin.impl;

import cn.ya.javatribe.mapper.admin.CommunicationShowMapper;
import cn.ya.javatribe.mapper.generator.CommunicationMeetingMapper;
import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.CommunicationMeeting;
import cn.ya.javatribe.service.admin.CommunicationShowService;
import cn.ya.javatribe.utils.PageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 叶雅芳 on 2017/4/8.
 * 交流会风采业务层实现类
 */
@Service("communicationShowService")
public class CommunicationShowServiceImpl implements CommunicationShowService{

    @Autowired
    private CommunicationMeetingMapper communicationMeetingMapper;
    @Autowired
    private CommunicationShowMapper communicationShowMapper;

    // 添加交流会风采
    public int insertCommunicationMeetiong(CommunicationMeeting communicationMeeting){
        return communicationMeetingMapper.insertSelective(communicationMeeting);
    }

    // 交流会风采展览
    public Page<CommunicationMeeting> queryCommunicationShowByLimit(Integer currentPage){
        Page<CommunicationMeeting> communicationMeetingPage = new  Page<CommunicationMeeting>();
        communicationMeetingPage.setCurrentPage(currentPage);
        communicationMeetingPage.setTotalRecord(communicationShowMapper.countCommunicationShow());
        communicationMeetingPage.setPageSize(PageConstants.COMMUNICATION_PAGE_SIZE);
        communicationMeetingPage.setDatas(communicationShowMapper.queryCommunicationShowByLimit(communicationMeetingPage));
        return communicationMeetingPage;
    }

    // 交流会风采详情
    public CommunicationMeeting queryCommunicationShowById(Integer meetingId){
        return communicationMeetingMapper.selectByPrimaryKey(meetingId);
    }

    // 交流会风采修改
    public int updateCommunicationMeeting(CommunicationMeeting communicationMeeting){
        return communicationMeetingMapper.updateByPrimaryKeyWithBLOBs(communicationMeeting);
    }

    // 交流会风采删除
    public int delCommunicationMeeting(Integer meetingId){
        return communicationMeetingMapper.deleteByPrimaryKey(meetingId);
    }

}
