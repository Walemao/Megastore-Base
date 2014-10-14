package com.walemao.megastore.domain.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.walemao.megastore.domain.User;

@Component
public class RegisterValidator implements Validator
{
	private Logger logger = LoggerFactory.getLogger(RegisterValidator.class);
	
	public boolean supports(Class<?> clazz) 
	{
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) 
	{
		User user = (User) target;

		String userName = user.getUsername();
		
		ValidationUtils.rejectIfEmpty(errors, "username", "user.userName.required", "用户名不能为空");
		
		ValidationUtils.rejectIfEmpty(errors, "password", "user.userName.password", "密码不能为空");
		
		//ValidationUtils.rejectIfEmpty(errors, "email", errorCode);
		
		if (!(user.getPassword()).equals(user.getConfirmPassword())) 
		{
			errors.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Not match.");
		}
	}
}
