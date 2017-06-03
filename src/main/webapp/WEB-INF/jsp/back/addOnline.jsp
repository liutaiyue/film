<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../url.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
	<style type="text/css">
		body{
			background: #F5F5F5;
		}
		h1{
			text-align: center;
		}
		table{
			margin: 0px auto;
		}
  	</style>
  	<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.js"></script>
  	<script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
  </head>
  <body>
	<h1>添加电影时间</h1>
	<hr>
	<form action="${ctx }/back/savePlay" method="POST">
		<table border="1" cellspacing="0" cellpadding="3" >
			<tr>
				<td>电影名称</td>
				<td>${film.filmName }</td>
			</tr>
			<tr><td><input type="hidden" name="film.filmId" value="${film.filmId }"/></td></tr>
			<tr>
				<td>开始时间</td>
				<td><input type="text"  name="startTime" 
				onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm'});"/></td>
			</tr>
			<tr>
				<td>影厅号</td>
				<td><select name="hall.hallId">
					<option>--请选择--</option>
					<c:forEach items="${hallList }" var="hall">
					<option value="${hall.hallId}">${hall.hallName }</option>
					</c:forEach>
					</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加时间"/></td>
			</tr>
		</table>
	</form>
	<hr>
  </body>
</html>
