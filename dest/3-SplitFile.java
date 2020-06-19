e[] flush =new byte[1024];
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
