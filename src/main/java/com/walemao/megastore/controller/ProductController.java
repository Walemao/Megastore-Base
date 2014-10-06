package com.walemao.megastore.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.walemao.megastore.domain.ProductColor;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.service.ProductService;
import com.walemao.megastore.util.DateUtil;

@Controller
public class ProductController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * 进入商品管理页面
	 * 
	 * */
	@RequestMapping(value = "/admin/products", method = RequestMethod.GET)
	public String getProductPage(HttpServletRequest request) {

		request.setAttribute("startDate", DateUtil.getDefaultDates().get(0));
		request.setAttribute("endDate", DateUtil.getDefaultDates().get(1));
		return "admin/product/products";
	}

	/**
	 * 进入商品添加页面
	 * 
	 * */
	@RequestMapping(value = "/admin/product", params={ "add" }, method = RequestMethod.GET)
	public String addProductPage(
			@ModelAttribute("productInfo") ProductInfo productInfo) {

		return "admin/product/product";
	}

	/**
	 * 查看商品信息
	 * 
	 * */
	@RequestMapping(value = "/admin/product/{id}", method = RequestMethod.GET)
	public String getProductInfo(@PathVariable("id") int id,
			@ModelAttribute("productInfo") ProductInfo productInfo,
			HttpServletRequest request) {
        
		return "admin/product/product";
	}

	/**
	 * 添加商品
	 * 
	 * */
	@RequestMapping(value = "/admin/product", method = RequestMethod.POST)
	public String addProduct(
			@ModelAttribute("productInfo") ProductInfo productInfo,
			String productType, int amount, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		
		productInfo.setCreattime(new Date());
        productInfo.setType(0);
        if(productInfo.getProductColors() == null){
        	productInfo.setProductColors(new ArrayList<ProductColor>());
        }
        
		try {
			int id = this.productService.insert(productInfo);
			redirectAttributes.addFlashAttribute("status", "success");
			redirectAttributes.addFlashAttribute("messageStatus", "Success！");
			redirectAttributes.addFlashAttribute("message", "添加商品成功！");
			logger.debug("打印商品ID： {}", id);
			return "redirect:/admin/product/" + id;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		redirectAttributes.addFlashAttribute("status", "danger");
		redirectAttributes.addFlashAttribute("messageStatus", "Fail！");
		redirectAttributes.addFlashAttribute("message", "添加商品失败！");
		return "redirect:/admin/product?add";
	}
	
	/**
	 * 修改商品
	 * 
	 * */

}
