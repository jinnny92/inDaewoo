package kr.co.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.MemberDTO;



public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		 try { Context ctx = new InitialContext();
		  
		  dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g"); }
		  catch (NamingException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
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
	
	
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member2 (id, name, age) VALUES (?,?,?)";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public MemberDTO findDTOById(MemberDTO dto) {
		MemberDTO findDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member2 WHERE id = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				findDTO = new MemberDTO(dto.getId(), name, age);

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return findDTO;
	}

	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member2 SET name = ? , age = ? WHERE id = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setInt(3, dto.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public void delete(MemberDTO dto) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "DELETE FROM member2 WHERE id = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT * FROM member2 ORDER BY id ASC";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public MemberDTO updateUI(MemberDTO dto) {
		// TODO Auto-generated method stub
		return findDTOById(dto);
	}

	/*
	 * public MemberDTO login(MemberDTO dto) { // TODO Auto-generated method stub
	 * 
	 * MemberDTO login = null; Connection conn = null; PreparedStatement pstmt =
	 * null; String sql = "SELECT id, name FROM member2 WHERE id = ? AND age = ?";
	 * ResultSet rs = null;
	 * 
	 * try { conn = dataFactory.getConnection(); pstmt = conn.prepareStatement(sql);
	 * pstmt.setInt(1, dto.getId()); pstmt.setInt(2, dto.getAge()); rs =
	 * pstmt.executeQuery();
	 * 
	 * if(rs.next()) { String name = rs.getString("name"); login = new
	 * MemberDTO(dto.getId(), name, 0);
	 * 
	 * 
	 * } } catch (Exception e) { // TODO: handle exception e.printStackTrace();
	 * }finally { closeAll(rs, pstmt, conn); }
	 * 
	 * 
	 * return login; }
	 */

	
}
