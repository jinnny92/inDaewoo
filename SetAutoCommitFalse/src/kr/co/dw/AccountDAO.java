package kr.co.dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "dw";
	private final String PASSWORD = "dw";
	
	public AccountDAO() {
		// TODO Auto-generated constructor stub
	try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void transfer(int fromId, int toId, int amount) {
		Connection conn = null;
		//PreparedStatement pstmt = null;
		String sql1 = "UPDATE account SET balance = balance-? WHERE aid = ?";
		String sql2 = "UPDATE account SET balance = balance+? WHERE aid = ?";
		
		boolean isOk = false;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			

			
			boolean fromIsOk =  fromProcess(conn, sql1, amount, fromId);
			
			 //좋은 코드는 아니지만 보기엔 좋음 원래는 메서드를 하나 만들고 위 작업을 그래도 해줌
			//System.out.println(4/0);
			
			
			boolean toIsOk =  toProcess(conn, sql2, amount, toId);
			
			
			
			isOk = fromIsOk && toIsOk;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (isOk) {
				try {
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			closeAll(null, null, conn);
		}
		
		
	}

	private boolean toProcess(Connection conn, String sql2, int amount, int toId) {
		// TODO Auto-generated method stub
		
		boolean isOk = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, toId);
			
			pstmt.executeUpdate();
			isOk = true;
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
		
		return isOk;
	}

	private boolean fromProcess(Connection conn, String sql1, int amount, int fromId) {
		// TODO Auto-generated method stub
		
		boolean isOk = false;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, fromId);
			pstmt.executeUpdate();
			
			System.out.println(4/0);
			isOk = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
		
		return isOk;
	}

}
