package com.qht;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节-->字符串
 * @param han
 */

public class ContentDecode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "性命生命使命a";//gbk中文占2字节  UTF8中文占3字节
		//编码
		byte[] datas = msg.getBytes("utf8");//使用默认工程字符集
		
		//解码
		msg = new String(datas,0,datas.length-1,"utf8");
		System.out.println(msg);
		
		//乱码
		//1）字节数不够
		msg = new String(datas,0,datas.length-2,"utf8");
		System.out.println(msg);
		//2）字符不统一 ：编码和解码都必须使用相同字符集
		msg = new String(datas,0,datas.length-1,"gb2312");
		System.out.println(msg);
	}
}
