package cn.ya.javatribe.mapper.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.CommunicationMeeting;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/4/8.
 * 交流会风采mapper
 */
public interface CommunicationShowMapper {

    // 查询交流会风采总记录数
    int countCommunicationShow();

    // 分页查询交流会风采
    List<CommunicationMeeting> queryCommunicationShowByLimit(Page<CommunicationMeeting> communicationMeetingPage);

}
