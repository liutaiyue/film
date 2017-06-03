package cn.tarena.film.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tarena.film.pojo.User;
import cn.tarena.film.service.UserService;
import cn.tarena.film.tool.VerifyCode;
@Controller
public class BoforeLoginControlller {
	@Autowired
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "before/login";
	}
	
	@RequestMapping("login")
	public String login(String username, String password, Model model, HttpSession session) throws UnsupportedEncodingException{
		
		//1.检查是否为空,如果为空,返回并提示异常
		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
			model.addAttribute("errorInfo","用户名或密码不能为空");
			return "before/login";
		}
				
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		
		//生成subject "用户"
		Subject subject = SecurityUtils.getSubject();
		
		//进行登陆    登陆的结果如果不正确 则会抛出异常.
		try {
			subject.login(token);
			User user = (User) subject.getPrincipal(); //获取真实的用户对象
			subject.getSession().setAttribute("user", user);
			//证明用户名和密码正确
			return "redirect:/toHome.action";
		} catch (AuthenticationException e) {
			model.addAttribute("errorInfo","用户名与密码不匹配");
			return "before/login";
		}
		
		
		////
		
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		//销毁session
		session.removeAttribute("user");
		return "forward:/toHome";
	}
	
	@RequestMapping("toRegister")
	public String toRegister(){
		return "before/register";
	}
	
	@RequestMapping("register")
	public String regist(User user, String code, Model model, HttpSession session) throws UnsupportedEncodingException{
		User oldUser = userService.findUserByUsername(user.getUsername());
		if(oldUser!=null){
			model.addAttribute("message","用户名已存在,注册失败");
			model.addAttribute("user",user);
			return "forward:/toRegister";
		}
		if(!code.toUpperCase().equals(session.getAttribute("verifyCode"))){
			model.addAttribute("message","验证码错误,注册失败");
			model.addAttribute("user",user);
			return "forward:/toRegister";
		}
		userService.save(user);
		session.setAttribute("user", user);
		
		return "forward:/toHome";
	}
	
	@RequestMapping("registerVerfyCode")
	public void registerVerfyCode(HttpServletResponse response,HttpSession session,VerifyCode verifyCode){
		try {
			verifyCode.drawImage(response.getOutputStream());
			session.setAttribute("verifyCode", verifyCode.getCode().toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
















