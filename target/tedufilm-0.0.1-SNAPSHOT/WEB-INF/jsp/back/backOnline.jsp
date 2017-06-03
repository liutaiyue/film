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
function deleteFilm(uid,fid){
	if(window.confirm("您确定删除？")){
		window.location.href = "${app }/BackOnlineDeleteServlet?uid="+uid+"&fid="+fid;
	}
}
</script>
</head>
<body>
	<h1>电影管理</h1>
	<h3>${msg }</h3>
	<a href="${ctx}/BackAddOnlineServlet?fid=${filmId}">添加电影播映时间</a>
	<hr>
	<table bordercolor="black" border="1" width="95%" cellspacing="0px" cellpadding="5px">
		<tr>
			<th>电影名称</th>
			<th>电影时长</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>影厅号</th>
			<th nowrap="nowrap">&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;</th>
		</tr>
	<c:forEach items="${onlineList}" var="online" >
		<tr>
				<td>${online.film_name }</td>
				<td>${online.time_period}</td>
				<td>${online.start_time }</td>
				<td>${online.end_time}</td>
				<td>${online.hall_num }</td>
				<td><a href="javascript:void(0)" onclick="deleteFilm('${online.unique_id}','${online.film_id }')">删除</a>
					<a href="${ctx}/ToUpdateOnlineServlet?uqId=${online.unique_id}">更新</a>
				</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>
