package cn.tarena.film.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.Hall;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.service.FilmService;
import cn.tarena.film.service.HallService;
import cn.tarena.film.service.PlayService;

@Controller
@RequestMapping("/back")
public class BackPlayController extends BaseController {
	@Resource
	private PlayService playService;
	@Resource
	private FilmService filmService;
	@Resource
	private HallService hallSevice;
	@RequestMapping("playlist")
	public String findAll(Integer filmId,Model model){
		List<Play> playList = playService.findAll(filmId);
		for (Play play : playList) {
			long time = (long)play.getFilm().getDuration();
			Date date = new Date();
			date.setTime(play.getStartTime().getTime()+time*1000*60);
			play.setEndTime(date);
		}
		model.addAttribute("film", filmId);
		model.addAttribute("playList", playList);
		return "/back/play_list";
		
	}
	@RequestMapping("toPlayCreate")
	public String toPlayCreate(Integer filmId,Model model){
		Film film = filmService.findFilmByFilmId(filmId);
		List<Hall> hallList = hallSevice.findAll();
		model.addAttribute("film",film);
		model.addAttribute("hallList", hallList);
		return "/back/addOnline";
	}
	@RequestMapping("savePlay")
	public String saveFilm(Play play,Model model){
		playService.savePlay(play);
		return "forward:/back/playlist?filmId="+play.getFilm().getFilmId();
	}
	
	@RequestMapping("deletePlay")
	public String deletePlay(Play play) {
		playService.deletePlay(play);
		return "forward:/back/playlist?filmId="+play.getFilm().getFilmId();
	}
	@RequestMapping("toPlayUpdate")
	public String toPlayUpdate(Integer playId,Model model) {
		Play play = playService.findOne(playId);
		List<Hall> hallList = hallSevice.findAll();
		model.addAttribute("hallList", hallList);
		model.addAttribute("play", play);
		return "/back/onlineUpdate";
	}
	
	@RequestMapping("updatePlay")
	public String updatePlay(Play play){
		playService.updatePlay(play);
		return "forward:/back/playlist?filmId="+play.getFilm().getFilmId();
	}
}
