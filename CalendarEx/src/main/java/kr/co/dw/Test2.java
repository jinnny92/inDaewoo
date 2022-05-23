package kr.co.dw;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2
 */
@WebServlet("/test2")
public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		

		
		Date d2 = cal.getTime(); //캘린더 객체를 Date타입으로 바꾼것 getTime을 이용
		System.out.println(d2);
		
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		String naljja = sdf.format(d2);
		System.out.println(naljja);
		
		request.setAttribute("DATE", naljja);
		
		//출력값을 보고 캘린더 객체를 만드는 법 지금까지 공부한 것을 역순으로 가기
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd"); 
		//MM은 꼭 대문자로 적어야 한다 소문자는 시간의 분, 대문자는 달력의 month이기 때문
		try {
		Date d3 = sdf2.parse(naljja);
			Calendar ca12 = Calendar.getInstance();
			ca12.setTime(d3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("DATE", naljja);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
