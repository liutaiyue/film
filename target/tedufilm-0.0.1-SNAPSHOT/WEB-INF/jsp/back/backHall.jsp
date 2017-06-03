<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../url.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<style type="text/css">
body {
	background: #F5F5F5;
	text-align: center;
}

table {
	text-align: center;
	margin: 0px auto;
}
a {
	text-decoration: none;
	color:black;
}
a:hover{
	color:blue;
}
th {
	background-color: silver;
}
.row1{
	background-color: orange;
}
.row2{
	background-color: blue;
}
</style>
<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
function deleteHall(hid){
	if(window.confirm("您确定删除？")){
		window.location.href = "${app }/BackHallDeleteServlet?hid="+hid;
	}
}
</script>
</head>
<body>
	<h1>电影管理</h1>
	<h3>${msg }</h3>
	<a href="${ctx}/jsp/back/ addHall.jsp">添加影厅</a>
	<hr>
	<table bordercolor="black" border="1" width="95%" cellspacing="0px" cellpadding="5px">
		<tr>
			<th>影厅ID</th>
			<th>影厅号</th>
			<th nowrap="nowrap">&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;</th>
		</tr>
	<c:forEach items="${hallList}" var="hall" >
		<tr>
				<td>${hall.hall_id }</td>
				<td>${hall.hall_num}</td>
				<td><a href="javascript:void(0)" onclick="deleteHall('${hall.hall_id}')">删除</a>
				</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>
