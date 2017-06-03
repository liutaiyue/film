<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../url.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>影厅修改</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="update"><a href="#" onclick="formSubmit('${ctx}/back/updateHall','_self');this.blur();">更新</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx}/skin/default/images/icon/currency_yen.png"/>
    影厅更新
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<tr>
		<td><input type="hidden" name="hallId" value="${hall.hallId}"/></td>
	</tr>
	<tr class="odd">
		<td>影厅号:</td>
		<td><input  type="text" name="hallId" value="${hall.hallId}"/></td>
		<td>影厅名:</td>
		<td><input  type="text" name="hallName" value="${hall.hallName}"/></td>
		<td>座位行数:</td>
		<td><input  type="text" name="hallRow" value="${hall.hallRow}"/></td>
		<td>座位列数:</td>
		<td><input  type="text" name="hallCol" value="${hall.hallCol}"/></td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

