package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.Affiche;

public interface AfficheMapper {
    int deleteByPrimaryKey(Integer afficheId);

    int insert(Affiche record);

    int insertSelective(Affiche record);

    Affiche selectByPrimaryKey(Integer afficheId);

    int updateByPrimaryKeySelective(Affiche record);

    int updateByPrimaryKeyWithBLOBs(Affiche record);

    int updateByPrimaryKey(Affiche record);
}