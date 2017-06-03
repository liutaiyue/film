package cn.tarena.film.pojo;

import java.util.Date;

public class OnlineFilm {
	private String playId;
	private Integer filmId;
	private Integer hallId;
	private Date startTime;
	private String hallName;
	public String getPlayId() {
		return playId;
	}
	public void setPlayId(String playId) {
		this.playId = playId;
	}
	public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	public Integer getHallId() {
		return hallId;
	}
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	@Override
	public String toString() {
		return "OnlineFilm [playId=" + playId + ", filmId=" + filmId + ", hallId=" + hallId + ", startTime=" + startTime
				+ ", hallName=" + hallName + "]";
	}
	
	
}
