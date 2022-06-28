package kr.co.dw.repository.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.member";
	@Override
	public MemberDTO login(MemberDTO mDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".login", mDto);
	}

}
