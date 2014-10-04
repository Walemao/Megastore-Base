package com.walemao.megastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(PageController.class);
	
	/**
	 * 进入商品管理页面
	 * 
	 * */
	@RequestMapping(value="/admin/products", method = RequestMethod.GET)
	public String getProductPage(){
		return "admin/product/products";
	}
}
