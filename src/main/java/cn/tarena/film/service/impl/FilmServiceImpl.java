package cn.tarena.film.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.EvaluateMapper;
import cn.tarena.film.mapper.FilmMapper;
import cn.tarena.film.mapper.PlayMapper;
import cn.tarena.film.mapper.SeatMapper;
import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.OnlineFilm;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.service.FilmService;
@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	private FilmMapper filmMapper;
	
	@Resource
	private PlayMapper playMapper;
	
	@Resource
	private SeatMapper seatMapper;
	
	@Resource
	private EvaluateMapper evaluateMapper;
	
	@Override
	public Film findFilmByFilmId(Integer filmId) {
	
		return filmMapper.findFilmByFilmId(filmId);
	}

	@Override
	public List<OnlineFilm> findOnlineFilm(Integer filmId) {
		
		return filmMapper.findOnlineFilm(filmId);
	}

	@Override
	public List<Film> findFilms(Integer typeId) {
		return filmMapper.findFilms(typeId);
	}
	
	public List<Film> findAll() {
		return filmMapper.findAll();
	}
	@Override
	public void saveFilm(Film film) {
		Date date = new Date();
		boolean isState = date.after(film.getReleaseDate());
		if(isState){
			film.setState(0);
		}else{
			film.setState(1);
		}
		filmMapper.saveFilm(film);
	}
	@Override
	public void deleteFilm(Integer[] filmId) {
		for (Integer filmIds : filmId) {
			List<Play> playList = playMapper.findFilmByFid(filmIds);
			if(playList!=null){
				playMapper.deleteFilm(filmIds);
			}
			for (Play play : playList) {
				if(seatMapper.findFilmByPid(play.getPlayId())!=null){
					seatMapper.deleteSeatByPid(play.getPlayId());	
				}
			}
	       if(evaluateMapper.findFilmByFid(filmIds)!=null){
	    	   evaluateMapper.deleteFilm(filmIds);
	       }
		}
		
       filmMapper.deleteFilm(filmId);
	}

	@Override
	public List<Film> findInterested(int start, int end) {
		return filmMapper.findInterested(start,end);
	}

	@Override
	public List<Film> findQueryFilm(Film film) {
		return filmMapper.findQueryFilm(film);
	}
}
