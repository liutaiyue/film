package cn.tarena.film.pojo;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private String userId;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private Integer isAdmin;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin
				+ "]";
	}
	   
}
