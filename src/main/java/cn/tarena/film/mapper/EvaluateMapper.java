package cn.tarena.film.mapper;

import java.util.List;


import cn.tarena.film.pojo.Evaluate;

public interface EvaluateMapper {

	void deleteFilm(Integer filmId);

	List<Evaluate> findFilmByFid(Integer filmId);

	List<Evaluate> findEvaByUid(String userId);

	void deleteEva(String userId);
	
	void saveEvaluate(Evaluate evaluate);

}
