package com.qht.io.zs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Copy {
	public static void main(String[] args) {
		Copy c = new Copy(); 
		c.copy("adf.txt","copy-a.txt");
	}
	public  void copy(String srcPath,String destPath) {
		
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(new File(srcPath)));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(destPath)));) {
			
			String str = null;
			while((str = br.readLine())!=null) {
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
