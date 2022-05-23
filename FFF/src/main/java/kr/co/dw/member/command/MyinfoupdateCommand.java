package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;

import kr.co.board.command.BoardCommand;
import kr.co.board.dao.MemberDAO;
import kr.co.board.domain.BoardCommandAction;
import kr.co.board.domain.MemberDTO;

public class MyinfoupdateCommand implements BoardCommand {

   @Override
   public BoardCommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      HttpSession session = request.getSession(false);
      if (session == null) {
         return new BoardCommandAction("/board/main.do", true);
      }
      String id = request.getParameter("id");
      
      String name = request.getParameter("name");
      String pw = request.getParameter("pw");
      String phonenumber = request.getParameter("phonenumber");
      String birthday = request.getParameter("birthday");
      String email = request.getParameter("email");
      
      MemberDAO dao = new MemberDAO();

      dao.update(new MemberDTO(id, pw, name, birthday, phonenumber, email));

      return new BoardCommandAction("/myinfo.do", false);
   }

}