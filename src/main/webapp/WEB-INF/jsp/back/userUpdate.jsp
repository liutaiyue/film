<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="baselist.jsp"%>
<%@ include file="../url.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户修改</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="update"><a href="#" onclick="formSubmit('${ctx}/updateUser','_self');this.blur();">更新</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx}/skin/default/images/icon/currency_yen.png"/>
    用户更新
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr>
		<td><input type="hidden" name="userId" value="${user.userId}"/></td>
	</tr>
	<tr class="odd">
		<td>用户名:</td>
		<td><input  type="text" name="username" value="${user.username}"/></td>
		<td>用户密码:</td>
		<td><input  type="text" name="password" value="${user.password}"/></td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

