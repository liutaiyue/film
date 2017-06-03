<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>更多影片</title>
<link rel="stylesheet" href="${ctx }/styles/comm.css">
<script src="${ctx }/js/jquery-1.11.1.js"></script>
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="show_film clr">
	<a id="back" href="javascript:history.back()"> &lt;&lt;返回 </a>
		<ul>
			<c:forEach items="${films}" var="m">
				<li>
					<a href="${ctx }/toDetail?filmId=${m.filmId}">
						<img src="${m.filmImage}">
					</a>
					<p>${m.filmName}</p>
				</li>
			</c:forEach>
		</ul>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
	<a class="top" href="#">顶部</a>
</body>
</html>