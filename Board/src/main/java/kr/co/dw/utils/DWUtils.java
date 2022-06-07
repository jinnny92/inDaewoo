package kr.co.dw.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

public class DWUtils {
	
	public static String getImgFilePath(String filename) {
		String orgName = null;
		String prefix = filename.substring(0, 12); // /2022/06/03/
		String suffix = filename.substring(14); //uuid_oriname.png
		
		orgName = prefix + suffix;
		
		
		return orgName;
	}
	
	
	public static void deleteFile(String uploadPath, String filename) {
		
		//filename이 폴더로 끝나면 해당 폴더가 삭제
		//filename이 파일명으로 끝나면 해당 파일이 삭제
		//filename을 보고 파일인지 폴더인지 어떻게 구분하나? 확장자가 있으면 파일, 없으면 폴더
		
		File deleteFile = new File(uploadPath, filename);
		
		if (deleteFile.exists()) {
			deleteFile.delete();
		}
		if(isImgFile(filename)) {
		String orgImgPath	= getImgFilePath(filename);
		File deleteOrgImgFile = new File(uploadPath, orgImgPath);
		if (deleteOrgImgFile.exists()) {
			deleteOrgImgFile.delete();
			}
		} // 이미지 파일일때만 작업을 할 수 있게
		
	}
	
	public static MediaType getMediaType(String filename) { //utils 메서드는 static을 주로쓴다 이유는 사용하게 편리하기 위해 아니면 객체를 또 만들어줘야해서 귀찮아진다
		Map<String, MediaType> map = new HashMap<String, MediaType>();
		map.put("png", MediaType.IMAGE_PNG);
		map.put("gif", MediaType.IMAGE_GIF);
		map.put("jpg", MediaType.IMAGE_JPEG);
		map.put("jpeg", MediaType.IMAGE_JPEG);
		
		int idx = filename.lastIndexOf(".") + 1;
		String formatName = filename.substring(idx).toLowerCase();
		
		
		MediaType mType=  map.get(formatName); //위에 네 개 파일타입중 없는 파일 그러니까 txt파일 같은게 들어오면 null이 반환된다
		
		return mType;
	}
	
	
	
	//실제 파일 업로드하는 코드
	public static String uploadFile(String uplodePath, String oriName, byte[] fildData) throws Exception {
		String uploadedFilename = "";
		
		String datePath =  makefolder(uplodePath); //폴더를 만들어 보자
		String newFilename = makeNewFileName(oriName); // a.png => sjfkjfkjk_a.png
		
		FileCopyUtils.copy(fildData, new File(uplodePath+datePath,newFilename));
		
		boolean isImg = isImgFile(newFilename);//이미지 포멧인지 확인하기 이미지파일이면 true 아니면 false
		
		if (isImg) {
			//이미지 파일이면 썸네일을 호출
		try {
			uploadedFilename	=  makeThumbnail(uplodePath, datePath, newFilename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}else {
			uploadedFilename = makeIcon(datePath, newFilename);
		}
		
		
		return uploadedFilename;
	}
	
	//썸네일이 아닐경우
	public static String makeIcon(String datePath, String newFilename) {
		
		String iconPath = datePath + File.separator + newFilename;
		
		
		
		return iconPath.replace(File.separatorChar, '/');
		
	}
	
	
	public static String makeThumbnail(String uploadPath, 
            String datePath, 
            String newFilename) throws Exception {
String thumbnailPath = null;
//원래 파일을 Ram에 올려줄거임 그래야 속도가 빠르니까
System.out.println(datePath);

//BufferedImage 두번 나온거 = 더블버퍼링 이미지 출력할때 
BufferedImage sourceImg = 
ImageIO.read(new File(uploadPath+datePath, newFilename)); //이미지를 읽어오는 작업, 원본이미지가 ram에 올라가있는 상태

//램에다가 이 이미지를 축소해서 저장할 수 있는 공간을 만들자
BufferedImage destImg = Scalr.resize(sourceImg, 
            Scalr.Method.AUTOMATIC, 
            Scalr.Mode.FIT_TO_HEIGHT,
            100); //파일에 들어갈 이미지는 여기에 있음

//파일명과 확장자를 지정해주는 작업과 파일로 만드는 작업을 해줘야한다
String thumbnamiNamePath = datePath+File.separator+"s_"+newFilename;

int idx = newFilename.lastIndexOf(".") + 1;
String formatName = newFilename.substring(idx).toLowerCase();

ImageIO.write(destImg, formatName.toLowerCase(), new File(uploadPath, thumbnamiNamePath)); //썸네일이 저장이 되었다!


thumbnailPath = thumbnamiNamePath.replace(File.separatorChar, '/');//이런걸 사용하지 않으면 자바의 특징인 플랫폼 독립적이라는 특성이 없어지므로 사용해야한다


return thumbnailPath;
}

	
	

	
	
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
	
	public static String makefolder(String parent) {
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) +1;
			int date = cal.get(Calendar.DATE);
			//year안에 month가 month안에 date가 들어간다
			
			 File parentPath = new File(parent); 
			 
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
		return File.separator+year+File.separator+
				new DecimalFormat("00").format(month)+File.separator+
				new DecimalFormat("00").format(date);
		
		//exists() 존재하냐? 하고 물어보는거~ / new DecimalFormat("00") 양식을 두자리로 표시하겠다는 의미
		//파일 저장 위치를 알려줘야 하니까 (최종적으로 dateFolder 안에 저장할 것임) 
		
	
	}
}
