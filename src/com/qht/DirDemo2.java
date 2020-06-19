package com.qht;

import java.io.File;

public class DirDemo2 {
	public static void main(String[] args) {
		File src = new File("E:/data");
		printName(src,0);
		System.out.println(src.isFile());//�Ƿ�Ϊ�ļ�
	}
	
	public static void printName(File src,int deep) {
		for(int i = 0;i<deep;i++) {
			System.out.print("-");
		}
		
		System.out.println(src.getName());
		
		if(src == null || !src.exists()) {//����ļ��Ƿ����
			return;
		}else if(src.isDirectory()) {//���Ŀ¼ �Ƿ�Ϊ�ļ���
			for(File s:src.listFiles()) {
				printName(s,deep+1);
			}
		}
	}
}
