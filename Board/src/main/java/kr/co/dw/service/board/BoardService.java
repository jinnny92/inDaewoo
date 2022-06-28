package kr.co.dw.service.board;

import java.util.List;

import kr.co.dw.domain.BoardDTO;
import kr.co.dw.domain.PageTO;

public interface BoardService {

	void insert(BoardDTO bDto);

	List<BoardDTO> list();

	BoardDTO read(int bno);

	BoardDTO updateUI(int bno);

	void update(BoardDTO bDto);

	void delete(int bno);

	void update(BoardDTO bDto, String[] arr);

	void update(BoardDTO bDto, String[] arr, List<String> fileList);

	BoardDTO read(int bno, String ip);

	PageTO<BoardDTO> list(Integer curpage);
	
	List<BoardDTO> search(PageTO<BoardDTO> pt, String criteria, String keyword);
	
	Integer getAmountSearch(String criteria, String keyword);

	PageTO<BoardDTO> search(Integer curpage, String criteria, String keyword);

}
