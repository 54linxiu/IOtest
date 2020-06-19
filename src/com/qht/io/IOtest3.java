package com.qht.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放
 * @author q
 *
 */
public class IOtest3 {
	public static void main(String[] args) {
		//1创建
		File dest = new  File("dest.txt");
		//2选择流
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(dest,true);
			//3写出
			String msg = "IO is so easy\r\n";
			byte[] datas = msg.getBytes();
			os.write(datas, 0, datas.length);
			os.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
