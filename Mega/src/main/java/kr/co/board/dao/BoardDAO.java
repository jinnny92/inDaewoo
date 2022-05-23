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

import kr.co.domain.BoardDTO;
import kr.co.domain.PageTO;

public class BoardDAO {
	private DataSource dataFactory;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
	
		try {
			Context ctx = new InitialContext();
			dataFactory	= (DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");
			System.out.println("ㄷㄹㅇㅂ ㄹㄷ");
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

	public void insert(BoardDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board2(num, id, title, content, repRoot, repStep, repIndent) VALUES(seq_board2_num.NEXTVAL, ?, ?, ?, seq_board2_num.CURRVAL, 0, 0)";
		
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
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
		String sql = "SELECT * FROM board2 ORDER BY repRoot DESC, repStep ASC";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String writeDay = rs.getString("writeDay");
				int readCnt = rs.getInt("readCnt");
				int repRoot = rs.getInt("repRoot");
				int repStep= rs.getInt("repStep");
				int repIndent= rs.getInt("repIndent");
				
				writeDay = writeDay.substring(0, 10);
				
				
				list.add(new BoardDTO(num, id, title, null, writeDay, null, readCnt, repRoot, repStep, repIndent));
				
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
		//업데이트UI때문에 read 메서드를 살려둠 수정하겠다고 눌렀는데 조회수가 증가하면 안되니까. 
		//read는 그냥 DTO가져오는거 read2는 DTO도 가져오고 조회수도 증가
		BoardDTO read = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM board2 WHERE num = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				String title = rs.getString("title");
				String id = rs.getString("id");
				String content = rs.getString("content");
				String writeDay = rs.getString("writeDay");
				String updateDay = rs.getString("updateDay");
				int readCnt = rs.getInt("readCnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				
				
				
				read = new BoardDTO(num, id, title, content, writeDay, updateDay, readCnt, repRoot, repStep, repIndent);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return read;
	}

	
	public BoardDTO read2(int num) {
		// TODO Auto-generated method stub
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM board2 WHERE num = ?";
		String sql2 = "UPDATE board2 SET readCnt = readCnt+1 WHERE num = ?";
		ResultSet rs = null;
		boolean isOk = false;
		
		try {
			conn = dataFactory.getConnection();
			
			conn.setAutoCommit(false);//jdbc같은 경우는 autocommit(잡혀있음) 커넥션이 생성되고 난 다음에 수동커밋으로 바꿔야한다
 		//트랜잭션을 구현하려면 하나의 커넥션에서 작업이 이루어져야 한다 
			//conn.setAutoCommit(false) 이 코드가 없으면 무조건 커밋이 된다. 커밋이 된 상태에서 롤백해봤자 의미 없음
			
			
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			pstmt.close();
			
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String title = rs.getString("title");
				String id = rs.getString("id");
				String content = rs.getString("content");
				String writeDay = rs.getString("writeDay");
				String updateDay = rs.getString("updateDay");
				int readCnt = rs.getInt("readCnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				
				
				
				dto = new BoardDTO(num, id, title, content, writeDay, updateDay, readCnt, repRoot, repStep, repIndent);
				
			}
			
			
		
			
			
			isOk = true; //맨 밑에까지 정상적으로 오면 이제 true
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			//트랜잭션은 finally에서 구현
			//closeAll앞에서 구현함. 뒤에서 하면 의미 X
			
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

	public BoardDTO updateui(int num) {
		// TODO Auto-generated method stub
		return read(num);
	}

	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board2 SET title = ?, content = ?, updateDay = SYSDATE WHERE num = ?";
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
		String sql = "DELETE FROM board2 WHERE num = ?";
		
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
	
	
	
	
	

	public void reply(int orgnum, BoardDTO dto) {
		// TODO Auto-generated method stub
		//BoardDTO orgDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//String sql1 = "UPDATE board2 SET repStep = repStep + 1 WHERE repRoot = ? AND repStep > ?";
		String sql2 = "INSERT INTO board2(num, id, title, content, repRoot, repStep, repIndent) VALUES(seq_board2_num.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		//String sql3 = "SELECT * FROM board2 WHERE num = ?";
		ResultSet rs = null;
		boolean isOk = false;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			BoardDTO orgDto = SelectByOrgNum(conn, orgnum);
//			pstmt = conn.prepareStatement(sql3);
//			pstmt.setInt(1, orgnum);
//			rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				int ordrepRoot = rs.getInt("repRoot");
//				int ordrepStep = rs.getInt("repStep");
//				int ordrepIndent = rs.getInt("repIndent");
//				
//				orgDto= new BoardDTO(orgnum, null, null, null, null, null, 0, ordrepRoot, ordrepStep, ordrepIndent);
//				
//				
//			}
//				pstmt.close();
//				
				
				
				int result = increaseRepStep(conn, orgDto);
				
				
				
//				pstmt = conn.prepareStatement(sql1);
//				pstmt.setInt(1, orgDto.getRepRoot());
//				pstmt.setInt(2, orgDto.getRepStep());
//				pstmt.executeUpdate();
//				pstmt.close();
//				
				
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getContent());
				
				pstmt.setInt(4, orgDto.getRepRoot());
				pstmt.setInt(5, orgDto.getRepStep()+1);
				pstmt.setInt(6, orgDto.getRepIndent()+1);

				
				
				
				pstmt.executeUpdate();
				
			
			
			isOk = (orgDto != null) && (result == 1)? true:false;
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
		int result = -1; //정상적으로 끝나면 1을 반환/ 그렇지 않고 비정상적으로 끝나면 -1을 반환하도록 만들것이다
		PreparedStatement pstmt = null;
		String sql = "UPDATE board2 SET repStep = repStep+1 WHERE repRoot = ? AND repStep > ?";
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
		}finally {
			closeAll(null, pstmt, null);
		}
		
		
		
		
		return result;
	}

	private BoardDTO SelectByOrgNum(Connection conn, int orgnum) {
		// TODO Auto-generated method stub
		BoardDTO orgDto = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM board2 WHERE num = ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgnum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				orgDto = new BoardDTO(orgnum, null, null, null, null, null, 0, repRoot, repStep, repIndent);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			orgDto = null;
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		return orgDto;
	}
	
	

	

	
	
	

//	public void reply(int orgnum, BoardDTO dto) {
//		// TODO Auto-generated method stub
//				BoardDTO orgDto = null;
//				Connection conn = null;
//				PreparedStatement pstmt = null;
//				String sql1 = "UPDATE board2 SET repStep = repStep + 1 WHERE repRoot = ? AND repStep > ?"; //기존 답글에 대해서 repStep 증가시키는것
//				String sql2 = "INSERT INTO board2(num, id, title, content, repRoot, repStep, repIndent) VALUES(seq_board2_num.NEXTVAL, ?, ?, ?, ?, ?, ?)"; //이번엔 답글 다는거
//				//repRoot, repStep, repIndent 부모로부터 가져올것임
//				String sql3 = "SELECT * FROM board2 WHERE num = ?"; //부모거 데이터 가져오는거  대충하면 read라는 메서드를 호출하면 될 것 같지만 문제는 트랜젝션이 안맞음
//				//트랜잭션은 기본적으로 Connection이 같아야함. 
//				ResultSet rs = null;
//				boolean isOk = false;
//				try {
//						conn = dataFactory.getConnection();
//						conn.setAutoCommit(false);
//						pstmt = conn.prepareStatement(sql3);
//						pstmt.setInt(1, orgnum);
//						rs = pstmt.executeQuery();
//						
//						if (rs.next()) {
//							//여기서 필요한건 부모이 repRoot값 Step, Indent만 필요함 타이틀같은건 필요가 없음
//							int orgRepRoot = rs.getInt("repRoot");
//							int orgRepStep = rs.getInt("repStep");
//							int orgRepIndent = rs.getInt("repIndent");
//							orgDto = new BoardDTO(orgnum, null, null, null, null, null, 0, orgRepRoot, orgRepStep, orgRepIndent);
//							
//						} //원래 글에 대한 답글이 달렸을 때 답글에 대한 repRoot는 원래글의 repRoot와 같으니까 orgRepRoot가 필요  orgRepStep은 원래글의 RepStep에 +1을 해줘야하니까 필요
//						
//						pstmt.close();
//						 
//						
//						pstmt = conn.prepareStatement(sql1);
//						pstmt.setInt(1, orgDto.getRepRoot()); //부모의 루트값 
//						pstmt.setInt(2, orgDto.getRepStep());
//						pstmt.executeUpdate();
//						pstmt.close();
//						
//						
//						
//						
//						pstmt = conn.prepareStatement(sql2); //답글 등록하는 작업
//						pstmt.setString(1, dto.getId());
//						pstmt.setString(2, dto.getTitle());
//						pstmt.setString(3, dto.getContent());
//					
//						pstmt.setInt(4, orgDto.getRepRoot()); //부모와 관련된 친구들
//						pstmt.setInt(5, orgDto.getRepStep()+1); //부모와 관련된 친구들 신규답글은 기존부모가 가지고 있던 repStep에다가 +1, 기존 답글은 +1 할수도 안할수도 있음 
//						pstmt.setInt(6, orgDto.getRepIndent()+1);
//						
//						pstmt.executeUpdate();
//						
//						//마지막에 closeAll메서드가 있으니까 굳이 pstmt.close를 해줄필요는 없음
//						
//					
//					
//					isOk = true;
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}finally {
//					if (isOk) {
//						try {
//							conn.commit();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					} else {
//						try {
//							conn.rollback();
//						} catch (SQLException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//					
//					closeAll(rs, pstmt, conn);
//				}
//				
//				
//	}
	
	
		public PageTO<BoardDTO> page(int curpage){//리스트라는 메서드가 있지만 페이지라는 메서드를 만듦 왜냐면 리스트는 목록 전체. 얘는 특정페이지가 현재 페이지가 되도록
			PageTO<BoardDTO> pt = new PageTO<BoardDTO>(curpage); //현재페이지에 관한 정보를 넘겨주려고 (curpage)를 넣음
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM (SELECT "
					+ "rownum rnum, num, id, title, updateday, readCnt, repIndent "
					+ "from (SELECT * from board2 ORDER BY repRoot desc, repStep asc)) WHERE rnum between ? and ?";
			ResultSet rs = null;
			
			try {
					conn = dataFactory.getConnection();
					
					int amount = getAmount(conn); //getAmount메서드 호출/ int amount => amount를 넘거받음
					pt.setAmount(amount); //amount셋팅하는 작업 내부적으로 calculater라는 메서드 호출
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, pt.getStartNum());
					pstmt.setInt(2, pt.getEndNum());
					
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						int num = rs.getInt("num");
						String id = rs.getString("id");
						String title = rs.getString("title");
						String updateDay = rs.getString("updateDay");
						int readCnt = rs.getInt("readCnt");
						int repIndent = rs.getInt("repIndent");
						
						BoardDTO dto = new BoardDTO(num, id, title, null, null, updateDay, readCnt, 0, 0, repIndent);
						pt.getList().add(dto);
					}
					
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				closeAll(rs, pstmt, conn);
			}
			
			
			
			return pt;
		}
	
	
	
		public int getAmount(Connection conn) { //amount 가져오는 작업 페이징처리하는 메서드에서 호출되는거기때문에 conn을 넣어준거
			int amount = 0;
			PreparedStatement pstmt = null;
			String sql = "SELECT COUNT(num) FROM board2"; //기본키 넣어주는게 대세
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
				amount =  rs.getInt(1); //인덱스의 순서 하나밖에 없으니까 1번
				}
			} catch (Exception e) {
				// TODO: handle exception
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
			String sql = "SELECT * FROM board2 WHERE UPPER(" + criteria + ") like UPPER(?)";
			ResultSet rs = null;
			
			
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%"+keyword+"%");
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int num = rs.getInt("num");
					String title = rs.getString("title");
					String id = rs.getString("id");
		
					String updateDay = rs.getString("updateDay");
					int readCnt = rs.getInt("readCnt");
					int repIndent = rs.getInt("repIndent");
					
					list.add(new BoardDTO(num, id, title, null, null, updateDay, readCnt, 0, 0, repIndent));
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

