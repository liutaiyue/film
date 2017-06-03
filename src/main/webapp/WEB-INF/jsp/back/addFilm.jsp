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
  	<script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
  </head>
  <body>
	<h1>添加电影</h1>
	<hr>
	<form action="${ctx}/back/saveFilm" method="post"  enctype="multipart/form-data">
		<table border="1" cellspacing="0" cellpadding="3" >
			<tr>
				<td>电影名称</td>
				<td><input type="text" name="filmName" /></td>
			</tr>
			<tr>
				<td>电影时长</td>
				<td><input type="text" name="duration" /></td>
			</tr>
			<tr>
				<td>电影单价</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>上映时间</td>
				<td><input type="text"  name="releaseDate" 
				onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH:mm'});"/></td>
			</tr>
			<tr>
				<td>电影种类</td>
				<td>
					<select name="type.typeId">
						<c:forEach items="${typeList}" var="type">
						<option value="${type.typeId }">${type.typeName }</option>
						</c:forEach>
				</td>
			</tr></select>
			<tr>
				<td>电影图片</td>
				<td><input type="file" name="file"/>${msg }</td>
			</tr>
			<tr>
				<td>电影视频</td>
				<td><input type="file" name="video"/>该选项可为空!</td>
			</tr>
			<tr>
				<td>描述信息</td>
				<td><textarea cols="35" rows="6" name="describes"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加电影"/></td>
			</tr>
		</table>
	</form>
	<hr>
  </body>
</html>
