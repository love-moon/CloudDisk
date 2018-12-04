package com.cloud.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class FeignConfig {
	
	/*
	 * 用于Feign传文件
	 * */
    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
