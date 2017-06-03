package cn.tarena.film.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Order;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.pojo.Seat;
import cn.tarena.film.pojo.User;
import cn.tarena.film.service.OrderService;
import cn.tarena.film.service.PlayService;
import cn.tarena.film.service.SeatService;

@Controller
public class BeforePlayController {
	@Resource
	private PlayService playService;
	@Resource
	private SeatService seatService;
	@Resource
	private OrderService orderService;
	@RequestMapping("tochoose")
	public String chooseSeat(Integer playId,Model model){
		List<String> used = new ArrayList<String>();
		Play play = playService.findOne(playId);
		List<Seat> seatList = seatService.findSeatByPId(playId);
		if(seatList!=null){
			for (Seat seat : seatList) {
				int col = seat.getCol();
				int row = seat.getRow();
				String scol = null;
				String srow = null;
				String use = null;
				scol = "0"+String.valueOf(col);
				srow = "0"+String.valueOf(row);
				use = srow + scol;
				used.add(use);
			}
		}
		
		model.addAttribute("used", used);
		model.addAttribute("play", play);
		return "/before/choose";
	}
	@RequestMapping("choose")
	public String choose(String[] seats,Integer playId,HttpSession session){
		User user = (User)session.getAttribute("user");
		Order order = new Order();
		order.setUser(user);
		int col;
		int row;
		Seat seat = null;
		Play play = new Play();
		play.setPlayId(playId);
		for (String sub : seats) {
			seat = new Seat();
			if(sub.length()==4){
				row = Integer.parseInt(sub.substring(0, 2));
				col = Integer.parseInt(sub.substring(2, 4));
			}else if(sub.length()==5){
				row =Integer.parseInt(sub.substring(0, 2));
				col =Integer.parseInt(sub.substring(2, 5));
			}
			else{
				row =Integer.parseInt(sub.substring(0, 3));
				col =Integer.parseInt(sub.substring(3, 6));
			}
			seat.setRow(row);
			seat.setCol(col);
			seat.setPlay(play);
			seatService.saveSeat(seat);
			order.setSeat(seat);
			orderService.saveOrder(order);
			
		}
		return "redirect:/toHome";
	}
}
