package com.walemao.megastore.domain.rel;


import java.io.UnsupportedEncodingException;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class UsernameAuthenticatonProvider extends DaoAuthenticationProvider
{
	
	public UsernameAuthenticatonProvider() 
	{
		super();
	}
	
	//加密注册密码
	public String encodeRegisterPassword(String username, String password)
	{
		String salt = createSaltValue();
		return this.getPasswordEncoder().encodePassword(password, salt);
	}
	
	//加密新的密码，会从db取得已有的salt
	public String encodeUserPasswordWidthSalt(String username, String password)
	{
		return this.getPasswordEncoder().encodePassword(password, getSalt(username));
	}
	
	//检查用户密码是否有效
	public boolean isUserPasswordValid(String username, String rowPassword)
	{
		UserDetails userDetials = this.getUserDetailsService().loadUserByUsername(username);
		Object salt = null;
		if (null != this.getSaltSource())
		{
			salt = this.getSaltSource().getSalt(userDetials);
		}
		
		return getPasswordEncoder().isPasswordValid(userDetials.getPassword(), rowPassword, salt);
	}
	
	private Object getSalt(String username)
	{
		UserDetails userDetials = this.getUserDetailsService().loadUserByUsername(username);
		if (null == userDetials)
			return null;
		
		if (null != this.getSaltSource())
		{
			return this.getSaltSource().getSalt(userDetials);
		}
		return null;
	}
	
	private String createSaltValue()
	{
		BytesKeyGenerator generator = KeyGenerators.secureRandom(16);
		try {
			return new String(generator.generateKey(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
