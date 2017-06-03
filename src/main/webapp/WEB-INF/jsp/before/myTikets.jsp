<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ctx }/styles/comm.css">
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<title>我的电影票</title>
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="myTikets">
	<c:if test="${empty orderList}">
		<div class="contain">
			<h2>您还没有购买电影票...</h2>
		</div>
	</c:if>
		<c:forEach items="${orderList}" var="my">
		<div class="block">
			<div class="filmImg">
				<img src="${ctx }/${my.seat.play.film.filmImage}">
			</div>
			<div class="allMsg">
				<p>片名：${my.seat.play.film.filmName}</p>
				<p>影 厅：${my.seat.play.hall.hallId}</p>
				<p>放映时间：
				<fmt:formatDate value="${my.seat.play.startTime}" type="both"/>
				</p>
				<p>座位：${my.seat.col}行${my.seat.row }</p>
				<a href="/toDetail?filmId=${my.seat.play.film.filmId}">
					继 续 购 买
				</a>
				 <a href="${ctx }/deleteOrder?orderId=${my.orderId}">
					退订
				</a>
				<span>价格：${my.seat.play.film.price}（元）</span>
			</div>
		</div>
		</c:forEach>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
</body>
</html>