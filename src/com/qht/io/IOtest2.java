package com.qht.io;
/**
 * 文件字节输入流
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOtest2 {
	public static void main(String[] args) {
		File src =  new File("ab.txt");
		InputStream s = null;
		
		try {
			s = new FileInputStream(src);
			byte[] flush = new byte[1024];
			int len = -1;
			while((len=s.read(flush))!=-1) {
				String msg = new String(flush,0,len,"gbk");
				System.out.println(msg);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(s!=null)
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
