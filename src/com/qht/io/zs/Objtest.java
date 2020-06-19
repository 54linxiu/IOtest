package com.qht.io.zs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;



public class Objtest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));

		oos.writeChar('a');
		oos.writeUTF("嘿嘿嘿");
		yg g = new yg("heihie",123432.0);
		oos.writeObject(g);
		oos.writeObject(new Date());
		oos.flush();
		byte[] datas = baos.toByteArray();
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
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
	}
}

class yg implements java.io.Serializable{
	private transient String name;//该数据不需要序列化
	private double salary;
	public yg(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public yg() {
		
	}

	public String getName() {
		return name;
	}

	

	public double getSalary() {
		return salary;
	}

	
	
}