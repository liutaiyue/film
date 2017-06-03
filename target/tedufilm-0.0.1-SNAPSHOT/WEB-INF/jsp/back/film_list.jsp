<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../url.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="new"><a href="#" onclick="formSubmit('${ctx}/back/ToFilmCreate','_self');this.blur();">新增</a></li>
	<li id="update"><a href="#" onclick="formSubmit('${ctx}/back/playlist','_self');this.blur();">时间</a></li>
	<li id="delete"><a href="#" onclick="formSubmit('${ctx}/back/deleteFilm','_self');this.blur();">删除</a></li>
	<li id="view"><a href="#" onclick="formSubmit('${ctx}/back/printFilm','_self');this.blur();">打印</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx}/skin/default/images/icon/currency_yen.png"/>
    电影列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('filmId',this)"></td>
		<td class="tableHeader">影片图片</td>
		<td class="tableHeader">电影名称</td>
		<td class="tableHeader">上映时间</td>
		<td class="tableHeader">电影种类</td>
		<td class="tableHeader">电影时长</td>
		<td class="tableHeader">电影单价</td>
		<td class="tableHeader">描述信息</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${filmList}" var="film" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'">
		<td><input type="checkbox" name="filmId" value="${film.filmId}"/></td>
		<td><img width="120px" height="120px" src="${ctx}/${film.filmImage}"/></td>
		<td>${film.filmName}</td>
		<td><fmt:formatDate value="${film.releaseDate}" pattern="yyyy-MM-dd HH:mm"/></td>
		<td>${film.type.typeName}</td>
		<td>${film.duration }</td>
		<td>${film.price}</td>
		<td>${film.describes }</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

