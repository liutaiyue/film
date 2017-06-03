<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" href="${ctx }/styles/comm.css">
<script src="${ctx }/js/jquery-1.11.1.js"></script>
</head>
<body class="login-body">
	<div id="stage" >
		<div id="parent" style="margin-top:75px">
			<div><img alt="" src="${ctx }/images/films/1-1.jpg"></div>
			<div><img alt="" src="${ctx }/images/films/1-2.jpg"></div>
			<div><img alt="" src="${ctx }/images/films/1-3.jpg"></div>
			<div><img alt="" src="${ctx }/images/films/1-4.jpg"></div>
			<div><img alt="" src="${ctx }/images/films/1-5.jpg"></div>
			<div><img alt="" src="${ctx }/images/films/2-1.jpg"></div>
		</div>
	</div>
	<div class="login" style="margin-top:200px">
	<form action="${ctx }/login.action" method="post" class="login-box" id="submit">
			<p class="user">
				<span>
					账 号:
				</span>
				<input type="text" maxlength="8" name="username" value="${param.userName}" id="account" onblur="checkUsername()">
				<span style="color: red;font-size: 12px;" id="usernameError"/>
			</p>
			<p class="pwd">
				<span>
					密 码:
				</span>
				<input type="password" maxlength="16" value="${param.pwd}" name="password" id="password" onblur="checkPassword()">
				<span style="color: red;font-size: 12px;" id="passwordError"/>
			</p>
			<a href="javascript:;" onclick="login('${ctx }/login.action');">登 录</a>
			<p class="message"><c:if test="${!empty errorInfo}">
					${errorInfo}
				</c:if></p>
 </div>
</body>
<script type="text/javascript">
	function checkUsername(){
		$('#usernameError').text("");
		if($('#account').val()==""){
			$('#usernameError').text("账号不能为空");
			return false;
		}
		return true;
	}
	
	function checkPassword(){
		$('#passwordError').text("");
		if($('#password').val()==""){
			$('#passwordError').text("密码不能为空");
			return false;
		}
		return true;
	}
	
	function login(url){
		if(checkUsername() & checkPassword()){
			formSubmit(url);
		}
	}
	
	function formSubmit (url){
	    document.forms[0].action = url;
	    document.forms[0].submit(); 
	    return true;
	}
	
	
</script>
</html>