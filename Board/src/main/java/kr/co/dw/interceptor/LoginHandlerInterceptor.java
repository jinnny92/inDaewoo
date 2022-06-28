package kr.co.dw.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.dw.domain.MemberDTO;

public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		return true;
	}
	
	
	//ture가 되면 MVC핸들러로 넘어감, 하지만 false가 되면 MVC로 넘어가지 않기 때문에 여기서 리퀘스트와 리스폰스를 이용해서 포워딩작업을 해줘야함
	//가령 글쓰기를 하려는데 로그인이 안되어 있을때....
	// 컨트롤러로 무조건 넘어가야 할때는 true
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// Model = 데이터, View = jsp
		Map<String, Object> map = modelAndView.getModel();
		MemberDTO login = (MemberDTO)map.get("login");
		
		 HttpSession session = request.getSession();
		 
		 session.setAttribute("login",login);
		
	}

}
	//컨트롤러 실행 다음에 오는 postHandle

