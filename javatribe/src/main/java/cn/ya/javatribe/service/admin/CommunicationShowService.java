package cn.ya.javatribe.service.admin;

import cn.ya.javatribe.model.admin.Page;
import cn.ya.javatribe.model.generator.CommunicationMeeting;

/**
 * Created by 叶雅芳 on 2017/4/8.
 * 交流会风采业务层接口
 */
public interface CommunicationShowService {

    // 添加交流会风采
    int insertCommunicationMeetiong(CommunicationMeeting communicationMeeting);

    // 交流会风采展览
    Page<CommunicationMeeting> queryCommunicationShowByLimit(Integer currentPage);

    // 交流会风采详情
    CommunicationMeeting queryCommunicationShowById(Integer meetingId);

    // 交流会风采修改
    int updateCommunicationMeeting(CommunicationMeeting communicationMeeting);

    // 交流会风采删除
    int delCommunicationMeeting(Integer meetingId);

}
