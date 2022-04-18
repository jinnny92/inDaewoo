package kr.co.dw.member.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class KrEncodingFilter
 */
@WebFilter("/*") //모든 요청에 대해 얘가 적용되게 하기 위해서 /*
public class KrEncodingFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public KrEncodingFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//필터를 적용할때 클라이언트가 서버쪽으로 요청할때 그 사이에 끼어들어서 작업하고 싶으면 chain.doFilter 위에 적는다
		
		chain.doFilter(request, response); //요청과 응답의 기준점이 됨 
		
		//서버가 클라이언트한테 응답을 할때 뭔가 일을 만들고 싶으면 chain.doFilter 밑에 적는다
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
