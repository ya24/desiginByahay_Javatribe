package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.ExamineFrequency;

public interface ExamineFrequencyMapper {
    int deleteByPrimaryKey(Integer frequencyId);

    int insert(ExamineFrequency record);

    int insertSelective(ExamineFrequency record);

    ExamineFrequency selectByPrimaryKey(Integer frequencyId);

    int updateByPrimaryKeySelective(ExamineFrequency record);

    int updateByPrimaryKey(ExamineFrequency record);
}