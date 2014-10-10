package com.walemao.megastore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walemao.megastore.domain.User;
import com.walemao.megastore.service.UserService;

@Controller
public class UserController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService UserService;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value = "/admin/users", method = { RequestMethod.GET })
	public String getUsers(HttpServletRequest request) {

		List<User> users = this.UserService.getUsers();
		request.setAttribute("users", users);
		return "admin/user/users";
	}

}
