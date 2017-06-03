<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ include file="../../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="${ctx }/styles/comm.css">
<script src="${ctx }/js/jquery-1.11.1.js"></script>
<div class="head" >
	<div class="logo-box">
		<!-- <img class="logo" src="images/logo_v3.png"/> -->
		达 内 电 影 
	</div>
	<div class="nav-box">
		<a class="nav-item" href="${ctx }/toHome.action">主 页</a>
		<a class="nav-item" href="${ctx }/toSearch.action">查 询</a>
		<c:if test="${user.isAdmin==1}">
			<a href="${ctx }/backhome.action" class="nav-item">前往后端</a>
		</c:if>
	</div>
	<div class="personal">
		<c:if test="${empty user}">
			<a href="${ctx }/toLogin.action" class="head-toLogin">[登 录]</a>
			<a href="${ctx }/toRegister.action" class="head-toRegister">[注 册]</a>
		</c:if>
		<c:if test="${!empty user}">
			<a href="#"><img class="user" src="${ctx }/images/films/user.jpg"></a>
			<ul id="user-nav">
				<b></b>
				<li><a class="exit" href="${ctx }/logout.action">[退 出]</a></li>
				<li><a class="alter-code" href="${ctx }/toUpdatePassword.action">修 改 密 码</a></li>
				<li><a href="${ctx }/toMyTicket">我的电影票</a></li>
			</ul>
		</c:if>
	</div>
	<span class="user-name" id="user-name">${user.username}</span>
	<div class="clr"></div>
</div>