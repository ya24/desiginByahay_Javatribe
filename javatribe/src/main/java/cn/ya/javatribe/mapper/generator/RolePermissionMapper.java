package cn.ya.javatribe.mapper.generator;

import cn.ya.javatribe.model.generator.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}