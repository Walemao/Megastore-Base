package com.walemao.megastore.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.ProductBase;
import com.walemao.megastore.domain.ProductClassify;
import com.walemao.megastore.domain.ProductImage;
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
	 * 获取商品列表
	 * 
	 * */
	@RequestMapping(value = "/admin/products", method = RequestMethod.GET)
	public String getProductPage(
			CurrentPage<ProductBase> currentPage,
			@RequestParam(required = false) String productName,
			@RequestParam(defaultValue = "0") int productType,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy/MM/dd") Date startDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy/MM/dd") Date endDate,
			@RequestParam(defaultValue = "0") int mark,
			HttpServletRequest request) {

		if (startDate == null || endDate == null) {
			endDate = new Date(currentDate.getTime() + INTERVAL_TIME);
			startDate = new Date(currentDate.getTime() - 7 * INTERVAL_TIME);
		}

		CurrentPage<ProductBase> pb = this.productService.getProducts(
				productName, productType, startDate, new Date(endDate.getTime()
						+ INTERVAL_TIME), mark);
		List<ProductClassify> productClassifies = this.productService
				.getProductClassifies();	
		
		request.setAttribute("types", productClassifies);
		request.setAttribute("productType", productType);
		request.setAttribute("productName", productName);
		request.setAttribute("curretPage", pb);
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
			@ModelAttribute("productInfo") ProductInfo productInfo,
			HttpServletRequest request) {

		List<ProductClassify> productClassifies = this.productService
				.getProductClassifies();
		request.setAttribute("types", productClassifies);
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
			Model model, HttpServletRequest request) {

		productBase = this.productService.getProduct(id);
		List<ProductClassify> productClassifies = this.productService
				.getProductClassifies();

		model.addAttribute(productBase);
		request.setAttribute("productBase", productBase);
		request.setAttribute("types", productClassifies);

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
			@RequestParam(value = "imageId", required = false) int[] imageIds,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		productBase.setClassify(productType);
		productBase.setThumbnail(mainImg);

		try {
			int id = this.productService.insertProduct(productBase, colorIds,
					imageIds);
			redirectAttributes.addFlashAttribute("status", "success");
			redirectAttributes.addFlashAttribute("messageStatus", "Success！");
			redirectAttributes.addFlashAttribute("message", "添加商品成功！");

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
	 * 修改商品
	 * 
	 * */
	@RequestMapping(value = "/admin/product", method = RequestMethod.PUT)
	public String updateProduct(
			@ModelAttribute("productBase") ProductBase productBase,
			@RequestParam(defaultValue = "0") int productType,
			@RequestParam(defaultValue = "") String mainImg,
			@RequestParam(value = "colorId", required = false) int[] colorIds,
			@RequestParam(value = "imageId", required = false) int[] imageIds,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {

		productBase.setClassify(productType);
		productBase.setThumbnail(mainImg);

		try {
			this.productService.updateProduct(productBase, colorIds, imageIds);
			redirectAttributes.addFlashAttribute("status", "success");
			redirectAttributes.addFlashAttribute("messageStatus", "Success！");
			redirectAttributes.addFlashAttribute("message", "修改商品成功！");

			return "redirect:/admin/product/" + productBase.getId();

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/admin/product/" + productBase.getId();
	}

	/**
	 * 删除商品
	 * 
	 * */
	@RequestMapping(value = "/admin/product", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteProduct(int productId,
			HttpServletRequest request) {
		Map<String, Object> requestMap = new HashMap<String, Object>();

		try {
			this.productService.deleteProduct(productId);
			requestMap.put("status", "success");
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "danger");
		return requestMap;
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
			Map<String, Object> fileMap = FileUploadUtil.uploadSingleFile(file,
					request);
			if ((fileMap.get("status")).equals("error")) {
				requestMap.put("status", "danger");
				requestMap.put("message", (String) fileMap.get("message"));
				return requestMap;
			}
			String thumbnailUrl = (String) fileMap.get("thumbnailUrl");
			String thumbnailMD5 = StringMD5.encode(thumbnailUrl);

			productInfo.setProductid(productId);
			productInfo.setThumbnail(thumbnailUrl);
			productInfo.setThummd5(thumbnailMD5);
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

	/**
	 * 添加展示图片
	 * 
	 * */
	@RequestMapping(value = "/admin/product/img", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addProductImg(
			@RequestParam(defaultValue = "0") int productId,
			@RequestParam(defaultValue = "0") int sort,
			@RequestParam(value = "productImg") MultipartFile file,
			HttpServletRequest request) {
		Map<String, Object> requestMap = new HashMap<String, Object>();

		try {
			Map<String, Object> fileMap = FileUploadUtil.uploadSingleFile(file,
					request);
			String imgUrl = (String) fileMap.get("thumbnailUrl");
			String imgMD5 = StringMD5.encode(imgUrl);

			ProductImage productImage = new ProductImage();
			productImage.setPicSrc(imgUrl);
			productImage.setPicMd5(imgMD5);
			productImage.setProductid(productId);
			productImage.setSort(sort);
			int id = this.productService.insertProductImage(productImage);

			requestMap.put("status", "success");
			requestMap.put("imgId", id);
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "fail");
		requestMap.put("message", "上传失败！");
		return requestMap;
	}

	/**
	 * 删除展示图片
	 * 
	 * 
	 * */
	@RequestMapping(value = "/admin/product/img", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteProductImg(int imageId,
			HttpServletRequest request) {

		Map<String, Object> requestMap = new HashMap<String, Object>();

		try {
			this.productService.deleteProductImage(imageId);
			logger.debug("删除成功");
			requestMap.put("status", "success");
			return requestMap;

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		requestMap.put("status", "fail");
		requestMap.put("message", "删除失败！");
		return requestMap;
	}
}
