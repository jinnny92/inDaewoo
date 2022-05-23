package kr.co.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.board.domain.MemberDTO;

public class MemberDAO {
	public final String DRIVER = "oracle.jdbc.OracleDriver";
	public final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public final String USER = "dw";
	public final String PASSWORD = "dw";

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

	public MemberDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member (id,pw,name,birthday,phonenumber,email) VALUES (?,?,?,?,?,?)";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public MemberDTO findDTOById(MemberDTO dto) {
		MemberDTO findDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String phonenumber = rs.getString("phonenumber");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				findDTO = new MemberDTO(dto.getId(), pw, name, birthday, phonenumber, email);

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
		String sql = "UPDATE member SET name = ? , pw=?,phonenumber=?,birthday=?,email=? WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
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
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public void delete(MemberDTO dto) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "DELETE FROM member WHERE id = ?";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT * FROM member ORDER BY id ASC";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String phonenumber = rs.getString("phonenumber");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				MemberDTO dto = new MemberDTO(id, pw, name, birthday, phonenumber, email);
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

	public MemberDTO updateUI(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return findDTOById(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		// TODO Auto-generated method stub

		MemberDTO login = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id, name,phonenumber,birthday,email FROM member WHERE id = ? AND pw = ?";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				String phonenumber = rs.getString("phonenumber");
				String birthday = rs.getString("birthday");
				String email = rs.getString("email");
				login = new MemberDTO(memberDTO.getId(), memberDTO.getPw(), name, birthday, phonenumber, email);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return login;
	}

	public List<MemberDTO> check() {
		// TODO Auto-generated method stub
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, pw FROM member";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				list.add(new MemberDTO(id, pw, null, null, null, null));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
