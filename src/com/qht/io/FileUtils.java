package com.qht.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
	
	public static void close(Closeable... ios) {
		for(Closeable io:ios) {
			try {
				if(io!=null) {
					io.close();
				}
			}catch(IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void close(InputStream is,OutputStream os) {
		try {
			if(is!=null) {
				is.close();
			}
		}catch(IOException e) {
				e.printStackTrace();
			}
		
		try {
			if(os!=null) {
				os.close();
			}
		}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void copy(InputStream is,OutputStream os) {
		
		try {
			byte[] fulsh = new byte[1024*10];
			int len = -1;
			
			while((len = is.read(fulsh))!=-1) {
				os.write(fulsh, 0, len);
			}
			os.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			close(is,os);
		}
	}
	
	public static void main(String[] args) {
		
//		try {
//			InputStream is = new FileInputStream("test.txt");
//			OutputStream os = new FileOutputStream("text-copy.txt");
//			copy(is,os);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		byte[] datas = null;
		try {
			InputStream is = new FileInputStream("ac.jpeg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is,os);
			datas = os.toByteArray();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			InputStream is = new ByteArrayInputStream(datas);
			OutputStream os = new FileOutputStream("aw.jpeg");
			copy(is,os);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
