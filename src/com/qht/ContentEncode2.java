package com.qht;

/**
 * ���룺�ַ���-->�ֽ�
 * @param han
 */

public class ContentEncode2 {
	
	public static void main(String[] args) {
		String msg = "��������ʹ��a";//gbk����ռ2�ֽ�  UTF8����ռ3�ֽ�
		//����
		byte[] datas = msg.getBytes();//ʹ��Ĭ�Ϲ����ַ���
		System.out.println(datas.length);
	}
}
