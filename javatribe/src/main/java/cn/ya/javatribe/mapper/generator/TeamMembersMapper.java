package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.TeamMembers;

public interface TeamMembersMapper {
    int deleteByPrimaryKey(Integer memberId);

    int insert(TeamMembers record);

    int insertSelective(TeamMembers record);

    TeamMembers selectByPrimaryKey(Integer memberId);

    int updateByPrimaryKeySelective(TeamMembers record);

    int updateByPrimaryKey(TeamMembers record);
}