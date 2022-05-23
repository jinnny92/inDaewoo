package kr.co.dw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	
	public void p91() {
	      
	      File f1 = new File("C:"+File.separator+"aaa_renameTo.txt");
	      File f2 = new File("C:", "BBB"+ File.separator+ "aaa.txt");
	      /* rename = functions moving file and rename 
	       * Directory can product file but file cannot*/
	      f1.renameTo(f2);
	   }
	   
	   public void p9() {
	      File f1 = new File("C:"+File.separator+"aaa.txt");
	      File f2 = new File("C:"+File.separator+"aaa_renameTo.txt");
	      
	      f1.renameTo(f2);
	      
	      
	   }
	
	
	
	
	public void p8() {
		InputStream in = null; //바이트 스트림
		InputStreamReader isr = null;
		BufferedReader br = null; //문자 스트림이라 바이트 스트림과 직접 결합이 안되기에 중간에 InputStreamReader을 쓴다
		
		File f = new File("c:", "BBB"+File.separator + "aaa.txt");
		
		try {
			
			in = new FileInputStream(f);
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
			String what = null;
			while ((what = br.readLine()) != null) {
				System.out.println(what);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		f.delete();
	}
	
	
	public void p71() {
	
		File f1 = new File("C:"+File.separator+"aaa_renameTo.txt");
	    File f2 = new File("C:", "BBB"+ File.separator + "aaa.txt");
		f1.renameTo(f2);
		
	}
	
	public void p7() {
		File f1 = new File("C:" + File.separator + "aaa.txt");
		File f2 = new File("C:" + File.separator + "aaa_renameTo.txt");
		
		f1.renameTo(f2);
		
	}
	
	
	public void p6() {
		File f = new File("C:" + File.separator + "d.zip");
		if (f.exists()) {
			f.delete();
		}
	}
	
	
	public void p5() {
		File f = new File("C:" + File.separator + "ddd");
		if(f.exists()) {
			f.delete();
		}
		
	}
	
	
	public void p41(String dirname) {
		File f = new File("C:" + File.separator + dirname);
		if (!f.exists()) {
			f.mkdir();
		}
	}
	
	
	
	public void p4() {
		File f = new File("C:" + File.separator +"AAA");
		if (!f.exists()) {
			f.mkdir(); //폴더는 만들 수 있지만 파일을 만들 수는 없다
		}
	}
	
	
	public void p3() {
		File f = new File("C:" +File.separator + "AAA");
		
		boolean isIt = f.exists(); //c드라이브에 AAA라는 실제 폴더가 있냐고 물어보는 exists
		//exists 굉장히 중요 폴더가 없으면 만들고 있으면 그냥 놔두는 역할
		System.out.println(isIt);
	}
	
	
	public void p2() {
		File f = new File("c:" + File.separator + "AAA"); //확장자가 없으니 AAA는 디렉토리(폴더) 얘는 디렉토리를 관리할 수 있는 file 객체
		//객체라서 ram에서 동작 드라이버에서는 동작안함
	}
	
	
	
	public void p1() {
		File f = new File("C:" + File.separator + "io.jpg"); //file 객체

		
	}

}
