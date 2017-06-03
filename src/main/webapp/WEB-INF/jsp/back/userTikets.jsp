<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../url.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${ctx}/styles/comm.css">
<title>我的电影票</title>
</head>
<body>
	<div class="myTikets">
	<c:if test="${empty userTikets}">
		<div class="contain">
			<h2>此人还没有购买电影票...</h2>
		</div>
	</c:if>
		<c:forEach items="${userTikets}" var="my">
		<div class="block">
			<div class="filmImg">
				<img src="${ctx}/${my.img_url}">
			</div>
			<div class="allMsg">
				<p>片名：${my.film_name}</p>
				<p>影 厅：${my.hall_num}</p>
				<p>放映时间：
				<fmt:formatDate value="${my.start_time}" type="both"/>
				</p>
				<p>预计结束时间：
				<fmt:formatDate value="${my.end_time}" type="both"/>
				</p>
				<p>座位：${my.seat_id}</p>
				<a href="${ctx }/BackDetiketsServlet?seatID=${my.seat_id}&empId=${empId}">
					退订
				</a>
				<span>价格：${my.price}（元）</span>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>