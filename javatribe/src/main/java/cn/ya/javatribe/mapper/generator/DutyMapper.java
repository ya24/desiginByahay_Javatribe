package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.Duty;

public interface DutyMapper {
    int deleteByPrimaryKey(Integer dutyId);

    int insert(Duty record);

    int insertSelective(Duty record);

    Duty selectByPrimaryKey(Integer dutyId);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);
}