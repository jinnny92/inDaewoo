package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBPKG.ConnectindClass;
import kr.co.domain.MemberDTO;
import kr.co.domain.MemberGradeDTO;

public class MemberDAO {

	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		
		 List<MemberDTO> list = new ArrayList<MemberDTO>();
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 String sql = "select * from tbl_party_202005 natural join tbl_member_202005";
		 ResultSet rs = null;
		 
		 
		 try {
			conn = ConnectindClass.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String m_no = rs.getString("m_no");
				String m_name = rs.getString("m_name");
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String p_school = rs.getString("p_school");
				String m_jumin = rs.getString("m_jumin");
				String m_city = rs.getString("m_city");
				String p_tel1 = rs.getString("p_tel1");
				String p_tel2 = rs.getString("p_tel2");
				String p_tel3 = rs.getString("p_tel3");
				
				MemberDTO dto = new MemberDTO(m_no, m_name, p_code, p_name, p_school, m_jumin, m_city, p_tel1, p_tel2, p_tel3);
				list.add(dto);
			}
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectindClass.closeAll(rs, pstmt, conn);
		}
		 
		
		return list;
	}

	public List<MemberGradeDTO> grade() {
		// TODO Auto-generated method stub
		List<MemberGradeDTO> list = new ArrayList<MemberGradeDTO>();
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 String sql = "select m_no, m_name, count(vote) count from "
		 		+ "(select m.m_no as m_no, m.m_name as m_name, v.m_no as vote from TBL_MEMBER_202005 m left outer join TBL_VOTE_202005 v on m.m_no = v.m_no where v.c_confirm = 'Y') "
		 		+ "group by(m_no, m_name) order by count desc";
		 ResultSet rs = null;
		 
		 
		 try {
			conn = ConnectindClass.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String m_no = rs.getString(1);
				String  m_name = rs.getString(2);
				int count = rs.getInt(3);
				
				MemberGradeDTO dto = new MemberGradeDTO(m_no, m_name, count);
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
