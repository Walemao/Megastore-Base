package com.walemao.megastore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.User;
import com.walemao.megastore.service.UserService;

@Controller
public class UserController {
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
	public String getUsers(CurrentPage<User> currentPage,
			@RequestParam(required = false) String userName,
			HttpServletRequest request) {

		CurrentPage<User> cp = this.UserService.getUsers(userName);
		logger.debug("打印对象：{}", cp.getPageItems());
		request.setAttribute("userName", userName);
		request.setAttribute("curretPage", cp);
		return "admin/user/users";
	}

	@RequestMapping(value = "/admin/user", method = { RequestMethod.DELETE })
	public @ResponseBody Map<String, Object> deleteUser(String username,
			HttpServletRequest request) {
		Map<String, Object> requestMap = new HashMap<String, Object>();

		try {
			this.UserService.delete(username);
			requestMap.put("status", "success");
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "danger");
		return requestMap;
	}

}
