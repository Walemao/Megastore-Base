package com.walemao.megastore.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component("registrationValidator")
public class RegistrationValidation 
{
	private Logger logger = LoggerFactory.getLogger(RegistrationValidation.class);
	public boolean supports(Class<?> klass) 
	{
		return User.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) 
	{
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.registration.userName",
				"User Name must not be Empty.");
		logger.debug("ffffffffffffffffffff");
		String userName = user.getUsername();
		logger.debug("fff" + userName);
		if ((userName.length()) > 50) 
		{
			errors.rejectValue("userName",
					"lengthOfUser.registration.userName",
					"User Name must not more than 50 characters.");
		}
		
		if (!(user.getPassword()).equals(user.getConfirmPassword())) 
		{
			errors.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}
}
