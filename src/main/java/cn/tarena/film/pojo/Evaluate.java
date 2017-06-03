package cn.tarena.film.pojo;

public class Evaluate {
	/*
	 *  film_id              int not null,
   user_id              varchar(100),
   evaluate_id          varchar(255) not null,
   info                 varchar(255),
	 */
	private String evaluteId;
	private Film film;
	private User user;
	private String info;
	private Double score;
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getEvaluteId() {
		return evaluteId;
	}
	public void setEvaluteId(String evaluteId) {
		this.evaluteId = evaluteId;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Evaluate [evaluteId=" + evaluteId + ", film=" + film + ", user=" + user + ", info=" + info + ", score="
				+ score + "]";
	}
	
}
