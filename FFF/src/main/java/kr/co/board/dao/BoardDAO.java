package kr.co.board.dao;

import java.io.File;
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
import javax.swing.text.AbstractDocument.Content;

import kr.co.board.domain.BoardDTO;
import kr.co.board.domain.MemberDTO;
import kr.co.board.domain.PageTO;

public class BoardDAO {
	public final String DRIVER = "oracle.jdbc.OracleDriver";
	public final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public final String USER = "dw";
	public final String PASSWORD = "dw";

	public BoardDAO() {

		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
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

	public void insert(BoardDTO bdto, String a) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "INSERT INTO tbl_board (num, writer, title, content, repRoot, repStep, repIndent,id) VALUES(seq_board_num.NEXTVAL, ?, ?, ?, seq_board_num.CURRVAL, 0, 0,?)";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getContent());
			pstmt.setString(4, a);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);

		}
	}

	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT * FROM tbl_board ORDER BY repRoot DESC, repStep ASC";

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
				String writeday = rs.getString("writeday");

				writeday = writeday.substring(0, 10);

				BoardDTO dto = new BoardDTO(num, writer, title, null, writeday, null, readcnt, repRoot, repStep,
						repIndent);
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

	
	public List<BoardDTO> list2() {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "select * from(select * from tbl_board where repStep = 0 order by num desc ) where rownum <= 5";

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
				String writeday = rs.getString("writeday");

				writeday = writeday.substring(0, 10);

				BoardDTO dto = new BoardDTO(num, writer, title, null, writeday, null, readcnt, repRoot, repStep,
						repIndent);
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

	public BoardDTO read2(int num) {
		BoardDTO dto = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		String sql2 = "UPDATE tbl_board SET readcnt = readcnt +1 WHERE num =?";
		ResultSet rs = null;
		boolean isOk = false;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			pstmt.close();

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writerDay = rs.getString("writeday");
				String updateDay = rs.getString("updateday");
				String content = rs.getString("content");

				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

				dto = new BoardDTO(num, writer, title, content, writerDay, updateDay, readcnt, repRoot, repStep,
						repIndent);

			}

			isOk = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

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

			closeAll(rs, pstmt, conn);
		}

		return dto;
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

			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writerDay = rs.getString("writeday");
				String updateDay = rs.getString("updateDay");
				String content = rs.getString("content");

				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

				dto = new BoardDTO(num, writer, title, content, writerDay, updateDay, readcnt, repRoot, repStep,
						repIndent);

			}

		} catch (Exception e) {
			// TODO: handle exception
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
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET title = ?, content = ? , updateday=SYSDATE WHERE num =?";
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);

		}

	}

	public void login(BoardDTO dto) {
		// TODO Auto-generated method stub
		BoardDTO login = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT num,writer,title,content,writeday,updateday,readcnt,repStep,repRoot,repIndent FROM tbl_board WHERE num =? AND repRoot = ?";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setInt(2, dto.getRepRoot());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeDay = rs.getString("writeday");
				String updateDay = rs.getString("updateday");
				int readcnt = rs.getInt("readcnt");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

	}

	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_board WHERE num = ?";

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);

		}

	}

	public void reply(int orgNum, BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		// String sql1 = "UPDATE tbl_board SET repStep = repStep + 1 WHERE repRoot = ?
		// AND repStep > ?";

		String sql2 = "INSERT INTO tbl_board (num, writer, title, content, repRoot,repStep, repIndent) VALUES (seq_board_num.NEXTVAL, ? , ? , ? , ? , ? , ?)";

		// String sql3 = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		boolean isOk = false;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);

			/*
			 * pstmt = conn.prepareStatement(sql3); pstmt.setInt(1, orgNum); rs =
			 * pstmt.executeQuery();
			 * 
			 * BoardDTO orgDto = null;
			 * 
			 * if (rs.next()) { int orgRepRoot = rs.getInt("repRoot"); int orgRepStep =
			 * rs.getInt("repStep"); int orgRepIndent = rs.getInt("repIndent");
			 * 
			 * orgDto = new BoardDTO(orgNum, null, null, null, null, null, 0, orgRepRoot,
			 * orgRepStep, orgRepIndent);
			 * 
			 * }
			 * 
			 * 
			 * pstmt.close();
			 */

			BoardDTO orgDto = selectByOrgNum(conn, orgNum);

			/*
			 * pstmt = conn.prepareStatement(sql1); pstmt.setInt(1, orgDto.getRepRoot());
			 * pstmt.setInt(2, orgDto.getRepStep()); pstmt.executeUpdate();
			 * 
			 * pstmt.close();
			 */
			int result = increaseRepStep(conn, orgDto);
			pstmt = conn.prepareStatement(sql2);

			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getContent());
			pstmt.setInt(4, orgDto.getRepRoot());
			pstmt.setInt(5, orgDto.getRepStep() + 1);
			pstmt.setInt(6, orgDto.getRepIndent() + 1);

			pstmt.executeUpdate();

			isOk = (orgDto != null) && (result == 1) ? true : false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
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
			closeAll(rs, pstmt, conn);
		}

	}

	private int increaseRepStep(Connection conn, BoardDTO orgDto) {
		// TODO Auto-generated method stub
		int result = -1;

		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET repStep = repStep + 1 WHERE repRoot = ? AND repStep > ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orgDto.getRepRoot());
			pstmt.setInt(2, orgDto.getRepStep());

			pstmt.executeUpdate();

			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = -1;

		} finally {
			closeAll(null, pstmt, null);
		}

		return result;
	}

	private BoardDTO selectByOrgNum(Connection conn, int orgNum) {
		BoardDTO orgDto = null;

		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");

				orgDto = new BoardDTO(orgNum, null, null, null, null, null, 0, repRoot, repStep, repIndent);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			orgDto = null;
		} finally {
			closeAll(rs, pstmt, null);
		}

		return orgDto;
	}

	public PageTO<BoardDTO> page(int curPage) {
		PageTO<BoardDTO> pt = new PageTO<BoardDTO>(curPage);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM " + "(SELECT " + "rownum rnum, num, title, writer, updateday, readcnt, repIndent "
				+ "from (SELECT * FROM tbl_board order by repRoot desc, repStep asc)) " + "where rnum between ? and ?";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			int amount = getAmount(conn);
			pt.setAmount(amount);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pt.getStartNum());
			pstmt.setInt(2, pt.getEndNum());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String updateDay = rs.getString("updateDay");

				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");

				BoardDTO dto = new BoardDTO(num, writer, title, null, null, updateDay, readcnt, 0, 0, repIndent);

				pt.getList().add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return pt;

	}

	public int getAmount(Connection conn) {
		int amount = 0;

		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(num) FROM tbl_board";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}

		return amount;
	}

	public List<BoardDTO> search(String criteria, String keyword) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE UPPER(" + criteria + ") like UPPER(?)";
		// select * from tbl_board where writer like ?, ?= %값%
		// select * from tbl_board where title like ?
		// select * from tbl_board where content like ?
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String updateDay = rs.getString("updateDay");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				list.add(new BoardDTO(num, writer, title, null, null, updateDay, readcnt, 0, 0, repIndent));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return list;
	}

	public List<BoardDTO> list3() {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT*FROM(SELECT * FROM tbl_board  WHERE writer = 'admin' order by num desc) WHERE rownum <=5";

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
				String writeday = rs.getString("writeday");

				writeday = writeday.substring(0, 10);

				BoardDTO dto = new BoardDTO(num, writer, title, null, writeday, null, readcnt, repRoot, repStep,
						repIndent);
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
	public List<BoardDTO> list4() {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "SELECT*FROM (SELECT * FROM tbl_board where readcnt >= 10) WHERE rownum <=5 AND repIndent = 0";

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
				String writeday = rs.getString("writeday");

				writeday = writeday.substring(0, 10);

				BoardDTO dto = new BoardDTO(num, writer, title, null, writeday, null, readcnt, repRoot, repStep,
						repIndent);
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
	
}