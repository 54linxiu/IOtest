package com.qht;

import java.io.File;

public class DirDemo2 {
	public static void main(String[] args) {
		File src = new File("E:/data");
		printName(src,0);
		System.out.println(src.isFile());//是否为文件
	}
	
	public static void printName(File src,int deep) {
		for(int i = 0;i<deep;i++) {
			System.out.print("-");
		}
		
		System.out.println(src.getName());
		
		if(src == null || !src.exists()) {//检测文件是否存在
			return;
		}else if(src.isDirectory()) {//检测目录 是否为文件夹
			for(File s:src.listFiles()) {
				printName(s,deep+1);
			}
		}
	}
}
