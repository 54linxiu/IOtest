package com.qht;

import java.io.File;

/**
 * 构建File类
 * 相对路径和绝对路径
 * 1）存在盘符是绝对路径
 * 2）不存在盘符是相对路径
 * @author q
 *
 */

public class Demo02 {
	
	public static void main(String[] args) {
		String path = "E:/data/IO/ac.jpeg";
		
		//绝对路径
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//相对路径
		System.out.println(System.getProperty("user.dir"));
		src = new File("ac.jpeg");
		System.out.println(src.getAbsolutePath());
	}
}
