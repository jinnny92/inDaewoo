package kr.co.dw.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Util {
	public static String mkfolder() {
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month  = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		
		File parentPath = new File("C:" + File.separator + "day");
		
		File yearPath = new File(parentPath, year+"");
		if (!yearPath.exists()) {
			yearPath.mkdir();
		}
		
		File monthPath = new File(yearPath, new DecimalFormat("00").format(month));
			if (!monthPath.exists()) {
				monthPath.mkdir();
			}
		
		
		File datePath = new File(monthPath, new DecimalFormat("00").format(date));
			if (!datePath.exists()) {
				datePath.mkdir();
			}
		
		return datePath.getPath();
	}
}
