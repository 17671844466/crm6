package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.Business;
import com.zhidisoft.system.entity.User;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IBusinessDao extends BaseDao<Business>{
    
	List<Map<String, Object>> findMapByPage(@Param("offset") int offset,@Param("pageSize")int pageSize,@Param("condition")Map<String,Object> condition);

	List<Map<String, Object>> findMapByPages(@Param("offset")int offset, @Param("pageSize")Integer pageSize, @Param("condition")Map<String, Object> condition);

	
} 