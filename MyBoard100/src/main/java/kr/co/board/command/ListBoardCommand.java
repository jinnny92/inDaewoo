package kr.co.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.BoardDTO;
import kr.co.board.domain.PageTO;

public class ListBoardCommand implements BoardCommand {

	@Override
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int curPage = 1; //클라이언트가 페이지에 들어오면 아무것도 건드리지 않았어도 1페이지로 시작하게 하려고 만든 만든코드
		
		String sCurPage = request.getParameter("curPage");
		if (sCurPage != null) {
			curPage = Integer.parseInt(sCurPage);
			//클라이언트가 페이지를 눌렀을 때 몇 페이지인지 알려고 하는 코드 5페이지를 누르면 5페이지가 보여짐
		} 
		
		BoardDAO bDao = new BoardDAO();
		//List<BoardDTO>list = bDao.list();
		//request.setAttribute("list", list);
		
		PageTO<BoardDTO> pt = bDao.page(curPage);
		request.setAttribute("pt", pt);
		//외부시험엔 페이징처리가 안나오기 때문에 그냥 jsp에서 작업함
		
	
		
		return new BoardCommandAction("/jsp/board/list2.jsp", false);
	}

}
