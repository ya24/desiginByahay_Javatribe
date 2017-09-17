package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.ExamineWork;

public interface ExamineWorkMapper {
    int deleteByPrimaryKey(Integer workId);

    int insert(ExamineWork record);

    int insertSelective(ExamineWork record);

    ExamineWork selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(ExamineWork record);

    int updateByPrimaryKey(ExamineWork record);
}