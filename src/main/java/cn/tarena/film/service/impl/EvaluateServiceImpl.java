package cn.tarena.film.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.EvaluateMapper;
import cn.tarena.film.pojo.Evaluate;
import cn.tarena.film.service.EvaluateService;
@Service
public class EvaluateServiceImpl implements EvaluateService {
	
	@Autowired
	private EvaluateMapper evaluateMapper;
	@Override
	public void saveEvaluate(Evaluate evaluate) {
		evaluate.setEvaluteId(UUID.randomUUID().toString());
		evaluateMapper.saveEvaluate(evaluate);
	}
	@Override
	public List<Evaluate> findByFilmId(Integer filmId) {
		return evaluateMapper.findFilmByFid(filmId);
	}

}
