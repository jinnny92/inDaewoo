<%@ page contentType="text/html; charset=EUC-KR"%>

<%@ page import="java.util.*"  %>
<%@ page import="com.model2.mvc.service.product.vo.*" %>
<%@ page import="com.model2.mvc.common.*" %>


<%
	HashMap<String,Object> map=(HashMap<String,Object>)request.getAttribute("map");
	SearchVO searchVO=(SearchVO)request.getAttribute("searchVO");
	String menu = request.getParameter("menu");

	
	int total=0;
	ArrayList<ProductVO> list=null;
	if(map != null){
		total=((Integer)map.get("count")).intValue();
		list=(ArrayList<ProductVO>)map.get("list");
	}
	
	int currentPage=searchVO.getPage();
	
	int totalPage=0;
	if(total > 0) {
		totalPage= total / searchVO.getPageUnit() ;
		if(total%searchVO.getPageUnit() >0)
			totalPage += 1;
	}
%>




<!DOCTYPE html>










<html>
<head>
<title>��ǰ �����ȸ</title>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

<script type="text/javascript">
function fncGetProductList(){
	   document.detailForm.submit();
	}



<!--
function fncGetProductList(){
	document.detailForm.submit();
}
-->
</script>
</head>

<body bgcolor="#ffffff" text="#000000">

<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/listProduct.do?menu=<%=menu%>" method="post">

<table width="100%" height="37" border="0" cellpadding="0"	cellspacing="0">
	<tr>
		<td width="15" height="37">
			<img src="/images/ct_ttl_img01.gif" width="15" height="37"/>
		</td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
					
					<%if(menu.equals("manage")) {%>
							��ǰ ����
					<%}else{ %>
							��ǰ �����ȸ
					<%} %>	
					
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37">
			<img src="/images/ct_ttl_img03.gif" width="12" height="37"/>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
	<%
		if(searchVO.getSearchCondition() != null) {
	%>
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
			<%
				if(searchVO.getSearchCondition().equals("0")){
			%>	
				
				<option value="0"selected>��ǰ��ȣ</option>
				<option value="1">��ǰ��</option>
				<option value="2">��ǰ����</option>
				
			<%
				}else if(searchVO.getSearchCondition().equals("1")){
			%>	
				<option value="0">��ǰ��ȣ</option>
				<option value="1"selected>��ǰ��</option>
				<option value="2">��ǰ����</option>
			<%
				}else {
			%>	
				<option value="0">��ǰ��ȣ</option>
				<option value="1">��ǰ��</option>
				<option value="2"selected>��ǰ����</option>
			<%
				}
			%>		
				
			</select>
			<input type="text" name="searchKeyword" value="<%=searchVO.getSearchKeyword() %>"
				 class="ct_input_g" style="width:200px; height:19px" />
		</td>
	<%
		}else{
	%>
		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0">��ǰ��ȣ</option>
				<option value="1">��ǰ��</option>
				<option value="2"selected>��ǰ����</option>
				<input type="text" name="searchKeyword"  class="ct_input_g" style="width:200px; height:19px" >
		</td>
	<%
		}
	%>	
		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23">
						<img src="/images/ct_btnbg01.gif" width="17" height="23">
					</td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetProductList();">�˻�</a>
					</td>
					<td width="14" height="23">
						<img src="/images/ct_btnbg03.gif" width="14" height="23">
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >��ü  <%= total%> �Ǽ�, ���� <%=currentPage %> ������</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">��ǰ��</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">�������</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	<% 	
		int no=list.size();
		for(int i=0; i<list.size(); i++) {
			ProductVO vo = (ProductVO)list.get(i);
	%>	
	<tr class="ct_list_pop">
		<td align="center"><%=no--%></td>
		<td></td>
				
				<td align="left">
				
				<% if(menu.equals("search")){%>
				<a href="/getProduct.do?prodNo=<%=vo.getProdNo() %>"><%= vo.getProdName() %></a>
				<%}else{ %>
				<a href="/updateProductView.do?prodNo=<%=vo.getProdNo() %>"><%= vo.getProdName() %></a>
				<% } %>
				
				</td>
		
		<td></td>
		<td align="left"><%=vo.getPrice() %></td>
		<td></td>
		<td align="left"><%=vo.getManuDate() %></td>
		<td></td>
		<td align="left">
		
			�Ǹ���
		
		</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>	
	
	<% } %>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
		<%
			for(int i=1;i<=totalPage;i++){
		%>
			<a href="/listProduct.do?page=<%=i%>&menu=<%=menu%>"><%=i %></a>
		<%
			}
		%>	
			
    	</td>
	</tr>
</table>
<!--  ������ Navigator �� -->

</form>

</div>
</body>
</html>
