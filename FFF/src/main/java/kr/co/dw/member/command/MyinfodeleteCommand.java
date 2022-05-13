package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.command.BoardCommand;
import kr.co.board.dao.MemberDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class MyinfodeleteCommand implements BoardCommand {

   @Override
   public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      HttpSession session = request.getSession(false);
      
      String id = request.getParameter("id");
      
      
      MemberDAO dao = new MemberDAO();

      dao.delete(new MemberDTO(id, null, null, null, null, null));
      if (session != null) {
         session.invalidate();
         
      }
      return new BoardCommandAction("/board/main.do", true);
      
      
   }

}