package com.qht.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOtest5 {
	
	public static void main(String[] args) {
		byte[] datas =toByteArray("ac.jpeg");
		System.out.println(datas.length);
		toFile(datas,"acd.jpeg");
	}
	
	public static byte[] toByteArray(String filePath) {
		File src = new File(filePath);
		
		
		
		
		try(InputStream is = new FileInputStream(src);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			
			
			byte[] flush = new byte[1024*10];
			int len = -1;
			while((len = is.read(flush))!=-1){
				baos.write(flush, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void toFile(byte[] src,String filePath) {
		File dest = new File(filePath);
		
		ByteArrayInputStream is = null;
		OutputStream os = null;
		
		try {
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(filePath);
			byte[] flush = new byte[1024];
			int len = -1;
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
			is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
