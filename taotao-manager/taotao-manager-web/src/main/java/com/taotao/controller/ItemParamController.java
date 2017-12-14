package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.IItemParamService;

@Controller
public class ItemParamController {

	@Autowired
	private IItemParamService itemParamService;
	
	@ResponseBody
	@RequestMapping(value = "/item/param/query/itemcatid/{cid}")
	public TaotaoResult getItemParamByCid(@PathVariable long cid) {
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/item/param/save/{cid}")
	public TaotaoResult saveItemParam(@PathVariable(value = "cid") long cid,@RequestParam(value = "paramData") String paramData) {
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult result = itemParamService.saveItemParam(itemParam);
		return result;
	}
	
}
