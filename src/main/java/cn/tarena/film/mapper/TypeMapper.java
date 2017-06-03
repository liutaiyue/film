package cn.tarena.film.mapper;

import java.util.List;

import cn.tarena.film.pojo.Type;

public interface TypeMapper {
	/**
	 * 查找所以的类型
	 * @return
	 */
	List<Type> findAll();
	/**
	 * 保存电影类型
	 * @param type
	 */
	void saveType(Type type);
	/**
	 * 删除电影类型
	 * @param typeId
	 */
	void deleteType(Integer[] typeId);

}
