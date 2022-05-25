package kr.co.dw.repository.item;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.sym.Name;

import kr.co.dw.domain.ItemDTO;

@Repository
public class ItemDAOImpl implements ItemDAO{
	@Autowired
		private SqlSession sqlSession;
		private final String NAMESPACE = "kr.co.dw.item"; //mapper에 namesapce값하고 다르면 안됨

		@Override
		public void delete(int iId) {
			// TODO Auto-generated method stub
			sqlSession.delete(NAMESPACE+".delete", iId);
		}
		
		
		@Override
		public void update(ItemDTO iDto) {
			// TODO Auto-generated method stub
			
			sqlSession.update(NAMESPACE+".update", iDto);
		}
		
		
		@Override
		public ItemDTO updateUI(int iId) {
			// TODO Auto-generated method stub
			return sqlSession.selectOne(NAMESPACE+".read", iId);
		}
		
		@Override
		public List<ItemDTO> list() {
			// TODO Auto-generated method stub
			return sqlSession.selectList(NAMESPACE+".list");
		}
		
		
		@Override
		public ItemDTO read(int iId) {
			// TODO Auto-generated method stub
			return sqlSession.selectOne(NAMESPACE+".read", iId);
		}
		
		
@Override
		public void insert(ItemDTO iDto) {
			// TODO Auto-generated method stub
			sqlSession.insert(NAMESPACE+".insert", iDto);
		}
}
