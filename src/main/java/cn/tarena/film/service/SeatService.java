package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Seat;

public interface SeatService {

	void saveSeat(Seat seat);

	List<Seat> findSeatByPId(Integer playId);

}
