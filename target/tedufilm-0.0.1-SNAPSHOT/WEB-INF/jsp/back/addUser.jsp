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
	<h1>添加用户</h1>
	<hr>
	<form action="${ctx }/back/saveUser" method="POST">
		<table border="1" cellspacing="0" cellpadding="3" >
			<tr>
				<td>用户名</td>
				<td><input type="text"  name="username" /></td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td><input type="text"  name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加用户"/></td>
			</tr>
		</table>
	</form>
	<hr>
  </body>
</html>
