package cn.tarena.film.mapper;

import java.util.List;

import cn.tarena.film.pojo.Hall;

public interface HallMapper {

	public List<Hall> findAll();

	public void saveHall(Hall hall);

	public void deleteHall(Integer[] hallId);

	public Hall findOne(Integer hallId);

	public void updateHall(Hall hall);

	public void deleteH_S(int[] hallId);

	public void deleteH_P(int[] hallId);

}
