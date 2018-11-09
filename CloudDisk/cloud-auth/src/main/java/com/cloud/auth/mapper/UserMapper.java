package com.cloud.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cloud.auth.model.entity.User;


@Mapper
public interface UserMapper {

	
	@Select("Select * From user Where username=#{username}")
	User findUserByUsername(@Param("username") String username);
}
