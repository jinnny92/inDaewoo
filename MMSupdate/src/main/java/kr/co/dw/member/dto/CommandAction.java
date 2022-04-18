package kr.co.dw.member.dto;

public class CommandAction {//서블릿에서 jsp로 갈 때 사용
	private String where;
	private boolean isRedirect;
	
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
