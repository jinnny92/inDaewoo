package kr.co.b.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.menu.MenuCommand;

public interface bCommand extends MenuCommand{
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
