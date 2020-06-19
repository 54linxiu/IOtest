package com.qht;

/**
 * 编码：字符串-->字节
 * @param han
 */

public class ContentEncode2 {
	
	public static void main(String[] args) {
		String msg = "性命生命使命a";//gbk中文占2字节  UTF8中文占3字节
		//编码
		byte[] datas = msg.getBytes();//使用默认工程字符集
		System.out.println(datas.length);
	}
}
