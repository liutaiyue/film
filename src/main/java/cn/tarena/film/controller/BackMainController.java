package cn.tarena.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackMainController {
	@RequestMapping("backhome")
	public String backHome(){
		return "/back/manage";
	}
	@RequestMapping("backtop")
	public String backTop(){
		return "/back/_top";
	}
	@RequestMapping("backleft")
	public String backLeft(){
		return "/back/_left";
	}
	@RequestMapping("backright")
	public String backRight(){
		return "/back/_right";
	}
}
