package kr.co.dw;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		String[] ids = TimeZone.getAvailableIDs();
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			System.out.println(id);
		}
		
		TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(tz);
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = cal.get(Calendar.MONTH);
		System.out.println(month+1);
		
		int date = cal.get(Calendar.DATE);
		System.out.println(date);
		
		int date2 = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(date2);
		
		int hour = cal.get(Calendar.HOUR);
		System.out.println(hour);
		
		Calendar cal2 = Calendar.getInstance();
		System.out.println(cal2);
		
		cal2.set(Calendar.DATE, 19); //month.JANUARY는 에러. int자료형인데 enum을 집어넣었더니 안들어간다
		System.out.println(cal2);
		
		cal2.set(2021, 12, 1);
		System.out.println(cal2);
		
		
		cal2.set(2022, 3, 20);
		//지금으로부터 1개월 후의 날짜는? 
		
		cal2.add(Calendar.DATE, 13);
		System.out.println(cal2.getTime());
		
		cal2.add(Calendar.HOUR, 22); //add는 다른 필드까지 바뀜
		System.out.println(cal2.getTime());
		
		
		cal2.roll(Calendar.HOUR, 23);//roll은 자기 필드만 바뀔
		System.out.println(cal2.getTime());
		
		System.out.println(cal.getTime());
		System.out.println(cal2.getTime());
	
		boolean result = cal.before(cal2);
		System.out.println(result);
		
		result = cal.after(cal2);
		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
