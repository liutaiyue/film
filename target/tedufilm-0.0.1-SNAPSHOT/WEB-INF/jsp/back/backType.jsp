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
function deleteType(tid){
	if(window.confirm("您确定删除？")){
		window.location.href = "${app }/BackTypeDeleteServlet?tid="+tid;
	}
}
</script>
</head>
<body>
	<h1>电影管理</h1>
	<h3>${msg }</h3>
	<a href="${ctx}/jsp/back/addType.jsp">添加电影类型</a>
	<hr>
	<table bordercolor="black" border="1" width="95%" cellspacing="0px" cellpadding="5px">
		<tr>
			<th>电影类型ID</th>
			<th>电影类型名称</th>
			<th nowrap="nowrap">&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;</th>
		</tr>
	<c:forEach items="${typeList}" var="type" >
		<tr>
				<td>${type.type_id }</td>
				<td>${type.type_name}</td>
				<td><a href="javascript:void(0)" onclick="deleteType('${type.type_id}')">删除</a>
				</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>
