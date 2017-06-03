package cn.tarena.film.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.PlayMapper;
import cn.tarena.film.mapper.SeatMapper;
import cn.tarena.film.pojo.Play;
import cn.tarena.film.service.PlayService;
@Service
public class PlayServiceImpl implements PlayService{
	@Resource
	private PlayMapper playMapper;
	@Resource
	private SeatMapper seatMapper;
	@Override
	public List<Play> findAll(Integer filmId) {
		return playMapper.findAllByFid(filmId);
	}
	@Override
	public void savePlay(Play play) {
		playMapper.savePlay(play);
		
	}
	@Override
	public void deletePlay(Play play) {
			if(seatMapper.findFilmByPid(play.getPlayId())!=null){
				seatMapper.deleteSeatByPid(play.getPlayId());
			}
			playMapper.deletePlay(play.getPlayId());
		
	}
	@Override
	public Play findOne(Integer playId) {
		return playMapper.findOne(playId);
	}
	@Override
	public void updatePlay(Play play) {
		playMapper.updatePlay(play);
	}
	@Override
	public Play findByFilmIdAndHallId(Integer filmId, String hallId) {
		
		return playMapper.findByFilmIdAndHallId(filmId,hallId);
	}

}
