package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.TeamGroup;

public interface TeamGroupMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(TeamGroup record);

    int insertSelective(TeamGroup record);

    TeamGroup selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(TeamGroup record);

    int updateByPrimaryKey(TeamGroup record);
}