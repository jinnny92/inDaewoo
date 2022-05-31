package kr.co.dw.repository.reply;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.sym.Name;

import kr.co.dw.domain.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.reply";
	
	@Override
	public void insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".insert", map);
		
	}

	@Override
	public List<ReplyDTO> list(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+ ".list", bno);
	}

	@Override
	public void delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		
		sqlSession.delete(NAMESPACE + ".delete", map);
	}

	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		sqlSession.update(NAMESPACE + ".update", map);
		
	}

	@Override
	   public void deleteByBno(int bno) {
	      // TODO Auto-generated method stub
	      sqlSession.delete(NAMESPACE+".deleteByBno", bno);
	   }


}
