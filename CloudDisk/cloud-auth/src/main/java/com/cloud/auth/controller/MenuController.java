package com.cloud.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.auth.manager.MenuManager;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuManager menuManager;
	
	@RequestMapping("/getUserMenu/{username}")
	String getUserMenu(@PathVariable("username")String username) {
		
		return menuManager.getMenuByUsername(username);
	}
	
}
