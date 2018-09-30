package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IContractDao;
import com.zhidisoft.system.entity.Contract;
import com.zhidisoft.system.service.IContractService;
@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract> implements IContractService{

	@Autowired
	IContractDao contractDao;
	
	@Override
	public List<Map<String, Object>> findAllMap(Integer offset, Integer pageSize, Map<String, Object> condition) {
		return contractDao.findAllMap((offset-1)*pageSize,pageSize,condition);
	}

}
