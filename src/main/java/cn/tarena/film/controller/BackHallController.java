package cn.tarena.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Hall;
import cn.tarena.film.service.HallService;

@Controller
@RequestMapping("/back/")
public class BackHallController {
	@Autowired
	private HallService hallService;
	
	@RequestMapping("hallList")
	public String findAll(Model model){
		List<Hall> hallList=hallService.findAll();
		model.addAttribute("hallList", hallList);
		return "/back/hall_list";
	}
	
	@RequestMapping("toCreatHall")
	public String toCreate(){
		return "/back/addHall";
	}
	@RequestMapping("saveHall")
	public String saveHall(Hall hall){
		hallService.saveHall(hall);
		return "redirect:/back/hallList";
	}
	@RequestMapping("deleteHall")
	public String deleteHall(Integer[] hallId){
		hallService.deleteHall(hallId);
		return "redirect:/back/hallList";
	}
	@RequestMapping("toUpdateHall")
	public String toUpdate(Integer hallId,Model model){
		Hall hall=hallService.findOne(hallId);
		model.addAttribute("hall", hall);
		return "/back/hallUpdate"; 
	}
	@RequestMapping("updateHall")
	public String updateHall(Hall hall){
		hallService.updateHall(hall);
		return "redirect:/back/hallList";
	}
}
