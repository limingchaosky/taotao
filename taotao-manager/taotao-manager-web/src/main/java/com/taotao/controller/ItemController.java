package com.taotao.controller;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.IItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * @author	limingchaosky
 * @date	2017年11月20日上午2:12:05
 * @version 1.0
 */
//@RequestMapping(value = "/item")
@Controller
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@ResponseBody
	@RequestMapping(value = "/item/{itemId}")
	public TbItem geTbItemByItemId(@PathVariable(value = "itemId") long itemId) {
		
		TbItem item = itemService.geTbItemById(itemId);
		
		return item;
	}
	
	@ResponseBody
	@RequestMapping(value = "/item/list")
	public EasyUIDataGridResult getItemList(int page , int rows) {
		EasyUIDataGridResult easyUIResult = itemService.getItemList(page, rows);
		return easyUIResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/item/save")
	public TaotaoResult createTbitem(TbItem item) {
		
		TaotaoResult taotaoResult = itemService.createTbitem(item);
		
		return taotaoResult;
	}
	
}
