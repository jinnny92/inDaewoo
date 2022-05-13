package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.command.BoardCommand;
import kr.co.board.command.DeleteBoardCommand;
import kr.co.board.command.InsertBoardCommand;
import kr.co.board.command.InsertUIBoardCommand;
import kr.co.board.command.ListBoardCommand;
import kr.co.board.command.MainCommand;
import kr.co.board.command.ReadBoardCommand;
import kr.co.board.command.ReplyBoardCommand;
import kr.co.board.command.ReplyUIBoardCommand;
import kr.co.board.command.SearchBoardCommand;
import kr.co.board.command.UpdateBoardCommand;
import kr.co.board.command.UpdateUIBoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.dw.member.command.AdminCommand;
import kr.co.dw.member.command.DeleteCommand;
import kr.co.dw.member.command.DeleteUICommand;
import kr.co.dw.member.command.FindDTOByIdCommand;
import kr.co.dw.member.command.InsertUICommand;
import kr.co.dw.member.command.ListCommand;
import kr.co.dw.member.command.LoginCommand;
import kr.co.dw.member.command.LoginUICommand;
import kr.co.dw.member.command.LogoutCommand;
import kr.co.dw.member.command.MyinfoCommand;
import kr.co.dw.member.command.MyinfodeleteCommand;
import kr.co.dw.member.command.MyinfodeleteuiCommand;
import kr.co.dw.member.command.MyinfoupdateCommand;
import kr.co.dw.member.command.MyinfoupdateuiCommand;
import kr.co.dw.member.command.UpdateCommand;
import kr.co.dw.member.command.UpdateUICommand;
import kr.co.dw.member.command.insertCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, BoardCommand> menus = new HashMap<String, BoardCommand>();

		menus.put("/board/insertui.do", new InsertUIBoardCommand());
		menus.put("/board/insert.do", new InsertBoardCommand());
		menus.put("/board/list.do", new ListBoardCommand());
		menus.put("/board/read.do", new ReadBoardCommand());
		menus.put("/board/updateui.do", new UpdateUIBoardCommand());
		menus.put("/board/update.do", new UpdateBoardCommand());

		menus.put("/board/delete.do", new DeleteBoardCommand());
		menus.put("/board/replyui.do", new ReplyUIBoardCommand());
		menus.put("/board/reply.do", new ReplyBoardCommand());
		menus.put("/board/search.do", new SearchBoardCommand());
		menus.put("/board/main.do", (BoardCommand) new MainCommand());
		menus.put("/list.do", (BoardCommand) new ListCommand());
		
		menus.put("/insertui.do", (BoardCommand) new InsertUICommand());
		menus.put("/insert.do", (BoardCommand) new insertCommand());
		menus.put("/updateui.do", (BoardCommand) new UpdateUICommand());
		menus.put("/update.do", (BoardCommand) new UpdateCommand());
		menus.put("/deleteui.do", (BoardCommand) new DeleteUICommand());
		menus.put("/delete.do", (BoardCommand) new DeleteCommand());
		menus.put("/finddtobyid.do", (BoardCommand) new FindDTOByIdCommand());
		menus.put("/loginui.do", (BoardCommand) new LoginUICommand());
		menus.put("/login.do", (BoardCommand) new LoginCommand());
		menus.put("/logout.do", (BoardCommand) new LogoutCommand());
		menus.put("/admin.do", (BoardCommand) new AdminCommand());
		menus.put("/myinfo.do", (BoardCommand) new MyinfoCommand());
	    menus.put("/myinfodeleteui.do",  (BoardCommand) new MyinfodeleteuiCommand());
	    menus.put("/myinfodelete.do", (BoardCommand) new MyinfodeleteCommand());
	    menus.put("/myinfoupdateui.do", (BoardCommand) new MyinfoupdateuiCommand());
	    menus.put("/myinfoupdate.do", (BoardCommand) new MyinfoupdateCommand());
		
		String what = request.getServletPath();

		BoardCommand bCommand = menus.get(what.toLowerCase());

		if (bCommand != null) {
			BoardCommandAction bAction = bCommand.execute(request, response);

			if (bAction.isRedirect()) {

				response.sendRedirect(bAction.getWhere());

			} else {
				request.getRequestDispatcher(bAction.getWhere()).forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/jsp/noserviceinfo.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
