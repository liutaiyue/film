<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
function deleteFilm(hid,fid,pid){
	if(window.confirm("您确定删除？")){
		window.location.href = "${ctx}/back/deletePlay?hall.hallId="+hid+"&film.filmId="+fid+"&playId="+pid;
	}
}
</script>
</head>
<body>
	<h1>电影管理</h1>
	<h3>${msg }</h3>
	<a href="${ctx}/back/toPlayCreate?filmId=${film }">添加电影播映时间</a>
	<hr>
	<table bordercolor="black" border="1" width="95%" cellspacing="0px" cellpadding="5px">
		<tr>
			<th>电影名称</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>影厅</th>
			<th nowrap="nowrap">&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;</th>
		</tr>
	<c:forEach items="${playList}" var="play" >
		<tr>    <td>
		           ${play.film.filmName }
				</td>
				<td><fmt:formatDate value="${play.startTime}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td><fmt:formatDate value="${play.endTime}" pattern="yyyy-MM-dd HH:mm"/></td>
				<td>${play.hall.hallName }</td>
				<td><a href="javascript:void(0)" onclick="deleteFilm('${play.hall.hallId}','${play.film.filmId }','${play.playId }')">删除</a>
					&nbsp&nbsp<a href="${ctx}/back/toPlayUpdate?playId=${play.playId }">更新</a>
				</td>
			</tr>
	</c:forEach>
	</table>
</body>
</html>

