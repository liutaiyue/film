package cn.tarena.film.pojo;

import java.util.List;

public class FilmType {
	private Integer typeId;
	private String typeName;
	
	private List<Film> films;
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	@Override
	public String toString() {
		return "FilmType [typeId=" + typeId + ", typeName=" + typeName + ", films=" + films+ "]";
	}
	
}
