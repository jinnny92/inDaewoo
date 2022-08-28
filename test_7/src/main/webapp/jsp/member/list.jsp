<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보조회</title>
</head>
<body>
<jsp:include page="../../part/header.jsp"/>

<section>
	<h1>후보조회</h1>
	<table border="1">
			<thead>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
			</thead>
			<tbody>
				<%
							Object obj = request.getAttribute("list");
							List<MemberDTO> list = null;
							if(obj != null){
								list = (List<MemberDTO>)obj;
								
								for(int i=0; i<list.size(); i++){
									MemberDTO dto = list.get(i);
									
									%>
									<tr>
										<td><%=dto.getM_no() %></td>
										<td><%=dto.getM_name() %></td>
										<td><%=dto.getP_name() %></td>
										<td><%=dto.getSchoolName() %></td>
										<td><%=dto.getJumin() %></td>
										<td><%=dto.getM_city() %></td>
										<td><%=dto.getTel() %></td>
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