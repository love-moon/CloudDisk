package com.cloud.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cloud.auth.model.entity.Menu;



@Mapper
public interface MenuMapper {
	@Select("SELECT * FROM menu")
	List<Menu> getAllMenu();
	
	@Select("SELECT menu.* FROM menu,role_menu WHERE menu.id=role_menu.menu_id and role_menu.role_id=#{roleid}")
	List<Menu> getMenuByRoleId(@Param("roleid") int roleid);
 }
