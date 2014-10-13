package com.walemao.megastore.domain.Authentication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class UsernameJdbcDaoImpl extends JdbcDaoImpl
{

	/*public void changePassword(String username, String password) 
	{  
	    getJdbcTemplate().update(  
	      "UPDATE USERS SET PASSWORD = ? WHERE USERNAME = ?",  
	      password, username);  
	} */
	
	@Override  
	protected UserDetails createUserDetails(String username,  
	          UserDetails userFromUserQuery,  
	          List<GrantedAuthority> combinedAuthorities) 
	{  
		String returnUsername = userFromUserQuery.getUsername();  
		if (!isUsernameBasedPrimaryKey()) 
		{  
			returnUsername = username;
		}  
		return new SaltedUser(returnUsername,   
				userFromUserQuery.getPassword(),userFromUserQuery.isEnabled(),  
				true, true, true, combinedAuthorities,   
				((SaltedUser) userFromUserQuery).getSalt());
	}
	
	@Override
	protected List<UserDetails> loadUsersByUsername(String username)
	{
		return getJdbcTemplate().query(
			getUsersByUsernameQuery(),
			new String[] { username }, new RowMapper<UserDetails>()
			{
				public UserDetails mapRow(ResultSet rs, int rowNum)
						throws SQLException 
				{
					String username = rs.getString(1);
					String password = rs.getString(2);
					boolean enabled = rs.getBoolean(3);
					String salt = rs.getString(4);
					return new SaltedUser(username, password, enabled, true,
							true, true, AuthorityUtils.NO_AUTHORITIES, salt);
				}
			});
	}
}
