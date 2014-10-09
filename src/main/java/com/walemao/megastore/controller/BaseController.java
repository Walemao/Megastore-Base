package com.walemao.megastore.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

public class BaseController {
	private Logger logger = LoggerFactory.getLogger(BaseController.class);
	public Date currentDate = new Date();
	public long INTERVAL_TIME = 24 * 3600 * 1000;

	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {

		processException(e, request, response);

		if (request.getRequestURI().endsWith(".json")) {
			logger.error("{} AJAX请求发生错误, 错误信息: {}", request.getRequestURI(), e.getMessage());
			try {
				String message = String.format("{status:\"error\", message:\"%s\"}", e.getMessage());
				response.getWriter().println(message);
				response.setContentType("application/json");
			} catch (IOException ex) {
				logger.error("{}", ex.getMessage());
			}
		} else {
			logger.error("{} HTTP请求发生错误, 错误信息: {}", request.getRequestURI(), e.getMessage());
		}
	}

	public void processException(Exception e, HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("rawtypes")
		Class clazz = e.getClass();

		if (clazz.isInstance(ConversionNotSupportedException.class)) {
			response.setStatus(500);
		} else if (clazz.isInstance(HttpMediaTypeNotAcceptableException.class)) {
			response.setStatus(406);
		} else if (clazz.isInstance(HttpMediaTypeNotSupportedException.class)) {
			response.setStatus(415);
		} else if (clazz.isInstance(HttpMessageNotReadableException.class)) {
			response.setStatus(400);
		} else if (clazz.isInstance(HttpMessageNotWritableException.class)) {
			response.setStatus(500);
		} else if (clazz.isInstance(HttpRequestMethodNotSupportedException.class)) {
			response.setStatus(405);
		} else if (clazz.isInstance(MissingServletRequestParameterException.class)) {
			response.setStatus(400);
		} else if (clazz.isInstance(NoSuchRequestHandlingMethodException.class)) {
			response.setStatus(404);
		} else if (clazz.isInstance(TypeMismatchException.class)) {
			response.setStatus(400);
		} else {
			response.setStatus(500);
		}
	}

}
