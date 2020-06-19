package com.qht.io.zs;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintSteam {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.print("大帅");
		ps.println(false);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("ps.txt")) ,true);
		ps.print("3366");
		ps.println(57467484);
		
		
//		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("ps.txt")) ,true);
//		pw.print(45674567);
		
		//重定向输出端
		System.setOut(ps);
		System.out.println("重定向");
		
		//重定向会控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("重定向");
	}
}
