package com.qht;

import java.io.File;

/**
 * ����File��
 * ���·���;���·��
 * 1�������̷��Ǿ���·��
 * 2���������̷������·��
 * @author q
 *
 */

public class Demo02 {
	
	public static void main(String[] args) {
		String path = "E:/data/IO/ac.jpeg";
		
		//����·��
		File src = new File(path);
		System.out.println(src.getAbsolutePath());
		
		//���·��
		System.out.println(System.getProperty("user.dir"));
		src = new File("ac.jpeg");
		System.out.println(src.getAbsolutePath());
	}
}
