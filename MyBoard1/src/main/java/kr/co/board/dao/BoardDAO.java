package kr.co.board.dao;

<<<<<<< HEAD
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.board.domain.BoardDTO;

public class BoardDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "dw";
	private final String PASSWORD = "dw";
	
	public BoardDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
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

	public void insert(BoardDTO bdto) {
		// TODO Auto-generated method stub
		
//		seq_board_num.NEXTVAL             seq_board_num.CURRVAL
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board "
				+ " (num, writer, title, content, repRoot, repStep, repIndent) "
				+ " VALUES "
				+ "(seq_board_num.NEXTVAL, ?, ?, ?, seq_board_num.CURRVAL, 0, 0)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	public List<BoardDTO> list() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board ORDER BY repRoot DESC, repStep ASC";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				String writeday = rs.getString("writeDay");
				
				writeday = writeday.substring(0, 10);
				
				
				list.add(new BoardDTO(num, writer, title, null, writeday, null, readcnt, repRoot, repStep, repIndent));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		
		return list;
	}

	public BoardDTO read(int num) {
		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeDay = rs.getString("writeday");
				String updateDay = rs.getString("updateday");
				String content = rs.getString("content");
								
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				dto = new BoardDTO(num, writer, title, 
						content, writeDay, updateDay, 
						readcnt, repRoot, repStep, repIndent);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public BoardDTO updateUI(int num) {
		// TODO Auto-generated method stub
		return read(num);
	}

	public void update(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board "
				+ " SET "
				+ " title=?, content=?, updateday=SYSDATE "
				+ "WHERE num = ?";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.board.domain.BoardDTO;

public class BoardDAO {
	private final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "dw";
	private final String PASSWORD = "dw";
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clostAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
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

	public void insert(BoardDTO bdto) {
		// TODO Auto-generated method stub
		//seq_board_num.NEXTVAL  seq_board_num.CURRVAL
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board"
				+ "(num, writer, title, content, repRoot, repStep, repIndent) "
				+ "VALUES"
				+ "(seq_board_num.NEXTVAL,?, ?, ?, seq_board_num.CURRVAL, 0, 0)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getContent());
			pstmt.executeUpdate();
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			clostAll(null, pstmt, conn);
		}
		
	}

	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board ORDER BY repRoot DESC, repStep ASC";
		ResultSet rs = null;
		
		 try {
			 	conn = DriverManager.getConnection(URL, USER, PASSWORD);
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
				
					int num = rs.getInt("num");
					String writer = rs.getString("writer");
					String title =  rs.getString("title");
					String writeday = rs.getString("writerDay");
					int readcnt = rs.getInt("readcnt");
					int repRoot = rs.getInt("repRoot");
					int repStep = rs.getInt("repStep");
					int repIndent = rs.getInt("repIndent");
					
				
					
					list.add(new BoardDTO(num, writer, title, null, writeday, null, readcnt, repRoot, repStep, repIndent));
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			clostAll(rs, pstmt, conn);
		}
		
		return list;
	}
>>>>>>> refs/remotes/origin/master
}
