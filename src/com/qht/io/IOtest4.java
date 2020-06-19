package com.qht.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class IOtest4 {
	public static void main(String[] args) {
		byte[] src = null;
		
		ByteArrayOutputStream baos = null;
		
		try {
			baos = new ByteArrayOutputStream();
			String msg = "zhenai yongbutingzhi\r\nzhenaiyongbutingzhi";
			byte[] s = msg.getBytes();
			baos.write(s,0,s.length);
			baos.flush();
			src = baos.toByteArray();
			System.out.println(src.length+"   "+new String(src,0,baos.size()));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
