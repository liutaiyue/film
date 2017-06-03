<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../url.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" href="${ctx}/styles/comm.css">
<script src="${ctx}/js/jquery-1.11.1.js"></script>
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="alter-base" id="register-base">
		<div class="alter-box">
			<div class="title">
				<span>注 册</span>
				<a class="cancle" href="${ctx}/toHome" title="取 消"><img src="${ctx}/images/remove.png"></a>
			</div>
			<form method="post">
				<table>
					<tr>
						<td class="name">
							<span>账 号:</span>
						</td>
						<td class="in">
							<input type="text" maxlength="8" name="username" id="username" onblur="checkUsernameAvailable(this)"/>
						</td>
						<td class="note">最长8位 <span id="user_check"></span></td>
					</tr>
					<tr>
						<td class="name">
							<span>密 码:</span>
						</td>
						<td class="in">
							<input type="password" maxlength="16" name="password" id="password" onblur="checkPassword()"/>
						</td>
						<td class="note">最长16位</td>
					</tr>
					<tr>
						<td class="name">
							<span>确认密码:</span>
						</td>
						<td class="in">
							<input type="password" maxlength="16" name="password2" id="password2" onblur="checkPassword2()"/>
						</td>
						<td class="note">确认要设置的密码</td>
					</tr>
				</table>
				<div>
					<input name="code" name="code" type="text" class="code"/>
					<img src="registerVerfyCode.action" onclick="this.setAttribute('src','${ctx}/registerVerfyCode.action?x='+Math.random());" alt="验证码" title="点击更换" />
				</div>
				<p>
					<a class="submit" href="javascript:;" onclick="formSubmit('${ctx}/register.action')">提 交</a>
					<span class="message" id="message">${message}</span>
				</p>
			</form>
		</div>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
</body>
<script>
	function checkUsernameAvailable(){
		$('#message').text("");
		if($('#username').val()==""){
			$('#message').text("用户名不能为空");
			return false;
		}
		
		var username = $('#username').val();
		$("#user_check").load("${ctx}/checkUsernameAvailable.action",{"username":username});
	}
	
	function checkPassword(){
		$('#message').text("");
		if($('#password').val()==""){
			$('#message').text("密码不能为空");
			return false;
		}
		return true;
	}
	function checkPassword2(){
		$('#message').text("");
		if($('#password2').val()==""){
			$('#message').text("确认密码不能为空");
			return false;
		}
		if($('#password').val()!=$('#password2').val()){
			$('#message').text("两次密码不一致");
			return false;
		}
		return true;
	}
	
	function formSubmit (url){
		var checkUserResult = $('#user_check').val()!="该用户已存在";	
		var flag = checkUserResult & checkPassword() & checkPassword2();
		if(!checkUserResult){
			$('#message').text("请输入一个新的用户名");
			return;
		}
		if(flag){
		    document.forms[0].action = url;
		    document.forms[0].submit();
		}
	}
	
</script>
</html>