package kr.co.dw.repository.board;

import java.util.List;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.domain.PageTO;

public interface BoardDAO {

	void insert(BoardDTO bDto);

	List<BoardDTO> list();

	BoardDTO read(int bno);

	BoardDTO updateUI(int bno);

	void update(BoardDTO bDto);

	void delete(int bno);

	void increaseReadCnt(int bno);

	Integer getAmountBoard();

	List<BoardDTO> list(PageTO<BoardDTO> pt);

	//Integer getAmountSearch(String criteria, String keyword);
	
	
	 List<BoardDTO> search(PageTO<BoardDTO> pt, String criteria, String keyword);
	  //원래는 MAP으로 해야하는데..
	  
	  Integer getAmountSearch(String criteria, String keyword);
	 
}
