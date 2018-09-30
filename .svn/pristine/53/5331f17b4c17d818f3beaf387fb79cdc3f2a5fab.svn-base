package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.ProductCategory;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IProductCategoryDao extends BaseDao<ProductCategory>{
	List<Map<String, Object>> findMapByPage(@Param("offset") int offset,@Param("pageSize")int pageSize,@Param("condition")Map<String,Object> condition);
}