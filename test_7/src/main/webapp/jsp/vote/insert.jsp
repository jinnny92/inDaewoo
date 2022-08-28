<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
</head>
<body>
<jsp:include page="../../part/header.jsp"/>

<section>
	<h1>투표하기</h1>
	<form action="/vote/insert.do" method="post" name="mForm" id="mForm">
	<table border="1">
			<tr>
				<th><label for="v_jumin">주민번호</label> 예 : 8906153154726 </th>
				<td><input id="v_jumin" name="v_jumin"></td>
			</tr>
			
			<tr>
				<th><label for="v_name">성명</label></th>
				<td><input id="v_name" name="v_name"></td>
			</tr>
			
			<tr>
				<th><label for="m_no">투표번호</label></th>
				
				<td><select id="m_no" name="m_no">
					<option></option>
					<%
						Object obj =	request.getAttribute("list");
						List<MemberDTO> list = null;
						if(obj != null){
							list = (List<MemberDTO>)obj;
							for(int i =0; i<list.size(); i++){
							 MemberDTO dto = list.get(i);
							 %>
							 	<option value="<%=dto.getM_no() %>">[<%=dto.getM_no() %>]<%=dto.getM_name() %></option>
							 	
							 <%
							}
							
						}
					
					%>
				</select>
				</td>
			</tr>
			
			
			<tr>
				<th><label for="v_time">투표시간</label></th>
				<td><input id="v_time" name="v_time"></td>
			</tr>
			
			<tr>
				<th><label for="v_area">투표장소</label></th>
				<td><input id="v_area" name="v_area"></td>
			</tr>
			<tr>
				<th>유권자확인</th>
				<td>
				<input id="c_confirm_Y" name="c_confirm" type="radio" value="Y">
				<label for="c_confirm_Y">확인</label>
				<input id="c_confirm_N" name="c_confirm" type="radio" value="N">
				<label id="c_confirm_N">미확인</label>
				</td>
			</tr>
	</table>
	</form>
	<button onclick="vote();">투표하기</button>
	<button onclick="reset();">다시하기</button>
</section>
<jsp:include page="../../part/footer.jsp"/>
<script type="text/javascript">

function reset() {
	document.mForm.reset();
	document.getElementById("v_jumin").focus();
}

function vote() {
	let v_jumin = document.getElementById("v_jumin");
	if (v_jumin.value == "") {
		alert("주민번호가 입력되지 않았습니다!");
		v_jumin.focus();
		return false;
	}
	
	
	let v_name = document.getElementById("v_name");
	if (v_name.value == "") {
		alert("성명이 입력되지 않았습니다!");
		v_name.focus();
		return false;
	}
	
	
	let m_no = document.getElementById("m_no");
	if (m_no.value == "") {
		alert("투표번호가 입력되지 않았습니다!");
		m_no.focus();
		return false;
	}
	
	
	let v_time = document.getElementById("v_time");
	if (v_time.value == "") {
		alert("투표시간이 입력되지 않았습니다!");
		v_time.focus();
		return false;
	}
	
	
	let v_area = document.getElementById("v_area");
	if (v_area.value == "") {
		alert("투표장소가 입력되지 않았습니다!");
		v_area.focus();
		return false;
	}
	
	
	let c_confirm_el = document.querySelector("input[name='c_confirm']:checked");
	if (c_confirm_el == null) {
		alert("유권자확인이 입력되지 않았습니다!");
		return false;
	}
	
	let c_confirm = c_confirm_el.value;
	
	alert("투표하기 정보가 정상적으로 등록 되었습니다");
	document.getElementById("mForm").submit();
}
	
/* 	let xhr = new XMLHttpRequest();
	let type = 'get';
	let url = "/vote/insert?v_jumin="+v_jumin+"&v_name="+v_name+"&m_no="+m_no+"&v_time="+v_time+"&v_area="+v_area+"&c_confirm="+c_confirm;
	
	xhr.open(type, url, false);
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState = 4) {
			if (xhr.status == 200 || xhr.status == 201) {
				alert("투표하기 정보가 정상적으로 등록 되었습니다");
				location.href='/';
			}
		}
		
	}
	
xhr.send();
}
 */

</script>
</body>
</html>