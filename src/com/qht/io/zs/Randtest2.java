package com.qht.io.zs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class Randtest2 {

	public static void main(String[] args) throws IOException {
		//�ֶ��ٿ�
		File src = new File("ps.txt");
		//�ܳ���
		long len = src.length();
		//ÿ���С
		int blockSize = 1024;
		//���ٿ�
		int size = (int)Math.ceil(len*1.0/blockSize);
		System.out.println(size);
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actulSize = (int) (blockSize>len?len:blockSize);
		for(int i = 0;i < size;i++) {
			beginPos = i*blockSize;
			if(i==size-1) {
				actulSize = (int)len;
			}else {
				actulSize = blockSize;
				len -= actulSize;
			}
			System.out.println(beginPos+"  "+actulSize+" "+i);
			split(i,beginPos,actulSize);
		}
	}
	
	public static void split(int i, int beginPos, int actulSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("ps.txt"),"r");
		OutputStream os = new FileOutputStream("dest/"+i+"Copy.txt");
		//��ʼλ��
		//ʵ�ʴ�С
		//�����д
		raf.seek(beginPos);
		//��ȡ
		//3����(�ֶζ�д)
		byte[] flush = new byte[1024];
		int len = -1;//���ܳ���
		while((len = raf.read(flush))!=-1) {
			if(actulSize>len) {
				
				os.write(flush, 0, len);
				actulSize -= len;
			}else {
				
				os.write(flush, 0, actulSize);
				break;

			}
		}
		
		raf.close();
	}
	
}
