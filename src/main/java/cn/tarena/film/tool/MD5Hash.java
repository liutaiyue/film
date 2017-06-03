package cn.tarena.film.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Hash {
	
	public static void main(String[] args){
		String password="admin";
		
		 //source:明文
		 //salt:盐
		 //hashIterations 哈希的次数
	
		Md5Hash md5Hash=new Md5Hash(password, "admin", 3);
		System.out.println(md5Hash);
	}
	
	public static String getMd5Password(String password,String username){
		
		return new Md5Hash(password, username, 3).toString();
		
	}
}
