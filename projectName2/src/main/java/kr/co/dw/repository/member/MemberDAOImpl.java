package kr.co.dw.repository.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired 
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.dw.member";
	
	@Override
	public void insert(MemberDTO dto) {
		// TODO Auto-generated method stub
		
		sqlSession.insert(NAMESPACE + ".insert", dto);
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".list");
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".read", id);
	}

	@Override
	public MemberDTO updateUI(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".updateUI", id);
	}

	@Override
	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		
		sqlSession.update(NAMESPACE + ".update", dto);
		
	}
	
}
