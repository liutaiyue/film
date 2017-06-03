package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Type;

public interface TypeService {
	/**
	 * 查找所有的类型
	 */
	List<Type> findAll();

	void saveType(Type type);

	void deleteType(Integer[] typeId);

}
