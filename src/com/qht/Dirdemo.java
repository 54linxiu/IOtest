package com.qht;

import java.io.File;
/**
 * mkdir �������ϼ�Ŀ¼
 * mkdirs �����ϼ�Ŀ¼
 * @author q
 *
 */
public class Dirdemo {
	public static void main(String[] args) {
		File dir = new File("E:/data/");
		
//		boolean flag = dir.delete();
//		System.out.println(flag);
		
		//�г���һ��
		//list() �г��ļ�����
		//listFiles()�г��¼�File����
		
		String[] sub = dir.list();
		for(String s:sub) {
			System.out.println(s);
		}
		
		//�¼�����
		File[] f = dir.listFiles();
		for(File s:f) {
			System.out.println(s);
		}
		
		File[] ff = dir.listRoots();
		for(File s:ff) {
			System.out.println(s);
		}
	}
}
