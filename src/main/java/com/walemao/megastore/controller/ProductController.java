package com.walemao.megastore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walemao.megastore.util.DateUtil;

@Controller
public class ProductController extends BaseController {
	
	/**
	 * 进入商品管理页面
	 * 
	 * */
	@RequestMapping(value="/admin/products", method = RequestMethod.GET)
	public String getProductPage(HttpServletRequest request){

		request.setAttribute("startDate", DateUtil.getDefaultDates().get(0));
		request.setAttribute("endDate", DateUtil.getDefaultDates().get(1));
		return "admin/product/products";
	}
}
