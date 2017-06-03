<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../url.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" href="${ctx}/styles/comm.css">
<link rel="stylesheet" href="${ctx}/styles/all.css">
<script type="text/javascript" src="${ctx}/js/jquery-1.11.1.js"></script>
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div id="bigpic">
		<div title="即将上映" id="box" onmouseover="stop();" onmouseout="lunbo();"><img src="${ctx}/images/welcome.jpg" alt="欢迎界面" width="780px" height="439px"></div>
		<c:forEach items="${filmTypes}" var="thisType" varStatus="i">
			<c:forEach items="${thisType.films}" var="film" varStatus="t">
				<c:if test="${film.state==1}">
					<input type="hidden" class="newFilmImage" name="newFilmImage" value="${ctx}/${film.filmImage}"/>
					<input type="hidden" name="newfilmId" value="${film.filmId}">
				</c:if>
			</c:forEach>
		</c:forEach>
	</div>
	<c:forEach items="${filmTypes}" var="thisType" varStatus="i" >
		<div class="sorts type${i.index}">
			<div>
				<span class="pattern">${thisType.typeName}</span>
				<a href="${ctx}/moreFiles.action?typeId=${thisType.typeId}">更多影片>></a>
			</div>
			<div class="films">
				<ul>
					<c:forEach items="${thisType.films}" var="film" varStatus="t">
						<c:if test="${t.index<5}">
							<li>
								<a href="${ctx}/toDetail?filmId=${film.filmId}">
									<img src="${ctx}/${film.filmImage}">
								</a>
								<p>${film.filmName}</p>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<div class="clr"></div>
			</div>
		</div>
	</c:forEach>
	<c:import url="comm/footer.jsp"></c:import>
	<a class="top" href="#">顶部</a>
</body>
<script>
	var currentIndex = 0;
	var id;
	$(function(){
		lunbo();
	});
	var bgImgs=[];
	for(var i=0;i<$(".newFilmImage").length;i++){
		bgImgs[i]=document.getElementsByName("newFilmImage")[i].value; 
	}
	function lunbo(){
		id= setInterval(function(){
		    if (currentIndex >= bgImgs.length){
			    currentIndex = 0;
		    }
		    var obj = $("#box");
		    $(obj).html("<img height='439px' width='780px' onclick='forSumit("+currentIndex+")' src='"+bgImgs[currentIndex]+"'/>");
		    currentIndex += 1;
		}, 2500);
	}
	function forSumit(index){
		location.href="${ctx}/toDetail.action?filmId="+document.getElementsByName("newfilmId")[index].value;
		
	}
	function stop(){
		clearInterval(id);
	} 
</script>
</html>