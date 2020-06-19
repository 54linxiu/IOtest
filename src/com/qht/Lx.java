package com.qht;

import java.io.File;

public class Lx {
	//大小
	private int len;
	//文件夹
	private String path;
	//文件夹
	private int dircount=-1;
	//文件个数
	private int filecount;
	//源文件
	File src;
	public Lx(String path) {
		this.path=path;
		this.src=new File(path);
		count(this.src);
	}
	
	public void count(File src) {
		if(src!=null && src.exists() && src.isFile()) {
			this.filecount++;
			len+=src.length();
		}else if(src.isDirectory()) {
			this.dircount++;
			for(File t:src.listFiles()) {
				count(t);
			}
		}
	}

	public int getLen() {
		return len;
	}

	public int getDircount() {
		return dircount;
	}

	public int getFilecount() {
		return filecount;
	}
	
	public static void main(String[] args) {
		Lx s = new Lx("E:/data/IO");
		System.out.println(s.getLen()+"   "+s.getDircount()+" "+s.getFilecount());
	}
}
