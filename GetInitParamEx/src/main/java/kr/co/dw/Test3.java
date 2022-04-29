package kr.co.dw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/test3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ServletContext application = request.getServletContext();
	InputStream in =	application.getResourceAsStream(File.separator+"WEB-INF"+File.separator+"show.txt");
	
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<body>");
			
			
			String what = null;
			
			while (true) {
			what = br.readLine();
			if (what == null) { //파일 업로드, 다운로드 구현할떄 나올수 있으니 암기하기
				break;
				}
				out.println(what);
				out.println("<br>");
			}
			out.print("</html>");
			out.print("</body>");
			
		response.getWriter().append("Served at: ").
		append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
