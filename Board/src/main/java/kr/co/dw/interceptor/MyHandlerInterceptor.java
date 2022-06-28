package kr.co.dw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyHandlerInterceptor extends HandlerInterceptorAdapter{//끝에 Adapter가 들어간 애들은 오버라이딩을 하는데 본문에 아무것도 없이 그냥 구현하는 것을 의미한다 빈껍데기메서드

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("111111");
		
		//특정 MVC핸들러가 실행되기 전에 얘가 실행이 된다
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("33333");
		
		//특정 MVC핸들러가 실행된 후에 얘가 실행이 된다
	} 

}
