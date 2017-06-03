package cn.tarena.film.mapper;

import java.util.List;

import cn.tarena.film.pojo.Seat;

public interface SeatMapper {


	 List<Seat> findFilmByPid(Integer playId);

	void deleteSeatByPid(Integer playId);

	void saveSeat(Seat seat);

	List<Seat> findSeatByPid(Integer playId);

	void deleteSeat(String seatId);

}
