package cn.tarena.film.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.mapper.FilmTypeMapper;
import cn.tarena.film.pojo.Evaluate;
import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.FilmType;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.service.EvaluateService;
import cn.tarena.film.service.FilmService;
import cn.tarena.film.service.PlayService;

@Controller
public class FilmController {

	@Autowired
	private FilmTypeMapper filmTypeMapper;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private PlayService playService;
	
	@Autowired
	private EvaluateService evaluateService;
	
	@RequestMapping("toHome")
	public String toHome(Model model){
		List<FilmType> filmTypes = filmTypeMapper.findAll();
		model.addAttribute("filmTypes", filmTypes);
		return "/before/index";
	}
	
	@RequestMapping("moreFiles")
	public String moreFiles(Integer typeId,Model model){
		List<Film> films=filmService.findFilms(typeId);
		model.addAttribute("films", films);
		return "/before/more";
		
	}
	
	@RequestMapping("toDetail")
	public String toDetail(Integer filmId,Model model){
		Film film=filmService.findFilmByFilmId(filmId);
		List<Play> playList = playService.findAll(filmId);
		
		List<Evaluate> evaluates= evaluateService.findByFilmId(filmId);
		if(evaluates.size()>1){
			Double count=0.0;
			for(Evaluate e:evaluates){
				count+=e.getScore();
			}
			Double avgScore=count/evaluates.size();
			avgScore =(double)Math.round(avgScore);
			model.addAttribute("avgScore", avgScore);
			model.addAttribute("evaluates", evaluates);
		}
		model.addAttribute("film", film);
		model.addAttribute("playList", playList);
		
		return "/before/detail";
	}
	
	@RequestMapping("toSearch")
	public String toSearch(Model model){
		interested(model);
		return "/before/query";
	}
	
	@RequestMapping("queryFilm")
	public String queryFilm(Film film,Model model){
		interested(model);
		List<Film> filmList = filmService.findQueryFilm(film);
		if(filmList.size()==0){
			model.addAttribute("message", "抱歉，没有找到与"+"\""+film.getFilmName()+"\""+"的相关结果请您检查输入或者尝试其他关键字");
		}
		model.addAttribute("filmList", filmList);
		model.addAttribute("type", film.getType().getTypeId());
		model.addAttribute("filmname", film.getFilmName());
		return "/before/query";
	}
	private void  interested(Model model){
		List<FilmType> filmTypeList = filmTypeMapper.findAll();
		List<Film> list = filmService.findAll();
		int start;
		int end = 5;
		List<Film> interestFilm = null;
		if(list.size()>=5){
			start = (int)(Math.random()*(list.size()-5));
		}else{
			start = 0;
		}
		interestFilm = filmService.findInterested(start,end);
		model.addAttribute("filmTypeList", filmTypeList);
		model.addAttribute("interestFilm", interestFilm);
	}
	
}
















