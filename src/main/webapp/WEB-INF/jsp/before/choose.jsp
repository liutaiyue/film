<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../url.jsp"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选座</title>
<script type="text/javascript" src="${ctx }/js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="${ctx }/styles/comm.css">
</head>
<body>
	<c:import url="comm/head.jsp"></c:import>
	<div class="booking">
		<div class="register-first" id="register-first">
			<span>请 您 先 登 录</span>
			<a class="y" href="${ctx }/toLogin.action">确 定</a>
			<a class="y" href="${ctx }/toHome.action">取 消</a>
		</div>
		<div class="info">
			<span>选择座位</span>
		</div>
		<div class="chooseSeats">
			<div class="choose">
				<div class="note">
					<span>可选座位</span><span class="can"></span>
					<span>已售座位</span><span class="used"></span>
					<span>已选座位</span><span class="selected"></span>
					<p>荧幕方向</p>
				</div>
				<div class="seats">
					<c:forEach	begin="0" end="${play.hall.hallRow-1}" varStatus="i">
						<c:forEach begin="0" end="${play.hall.hallCol-1}" varStatus="t">
							<c:set var="col" value="${play.hall.hallCol-1}"/>
							<span class="can" id="0${i.index+1}0${t.index+1}" title="${i.index+1}排${t.index+1}号"></span>
							<c:if test="${t.index==col}"><br/></c:if>
						</c:forEach>
					</c:forEach>
				</div>
				<p class="notice">单击已选取座位可取消选择!&nbsp;一次最多订<b>2张</b>!</p>
			</div>
			<div class="descr">
				<div class="base">
					<p>影片:<span>${play.film.filmName}</span></p>
					<p>时长:<span>${play.film.duration}</span> &nbsp;&nbsp;单价:<span>${play.film.price}(元)</span></p>
					<p>影院:<span>${play.hall.hallName}</span></p>
					<p>
						场次:
						<span><fmt:formatDate value="${play.startTime}" type="both"/></span>
					</p>
				</div>
				<div class="seat">
					座位：
				</div>	
				<div class="saleout">
					<p>
						<a id="saleout" href="javascript:;" onclick="buy();">立即购买</a>
						<span></span>
					</p>
				</div>
			</div>
		</div>
	</div>
	<c:import url="comm/footer.jsp"></c:import>
</body>
<script>
	$(function(){
		//处理已经被购买的座位样式
		var used = '${used}';
		used = used.replace("[","").replace("]",""); 
		var usedArr = used.split(",");
		$(usedArr).each(function(i,id){
			id = $.trim(id);
			$("#"+id).addClass("used").removeClass("can");
		});
		
		//是否登录--能够购买
		if(""==$("#user-name").html()){
			$("#register-first").show();
			$("#saleout").attr("href","#");
		}
		//
		var count=0;
		$(".seats span").click(function(){
			if($(this).hasClass("can") && count<=2){
				if(count>=2){
					alert("最多选2个位置");
					return false;
				}
				$(this).attr("class","selected");
				var $span="<span id=select_"+$(this).attr("id")+"> "+$(this).attr("title")+"</span>";
				/* 去除提示选座信息 */
				var $input="<input type='hidden' value="+$(this).attr("id")+" name='seats'/>";
				$(".saleout p span").html("");
				$(".seat").append($span);
				$(".seat").append($input);
				count++;
			}else if($(this).hasClass("selected")){
				$(this).attr("class","can");
				$(".seat span[id=select_"+$(this).attr('id')+"]").remove();
				count--;
			}
			
		});
	});
	function buy(){
		if(""==$("#user-name").html()){
			$(".register-first").show();
			return false;
		}
		if(!$(".seat span").html()){
			$(".saleout p span").html("请选择座位");
			return false;
		}
		$("#buyForm").remove();
		var seatIdArr = [];
		var form = '<form id="buyForm" action="${ctx }/choose?playId=${play.playId}" method="POST">';
		$(".seats span.selected").each(function(){
			var thisId = $(this).attr("id");
			seatIdArr.push(thisId);
		});
		var thisInput = '<input type="text" value="'+seatIdArr+'" name="seats"/>';
		form += thisInput;
		form += "</form>";
		$("body").append(form);
		/* 获取总价 */
		var price='${onlineFilm.price}';
		var count=$('.selected').length-1;
		var b1 = confirm('支付 '+price*count+' 元');
		if(b1==false){
			return false;
		}
		$("#buyForm").submit();
	}
</script>
</html>