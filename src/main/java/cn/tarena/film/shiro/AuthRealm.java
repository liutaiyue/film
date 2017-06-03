package cn.tarena.film.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tarena.film.pojo.User;
import cn.tarena.film.service.UserService;


public class AuthRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	//权限控制
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		List<String> privilegeList = new ArrayList<String>();

		if(user.getIsAdmin()==1){
			privilegeList.add("admin");
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(privilegeList);
		return info;
		
	}
	
	
	//登陆认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//为Shiro安全管理器提供真实的用户信息 
		
		//1.根据用户输入的username查询正确的用户信息
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		User user = userService.findUserByUsername(username);
		
		//2将user真实信息返回给Shiro安全管理器
		/**
		 * 参数介绍:
		 * 1.principal 真实的用户对象
		 * 2.credentials  真实的密码
		 * 3.realmName   当前realm的名称
		 */
		AuthenticationInfo info = 
				new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}
	
	
	

}
