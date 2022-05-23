package kr.co.board.dao;

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
import javax.xml.crypto.Data;

import org.eclipse.jdt.internal.compiler.ast.Wildcard;

import kr.co.domain.BoardDTO;

public class BoardDAO {
private DataSource dataFactory;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
		
		try {
			Context	ctx = new InitialContext();
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
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

	public void insert(BoardDTO bdto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board(num, writer, title, content, repRoot, repStep, repIndent, id) VALUES(seq_board_num.NEXTVAL, ?, ?, seq_board_num.CURRVAL, 0, 0, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getContent());
			pstmt.setString(4, bdto.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
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
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				String id = rs.getString("id");
				
				writeday = writeday.substring(0, 10);
				
				list.add(new BoardDTO(num, writer, title, title, writeday, null, readcnt, repRoot, repStep, repIndent, id));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}
}
