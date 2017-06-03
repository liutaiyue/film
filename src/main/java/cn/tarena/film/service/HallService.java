package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Hall;

public interface HallService {

	public List<Hall> findAll();

	public void saveHall(Hall hall);

	public void deleteHall(Integer[] hallId);

	public Hall findOne(Integer hallId);

	public void updateHall(Hall hall);

}
