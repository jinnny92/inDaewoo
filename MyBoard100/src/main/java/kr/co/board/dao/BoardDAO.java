package kr.co.board.dao;

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

import org.eclipse.jdt.internal.compiler.ast.Wildcard;

import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;
import kr.co.board.domain.PageTO;

public class BoardDAO {
	
	private DataSource dataFactory;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			
			dataFactory = 	(DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
		}
		
	}

	public void insert(BoardDTO bdto) {
		// TODO Auto-generated method stub
		
		//seq_board_num.NEXTVAL 새로운sequence                   seq_board_num.CURRVAL 현재의 sequence
		Connection conn= null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board"+"(num, writer, title, content, repRoot, repStep, repIndent)" + "VALUES" +"(seq_board_num.NEXTVAL ,?, ?, ?, seq_board_num.CURRVAL, 0, 0)";
		
		try {
			
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bdto.getWriter());
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getContent());
			
			pstmt.executeUpdate();
			
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
			
			
			while(rs.next()) {
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
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	public BoardDTO read(int num) {
		// TODO Auto-generated method stub
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeDay = rs.getString("writeDay");
				String updateDay = rs.getString("updateDay");
				String content = rs.getString("content");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				
				dto = new BoardDTO(num, writer, title, content, writeDay, updateDay, readcnt, repRoot, repStep, repIndent);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public BoardDTO read2(int num) {	
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		String sql2 = "UPDATE tbl_board SET readcnt = readcnt+1 WHERE num = ?";
		ResultSet rs = null;
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
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
				String writeDay = rs.getString("writeDay");
				String updateDay = rs.getString("updateDay");
				String content = rs.getString("content");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				
				dto = new BoardDTO(num, writer, title, content, writeDay, updateDay, readcnt, repRoot, repStep, repIndent);
			}
			

			
			isOk = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			if (isOk) {
				try {
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
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

	
	

	public BoardDTO updateUI(int num) {
		// TODO Auto-generated method stub
		return read(num);
	}

	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET title = ?, content = ?, updateDay = SYSDATE WHERE num = ?";
		
	
		
		try {
			conn = dataFactory.getConnection();
					
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
		
	}
	
	


	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_board WHERE num = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	
	
	public void reply(int orgNum, BoardDTO bdto) {
		// TODO Auto-generated method stub
		
		//seq_board_num.NEXTVAL 새로운sequence                   seq_board_num.CURRVAL 현재의 sequence
				Connection conn= null;
				PreparedStatement pstmt = null;
				//String sql1 = "UPDATE tbl_board SET repStep = repStep + 1 WHERE repRoot = ? AND repStep  > ?";
			      String sql2 = "INSERT INTO tbl_board (num, writer, title, content, repRoot, repStep, repIndent) VALUES (seq_board_num.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			     // String sql3 = "SELECT * FROM tbl_board WHERE num = ?";

				ResultSet rs = null;
				
				boolean isOk = false;
				
				try {
					
					conn = dataFactory.getConnection();
					conn.setAutoCommit(false);
					
					BoardDTO orgDto = selectByOrgNum(conn, orgNum); //부모 정보 가져오는거 메서드처리
					
//					pstmt = conn.prepareStatement(sql3);
//					pstmt.setInt(1, orgNum);
//					rs = pstmt.executeQuery();
//					BoardDTO orgDto = null;
//					
//					if (rs.next()) {
//						int orgRepRoot = rs.getInt("repRoot");
//						int orgRepStep = rs.getInt("repStep");
//						int orgRepIndent = rs.getInt("repIndent");
//						
//						orgDto = new BoardDTO(orgNum, null,  null,  null,  null,  null, 0,
//								orgRepRoot, orgRepStep, orgRepIndent);
//					}
//					
//					pstmt.close();
					
					
					int result = increaseRepStep(conn, orgDto); //1씩 증가되는거 메서드처리
					
//					pstmt = conn.prepareStatement(sql1);
//					pstmt.setInt(1, orgDto.getRepRoot());
//					pstmt.setInt(2, orgDto.getRepStep());
//					
//					pstmt.executeUpdate();
//					pstmt.close();
//					
					
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, bdto.getWriter());
					pstmt.setString(2, bdto.getTitle());
					pstmt.setString(3, bdto.getContent());
					pstmt.setInt(4, orgDto.getRepRoot());
					pstmt.setInt(5, orgDto.getRepStep()+1);
					pstmt.setInt(6, orgDto.getRepIndent()+1); //들여쓰기에 관한 컬림값은 원래거에 +1
					
					pstmt.executeUpdate();
					
					
					isOk = (orgDto != null) && result ==1? true: false; //삼항연산자 이중에서 뭔가 하나라도 잘못되면false야 메서드에서 뭔가 잘못되었어 라는뜻
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					if (isOk) {
						try {
							conn.commit();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						try {
							conn.rollback();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					closeAll(null, pstmt, conn);
				}
		
	}

	private int increaseRepStep(Connection conn, BoardDTO orgDto) {
		// TODO Auto-generated method stub
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET repStep = repStep + 1 WHERE repRoot = ? AND repStep  > ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgDto.getRepRoot());
			pstmt.setInt(2, orgDto.getRepStep());
			pstmt.executeUpdate();
			
			result = 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
		
		return result;
	}

	private BoardDTO selectByOrgNum(Connection conn, int orgNum) {
		// TODO Auto-generated method stub
		BoardDTO ordDto = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int RepRoot = rs.getInt("repRoot");
				int RepStep = rs.getInt("repStep");
				int RepIndent = rs.getInt("repIndent");
			
				ordDto = new BoardDTO(orgNum, null, null, null, null, null, 0, RepRoot, RepStep, RepIndent);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ordDto = null;
		}finally {
			closeAll(rs, pstmt, null);
		}
				
		
		return ordDto;
	}
	

	 public PageTO<BoardDTO> page(int curPage){ //특정페이지에 관한 메서드
	      PageTO<BoardDTO> pt = new PageTO<BoardDTO>(curPage);//현재 페이지에 관한 정보를 넘겨준다
	       
	      Connection conn =null;
	      PreparedStatement pstmt = null;
	      String sql = "select * from (select rownum rnum, num, title, writer, updateday, readcnt, repIndent "
	            + "from ( select * from tbl_board order by repRoot desc, repStep asc)) where rnum between ? and ?";
	      //board.sql에서 가져옴 
	      ResultSet rs = null;
	      
	      try {
	         
	         conn = dataFactory.getConnection();
	         
	         int amount = getAmount(conn);
	         pt.setAmount(amount); //amount를 입력받으면서 calculate();다시 한번 호출하는것
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, pt.getStartNum());
	         pstmt.setInt(2, pt.getEndNum());
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            int num = rs.getInt("num");
	            String title =  rs.getString("title");
	            String writer = rs.getString("writer");
	            String updateDay = rs.getString("updateDay");
	            int readcnt = rs.getInt("readcnt");
	            int repIndent = rs.getInt("repIndent");
	            
	            BoardDTO dto = new BoardDTO(num, writer, title, null, null, updateDay, readcnt, 0, 0, repIndent);
	            pt.getList().add(dto);
	          //List<BoardDTO> list = pt.getList(); = pt.getList().add(dto);
	            
	         }
	         
	         
	         
	         
	         
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally {
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
		      
		      if(rs.next()) {
		         amount = rs.getInt(1);
		         
		      }
		      
		   } catch (Exception e) {
		      // TODO: handle exception
		      e.printStackTrace();
		   }finally {
		      closeAll(rs, pstmt, null);
		   }
		   
		   
		   
		   return amount;
		   
		}

	

	public List<BoardDTO> search(String criteria, String keyword) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE UPPER("+ criteria + ") like UPPER(?)"; //띄어쓰기 필수
		//select * from tbl_board where write like
		//select * from tbl_board where title like
		//select * from tbl_board where content like
		
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
	            String title =  rs.getString("title");
	            String writer = rs.getString("writer");
	            String updateDay = rs.getString("updateDay");
	            int readcnt = rs.getInt("readcnt");
	            int repIndent = rs.getInt("repIndent");
	            
	            list.add(new BoardDTO(num, writer, title, null, null, updateDay, readcnt, 0, 0, repIndent));
				
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
