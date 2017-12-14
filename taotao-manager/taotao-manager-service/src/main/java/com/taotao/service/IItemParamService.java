package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * 用于操作ItemParam的Service接口
 * <p>Title: IItemParamService</p>
 * <p>Description: </p>
 * @author	limingchaosky
 * @date	2017年12月14日下午9:56:13
 * @version 1.0
 */
public interface IItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	
	TaotaoResult saveItemParam(TbItemParam itemParam);
	
}
