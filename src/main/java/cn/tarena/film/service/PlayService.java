package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Play;

public interface PlayService {

	List<Play> findAll(Integer filmId);

	void savePlay(Play play);

	void deletePlay(Play play);

	Play findOne(Integer playId);

	void updatePlay(Play play);

	Play findByFilmIdAndHallId(Integer filmId, String hallId);

}
