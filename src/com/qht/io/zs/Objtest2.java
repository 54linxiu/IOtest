package com.qht.io.zs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;



public class Objtest2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.qht"));

		oos.writeChar('a');
		oos.writeUTF("ºÙºÙºÙ");
		yg g = new yg("heihie",123432.0);
		oos.writeObject(g);
		oos.writeObject(new Date());
		oos.flush();
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.qht")));
		char a = ois.readChar();
		String b = ois.readUTF();
		Object c = ois.readObject();
		Object d = ois.readObject();
		
		System.out.println(a+"  "+b);
		if(c instanceof yg) {
			yg r = (yg)c;
			System.out.println(r.getName()+"  "+r.getSalary());
		}
		if(d instanceof Date) {
			Date s = (Date)d;
			System.out.println(s);
		}
		ois.close();
	}
}

