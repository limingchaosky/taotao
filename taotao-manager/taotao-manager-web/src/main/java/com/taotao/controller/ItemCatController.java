package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeResult;
import com.taotao.service.IItemCatService;

@Controller
public class ItemCatController {

	@Autowired
	private IItemCatService itemCatService;
	
	@ResponseBody
	@RequestMapping(value = "/item/cat/list")
	public List<EasyUITreeResult> getCategoryList(@RequestParam(value = "id", defaultValue = "0") long parentId) {
		List<EasyUITreeResult> list = itemCatService.getEasyUITreeResultsList(parentId);
		return list;
	}
	
}
