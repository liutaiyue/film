<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
    	<style>
    		
    		
    	</style>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>出现错误</title>
        <script language="javascript" type="text/javascript">
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    location.href = "${app}/AllFilmServlet";
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    location.href = "${app}/jsp/login.jsp";
                }
            }
        </script> 
    </head>
    <body class="error_page" style="padding:0px;" onload="startTimes();">
    	<div style="background:url(${app}/images/error.jpg) repeat-y scroll 0 0 transparent; margin: 0px; background-size:cover; padding:0px;height:720px;border:1px solid #fff"> 
    		<h1 id="error" style="margin-top:310px;padding-bottom:0px; padding:0px;">
	     		   遇到错误，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
           		 <a  href="javascript:resetTimer();">返回</a>
        	</h1>
    	</div>
        
    </body>
</html>
