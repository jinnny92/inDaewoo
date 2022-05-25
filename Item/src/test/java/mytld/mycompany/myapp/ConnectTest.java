package mytld.mycompany.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectTest {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "dw";
	private String password = "dw";
	
	@Test
	public void testConnect() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("커넥션 연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
