package kr.co.menu;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public interface MenuCommand {
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
