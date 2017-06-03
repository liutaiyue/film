package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.OnlineFilm;

public interface FilmService {

	public Film findFilmByFilmId(Integer filmId);

	public List<OnlineFilm> findOnlineFilm(Integer filmId);

	public List<Film> findFilms(Integer typeID);

	List<Film> findAll();

	void saveFilm(Film film);

	void deleteFilm(Integer[] filmId);

	public List<Film> findInterested(int start, int end);

	public List<Film> findQueryFilm(Film film);

}
