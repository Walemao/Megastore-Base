package com.walemao.megastore.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductInfo;
import com.walemao.megastore.service.ProductService;
import com.walemao.megastore.util.DateUtil;
import com.walemao.megastore.util.FileUploadUtil;
import com.walemao.megastore.util.StringMD5;

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
	@RequestMapping(value = "/admin/product", params = { "add" }, method = RequestMethod.GET)
	public String addProductPage(
			@ModelAttribute("productBase") ProductBase productBase,
			@ModelAttribute("productInfo") ProductInfo productInfo) {

		return "admin/product/product";
	}

	/**
	 * 查看商品信息
	 * 
	 * */
	@RequestMapping(value = "/admin/product/{id}", method = RequestMethod.GET)
	public String getProductInfo(@PathVariable("id") int id,
			@ModelAttribute("productBase") ProductBase productBase,
			@ModelAttribute("productInfo") ProductInfo productInfo,
			HttpServletRequest request) {
          
		productBase = this.productService.getProduct(id);
		request.setAttribute("productBase", productBase);
		
		return "admin/product/product";
	}

	/**
	 * 添加商品
	 * 
	 * */
	@RequestMapping(value = "/admin/product", method = RequestMethod.POST)
	public String addProduct(
			@ModelAttribute("productBase") ProductBase productBase,
			@RequestParam(defaultValue = "0") int productType,
			@RequestParam(defaultValue = "") String mainImg,
			@RequestParam(value = "colorId", required = false) int[] colorIds,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		productBase.setCreattime(new Date());
		productBase.setClassify(productType);
		productBase.setThumbnail(mainImg);

		try {
			int id = this.productService.insertProductBase(productBase, colorIds);
			redirectAttributes.addFlashAttribute("status", "success");
			redirectAttributes.addFlashAttribute("messageStatus", "Success！");
			redirectAttributes.addFlashAttribute("message", "添加商品成功！");
			logger.debug("打印商品ID： {}", id);
			return "redirect:/admin/product/" + id;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		redirectAttributes.addFlashAttribute("status", "danger");
		redirectAttributes.addFlashAttribute("messageStatus", "Fail！");
		redirectAttributes.addFlashAttribute("message", "添加商品失败！");
		return "redirect:/admin/product?add";
	}

	/**
	 * 根据MD5查看商品型号分类信息
	 * 
	 * */
	@RequestMapping(value = "/admin/product/color", method = RequestMethod.GET)
	public @ResponseBody ProductInfo getProductColor(String thumbnailMD5) {

		return this.productService.getProductInfo(thumbnailMD5);
	}

	/**
	 * 添加商品型号分类
	 * 
	 * */
	@RequestMapping(value = "/admin/product/color", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addProductColor(
			@ModelAttribute("productInfo") ProductInfo productInfo,
			@RequestParam(defaultValue = "0") int productId,
			@RequestParam(value = "thumbnailImg", required = false) MultipartFile file,
			HttpServletRequest request) {

		Map<String, Object> requestMap = new HashMap<String, Object>();
		if (file == null) {
			requestMap.put("status", "danger");
			requestMap.put("message", "请选择文件！");
			return requestMap;
		}

		try {
			String thumbnailUrl = FileUploadUtil
					.uploadSingleFile(file, request);
			String thumbnailMD5 = StringMD5.encode(thumbnailUrl);

			productInfo.setProductid(productId);
			productInfo.setThumbnail(thumbnailUrl);
			productInfo.setThummd5(thumbnailMD5);
			productInfo.setCreatetime(new Date());
			int id = this.productService.insertProductInfo(productInfo);
			productInfo.setId(id);

			requestMap.put("status", "success");
			requestMap.put("productInfo", productInfo);
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "danger");
		requestMap.put("message", "添加失败！");
		return requestMap;
	}

	/**
	 * 修改商品型号分类
	 * 
	 * */
	@RequestMapping(value = "/admin/product/color", method = RequestMethod.PUT)
	public @ResponseBody Map<String, Object> updateProductColor(
			@ModelAttribute("productInfo") ProductInfo productInfo,
			HttpServletRequest request) {

		Map<String, Object> requestMap = new HashMap<String, Object>();
		try {
			this.productService.updateProductInfo(productInfo);
			requestMap.put("status", "success");
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "danger");
		requestMap.put("message", "修改失败！");
		return requestMap;
	}

	/**
	 * 删除商品型号分类
	 * 
	 * */
	@RequestMapping(value = "/admin/product/color", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteProductColor(int id,
			HttpServletRequest request) {
		Map<String, Object> requestMap = new HashMap<String, Object>();

		try {
			this.productService.deleteProductInfo(id);
			requestMap.put("status", "success");
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "danger");
		requestMap.put("message", "删除失败！");
		return requestMap;
	}

}
