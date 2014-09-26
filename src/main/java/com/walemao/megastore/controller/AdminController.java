package com.walemao.megastore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController extends BaseController {

	@RequestMapping(value = "/admin/login.html", method = RequestMethod.GET)
	public String loginPage() {
		return "admin/adminLogin";
	}

	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String indexPage() {
		return "admin/adminIndex";
	}
}
