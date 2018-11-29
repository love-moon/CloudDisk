package com.cloud.service.fileservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
	
	
	@RequestMapping("/upload")
	String uploadFile(MultipartFile file) {
		
		return file.getOriginalFilename();
	}
	
}
