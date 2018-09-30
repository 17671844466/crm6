package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Contract;

public interface IContractService extends BaseService<Contract>{
	List<Map<String, Object>> findAllMap(Integer offset,Integer pageSize,Map<String, Object> condition);
}
