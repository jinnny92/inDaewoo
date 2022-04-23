package kr.co.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.domain.BoardCommandAction;

public interface BoardCommand {
<<<<<<< HEAD
	public BoardCommandAction execute(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException;

=======
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
>>>>>>> refs/remotes/origin/master
}
