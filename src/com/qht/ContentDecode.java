package com.qht;

import java.io.UnsupportedEncodingException;

/**
 * ���룺�ֽ�-->�ַ���
 * @param han
 */

public class ContentDecode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "��������ʹ��a";//gbk����ռ2�ֽ�  UTF8����ռ3�ֽ�
		//����
		byte[] datas = msg.getBytes("utf8");//ʹ��Ĭ�Ϲ����ַ���
		
		//����
		msg = new String(datas,0,datas.length-1,"utf8");
		System.out.println(msg);
		
		//����
		//1���ֽ�������
		msg = new String(datas,0,datas.length-2,"utf8");
		System.out.println(msg);
		//2���ַ���ͳһ ������ͽ��붼����ʹ����ͬ�ַ���
		msg = new String(datas,0,datas.length-1,"gb2312");
		System.out.println(msg);
	}
}
