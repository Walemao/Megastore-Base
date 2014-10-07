package com.walemao.megastore.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author ylemzy
 *	单个或者多个文件上传
 *	文件保存的命名方式: 主机名 + upload + 时间格式 + 文件顺序id + 文件后缀 
 */

@Controller
public class FileUploadController 
{
	private Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	private String m_hostName = "";
	private SimpleDateFormat m_sDateFormat = new SimpleDateFormat("yyyy-MM-dd#hh_mm_ss");
	private String getSaveFilePath()
	{
		//return ${host}/Upload/
		return getHostName() + File.separator + "Upload" + File.separator;
	}
	
	public String getHostName()
	{
		return m_hostName;
	}
	
	public boolean SetHostName(String name)
	{
		m_hostName = name;
		//if the host is valid,return true;
		return true;
	}
	
	//单文件
	private String createFileName(MultipartFile file)
	{
		if (file.isEmpty())
			return "";
		String fileName = file.getOriginalFilename();
		return getDataTimeFormat() + fileName.substring(fileName.lastIndexOf('.'));
	}
	
	//批量上传时，要附加下标，避免瞬间生成的时间一样导致覆盖
	private String createFileName(MultipartFile file, int idx)
	{
		if (file.isEmpty())
			return "";
		String fileName = file.getOriginalFilename();
		return getDataTimeFormat() + idx + fileName.substring(fileName.lastIndexOf('.'));
	}
	
	private String getDataTimeFormat()
	{
		return m_sDateFormat.format(new java.util.Date());
	}
	
	//请求文件上传 页面
	@RequestMapping(value="admin/upload", method=RequestMethod.GET)
	public String uploadInfo()
	{
		return "admin/fileUpload/upload";
	}
	
	//单文件上传页面表单提交
	@RequestMapping(value = "admin/fileUpload/singleUpload", method = RequestMethod.POST)
	public @ResponseBody String handleSingleFileUpload(@RequestParam("file") MultipartFile file) 
	{
		logger.debug(this.toString() + ":handing file upload!");
		if (file.isEmpty())
		{
			return "Can't not upload a empty file.";
		}
		
		try
		{
			byte[] bytes = file.getBytes();
	
			
			//create directory to store file
			File dir = new File(getSaveFilePath());
			if (!dir.exists())
				dir.mkdirs();
			
			//create file on server
			String fileName = dir.getAbsolutePath() + File.separator + createFileName(file);
			File serverFile = new File(fileName);
			
			BufferedOutputStream stream = 
					new BufferedOutputStream(
							new FileOutputStream(
									serverFile));
			
			
			logger.info("Saving file:" + fileName);
			stream.write(bytes);
			stream.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Failed to upload " + file.getOriginalFilename() + "=>" + e.getMessage();
		}
		return "File uploaded successfully";
	}
	
	@RequestMapping(value = "admin/fileUpload/batchUpload", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(HttpServletRequest request)
	{
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        
        File dir = new File(getSaveFilePath());
		if (!dir.exists())
			dir.mkdirs();
		
        for (int i = 0; i < files.size(); ++i) 
        {
            MultipartFile file = files.get(i);
 
            String name = dir.getAbsolutePath() + File.separator + createFileName(file, i + 1);
            if (!file.isEmpty()) 
            {
                try 
                {
                    byte[] bytes = file.getBytes();
               
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File(name)));
                    logger.info("Saving file:" + name);
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) 
                {
                    return "You failed to upload " + name + " => " + e.getMessage();
                }
            } else 
            {
                return "You failed to upload " + name + " because the file was empty.";
            }
        }
        return "upload successful";
    }
}


