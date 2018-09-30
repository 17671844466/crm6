package com.zhidisoft.system.service;



import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Business;

public interface IBusinessService extends BaseService<Business>{
     
	List<Map<String, Object>> findMapByPage(int pageNumber,Integer pageSize, Map<String, Object> condition);
	
	List<Map<String, Object>> findMapByPages(int pageNumber,Integer pageSize, Map<String, Object> condition);

	
}
