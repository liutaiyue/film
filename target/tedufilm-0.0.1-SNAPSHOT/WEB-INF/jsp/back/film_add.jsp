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
  </head>
  <body>
	<h1>添加电影</h1>
	<hr>
	<form action="${ctx}/BackFilmAddServlet"
	   enctype="multipart/form-data" method="POST">
		<table border="1" cellspacing="0" cellpadding="3" >
			<tr>
				<td>电影名称</td>
				<td><input type="text" name="film_name" /></td>
			</tr>
			<tr>
				<td>电影时长</td>
				<td><input type="text" name="time_period" /></td>
			</tr>
			<tr>
				<td>电影单价</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>电影种类</td>
				<td>
					<select name="type_id">
						<c:forEach items="${typeList}" var="type">
						<option value="${type.type_id }">${type.type_name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>电影图片</td>
				<td><input type="file" name="img_url"/>${msg }</td>
			</tr>
			<tr>
				<td>描述信息</td>
				<td><textarea cols="35" rows="6" name="descr"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加电影"/></td>
			</tr>
		</table>
	</form>
	<hr>
  </body>
</html>
