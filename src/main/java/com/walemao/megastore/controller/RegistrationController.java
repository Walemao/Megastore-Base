package com.walemao.megastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walemao.megastore.domain.User;
import com.walemao.megastore.domain.UserAuthority;
import com.walemao.megastore.domain.Authentication.RegistrationUsernameProvider;
import com.walemao.megastore.domain.Authentication.RegistrationValidation;
import com.walemao.megastore.domain.Authentication.RegistrationValidationImpl;
import com.walemao.megastore.repository.UserAuthorityDao;
import com.walemao.megastore.service.UserService;

@Controller
@RequestMapping("registrationform")
public class RegistrationController {
	
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAuthorityDao userAuthorityDao;
	

    private RegistrationValidation registrationValidation = new RegistrationValidationImpl();
	
	@Autowired
	private RegistrationUsernameProvider provider;
	
	public void setRegistrationValidation(
            @ModelAttribute RegistrationValidationImpl registrationValidation) 
	{
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistration(@ModelAttribute("user") User user) 
    {
		return "registration";
    }
	
    // Process the form.
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String processRegistration(@ModelAttribute("user") User user,
                    BindingResult result) 
    {
    	logger.debug("bbababbababab");
		// set custom Validation by user
		registrationValidation.validate(user, result);
		if (result.hasErrors()) 
		{
			return "registrationform";
		}
		user.setPassword(provider.encodePassword(user));
		user.setSalt(user.getUsername());
		
		UserAuthority author = new UserAuthority();
		author.setUsername(user.getUsername());
		author.setAuthority("ROLE_USER");
		int id = userService.insert(user);
		userAuthorityDao.insert(author);
		return "registrationsuccess" + id;
    }
}