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
		ps.print("��˧");
		ps.println(false);
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("ps.txt")) ,true);
		ps.print("3366");
		ps.println(57467484);
		
		
//		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("ps.txt")) ,true);
//		pw.print(45674567);
		
		//�ض��������
		System.setOut(ps);
		System.out.println("�ض���");
		
		//�ض�������̨
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
		System.out.println("�ض���");
	}
}
