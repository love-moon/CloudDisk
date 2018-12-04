package com.cloud.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.auth.feign.FileServiceFeign;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	FileServiceFeign fileServiceFeign; 
	
	@PostMapping("/upload")
	String uploadFile(MultipartFile file) {
		
		return fileServiceFeign.fileUpload(file);
	}
}
