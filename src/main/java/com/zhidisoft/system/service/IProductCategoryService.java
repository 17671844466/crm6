package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;


import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.ProductCategory;


public interface IProductCategoryService extends BaseService<ProductCategory>{
	
	List<Map<String, Object>> findMapByPage(int pageNumber,Integer pageSize, Map<String, Object> condition);
	
}
