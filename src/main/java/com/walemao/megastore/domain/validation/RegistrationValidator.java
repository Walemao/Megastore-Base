package com.walemao.megastore.domain.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.walemao.megastore.domain.User;
import com.walemao.megastore.repository.UserDao;

@Component
public class RegistrationValidator implements Validator
{
	private Logger logger = LoggerFactory.getLogger(RegistrationValidator.class);
	
	@Autowired
	private UserDao userDao;
	
	public boolean supports(Class<?> klass) 
	{
		return User.class.isAssignableFrom(klass);
	}
	
	public void validate(Object target, Errors errors) 
	{
		User user = (User) target;
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registration.userName",
				"User Name must not be Empty.");*/

		String userName = user.getUsername();
		if ((userName.length()) > 50) 
		{
			errors.rejectValue("username",
					"lengthOfUser.registration.userName",
					"User Name must not more than 50 characters.");
		}
		
		if (userDao.CheckUsername(user.getUsername()))
		{
			System.out.println("ffffffasdfasdfasdfsfdadfasdf");
			errors.rejectValue("username",
					"User:userName",
					"User Name exists");
		}
		
		
		if (!(user.getPassword()).equals(user.getConfirmPassword())) 
		{
			errors.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}
}
