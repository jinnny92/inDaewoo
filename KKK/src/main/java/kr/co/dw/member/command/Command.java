package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dto.CommandAction;

public interface Command {
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
