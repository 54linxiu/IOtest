g>();
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
		
		raf.s