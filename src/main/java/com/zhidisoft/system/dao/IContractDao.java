package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.Contract;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IContractDao extends BaseDao<Contract>{

	List<Map<String, Object>> findAllMap(@Param("offset")int offset,@Param("pageSize") Integer pageSize, @Param("condition")Map<String, Object> condition);
	
}