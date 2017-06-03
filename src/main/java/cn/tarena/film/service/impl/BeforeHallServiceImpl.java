package cn.tarena.film.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.BeforeHallMapper;
import cn.tarena.film.pojo.Hall;
import cn.tarena.film.service.BeforeHallService;

@Service
public class BeforeHallServiceImpl implements BeforeHallService {
	
	@Autowired
	private BeforeHallMapper beforeHallMapper;
	
	@Override
	public Hall findHallById(String hallId) {
		
		return beforeHallMapper.findHallById(hallId);
	}

}
