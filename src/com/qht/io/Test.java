package com.qht.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Test {
	
	public static void main(String[] args) {
		
		copy("test.txt","mb.txt");
		
	}
	
	public static void copy(String y,String d) {
		File src = new File(y);
		File mb = new File(d);
		Reader read = null;
		Writer writer = null;
		
		try {
			read = new FileReader(src);
			writer = new FileWriter(mb);
			char[] datas = new char[1024];
			int len = -1;
			while((len = read.read(datas))!=-1) {
				String t = new String(datas,0,len);
				writer.write(t);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				read.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
			try {
				writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
