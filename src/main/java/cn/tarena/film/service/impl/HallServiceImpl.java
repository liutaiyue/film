package cn.tarena.film.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.HallMapper;
import cn.tarena.film.mapper.PlayMapper;
import cn.tarena.film.mapper.SeatMapper;
import cn.tarena.film.pojo.Hall;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.service.HallService;
@Service
public class HallServiceImpl implements HallService {
	@Autowired
	private HallMapper hallMapper;
	@Autowired
	private PlayMapper playMapper;
	@Autowired 
	private SeatMapper seatMapper;
	@Override
	public List<Hall> findAll() {
		return hallMapper.findAll();
	}
	@Override
	public void saveHall(Hall hall) {
		hallMapper.saveHall(hall);
	}
	@Override
	public void deleteHall(Integer[] hallId) {
		for (Integer hallIds : hallId) {
			List<Play> playList=playMapper.findPlayByHid(hallIds);
			if(playList!=null){
				playMapper.deletePlayByHid(hallIds);
			}
			for (Play play : playList) {
				if(seatMapper.findFilmByPid(play.getPlayId())!=null){
					seatMapper.deleteSeatByPid(play.getPlayId());
				}
			}
		}
		hallMapper.deleteHall(hallId);
	}
	@Override
	public Hall findOne(Integer hallId) {
		return hallMapper.findOne(hallId);
	}
	@Override
	public void updateHall(Hall hall) {
		hallMapper.updateHall(hall);
	}

}
