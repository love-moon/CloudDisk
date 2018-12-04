package com.cloud.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.auth.manager.UserManager;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserManager userManagerImpl;
	
	@RequestMapping("/getUserInfo/{username}")
	String getUserInfo(@PathVariable("username")String username) {
		
		return userManagerImpl.getUserInfo(username);
	}
	@RequestMapping("/test")
	String test() {
		
		return userManagerImpl.getUserInfo("am");
	}
	
}
