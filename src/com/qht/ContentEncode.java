package com.qht;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ַ���-->�ֽ�
 * @param han
 */

public class ContentEncode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "��������ʹ��a";//gbk����ռ2�ֽ�  UTF8����ռ3�ֽ�
		//����
		byte[] datas = msg.getBytes();//ʹ��Ĭ�Ϲ����ַ���
		System.out.println(datas.length);
		
		//���������ַ���
		datas = msg.getBytes("UTF-16LE");
		System.out.println(datas.length);
	}
}
