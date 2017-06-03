package cn.tarena.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.FilmTypeMapper;
import cn.tarena.film.pojo.FilmType;
import cn.tarena.film.service.FilmTypeService;

@Service
public class FilmTypeServiceImpl implements FilmTypeService {
	
	@Autowired
	private FilmTypeMapper filmTypeServiceImpl;
	@Override
	public List<FilmType> findAll() {
		
		return filmTypeServiceImpl.findAll();
	}

}
