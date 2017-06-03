<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ include file="../url.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<style type="text/css">
  		body{
  			background-image: url(${ctx}/images/films/backleft.jpg);
            background-repeat:no-repeat;
  			text-align: center;
  			font-size: 25px;
  			
  		}
  		a{
  			text-decoration: none;
  		}
  	</style>
  </head>
  <body>
	<a target="_right" href="${ctx}/back/filmlist">电影管理</a><br>
	<a target="_right" href="${ctx}/back/userList">用户管理</a><br>
	<a target="_right" href="${ctx}/back/typelist">类型管理</a><br>
	<a target="_right" href="${ctx}/back/hallList">影厅管理</a><br>
	<a target="_right" href="${ctx}/back/orderList">订单管理</a><br>
	<shiro:hasPermission name="admin">
		<a href="${ctx}/toHome.action" target="_parent">前往前端</a>
	</shiro:hasPermission>
  </body>
</html>
