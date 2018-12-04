package com.cloud.auth.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.auth.manager.UserManager;
import com.cloud.auth.mapper.UserMapper;
import com.cloud.auth.model.entity.User;

@Service
public class UserManagerImpl implements UserManager{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public String getUserInfo(String username) {
		
		User u=(User)userMapper.findUserByUsername(username);
		if(u==null)
			return null;
		else {
			
			String uStr=JSONObject.toJSONString(u);
			
			return  uStr;
		}	
		}
	
}
