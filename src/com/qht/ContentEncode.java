package com.qht;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符串-->字节
 * @param han
 */

public class ContentEncode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命a";//gbk中文占2字节  UTF8中文占3字节
		//编码
		byte[] datas = msg.getBytes();//使用默认工程字符集
		System.out.println(datas.length);
		
		//编码其他字符集
		datas = msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
	}
}
