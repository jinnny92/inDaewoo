package kr.co.dw.member.dto;

public class CommandAction {//포워딩 : 어디로 갈건지, 포워딩의 2가지 방식 : redirect 방식과 Dispatcher방식 
	//이 둘 중 어떤 방식으로 포워딩 할거냐 그리고 어디로 갈거냐 이걸 클래스로 설계한게 CommandAction패턴 
	private String where;//어디로 포워딩 할건지
	private boolean isRedirect;// 어떤 방식으로 할건지 Dispatcher방식일때는 false 
	
	public CommandAction() {
		// TODO Auto-generated constructor stub
	}

	public CommandAction(String where, boolean isRedirect) {
		super();
		this.where = where; 
		this.isRedirect = isRedirect;  
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
