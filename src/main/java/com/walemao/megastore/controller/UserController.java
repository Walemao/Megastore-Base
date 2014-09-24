package com.walemao.megastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
public class UserController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value={ "/users" }, method = { RequestMethod.GET })
	public String getUsers(){
		return "index";
	}
	
}
