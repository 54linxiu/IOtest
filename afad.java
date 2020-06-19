package com.qht.io.zs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.sound.midi.Sequence;

public class SplitFile {
	//Դͷ
	private File src;
	//Ŀ�ĵأ��ļ���)
	private String destDir;
	//���зָ����ļ��洢·��
	private List<String> destPaths;
	//ÿ���С
	private int blockSize;
	//����:���ٿ�
	private int size;
	
	public SplitFile(String src, String destDir) {
		this(src, destDir, 1024);
	}

	public SplitFile(String src, String destDir, int blockSize) {
		
		this.src = new File(src);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();
		//��ʼ��
		init();
	}

	
	//��ʼ��
	private void init() {
		//�ܳ���
		long len = this.src.length();
		
		//���ٿ�
		this.size = (int)Math.ceil(len*1.0/blockSize);
		//·��
		for(int i = 0;i<size;i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	public void spilt() throws IOException {
		
		//�ܳ���
		long len = src.length();
		
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos = 0;
		int actulSize = (int) (blockSize>len?len:blockSize);
		for(int i = 0;i < size;i++) {
			beginPos = i*blockSize;
			if(i==size-1) {
				actulSize = (int)len;
			}else {
				actulSize = blockSize;
				len -= actulSize;
			}
			System.out.println(beginPos+"  "+actulSize+" "+i);
			splitDetail(i,beginPos,actulSize);
		}
	}
	
	
	
	private  void splitDetail(int i, int beginPos, int actulSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(this.src,"r");
		OutputStream os = new FileOutputStream(this.destPaths.get(i));
		//��ʼλ��
		
		raf.seek(beginPos);
		//��ȡ
		//3����(�ֶζ�д)
		byte[] flush = new byte[1024];
		int len = -1;//���ܳ���
		while((len = raf.read(flush))!=-1) {
			if(actulSize>len) {
				
				os.write(flush, 0, len);
				actulSize -= len;
			}else {
				
				os.write(flush, 0, actulSize);
				break;

			}
		}
		
		raf.close();
	}
	
	public  void merge(String destPath) throws IOException {
		//�����
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
		//������
		Vector<InputStream> vi = new Vector<InputStream>();
		SequenceInputStream sis = null;
		for(int i = 0; i < destPaths.size();i++) {
//			InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
//			byte[] flush =new byte[1024];
//			int len = -1;
//			while((len = is.read(flush))!=-1) {
//				System.out.println(len);
//				os.write(flush,0,len);
			}
		sis = new SequenceInputStream(vi.elements());
			byte[] flush =new byte[1024];
			int len = -1;
			while((len = sis.read(flush))!=-1) {
				System.out.println(len);
				os.write(flush,0,len);
			}
			os.flush();
			sis.close();
			os.close();
	}
	
	public static void main(String[] args) throws IOException {
		SplitFile sf = new SplitFile("src/com/qht/io/zs/SplitFile.java", "dest");
		sf.spilt();
		sf.merge("afad.java");
	}
}
