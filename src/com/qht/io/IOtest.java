package com.qht.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOtest {
	
	public static void main(String[] arsgs) {
		copy("src/com/qht/Lx.java","test.txt");
	}
	
	public static void copy(String srcPath,String destPath) {
		
		InputStream is = null;
		OutputStream os = null;
		
		
		
		try {
			is = new FileInputStream(srcPath);
			os = new FileOutputStream(destPath);
			byte[] fulsh = new byte[1024];
			int len = -1;
			while((len = is.read(fulsh)) != -1){
				os.write(fulsh, 0, len);
			}
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			}catch(IOException e){
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
