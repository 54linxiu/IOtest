package com.qht;

import java.io.File;

public class Demo01 {
	
	public static void main(String[] args) {
		String path = "E:/data/IO/ac.jpeg";//����б��
		System.out.println(File.separatorChar);
		path = "E:"+File.separator+"data"+File.separator+"IO"+File.separator+"ac.jpeg";
		System.out.println(path);
		
		//1.����File����
		File src = new File(path);
		System.out.println(src.length());
		
		//2.����File����
		src = new File("E:/data/IO","ac.jpeg");
		System.out.println(src.length());
		
		//3.����File����
		src = new File(new File("E:/data/IO"),"ac.jpeg");
		System.out.println(src.length());
	}
}
