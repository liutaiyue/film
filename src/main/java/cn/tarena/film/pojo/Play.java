package cn.tarena.film.pojo;

import java.util.Date;

public class Play {
	private Integer playId;
	private Film film;
	private Hall hall;
	private Date startTime;
	private Date endTime;
	public Integer getPlayId() {
		return playId;
	}
	public void setPlayId(Integer playId) {
		this.playId = playId;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Play [playId=" + playId + ", film=" + film + ", hall=" + hall + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
	
}
