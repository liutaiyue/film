<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../url.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>类型列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="#" onclick="formSubmit('${ctx}/back/toTypeCreate','_self');this.blur();">新增</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('${ctx}/back/deleteType','_self');this.blur();">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx}/skin/default/images/icon/currency_yen.png"/>
    类型列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('typeId',this)"></td>
		<td class="tableHeader">类型ID</td>
		<td class="tableHeader">类型名称</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${typeList}" var="type" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="typeId" value="${type.typeId }"/></td>
		<td>${type.typeId }</td>
		<td>${type.typeName}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

