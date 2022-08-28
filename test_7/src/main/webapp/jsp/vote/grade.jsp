<%@page import="kr.co.domain.MemberGradeDTO"%>
<%@page import="kr.co.domain.VoteConfirmDTO"%>
<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자등수</title>
</head>
<body>
<jsp:include page="../../part/header.jsp"/>

<section>
	<h1>후보자등수</h1>
	<table border="1">
			<thead>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
					
				</tr>
			</thead>
			<tbody>
				<%
							Object obj = request.getAttribute("list");
							List<MemberGradeDTO> list = null;
							if(obj != null){
								list = (List<MemberGradeDTO>)obj;
								
								for(int i=0; i<list.size(); i++){
									MemberGradeDTO dto = list.get(i);
									
									%>
									<tr>
				
										<td><%=dto.getM_no() %></td>
										<td><%=dto.getM_name() %></td>
										<td><%=dto.getCount() %></td>
									
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