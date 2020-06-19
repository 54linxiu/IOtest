g>();
		//初始化
		init();
	}

	
	//初始化
	private void init() {
		//总长度
		long len = this.src.length();
		
		//多少块
		this.size = (int)Math.ceil(len*1.0/blockSize);
		//路径
		for(int i = 0;i<size;i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	public void spilt() throws IOException {
		
		//总长度
		long len = src.length();
		
		//起始位置和实际大小
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
		//起始位置
		
		raf.s