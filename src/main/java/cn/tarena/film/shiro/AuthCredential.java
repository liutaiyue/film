package cn.tarena.film.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.film.tool.MD5Hash;

//表示密码校验
public class AuthCredential extends  SimpleCredentialsMatcher{
	/**
	 * token  用户传入的令牌
	 * info   自定义的Realm传来的info对象
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//将用户输入的明文 转化为密文
		/**
		 * 1.获取用户名和密码
		 * 2.将明文进行加密操作
		 * 3.将加密后的密码存入token中  交给shiro安全管理器去做校验
		 */
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		
		String username = loginToken.getUsername();
		char[]  password = loginToken.getPassword();
		String md5HashPassword = MD5Hash.getMd5Password(String.valueOf(password),username);
		loginToken.setPassword(md5HashPassword.toCharArray());
		
		//将数据传入安全管理器
		return super.doCredentialsMatch(loginToken, info);
	}
}
