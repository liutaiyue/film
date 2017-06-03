<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${ctx }/css/video-js.css">
<link rel="stylesheet" type="text/css" href="${ctx }/styles/comm.css">
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<title>详细</title>
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="main">
		<div class="pic">
			<img src="${ctx }/${film.filmImage}"><br/>
			最新评价:<br/>
				<ol>
					<c:forEach items="${evaluates}" var="e" varStatus="i">
					<c:if test="${e!= null}">
						<c:if test="${i.index<5}">
								<li>${e.info}</li>
						</c:if>
					</c:if>	
					</c:forEach>
				</ol>
		</div>
		<div class="descript">
			<div class="film-name">
				<span style="font-size: 30px">${film.filmName}<p style="font-size: 22px">&nbsp;&nbsp;&nbsp;电影得分:${avgScore}</p></span>
			</div>
			<div class="descr">
				<span>剧情：</span>
				<span>
					${film.describes}
				</span>
			</div>
			<div class="time-period">
				<span>片长：</span>
				<span>${film.duration}</span>
			</div>
			<div class="type">
				<span>类型：</span>
				<span>${film.filmType.typeName}</span>
				<c:if test="${film.movieUrl!=null}">
					<video id="Html5Video" class="video-js vjs-default-skin" preload controls autoplay  width="100%"
		    		poster="${ctx }/assets/images/movie/poster.jpg"> 
		            <source id="src1" src="${film.movieUrl}" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"' />
		            <source id="src2" src="${film.movieUrl}" type='video/ogg; codecs="theora, vorbis"' />
		            <source id="src3" src="${film.movieUrl}" type='video/webm; codecs="vp8, vorbis"' />
		   			 您的浏览器不支持 video 标签。
		 			</video>
		 			<script type="text/javascript">
		  			  var myPlayer = videojs('example_video_1');
		   				 videojs("example_video_1").ready(function(){
		       		 var myPlayer = this;
		      		  myPlayer.play();
		    		});
					</script>
				</c:if>
			</div>
			<div class="films-list">
				<table class="lis">
					<tr>
						<th>放映时间</th>
						<th>时长</th>
						<th>影厅</th>
						<th>现价</th>
						<th>选座购票</th>
					</tr>
					<c:forEach items="${playList}" var="play">
						<tr>
							<td>
								<span class="pre">
									预计
									<fmt:formatDate value="${play.startTime}"
									 type="time" dateStyle="default"/>
									 结束
								 </span>
							</td>	
							<td>${film.duration}</td>
							<td>${play.hall.hallName}</td>
							<td>${film.price}</td>
							<td>
								<a id="toseats" href="${ctx }/tochoose?playId=${play.playId }">
									选座购票
								</a>
							</td>
						</tr>
					</c:forEach>
					<%-- <c:forEach items="" var="" varStatus="i">
						<tr></tr>
					</c:forEach>	 --%>
				</table>
				<c:if test="${user!=null}">
					<form action="${ctx }/toEvaluate.action?film.filmId=${film.filmId}" method="post">
						欢迎评价:<br/>
						电影评分:
						<input type="radio" name="score" value="5" checked="checked" />5
						<input type="radio" name="score" value="4" />4
						<input type="radio" name="score" value="3" />3
						<input type="radio" name="score" value="2" />2
						<input type="radio" name="score" value="1" />1
						<textarea rows="5" cols="100" name="info"></textarea>
						<p style="display: inline-block; float: right;"><input type="submit" value="提交" style="width:80px;height:30px;font-size:20px ">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"style="width:80px;height:30px;font-size:20px "/></p>
					</form>
				</c:if>
			</div>
		</div>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
</body>
</html>