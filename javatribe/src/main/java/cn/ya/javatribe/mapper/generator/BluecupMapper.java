package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.Bluecup;

public interface BluecupMapper {
    int deleteByPrimaryKey(Integer bluecupId);

    int insert(Bluecup record);

    int insertSelective(Bluecup record);

    Bluecup selectByPrimaryKey(Integer bluecupId);

    int updateByPrimaryKeySelective(Bluecup record);

    int updateByPrimaryKey(Bluecup record);
}