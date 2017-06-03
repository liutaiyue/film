package cn.tarena.film.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.User;
import cn.tarena.film.service.UserService;
import cn.tarena.film.tool.MD5Hash;

@Controller
public class BeforeUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/checkUsernameAvailable")
	public void checkUsernameAvailable(String username,HttpServletResponse response, Model model) throws IOException{
		
		User user = userService.findUserByUsername(username);
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html; charset=utf-8");  
		
		if(user!=null){
			response.getWriter().write("该用户名已存在");
		} 
		
	}
	
	@RequestMapping("toUpdatePassword")
	public String toUpdatePassword(Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		model.addAttribute("user",user);
		return "before/alterCode";
	}
	
	@RequestMapping("updatePassword")
	public String updatePassword(String oldPassword, String userId, String newPassword, String code, Model model, HttpSession session){
		User user = userService.findOne(userId);
		String md5OldPassword = MD5Hash.getMd5Password(oldPassword, user.getUsername());
		
		if(!user.getPassword().equals(md5OldPassword)){
			model.addAttribute("message","请输入正确的原密码");
			return "forward:/toUpdatePassword";
		}
		
		if(!code.toUpperCase().equals(session.getAttribute("verifyCode"))){
			model.addAttribute("message","验证码错误,密码更新失败");
			return "forward:/toUpdatePassword";
		}
		
		userService.updatePassword(userId, newPassword);
		return "forward:/toHome";
	}
	
	@RequestMapping("/checkOldPassword")
	public void checkOldPassword(String userId, String oldPassword,HttpServletResponse response) {
		User user = userService.findOne(userId);
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html; charset=utf-8");  
		
		String md5OldPassword = MD5Hash.getMd5Password(oldPassword, user.getUsername());
		
		if(!user.getPassword().equals(md5OldPassword)){
			try {
				response.getWriter().write("请输入正确的原密码");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
}
