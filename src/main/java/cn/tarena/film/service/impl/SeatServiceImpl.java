package cn.tarena.film.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.SeatMapper;
import cn.tarena.film.pojo.Seat;
import cn.tarena.film.service.SeatService;
@Service
public class SeatServiceImpl implements SeatService {
	@Resource
	private SeatMapper seatMapper;
	@Override
	public void saveSeat(Seat seat) {
		seat.setSeatId(UUID.randomUUID().toString());
		seatMapper.saveSeat(seat);

	}
	@Override
	public List<Seat> findSeatByPId(Integer playId) {
		return seatMapper.findSeatByPid(playId);
	}

}
