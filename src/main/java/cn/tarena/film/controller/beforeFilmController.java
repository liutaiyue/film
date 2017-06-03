package cn.tarena.film.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Evaluate;
import cn.tarena.film.pojo.User;
import cn.tarena.film.service.EvaluateService;

@Controller
public class beforeFilmController {
	
	@Autowired
	private EvaluateService evaluateService;
	
	@RequestMapping("toEvaluate")
	public String toEvaluate(Evaluate evaluate,HttpSession session,Model model){
		if(!"".equals(evaluate.getInfo().trim())){
			evaluate.setUser((User)session.getAttribute("user"));
			evaluateService.saveEvaluate(evaluate);
		}
		return "redirect:/toDetail.action?filmId="+evaluate.getFilm().getFilmId();
	}
	
}
















