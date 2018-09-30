package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.Product;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IProductDao extends BaseDao<Product>{
	List<Map<String, Object>> findMapByPage(@Param("offset") int offset,@Param("pageSize")int pageSize,@Param("condition")Map<String,Object> condition);
}