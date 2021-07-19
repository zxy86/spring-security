package com.itheima.mapper;

import com.itheima.domain.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Classname RoleMapper
 * @Date 2021/7/16 14:16
 * @Created by GAEA
 */
public interface RoleMapper extends Mapper<SysRole> {

    @Select("select r.id,r.role_name roleName,r.role_desc roleDesc " +
            "from sys_role r,sys_user_role ur " +
            "where r.id=ur.rid and ur.uid=#{uid}")
    List<SysRole> findByUid(Integer uid);
}
