package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IProductCategoryDao;
import com.zhidisoft.system.entity.ProductCategory;
import com.zhidisoft.system.service.IProductCategoryService;

@Service
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory> implements IProductCategoryService{

	@Autowired
	private IProductCategoryDao productCategoryDao;
	
	public List<Map<String, Object>> findMapByPage(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		return productCategoryDao.findMapByPage(offset, pageSize, condition);
	}
	
	
}
