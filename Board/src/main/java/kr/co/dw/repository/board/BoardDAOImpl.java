package kr.co.dw.repository.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "kr.co.dw.board";

	
	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		
		sqlSession.delete(NAMESPACE + ".delete", bno);
	}
	
	
	@Override
	public void update(BoardDTO bDto) {
		// TODO Auto-generated method stub
		
		sqlSession.update(NAMESPACE + ".update", bDto);
	}
	

	@Override
	public BoardDTO updateUI(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".updateUI", bno);
	}
	
	
	@Override
	public BoardDTO read(int bno) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(NAMESPACE+".read", bno);
	}
	
	
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list");
	}
	
	
	@Override
	public void insert(BoardDTO bDto) {
		// TODO Auto-generated method stub
	
		sqlSession.insert(NAMESPACE + ".insert", bDto);
		
	}


	@Override
	public void increaseReadCnt(int bno) {
		// TODO Auto-generated method stub
		
		sqlSession.update(NAMESPACE + ".increaseReadCnt", bno);
		
	}

}
