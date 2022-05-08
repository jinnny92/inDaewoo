package kr.co.board.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.domain.BoardCommandAction;

public interface BoardCommand {
	public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
}
