<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ctx }/styles/comm.css">
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<title>查询</title>

</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="query">
		<form action="${ctx }/queryFilm.action" method="post">
			<span>电影类型</span>
			<select name="type.typeId" class="query_select">
				<option value="0">所有</option>
				<c:forEach items="${filmTypeList}" var="i">
				<option class="choose" value="${i.typeId}" <c:if test="${type==i.typeId }">selected="selected"</c:if>  >${i.typeName }</option>
				</c:forEach>
			</select>
			<span>电影名</span><input class="filmName" name="filmName" value="${filmname}"/>
			<input type="submit" class="go" value="搜 索 影  片"/>
		</form>
	</div>
	 <div class="show_film query_film clr">
		<span>${message}</span>
		<ul>
			<c:forEach items="${filmList}" var="film">
				<li>
					<a href="${ctx }/toDetail?filmId=${film.filmId}">
						<img src="${ctx }/${film.filmImage }">
					</a>
					<p>${film.filmName}</p>
				</li>
			</c:forEach>
		</ul>
	</div> 
	<div class="split clr"></div>
	<div class="show_film clr">
		<p>您可能感兴趣：</p>
		<ul>
			<c:forEach items="${interestFilm}" var="film">
				<li>
					<a href="${ctx }/detail.do?filmID=${film.filmId}">
						<img src="${ctx }/${film.filmImage}">
					</a>
					<p>${film.filmName}</p>
				</li>
			</c:forEach>
		</ul>
	<div class="clr"></div>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
	<a class="top" href="#">顶部</a>
</body>
</html>