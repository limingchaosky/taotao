package com.taotao.service;

import com.taotao.pojo.TbItem;

/**
 * 
 * <p>Title: IItemService</p>
 * <p>Description: </p>
 * @author	limingchaosky
 * @date	2017年11月20日上午1:59:49
 * @version 1.0
 */
public interface IItemService {

	TbItem geTbItemById(long itemId);
	
}