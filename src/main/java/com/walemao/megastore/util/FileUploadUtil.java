package com.walemao.megastore.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	private static String m_hostName = "";
	private static SimpleDateFormat m_sDateFormat = new SimpleDateFormat(
			"yyyy_MM_dd_hh_mm_ss");

	private static String getHostName() {
		return m_hostName;
	}

	private static boolean setHostName(String name) {
		m_hostName = name;
		// if the host is valid,return true;
		return true;
	}

	private static String getDataTimeFormat() {
		return m_sDateFormat.format(new java.util.Date());
	}

	/**
	 * 单个文件创建文件名
	 * 
	 * */
	private static String createFileName(MultipartFile file) {
		if (file.isEmpty())
			return "";
		String fileName = file.getOriginalFilename();
		return getDataTimeFormat()
				+ fileName.substring(fileName.lastIndexOf('.'));
	}

	/**
	 * 单个文件上传方法
	 * 
	 * */
	public static Map<String, Object> uploadSingleFile(MultipartFile file,
			HttpServletRequest request) throws Exception {
		Map<String, Object> requestMap = new HashMap<String, Object>();
		if (file.isEmpty()) {
			requestMap.put("status", "error");
			requestMap.put("message", "空文件");
			return requestMap;
		}
		byte[] bytes = file.getBytes();
		if (FileTypeUtil.getFileTypeByStream(bytes) == null) {
			requestMap.put("status", "error");
			requestMap.put("message", "文件可能不是jpg,png,gif。");
			return requestMap;
		}
		// create directory to store file
		setHostName(request.getSession().getServletContext()
				.getRealPath("/resources-admin/Upload/"));
		File dir = new File(getHostName());
		if (!dir.exists())
			dir.mkdirs();

		// create file on server
		String fileName = createFileName(file);
		File serverFile = new File(getHostName(), fileName);

		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));

		stream.write(bytes);
		stream.close();

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path;
		requestMap.put("status", "success");
		requestMap.put("thumbnailUrl", basePath + "/resources-admin/Upload/"
				+ fileName);
		return requestMap;

	}

}
