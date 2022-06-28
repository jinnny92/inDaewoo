package kr.co.dw.repository.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.domain.PageTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
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

		return sqlSession.selectOne(NAMESPACE + ".read", bno);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".list");
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

	@Override
	public Integer getAmountBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".getAmountBoard");
	}

	@Override
	public List<BoardDTO> list(PageTO<BoardDTO> pt) {
		// TODO Auto-generated method stub

		RowBounds rb = new RowBounds(pt.getStartNum() - 1, pt.getPerPage());

		return sqlSession.selectList(NAMESPACE + ".list", null, rb);
		// return sqlSession.selectList(NAMESPACE+".", pt, rb); 여기에 pt넣으면 절대 안됨
		// mapper가 select * FROM tbl_board만 적기 때문에 그냥 list랑 똑같아서
	}

	/*
	 * @Override public Integer getAmountSearch(String criteria, String keyword) {
	 * // TODO Auto-generated method stub
	 * 
	 * 
	 * return sqlSession.selectOne(NAMESPACE+".getAmountSearch"); }
	 */

	
	  @Override public List<BoardDTO> search(PageTO<BoardDTO> pt, String criteria,
	  String keyword) { // TODO Auto-generated method stub
	  
	  Map<String, String> map = new HashMap<String, String>(); map.put("criteria",
	  criteria); map.put("keyword", keyword);
	  
	  
	  //int amount = getAmountSearch(String criteria, String keyword); 
	  //여기서하지말고 서비스에서 호출하기 pt.setAmount(amount);
	  
	  
	  RowBounds rb = new RowBounds(pt.getStartNum()-1, pt.getPerPage()); //페이징과 관련된
	  
	  return sqlSession.selectList(NAMESPACE+".search", map, rb); }
	  
	  
	  @Override public Integer getAmountSearch(String criteria, String keyword) {
	  // TODO Auto-generated method stub
	  
	  Map<String, String> map = new HashMap<String, String>(); map.put("criteria",
	  criteria); map.put("keyword", keyword);
	  
	  
	  
	  return sqlSession.selectOne(NAMESPACE+".getAmountSearch", map);
	  
	  
	  }
	 

}
