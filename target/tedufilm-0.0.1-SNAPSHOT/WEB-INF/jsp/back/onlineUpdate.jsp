<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	<h1>添加电影</h1>
	<hr>                                                      
	<form action="${ctx}/back/updatePlay" method="POST">
		<table border="1" cellspacing="0" cellpadding="3" >
		   <tr>
				<td><input type="hidden" name="film.filmId" value="${play.film.filmId }" /></td>
				<td><input type="hidden" name="playId" value="${play.playId }" /></td>
			</tr>
			<tr>
				<td>电影名称</td>
				<td>${play.film.filmName}</td>
			</tr>
			<tr>
				<td>开始时间</td>
				<td><input type="text"  name="startTime" value="<fmt:formatDate value='${play.startTime}' pattern='yyyy-MM-dd HH:mm'/>"
				onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm'});"/></td>
			</tr>
			<tr>
				<td>影厅号</td>
				<td><select name="hall.hallId">
					<c:forEach items="${hallList }" var="hall">
					<option value="${hall.hallId}"  <c:if test="${play.hall.hallId==hall.hallId }">selected="selected"</c:if>  >${hall.hallName }</option>
					</c:forEach>
					</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新时间"/></td>
			</tr>
		</table>
	</form>
	<hr>
  </body>
</html>
