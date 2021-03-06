<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../url.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>影厅列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="#" onclick="formSubmit('${ctx}/back/toCreatHall','_self');this.blur();">新增</a></li>
	<li id="update"><a href="#" onclick="formSubmit('${ctx}/back/toUpdateHall','_self');this.blur();">修改</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('${ctx}/back/deleteHall','_self');this.blur();">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx}/skin/default/images/icon/currency_yen.png"/>
    影厅列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('hallId',this)"></td>
		<td class="tableHeader">影厅ID</td>
		<td class="tableHeader">影厅名</td>
		<td class="tableHeader">行数</td>
		<td class="tableHeader">列数</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${hallList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="hallId" value="${u.hallId}"/></td>
		<td>${u.hallId}</td>
		<td>${u.hallName}</td>
		<td>${u.hallRow}</td>
		<td>${u.hallCol}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

