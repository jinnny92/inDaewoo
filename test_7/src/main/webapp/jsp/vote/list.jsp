<%@page import="kr.co.domain.VoteConfirmDTO"%>
<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../../part/header.jsp"/>

<section>
	<h1>후보조회</h1>
	<table border="1">
			<thead>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
					
				</tr>
			</thead>
			<tbody>
				<%
							Object obj = request.getAttribute("list");
							List<VoteConfirmDTO> list = null;
							if(obj != null){
								list = (List<VoteConfirmDTO>)obj;
								
								for(int i=0; i<list.size(); i++){
									VoteConfirmDTO dto = list.get(i);
									
									%>
									<tr>
										<td><%=dto.getV_name() %></td>
										<td><%=dto.getBirth() %></td>
										<td><%=dto.getAge() %></td>
										<td><%=dto.getSex() %></td>
										<td><%=dto.getM_no() %></td>
										<td><%=dto.getV_time() %></td>
										<td><%=dto.getConfirm() %></td>
									
									</tr>
									<%
									
								}
								
							}
				
				
				%>
			</tbody>
	</table>
</section>
<jsp:include page="../../part/footer.jsp"/>
</body>
</html>