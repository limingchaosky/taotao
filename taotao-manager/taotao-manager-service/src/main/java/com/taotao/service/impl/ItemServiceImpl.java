package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
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
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
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

	@Override
	public EasyUIDataGridResult getItemList(int pageNum, int pageSize) {
		
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(pageNum, pageSize);
		
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		
		EasyUIDataGridResult easyUIResult = new EasyUIDataGridResult();
		easyUIResult.setRows(list);
		easyUIResult.setTotal(total);
		
		return easyUIResult;
	}

	@Override
	public TaotaoResult createTbitem(TbItem item, String desc) {
		
		item.setId(IDUtils.genItemId());
		
		//'商品状态，1-正常，2-下架，3-删除',
		item.setStatus((byte) 1);
		
		item.setCreated(new Date());
		item.setUpdated(new Date());
		
		int res = tbItemMapper.insert(item);
		
		if (res == 0) {
			return new TaotaoResult(500,"insert eroor",null);
		}
		
		insertItemDesc(item.getId(), desc);
		
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemDesc(long itemId, String desc) {
		
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		
		int res = tbItemDescMapper.insert(itemDesc);
		
		if (res == 1) {
			return TaotaoResult.ok();
		}
		
		return new TaotaoResult(500,"insert eroor",null);
	}

}
