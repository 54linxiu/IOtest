package com.qht.io.zs;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Datatest {
	
	public static void main(String[] args){
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("copy.txt"));
		DataInputStream dis = new DataInputStream(new FileInputStream("adf.txt"));) {
		
			String msg = null;
			while((msg=dis.readLine())!=null) {
				dos.writeChars(msg);;
				
			}
			dos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
