package cn.tarena.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Order;
import cn.tarena.film.service.OrderService;

@Controller
@RequestMapping("/back/")
public class BackOrderController {
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("orderList")
	public String findAll(Model model){
		List<Order> orderList=orderService.findAll();
		model.addAttribute("orderList", orderList);
		return "/back/order_list";
	}
	@RequestMapping("deleteOrder")
	public String deleteOrder(String[] orderId){
		orderService.deleteOrder(orderId);
		return "redirect:/back/orderList";
	}
}
