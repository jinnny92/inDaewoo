package kr.co.dw.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.repository.board.BoardDAO;
import kr.co.dw.repository.reply.ReplyDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO bDao;
	
	@Autowired
	private ReplyDAO rDao;
	
	@Transactional //세밀하게 작업하고 싶으면 메서드단에 @Transactional를 넣고 아니면 맨 위 서비스 쪽에 붙여도됨
	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		rDao.deleteByBno(bno);
		bDao.delete(bno);
	}
	
	@Override
	public void update(BoardDTO bDto) {
		// TODO Auto-generated method stub
		
		bDao.update(bDto);
		
	}
	
	
	@Override
	public BoardDTO updateUI(int bno) {
		// TODO Auto-generated method stub
	
		
		return bDao.updateUI(bno);
	}
	
	
	@Transactional
	@Override
	public BoardDTO read(int bno) {
		// TODO Auto-generated method stub
		
		bDao.increaseReadCnt(bno);
		
		BoardDTO dto = bDao.read(bno);
		
		
		//	String content =  dto.getContent().replace("<br>", System.lineSeparator());
		
		//dto.setContent(content);
		
		
		return dto;
	}
	
	
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		
		
		
		
		return bDao.list();
	}
	
	@Override
	public void insert(BoardDTO bDto) {
		// TODO Auto-generated method stub
		
		bDao.insert(bDto);
	}
	

}
