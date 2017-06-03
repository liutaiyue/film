package cn.tarena.film.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.film.pojo.User;

public interface UserMapper {
	@Select("SELECT * FROM user_list WHERE username=#{username} and password=#{password}")
	User findUserByU_P(@Param("username")String username, @Param("password")String password);

	void save(User user);

	@Select("SELECT * FROM user_list WHERE username=#{username}")
	User findUserByUsername(String username);
	
	public List<User> findAll();

	User findOne(String userId);


	void updateUser(User user);


	void deleteUser(String[] userId);

	@Update("UPDATE user_list SET password=#{password} WHERE user_id=#{userId}")
	void updatePassword(@Param("userId")String userId, @Param("password")String md5Password);

}
