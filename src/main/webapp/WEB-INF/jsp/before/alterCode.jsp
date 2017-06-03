<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="../url.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link rel="stylesheet" href="${ctx }/styles/comm.css">
<script type="text/javascript" src="${ctx }/js/jquery-1.11.1.js"></script>
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="alter-base">
	
		<div class="alter-box">
			<div class="title">
				<span>修 改 密 码</span>
				<a class="cancle" href="index.do" title="取 消"><img src="${ctx }/images/remove.png"></a>
			</div>
			<div class="user-name">你的用户名为: ${user.username}</div>
			<form action="" method="post">
				<table>
				<input type="hidden" id="userId" name="userId" value="${user.userId}" />
					<tr>
						<td class="name">
							<span>旧 密 码:</span>
						</td>
						<td class="in">
							<input type="password" maxlength="16" name="oldPassword" id="oldPassword" onblur="checkOldPassword()"/>
							<input type="hidden" id="oldPasswordCheckResult" value="false"/>
						</td>
						<td class="note">输入您当前的密码</td>
					</tr>
					<tr>
						<td class="name">
							<span>新 密 码:</span>
						</td>
						<td class="in">
							<input type="password" maxlength="16" name="newPassword" id="newPassword" onblur="checkNewPassword()"/>
						</td>
						<td class="note">输入您想设置的新密码</td>
					</tr>
					<tr>
						<td class="name">
							<span>确认密码:</span>
						</td>
						<td class="in">
							<input type="password" maxlength="16" name="newPassword2" id="newPassword2" onblur="checkNewPassword2()" />
						</td>
						<td class="note">确认要设置的新密码</td>
					</tr>
				</table>
				<div>
					<input name="code" type="text" class="code" />
					<img src="registerVerfyCode.action" onclick="this.setAttribute('src','registerVerfyCode.action?x='+Math.random());" alt="验证码" title="点击更换" />
				</div>
				<p>
					<a class="submit" href="javascript:;" onclick="submit('/updatePassword.action')"/>提 交</a>
					<span class="message" id="message">${message}</span>
				</p>
			</form>
		</div>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
</body>
<script>
function checkOldPassword(){
	$('#message').text("");
	if($('#oldPassword').val()==""){
		$('#message').text("原密码不能为空");
		return false;
	}
	
	var oldPassword = $('#oldPassword').val();
	var userId = $('#userId').val();
	$('#message').load("${ctx }/checkOldPassword.action",{"oldPassword":oldPassword,"userId":userId},function(){
		if($('#message').text()==""){
			$('#oldPasswordCheckResult').val("true");
		}
	});
}

function checkNewPassword(){
	$('#message').text("");
	if($('#newPassword').val()==""){
		$('#message').text("新密码不能为空");
		return false;
	}
	if($('#newPassword2').val()!="" & $('#newPassword').val()!=$('#newPassword2').val()){
		$('#message').text("两次密码不一致");
		return false;
	}
	
	return true;
}
function checkNewPassword2(){
	$('#message').text("");
	if($('#newPassword2').val()==""){
		$('#message').text("确认密码不能为空");
		return false;
	}
	if($('#newPassword').val()!=$('#newPassword2').val()){
		$('#message').text("两次密码不一致");
		return false;
	}
	return true;
}
function submit(url){
	var checkOldPasswordResult = $('#oldPasswordCheckResult').val()=="true";
	var flag = checkOldPasswordResult & checkNewPassword() & checkNewPassword2();
	if(flag){
		document.forms[0].action = url;
	    document.forms[0].submit(); 
	    return true;
	}
}
</script>
</html>