package kr.co.dw.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DWUtils {
	public static boolean isImgFile(String newFilename) {
		boolean  isImageFile = false;
		
		List<String> list = new ArrayList<String>();
		list.add("png");
		list.add("gif");
		list.add("jpg");
		list.add("jpeg");
		
		//newFilename = "aaaa.aaa.aaaa_a.png";
		int idx = newFilename.lastIndexOf(".") + 1; // . 다음부터 잘라내기 할거기 때문에 +1을 해준것
		 
		String formatName =	newFilename.substring(idx).toLowerCase(); // .toLowerCase()를 이용해서 소문자로 바꿔주기
		
		isImageFile = list.contains(formatName);
		
		
		return isImageFile;
	}
	
	
	
	
	public static String makeNewFileName(String oriName) {
		String newFilename = null;
			
		UUID uid = UUID.randomUUID(); //시스템이 켜져 있는 동안은 중복되지 않은 값을 넘겨주는 코드
		newFilename = uid.toString()+"_"+oriName;
		

		return newFilename;
	}
	
	
	public static String makefolder() {
		
	
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) +1;
			int date = cal.get(Calendar.DATE);
			//year안에 month가 month안에 date가 들어간다
			
			 File parentPath = new File("C:"+File.separator+"upload");
			 
			 File yearFile = new File(parentPath, year+"");
			 
			 if (!yearFile.exists()) {
				 	yearFile.mkdir();
			
			}
			 
			File monthFile = new File(yearFile, new DecimalFormat("00").format(month));
			 
			if (!monthFile.exists()) {
				monthFile.mkdir();
			}
			 
			
			
			File dateFile = new File(monthFile, new DecimalFormat("00").format(date));
			if (!dateFile.exists()) {
				dateFile.mkdir();
				
			
				
			}
		return dateFile.getPath();
		
		//exists() 존재하냐? 하고 물어보는거~ / new DecimalFormat("00") 양식을 두자리로 표시하겠다는 의미
		//파일 저장 위치를 알려줘야 하니까 (최종적으로 dateFolder 안에 저장할 것임) 
		
	
	}
}
