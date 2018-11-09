package com.cloud.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FallbackController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());


	@RequestMapping("/hystrixTimeout")
	    public String fallback(){
		log.error("service-gateway触发了断路由");
	        return "error";
	    }
	}

