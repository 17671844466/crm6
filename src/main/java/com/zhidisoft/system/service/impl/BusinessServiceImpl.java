package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IBusinessDao;
import com.zhidisoft.system.entity.Business;
import com.zhidisoft.system.service.IBusinessService;

@Service
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements IBusinessService{
      @Autowired
	   private IBusinessDao businessDao;
	
      public List<Map<String, Object>> findMapByPage(int pageNumber, Integer pageSize, Map<String, Object> condition) {
  		int offset = (pageNumber-1)*pageSize;
  		return businessDao.findMapByPage(offset, pageSize, condition);
  	}

	@Override
	public List<Map<String, Object>> findMapByPages(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		
		return businessDao.findMapByPages(offset, pageSize, condition);
		
	}


	

	
	

}
