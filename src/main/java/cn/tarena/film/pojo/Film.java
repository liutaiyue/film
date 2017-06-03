package cn.tarena.film.pojo;

import java.util.Date;

public class Film {
	
	private Integer filmId;
	private String filmName;
	private Type type;
	private String describes;
	private Date releaseDate; //上映时间
	private Integer state;//上映状态  0未上映  1正在上映  2已下架
	private String filmImage;
	private int duration; //电影时长
	private String movieUrl;
	
	public String getMovieUrl() {
		return movieUrl;
	}
	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}
	private double price;
	
	private FilmType filmType; 
	
	public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getFilmImage() {
		return filmImage;
	}
	public void setFilmImage(String filmImage) {
		this.filmImage = filmImage;
	}
	public int getDuration() {
		return duration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public FilmType getFilmType() {
		return filmType;
	}
	public void setFilmType(FilmType filmType) {
		this.filmType = filmType;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", filmName=" + filmName + ", type=" + type + ", describes=" + describes
				+ ", releaseDate=" + releaseDate + ", state=" + state + ", filmImage=" + filmImage + ", duration="
				+ duration + ", movieUrl=" + movieUrl + ", price=" + price + ", filmType=" + filmType + "]";
	}
	
}
