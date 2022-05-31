package kr.co.dw.repository.item;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE = "kr.co.dw.item"; //mapper에 namesapce값하고 다르면 안됨
}
