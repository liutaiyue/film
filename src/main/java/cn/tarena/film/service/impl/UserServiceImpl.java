package cn.tarena.film.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.EvaluateMapper;
import cn.tarena.film.mapper.UserMapper;
import cn.tarena.film.pojo.Evaluate;
import cn.tarena.film.pojo.User;
import cn.tarena.film.service.UserService;
import cn.tarena.film.tool.MD5Hash;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EvaluateMapper evaluateMapper;
	
	@Override
	public User findUserByU_P(String username, String password) {
		//1.先转为密文
		String md5Password = MD5Hash.getMd5Password(password, username);
		//2.验证是否存在对应user
		User user = userMapper.findUserByU_P(username, md5Password);
		return user;
	}

	@Override

	public List<User> findAll() {
		return userMapper.findAll();
	}

	public void save(User user) {
		//1.设置一个随机的UserID
		user.setUserId(UUID.randomUUID().toString());
		//2.明文转密文
		user.setPassword(MD5Hash.getMd5Password(user.getPassword(), user.getUsername()));
		//3.user_isAdmin设置为0
		user.setIsAdmin(0);
		//4.插入语句
		userMapper.save(user);

	}

	@Override
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	
	@Override
	public User findOne(String userId) {
		return userMapper.findOne(userId);
	}


	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}


	@Override
	public void deleteUser(String[] userId) {
		userMapper.deleteUser(userId);	
		for (String userIds : userId) {
			List<Evaluate> evaList=evaluateMapper.findEvaByUid(userIds);
			if(evaList!=null){
				evaluateMapper.deleteEva(userIds);
			}
		}
		
	}
	@Override
	public void updatePassword(String userId, String password) {
		User user = userMapper.findOne(userId);
		String md5Password = MD5Hash.getMd5Password(password, user.getUsername());
		userMapper.updatePassword(userId, md5Password);
	}


}
