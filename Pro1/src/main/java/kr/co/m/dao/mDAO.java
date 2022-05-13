package kr.co.m.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.mDTO;

public class mDAO {
	private DataSource dataFactory;
	
	public mDAO() {
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

	public void insert(mDTO mDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_m(id, name, age) VALUES(?, ?, ?)";
		
		try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mDTO.getId());
				pstmt.setString(2, mDTO.getName());
				pstmt.setInt(3, mDTO.getAge());
				
				pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public List<mDTO> list() {
		// TODO Auto-generated method stub
		List<mDTO> list = new ArrayList<mDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_m ORDER BY id";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new mDTO(id, name, age));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		
		return list;
	}

	public mDTO finddtobyid(mDTO mDTO) {
		// TODO Auto-generated method stub
		mDTO findDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_m WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDTO.getId());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				 findDTO = new mDTO(mDTO.getId(), name, age);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return findDTO;
	}

	public mDTO updateui(mDTO mDTO) {
		// TODO Auto-generated method stub
		return finddtobyid(mDTO);
	}

	public void update(mDTO mDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_m SET name = ?, age = ?  WHERE id = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDTO.getId());
			pstmt.setString(2, mDTO.getName());
			pstmt.setInt(3, mDTO.getAge());
			
			pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void delete(mDTO mDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql  = "DELETE FROM tbl_m WHERE id = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDTO.getId());
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public mDTO login(mDTO mDTO) {
		// TODO Auto-generated method stub
		mDTO login = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id, name FROM member WHERE id = ? AND age = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDTO.getId());
			pstmt.setInt(2, mDTO.getAge());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				login = new mDTO(mDTO.getId(), name, 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return login;
	}

}
