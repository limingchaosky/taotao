package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.IItemService;

/**
 * 商品管理Service实现类
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * @author	limingchaosky
 * @date	2017年11月20日上午2:12:41
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem geTbItemById(long itemId) {
		
//		TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		
		return null;
	}

}