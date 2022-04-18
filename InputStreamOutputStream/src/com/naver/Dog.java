package com.naver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.print.DocFlavor.INPUT_STREAM;


public class Dog{
	public void me7() {
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			in = new FileInputStream("C:" + File.separator + "c.zip");
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream("C:" + File.separator + "k.zip" );
			bos = new BufferedOutputStream(out);
			
			int what = -1;
			
			while ((what = bis.read()) != -1) {
//				what = bis.read();
//				if(what == -1) {
//					break;
//				}
				bos.write(what);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (bos != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	

	
	public void me6() {
		InputStream in = null;
		BufferedInputStream bis = null;
		
		OutputStream out = null;
		BufferedOutputStream bos = null;
		
		try {
			in = new FileInputStream("C:" + File.separator + "c.zip");
			bis = new BufferedInputStream(in);
			
			out = new FileOutputStream("C:" + File.separator + "e.zip");
			bos = new BufferedOutputStream(out);
			
			int what = -1;
			while ((what = bis.read()) != -1) {
				//what = bis.read();
//				if (what == -1) {
//					break;
//				}
				bos.write(what);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (bos != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public void me5() {
		InputStream in = null;
		OutputStream out = null;
				
				try {
					
					in = new FileInputStream("C:" + File.separator + "c.zip");
					out = new FileOutputStream("C:" + File.separator + "d.zip");
					
					byte[] arr = new byte[2048];
					int leng = -1; //더이상 가져올게 없으면 -1 아니면 가져올 숫자를 씀 45개면 int leng = 45;
					
					while ((leng = in.read(arr, 0, arr.length)) != -1) {
//						leng = in.read(arr, 0, arr.length);
//						if(leng == -1) {
//							break;
//						}
							out.write(arr, 0, leng);
					}
					System.out.println("end");
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
	}
	
	
	public void me4() {
		long start = System.currentTimeMillis();
		
		InputStream in = null;
		OutputStream out = null;
		
		
		try {
			in = new FileInputStream("C:" + File.separator + "c.zip");
			out = new FileOutputStream("C:" +File.pathSeparator + "b.zip");
			
			int what = -1;
			while ((what = in.read()) != -1) {
				out.write(what);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		

	
	public void me3() {
	long start = System.currentTimeMillis();
	
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			in = new FileInputStream("C:"+File.separator+"io.jpg");
			out = new FileOutputStream("C:"+File.pathSeparator+"b.jpg");
			
			
			int what = -1;
			
			while ((what = in.read()) != -1) {

					out.write(what);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public void me2() {
		System.out.println("\\"); //이스케이프문자 쓸때 역슬래쉬 먼저 쓴다. 나 이스케이프 쓸거임 하지만 경로와 관련되서는 이건 쓰면 안된다
	}
	

	public void me1() {
		System.out.println(File.separator); //앞으로 경로를 이용할때 이걸 사용하면 된다
	}
	
	
	
	
}
