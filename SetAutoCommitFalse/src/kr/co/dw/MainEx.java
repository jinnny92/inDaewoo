package kr.co.dw;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AccountDAO dao = new AccountDAO();
		dao.transfer(2, 1, 3000);
		
	}

}
