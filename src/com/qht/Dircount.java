package com.qht;

import java.io.File;

public class Dircount {
	//大小
	private  long len;
	//文件夹
	private String path;
	//文件的个数
	private int Filesize;
	//文件夹的个数
	private int Dirsize=-1;//算了自身 所以-1
	//源文件
	private File src;
	
	
	public Dircount(String path) {
		this.path = path;
		this.src = new File(path);
		count(this.src);
		
	}

	private void count(File src) {
		//获取大小
		if(src!= null && src.isFile() && src.exists()) {
			len += src.length();
			this.Filesize++;
		}else {
			this.Dirsize++;
			for(File s:src.listFiles()) {
				count(s);
			}
		}
	}
	
	public int getFilesize() {
		return Filesize;
	}

	public int getDirsize() {
		return Dirsize;
	}

	public long getLen() {
		return len;
	}
	
	public static void main(String[] args) {
		Dircount dir = new Dircount("E:/data/IO");
		System.out.println(dir.getLen()+"\t"+dir.getDirsize()+"\t"+dir.getFilesize());
	}
}
