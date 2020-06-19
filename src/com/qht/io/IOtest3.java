package com.qht.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * �ļ��ֽ������
 * 1.����Դ
 * 2.ѡ����
 * 3.������д�����ݣ�
 * 4.�ͷ�
 * @author q
 *
 */
public class IOtest3 {
	public static void main(String[] args) {
		//1����
		File dest = new  File("dest.txt");
		//2ѡ����
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(dest,true);
			//3д��
			String msg = "IO is so easy\r\n";
			byte[] datas = msg.getBytes();
			os.write(datas, 0, datas.length);
			os.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
