package com.cloud.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cloud.auth.mapper.RoleMapper;
import com.cloud.auth.mapper.UserMapper;
import com.cloud.auth.model.entity.Role;
import com.cloud.auth.model.entity.User;
import com.cloud.auth.model.vo.MyUserPrincipal;



@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=(User)userMapper.findUserByUsername(username);
		
		if(user==null) {
			System.out.println("===============NULL==============");
		}
		Role role=roleMapper.getRoleByUserId(user.getId());
		return new MyUserPrincipal(user,role);
	}

}
