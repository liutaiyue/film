package cn.tarena.film.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.film.pojo.Play;

public interface PlayMapper {

	List<Play> findAllByFid(Integer filmId);

	void deleteFilm(Integer filmId);

	List<Play> findFilmByFid(Integer filmId);

	void savePlay(Play play);


	void deletePlay(Integer play);

	Play findOne(Integer playId);

	void updatePlay(Play play);

	List<Play> findPlayByHid(Integer hallId);

	void deletePlayByHid(Integer hallId);

	Play findByFilmIdAndHallId(@Param("filmId") Integer filmId,@Param("hallId") String hallId);

}
