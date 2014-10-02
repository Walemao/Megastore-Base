package com.walemao.megastore.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * @author ylemzy
 * 批量上传文件
 */
@Controller
public class BatchFileUploadController
{
	@RequestMapping(value = "/batch/upload", method = RequestMethod.GET)
	public @ResponseBody String handleFileUpload(HttpServletRequest request)
	{
		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		for (int i = 0; i < files.size(); ++i)
		{
			MultipartFile file = files.get(i);
			String name = file.getName();
			
			if (file.isEmpty())
			{
				return "Can't n upload empty file" + name;
			}
			
			try
			{
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = 
						new BufferedOutputStream(
						new FileOutputStream(
						new File(name)));
				stream.write(bytes);
				stream.close();
			}
			catch (Exception e)
			{
				return "Failed to upload" + name + "=>" + e.getMessage();
			}

		}
		return "Upload successful";
	}
}

