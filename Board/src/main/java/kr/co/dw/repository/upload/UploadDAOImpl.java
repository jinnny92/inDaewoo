package kr.co.dw.repository.upload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.BoardDTO;

@Repository
public class UploadDAOImpl implements UploadDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "kr.co.dw.upload";

	@Override
	public void insert(String filename, int bno) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("filename", filename);
		map.put("bno", bno);
		
		sqlSession.insert(NAMESPACE + ".insert", map);
	}

	@Override
	public List<String> getAllUpload(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getAllUpload", bno);
	}

	@Override
	public void deleteUpload(String filename) {
		// TODO Auto-generated method stub
		
		sqlSession.delete(NAMESPACE+".deleteUpload", filename);		
	}


}
