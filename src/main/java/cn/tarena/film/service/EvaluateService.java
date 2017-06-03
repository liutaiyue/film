package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Evaluate;

public interface EvaluateService {

	void saveEvaluate(Evaluate evaluate);

	List<Evaluate> findByFilmId(Integer filmId);

}
