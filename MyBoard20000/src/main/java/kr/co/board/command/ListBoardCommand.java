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
		
		int curPage = 1; //프로젝트 처음 시작할때 1페이지 보여줄려고
		String sCurPage = request.getParameter("curPage");//클라이언트가 보내준 데이터
		if(sCurPage != null) {
			
			curPage = Integer.parseInt(sCurPage);
			
		}//가공
		
		BoardDAO bdao = new BoardDAO();
		//List<BoardDTO> list = bdao.list();
		PageTO<BoardDTO> pt = bdao.page(curPage);
		request.setAttribute("pt", pt);
		//request.setAttribute("list", list);
		//return new BoardCommandAction("/jsp/board/list.jsp", false);
		return new BoardCommandAction("/jsp/board/list2.jsp", false);
	}

}
