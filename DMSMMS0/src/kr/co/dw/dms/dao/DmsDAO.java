package kr.co.dw.dms.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.dw.dms.domain.DmsDTO;



public class DmsDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "dw";
	private final String PASSWORD = "dw";
	

	public DmsDAO() {
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

	public void insert(DmsDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO dms(did, dname) VALUES(?, ?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getDid());
			pstmt.setString(2, dto.getDname());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
		
	}

	public DmsDTO findDTOById(DmsDTO dmsDTO) {
		// TODO Auto-generated method stub
		DmsDTO findDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT dname 부서명 FROM dms WHERE did = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dmsDTO.getDid());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dname = rs.getNString("부서명");
				findDTO = new DmsDTO(dmsDTO.getDid(), dname);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return findDTO;
	}

	public void update(DmsDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE dms SET dname = ? WHERE did = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setInt(2, dto.getDid());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void delete(DmsDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM dms WHERE did = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getDid());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public List<DmsDTO> list() {
			List<DmsDTO> list = new ArrayList<DmsDTO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM dms";
			ResultSet rs = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int did = rs.getInt("did");
					String dname = rs.getString("dname");
					
					DmsDTO dto = new DmsDTO(did, dname);
					list.add(dto);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll(rs, pstmt, conn);
			}
			
		return list;
	}
	

}
