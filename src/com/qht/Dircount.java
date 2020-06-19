package com.qht;

import java.io.File;

public class Dircount {
	//��С
	private  long len;
	//�ļ���
	private String path;
	//�ļ��ĸ���
	private int Filesize;
	//�ļ��еĸ���
	private int Dirsize=-1;//�������� ����-1
	//Դ�ļ�
	private File src;
	
	
	public Dircount(String path) {
		this.path = path;
		this.src = new File(path);
		count(this.src);
		
	}

	private void count(File src) {
		//��ȡ��С
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
