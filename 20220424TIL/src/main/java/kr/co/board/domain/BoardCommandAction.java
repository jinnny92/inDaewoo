package kr.co.board.domain;

public class BoardCommandAction {
	private String whrer;
	private boolean isRedirect;
	
	public BoardCommandAction() {
		// TODO Auto-generated constructor stub
	}

	public BoardCommandAction(String whrer, boolean isRedirect) {
		super();
		this.whrer = whrer;
		this.isRedirect = isRedirect;
	}

	public String getWhrer() {
		return whrer;
	}

	public void setWhrer(String whrer) {
		this.whrer = whrer;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
