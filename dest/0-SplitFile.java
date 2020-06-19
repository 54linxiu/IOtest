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
		this.destPaths = new ArrayList<Strin