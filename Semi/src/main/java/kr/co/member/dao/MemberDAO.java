package kr.co.member.dao;

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

import kr.co.domain.MemberDTO;

public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context ctx = new InitialContext();
			
			dataFactory =	(DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
			
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

	public void insert(MemberDTO dto) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(id, pw, name, birthday, phonenumber, email) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirthday());
			pstmt.setString(5, dto.getPhonenumber());
			pstmt.setString(6, dto.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}

	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member ORDER BY id ASC";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				
				list.add(new MemberDTO(id, pw, name, birthday, phonenumber, email));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list;
	}

	public MemberDTO finddtobyid(MemberDTO dto) {
		// TODO Auto-generated method stub
		MemberDTO finddto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String phonenumber = rs.getString("phonenumber");
				String email = rs.getString("email");
				
				finddto = new MemberDTO(dto.getId(), pw, name, birthday, phonenumber, email);
			}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		closeAll(rs, pstmt, conn);
	}
		return finddto;
	}

	public MemberDTO updateui(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return finddtobyid(memberDTO);
	}

	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET name = ? , pw = ?, phonenumber = ?, birthday = ?, email = ? WHERE id = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getPhonenumber());
			pstmt.setString(4, dto.getBirthday());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}

	public void delete(MemberDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM member WHERE id = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}
}

