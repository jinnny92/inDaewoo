package kr.co.b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.bDTO;

public class bDAO {
		
		private DataSource dataFactory;
	
	public bDAO() {
		// TODO Auto-generated constructor stub
		
		try {
			Context ctx = new InitialContext();
			dataFactory	= (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
			
		} catch (NamingException e) {
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

	public void insert(bDTO bDTO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "INSERT INTO tbl_b(num, title, content) VALUES(seq_b_num.NEXTVAL, ?, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDTO.getTitle());
			pstmt.setString(2, bDTO.getContent());
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
}
