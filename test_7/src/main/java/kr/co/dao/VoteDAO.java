package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBPKG.ConnectindClass;
import kr.co.domain.MemberDTO;
import kr.co.domain.VoteConfirmDTO;
import kr.co.domain.VoteDTO;

public class VoteDAO {

	public void insert(VoteDTO dto) {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 String sql = "Insert into tbl_vote_202005 values(?, ?, ?, ?, ?, ?)";
		
		 
		 try {
			conn = ConnectindClass.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getV_jumin());
			pstmt.setString(2, dto.getV_name());
			pstmt.setString(3, dto.getM_no());
			pstmt.setString(4, dto.getV_time());
			pstmt.setString(5, dto.getV_area());
			pstmt.setString(6, dto.getC_confirm());
			 
			 pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectindClass.closeAll(null, pstmt, conn);
		}
		
		
	}

	public List<VoteConfirmDTO> list() {
		// TODO Auto-generated method stub
		List<VoteConfirmDTO> list = new ArrayList<VoteConfirmDTO>();
		
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 String sql = "select v_name, v_jumin, floor(months_between(sysdate, substr(v_jumin, 1, 6))/12) age, m_no, v_time, c_confirm from tbl_vote_202005 where v_area = '제1투표장'";
		 ResultSet rs = null;
		 
		 try {
				conn = ConnectindClass.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					String v_name =	rs.getString("v_name");
					String v_jumin =	rs.getString("v_jumin");
					String age =	rs.getString("age");
					String m_no =	rs.getString("m_no");
					String v_time =	rs.getString("v_time");
					String c_confirm =	rs.getString("c_confirm");
					
					VoteConfirmDTO dto = new VoteConfirmDTO(v_name, v_jumin, age, m_no, v_time, c_confirm);
					
					list.add(dto);
				}
				 
				 
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				ConnectindClass.closeAll(rs, pstmt, conn);
			}
			 
		
		return list;
	}

}
