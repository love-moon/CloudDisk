package com.cloud.auth.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.cloud.auth.manager.MenuManager;
import com.cloud.auth.mapper.MenuMapper;
import com.cloud.auth.mapper.RoleMapper;
import com.cloud.auth.model.entity.Menu;
import com.cloud.auth.model.entity.Role;

@Service
public class MenuManagerImpl implements MenuManager{
	@Autowired
	RoleMapper roleMapper;
	
	@Autowired
	MenuMapper menuMapper;
	
	@Override
	public String getMenuByUsername(String username) {
		// TODO Auto-generated method stub
		Role r=(Role)roleMapper.getRoleByUsername(username);
		if(r!=null) {
			
			List<Menu> mList=menuMapper.getMenuByRoleId(r.getId());
			
			String mStr=JSONArray.toJSONString(mList);
			return mStr;
		}else
		
		return null;
	}

}
