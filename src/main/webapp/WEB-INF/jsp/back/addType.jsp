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
	<h1>添加电影类型</h1>
	<hr>
	<form action="${ctx }/back/saveType" method="POST">
		<table border="1" cellspacing="0" cellpadding="3" >
			<tr>
				<td>电影类型名称</td>
				<td><input type="text"  name="typeName" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加类型"/></td>
			</tr>
		</table>
	</form>
	<hr>
  </body>
</html>
