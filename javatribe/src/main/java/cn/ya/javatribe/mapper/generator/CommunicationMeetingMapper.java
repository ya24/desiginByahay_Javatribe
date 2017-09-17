package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.CommunicationMeeting;

public interface CommunicationMeetingMapper {
    int deleteByPrimaryKey(Integer meetingId);

    int insert(CommunicationMeeting record);

    int insertSelective(CommunicationMeeting record);

    CommunicationMeeting selectByPrimaryKey(Integer meetingId);

    int updateByPrimaryKeySelective(CommunicationMeeting record);

    int updateByPrimaryKeyWithBLOBs(CommunicationMeeting record);

    int updateByPrimaryKey(CommunicationMeeting record);
}