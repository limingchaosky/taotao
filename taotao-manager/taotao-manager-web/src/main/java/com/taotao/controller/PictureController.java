package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.IPictureService;

@Controller
public class PictureController {

	@Autowired
	private IPictureService pictureService;
	
	@ResponseBody
	@RequestMapping(value = "/pic/upload")
	public Map uploadPicture(MultipartFile uploadFile) {
		Map map = pictureService.uploadPicture(uploadFile);
		return map;
	}
	
}
