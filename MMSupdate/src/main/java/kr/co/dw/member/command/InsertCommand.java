package kr.co.dw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dw.member.dao.MemberDAO;
import kr.co.dw.member.dto.CommandAction;
import kr.co.dw.member.dto.MemberDTO;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1. 사용자가 보내준 데이터를 획득 및 가공
		
				//request 클라이언트가 서버쪽으로 데이터를 보낼때 사용하는 객체
				
				//response 서버가 클라이언트쪽으로 데이트를 보낼때 사용하는 객체
				
				String sId = request.getParameter("id"); 
				//획득했고
				int id = Integer.parseInt(sId); 
				//가공했다  Integer는 Wrapper 클래스를 이용한것 큰따옴표가 제거된 기본 자료형의 값이 나오게 됨
				
				String name = request.getParameter("name");
				
				String sAge = request.getParameter("age");
				// insert.jap에서 홈태그 만들때 input의 네임값으로 "따옴표 안의 것대로(파라미터네임)" 꼭 써워야한다
				int age = Integer.parseInt(sAge);
				
				//2. DAO 객체 생성 및 해당 메서드 호출
				
				MemberDAO dao = new MemberDAO();
				dao.insert(new MemberDTO(id, name, age));
				
				
				//3. 해당 메서드가 반환한 데이터를 바인딩(저장)
				//이 부분은 SELECT문일때만 사용 
				
				//4. 포워딩 객체 생성 및 반환
				

				return new CommandAction("list.do", true); 
				//false로 잡혔던거 true로 변경 어차피 데이터 바인딩 될 것도 없으니 주소와 내용을 맞춰줘야함
				//목록으로 갈건지, 회원정보 자세히보기로 갈건지 정해야함
				//우리는 목록으로 감. list.jsp 와 list.do 중 선택
				// 데이터 가져오려면 무조건 do
				//jsp는 그냥 엑셀파일 같은 빈 양식일 뿐. 
		
	}

}
