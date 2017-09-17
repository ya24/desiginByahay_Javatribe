package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.Attachfile;

public interface AttachfileMapper {
    int deleteByPrimaryKey(String attachfileId);

    int insert(Attachfile record);

    int insertSelective(Attachfile record);

    Attachfile selectByPrimaryKey(String attachfileId);

    int updateByPrimaryKeySelective(Attachfile record);

    int updateByPrimaryKey(Attachfile record);
}