package cn.tarena.film.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.EvaluateMapper;
import cn.tarena.film.mapper.FilmMapper;
import cn.tarena.film.mapper.PlayMapper;
import cn.tarena.film.mapper.SeatMapper;
import cn.tarena.film.mapper.TypeMapper;
import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.pojo.Type;
import cn.tarena.film.service.TypeService;
/**
 * 类型
 * @author Tarena
 *
 */
@Service
public class TypeServiceImpl implements TypeService {
	@Resource
	private TypeMapper typeMapper;
	@Resource
	private FilmMapper filmMapper;
	@Resource
	private PlayMapper playMapper;
	
	@Resource
	private SeatMapper seatMapper;
	
	@Resource
	private EvaluateMapper evaluateMapper;
	@Override
	public List<Type> findAll() {
		return typeMapper.findAll();
	}
	@Override
	public void saveType(Type type) {
		typeMapper.saveType(type);
		
	}
	@Override
	public void deleteType(Integer[] typeId) {
		for (Integer typeIds : typeId) {
			List<Film> filmList = filmMapper.findFilms(typeIds);
			if(filmList!=null){
				for (Film film : filmList) {
					filmMapper.deleteFilmBeType(film.getFilmId());
					List<Play> playList = playMapper.findFilmByFid(film.getFilmId());
					if(playList!=null){
						playMapper.deleteFilm(film.getFilmId());
					}
					for (Play play : playList) {
						if(seatMapper.findFilmByPid(play.getPlayId())!=null){
							seatMapper.deleteSeatByPid(play.getPlayId());	
						}
					}
			       if(evaluateMapper.findFilmByFid(film.getFilmId())!=null){
			    	   evaluateMapper.deleteFilm(film.getFilmId());
			       }
				}
			}
		}
		
		typeMapper.deleteType(typeId);
		
	}



}
