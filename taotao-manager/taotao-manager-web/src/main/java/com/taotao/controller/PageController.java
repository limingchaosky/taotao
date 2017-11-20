package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 * @author	limingchaosky
 * @date	2017年11月20日下午11:11:46
 * @version 1.0
 */
@Controller
public class PageController {

	@RequestMapping(value = "/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/{pageName}")
	public String showPage(@PathVariable(value = "pageName") String pageName) {
		return pageName;
	}
}
