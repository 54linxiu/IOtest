package com.qht;

import java.io.File;

public class Demo01 {
	
	public static void main(String[] args) {
		String path = "E:/data/IO/ac.jpeg";//用左斜杠
		System.out.println(File.separatorChar);
		path = "E:"+File.separator+"data"+File.separator+"IO"+File.separator+"ac.jpeg";
		System.out.println(path);
		
		//1.构建File对象
		File src = new File(path);
		System.out.println(src.length());
		
		//2.构建File对象
		src = new File("E:/data/IO","ac.jpeg");
		System.out.println(src.length());
		
		//3.构建File对象
		src = new File(new File("E:/data/IO"),"ac.jpeg");
		System.out.println(src.length());
	}
}
