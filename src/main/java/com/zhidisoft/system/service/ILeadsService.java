package com.zhidisoft.system.service;


import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Leads;

public interface ILeadsService extends BaseService<Leads>
{
	
	List<Map<String, Object>> findMapByPage(int pageNumber,Integer pageSize, Map<String, Object> condition);
	
	List<Map<String, Object>> findMapByPageInPool(int pageNumber,Integer pageSize, Map<String, Object> condition);
}
