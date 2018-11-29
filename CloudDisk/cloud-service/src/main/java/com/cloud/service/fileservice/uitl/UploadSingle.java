package com.cloud.service.fileservice.uitl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class UploadSingle {

	public static void main(String[] args) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
	       Configuration conf = new Configuration();
	        
	        URI uri = new URI("hdfs://192.168.1.188:9000");
	        
	        String fPath="F:\\我的文档\\My Music\\Amy Chanrich - IF You & Faded Remix.mp3";
	        
	        FileSystem fs = FileSystem.get(uri,conf);
	        Path resP = new Path(fPath);
	        Path destP = new Path("/test");
	        if(!fs.exists(destP)){
	            fs.mkdirs(destP);
	        }
	        String name = fPath.substring(fPath.lastIndexOf("/")+1, fPath.length());
	        fs.copyFromLocalFile(resP, destP);
	        System.out.println("name is " + name);
	        fs.close();
	}

}
