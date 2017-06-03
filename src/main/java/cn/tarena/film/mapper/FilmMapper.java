package cn.tarena.film.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.OnlineFilm;

public interface FilmMapper {

	public Film findFilmByFilmId(Integer filmId);

	public List<OnlineFilm> findOnlineFilm(Integer filmId);

	public List<Film> findFilms(Integer typeId);
	
	List<Film> findAll();

	void saveFilm(Film film);

	void deleteFilm(Integer[] filmId);

	void deleteFilmBeType(Integer filmId);

	public List<Film> findInterested(@Param("start")Integer start, @Param("end")Integer end);

	public List<Film> findQueryFilm(Film film);

}
