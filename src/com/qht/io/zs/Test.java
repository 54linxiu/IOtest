package com.qht.io.zs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));){
			String msg = "";
			while(!msg.equals("exit")) {
				msg = bfr.readLine();
				bfw.write(msg);
				bfw.flush();
			}
		}catch(IOException e) {
			System.out.println("´í");
		}
		
	}
}
