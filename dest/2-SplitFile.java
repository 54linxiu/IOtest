eek(beginPos);
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
			byt