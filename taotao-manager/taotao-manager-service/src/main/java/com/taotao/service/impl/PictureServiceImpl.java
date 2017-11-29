package com.taotao.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.IPictureService;

@Service
public class PictureServiceImpl implements IPictureService {

	@Value("${FTP.Address}")
	private String host;
	
	@Value("${FTP.Port}")
	private int port;
	
	@Value("${FTP.Username}")
	private String username;
	
	@Value("${FTP.Password}")
	private String password;
	
	@Value("${FTP.Bathpath}")
	private String basePath;
	
	@Value("${Image.BaseUrl}")
	private String imageServerUrl;
	
	@Override
	public Map uploadPicture(MultipartFile uploadFile) {
		
		Map map = new HashMap();
		
		try {
		//生成一个新的文件名
		//取原文件名
		String originalFilename = uploadFile.getOriginalFilename();
		
		//生成新的文件名
		String imageName = IDUtils.genImageName();
		String newFileName = imageName + originalFilename.substring(originalFilename.lastIndexOf("."));
		
		String filePath = new DateTime().toString("/yyyy/MM/dd");
		
		//上传文件
		boolean res = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, newFileName, uploadFile.getInputStream());
		
		if (!res) {
			map.put("error", 1);
			map.put("message", "上传图片失败");
			return map;
		}
		
		map.put("error", 0);
		map.put("url", imageServerUrl + filePath + "/" + newFileName );
		return map;
			
		} catch (IOException e) {
			map.put("error", 1);
			map.put("message", "上传文件异常");
			return map;
		}
	}

}
