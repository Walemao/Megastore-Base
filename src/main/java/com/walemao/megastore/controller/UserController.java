package com.walemao.megastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/admin/users", method = { RequestMethod.GET })
	public String getUsers() {

		return "index";
	}

}
