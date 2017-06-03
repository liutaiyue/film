package cn.tarena.film.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Hall;
import cn.tarena.film.pojo.User;
import cn.tarena.film.service.UserService;

@Controller
@RequestMapping("/back/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("userList")
	public String findAll(Model model){
		List<User> userList=userService.findAll();
		model.addAttribute("userList", userList);
		return "/back/user_list";
	}
	
	@RequestMapping("toCreatUser")
	public String toCreate(){
		return "/back/addUser";
	}
	
	@RequestMapping("saveUser")
	public String save(User user){
		userService.save(user);
		return "redirect:/back/userList";
	}
	
	@RequestMapping("toUpdateUser")
	public String toUpdate(String userId,Model model){
		User user=userService.findOne(userId);
		model.addAttribute("user", user);
		return "/back/userUpdate";
	}
	@RequestMapping("updateUser")
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/back/userList";
	}
	@RequestMapping("deleteUser")
	public String deleteUser(String[] userId){
		userService.deleteUser(userId);
		return "redirect:/back/userList";
	}
}
