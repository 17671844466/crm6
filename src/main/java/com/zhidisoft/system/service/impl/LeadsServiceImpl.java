package com.zhidisoft.system.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.ILeadsDao;
import com.zhidisoft.system.entity.Leads;
import com.zhidisoft.system.service.ILeadsService;

@Service
public class LeadsServiceImpl extends BaseServiceImpl<Leads> implements ILeadsService{

	@Autowired
	private ILeadsDao leadsDao;
	
	public List<Map<String, Object>> findMapByPage(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		return leadsDao.findMapByPage(offset, pageSize, condition);
	}

	public List<Map<String, Object>> findMapByPageInPool(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		return leadsDao.findMapByPageInPool(offset, pageSize, condition);
	}

	


	
	
}
