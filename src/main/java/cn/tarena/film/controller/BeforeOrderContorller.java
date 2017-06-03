package cn.tarena.film.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Order;
import cn.tarena.film.pojo.User;
import cn.tarena.film.service.OrderService;

@Controller
public class BeforeOrderContorller {
	@Resource
	private OrderService orderService;
	
	
	@RequestMapping("toMyTicket")
	public String toMyTicket(Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		List<Order> orderList = orderService.findOrderByUId(user.getUserId());
		model.addAttribute("orderList", orderList);
		return "/before/myTikets";
	}
	@RequestMapping("deleteOrder")
	public String deleteOrder(String[] orderId){
		orderService.deleteOrder(orderId);
		return "forward:/toMyTicket";
	}
}
