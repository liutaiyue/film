<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提示成功</title>
<link rel="stylesheet" href="styles/comm.css">
<script src="${app }/js/jquery-1.11.1.js"></script>
</head>
    <body id="msgImg" onload="startTimes();" style="margin:0;width:100%;height:100%;">
        <h1  id="success">
	        购买成功，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转☞主页，立即跳转请点击&nbsp;
            <a  href="javascript:resetTimer();">返回</a>
        </h1>
    </body>
<script language="javascript" type="text/javascript">
    var timer;
    //启动跳转的定时器
    function startTimes() {
        timer = window.setInterval(showSecondes, 1000);
    }
    var i = 5;
    function showSecondes() {
        if (i > 0) {
            i--;
            document.getElementById("secondes").innerHTML = i;
        }
        else {
            window.clearInterval(timer);
            location.href = "${app }/AllFilmServlet";
        }
    }

    //取消跳转
    function resetTimer() {
        if (timer != null && timer != undefined) {
            window.clearInterval(timer);
            location.href = "${app }/AllFilmServlet";
        }
    }
</script> 
</html>