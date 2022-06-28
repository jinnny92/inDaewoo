package kr.co.dw.repository.readcnt;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReadCntDaoImpl implements ReadCntDao {

	@Inject
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.readcnt";
	
	
	@Override
	public void insert(String ip, int bno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("bno", bno);
		
		sqlSession.insert(NAMESPACE+".insert", map);
		
	}


	@Override
	public String read(String ip, int bno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ip", ip);
		map.put("bno", bno);
		
		
		return sqlSession.selectOne(NAMESPACE+".read", map);
	}

	
	
	
	
}
