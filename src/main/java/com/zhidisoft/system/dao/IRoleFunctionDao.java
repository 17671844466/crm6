package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.RoleFunction;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IRoleFunctionDao extends BaseDao<RoleFunction>{
  /**
   * 根据角色ID删除所有的权限
   * @param id
   * @return
   */
	int deleteroleId(Integer id);
	/**
	 * 批量插入角色权限
	 * 
	 */
	int saveRoleFunc(@Param("list")List<RoleFunction>list);
	/**
	 * 查询角色对象的权限
	 */
	List<RoleFunction>getRoleFunction(Integer id);
	
}