package com.qht.io.zs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test02 {
	
	public static byte[] r(String srcFile) {
		
		try(InputStream is = new BufferedInputStream(new FileInputStream(srcFile));
				ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			 byte[] fulsh = new byte[1024];
			 int len = -1;
			 while((len = is.read(fulsh))!=-1) {
				 os.write(fulsh, 0, len);
			 }
			 os.flush();
			 return os.toByteArray();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void w(byte[] srcFile,String mbFile) {
		
		try(ByteArrayInputStream is = new ByteArrayInputStream(srcFile);
			OutputStream os = new BufferedOutputStream(new FileOutputStream(mbFile))  ){
			byte[] fulsh = new byte[1024];
			 int len = -1;
			 while((len = is.read(fulsh))!=-1) {
				 os.write(fulsh, 0, len);
			 }
			 os.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		byte[] datas = r("ab.mp4");
		w(datas,"ag.mp4");
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
}
