package com.cloud.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cloud.auth.model.entity.Role;



@Mapper
public interface RoleMapper {
	@Select("SELECT role.* FROM role,user_role where  user_role.role_id=role.id and user_role.user_id=#{userid}")
	Role getRoleByUserId(@Param("userid") int userid);
}
