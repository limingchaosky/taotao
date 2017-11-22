package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.IItemCatService;

@Service
public class ItemCatServiceImpl implements IItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeResult> getEasyUITreeResultsList(long parentId) {
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EasyUITreeResult> treeResultList = new ArrayList<>(list.size());

		for (TbItemCat tbItemCat : list) {
			EasyUITreeResult treeResult = new EasyUITreeResult();
			treeResult.setId(tbItemCat.getId());
			treeResult.setText(tbItemCat.getName());
			treeResult.setState(tbItemCat.getIsParent() ? "closed" : "open");
			treeResultList.add(treeResult);
		}
		return treeResultList;
	}

}
