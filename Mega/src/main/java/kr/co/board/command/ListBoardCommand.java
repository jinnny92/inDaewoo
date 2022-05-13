package kr.co.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;
import kr.co.menu.MenuCommand;

public class ListBoardCommand implements MenuCommand {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//처음시작할때는 무조건 1페이지 나오지만 사용자가 누른 페이지
		
		int curPage = 1; // 무조건 1페이지를 보여주려고
		
		 String sCurPage = request.getParameter("curPage"); //클라이언트가 요청한 페이지
		 if (sCurPage != null) { //얘가 있을수도 있고 없을수도 있으니 not null이라는 가정하에 작업 notnull일때만 이 작업실행
			  curPage = Integer.parseInt(sCurPage);
			
		}
		
		BoardDAO dao = new BoardDAO();
		// List<BoardDTO> list = dao.list();
		
		//request.setAttribute("list", list);
		
			PageTO<BoardDTO> pt = dao.page(curPage);
		
			request.setAttribute("pt", pt);

		
		return new CommandAction("/jsp/board/b_list2.jsp", false);
	}

}
