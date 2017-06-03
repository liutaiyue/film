package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.User;

public interface UserService {
	
	public List<User> findAll();

	User findUserByU_P(String username, String password);

	public void save(User user);

	public User findOne(String userId);

	public void updateUser(User user);

	public void deleteUser(String[] userId);

	User findUserByUsername(String username);
	
	void updatePassword(String userId, String password);
}
