package com.qht.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
	public static void main(String[] args) {
//		copy("src/com/qht/Lx.java","icopy.txt");
	}
	public  void copy(String srcPath,String destPath) {
		File src = new File(srcPath);
		File src1 = new File(destPath);
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(src1,true);
			byte[] flush = new byte[1024];
			int len = -1;
			while((len = is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			try {
				os.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
