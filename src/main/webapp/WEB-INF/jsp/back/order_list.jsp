<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../url.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>订单列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="delete"><a href="#" onclick="formSubmit('${ctx}/back/deleteOrder','_self');this.blur();">删除</a></li>
	<li id="view"><a href="#" onclick="formSubmit('${ctx}/back/printOrder','_self');this.blur();">打印</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx}/skin/default/images/icon/currency_yen.png"/>
    订单列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('orderId',this)"></td>
		<td class="tableHeader">订单ID</td>
		<td class="tableHeader">顾客名</td>
		<td class="tableHeader">电影名</td>
		<td class="tableHeader">开始时间</td>
		<td class="tableHeader">票价</td>
		<td class="tableHeader">影厅号</td>
		<td class="tableHeader">座位号</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${orderList}" var="u" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="orderId" value="${u.orderId}"/></td>
		<td>${u.orderId}</td>
		<td>${u.user.username}</td>
		<td>${u.seat.play.film.filmName}</td>
		<td><fmt:formatDate value="${u.seat.play.startTime}" pattern="yyyy-MM-dd HH:mm"/></td>
		<td>${u.seat.play.film.price}</td>
		<td>${u.seat.play.hall.hallId}</td>
		<td>${u.seat.row}行${u.seat.col}列</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

