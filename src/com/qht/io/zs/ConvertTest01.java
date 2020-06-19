package com.qht.io.zs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

public class ConvertTest01 {
	public static void main(String[] args) {
		try(BufferedReader bfr = 
				new BufferedReader(
						new InputStreamReader(
								new URL("http://www.baidu.com").openStream(),"utf8"));
			BufferedWriter bfw = 
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("baidu.txt",true)));) {
			String msg = null;
			while((msg = bfr.readLine())!=null) {
				System.out.println(msg);
				bfw.write(msg);
				bfw.newLine();
			}
			bfw.flush();
		}catch(IOException e) {
			System.out.println("cw");
		}
	}
}
