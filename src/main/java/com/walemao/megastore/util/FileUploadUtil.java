package com.walemao.megastore.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	private static String m_hostName = "/re";
	private static SimpleDateFormat m_sDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd#hh_mm_ss");

	private static String getSaveFilePath() {
		// return ${host}/Upload/
		return getHostName() + File.separator + "Upload" + File.separator;
	}

	private static String getHostName() {
		return m_hostName;
	}

	private static boolean SetHostName(String name) {
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
	 * 批量上传创建文件名
	 * 
	 * */
	private static String createFileName(MultipartFile file, int idx) {
		if (file.isEmpty())
			return "";
		String fileName = file.getOriginalFilename();
		return getDataTimeFormat() + idx
				+ fileName.substring(fileName.lastIndexOf('.'));
	}

	/**
	 * 单个文件上传方法
	 * 
	 * */
	public static String uploadSingleFile(MultipartFile file, HttpServletRequest request) throws Exception {
		if (file.isEmpty()) {
			return "";
		}
		byte[] bytes = file.getBytes();

		// create directory to store file
		SetHostName(request.getSession().getServletContext().getRealPath("/resources-admin/"));
		File dir = new File(getSaveFilePath());
		if (!dir.exists())
			dir.mkdirs();

		// create file on server
		String fileName = createFileName(file);
		File serverFile = new File(getSaveFilePath(), fileName);

		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(serverFile));

		stream.write(bytes);
		stream.close();

		return "/resources-admin/Upload" + fileName;
	}

}
