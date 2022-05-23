package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class MyinfodeleteuiCommand implements BoardCommand {

   @Override
   public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      HttpSession session = request.getSession(false);
      MemberDTO login = (MemberDTO) session.getAttribute("login");
       String id =  login.getId();
       
       request.setAttribute(id, "id");
      return new BoardCommandAction("/member/jsp/myinfodelete.jsp", false);
   }

}