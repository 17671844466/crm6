package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IProductDao;
import com.zhidisoft.system.entity.Product;
import com.zhidisoft.system.service.IProductService;
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements IProductService{
	@Autowired
	private IProductDao productDao;
	
	public List<Map<String, Object>> findMapByPage(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		return productDao.findMapByPage(offset, pageSize, condition);
	}
}
