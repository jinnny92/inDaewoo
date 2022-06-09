package kr.co.dw.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.repository.board.BoardDAO;
import kr.co.dw.repository.reply.ReplyDAO;
import kr.co.dw.repository.upload.UploadDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO bDao;
	
	@Autowired
	private ReplyDAO rDao;
	
	
	@Autowired
	private UploadDAO uDao;
	
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

	@Override
	@Transactional
	public void update(BoardDTO bDto, String[] arr) {
		// TODO Auto-generated method stub
		update(bDto); //텍스트쪽에서 업데이트가 이루어졌고
		
		
		for (int i = 0; i < arr.length; i++) {
			String filename = arr[i];
			uDao.deleteUpload(filename); //파일 이름이 들어갈건데 배열이니까 반복문을 이용해서 하나씩 하나씩
		}
		
	}
	

}
