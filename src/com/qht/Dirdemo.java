package com.qht;

import java.io.File;
/**
 * mkdir 必须有上级目录
 * mkdirs 无需上级目录
 * @author q
 *
 */
public class Dirdemo {
	public static void main(String[] args) {
		File dir = new File("E:/data/");
		
//		boolean flag = dir.delete();
//		System.out.println(flag);
		
		//列出下一级
		//list() 列出夏季名称
		//listFiles()列出下级File对象
		
		String[] sub = dir.list();
		for(String s:sub) {
			System.out.println(s);
		}
		
		//下级对象
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
