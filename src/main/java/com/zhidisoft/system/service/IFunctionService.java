package com.zhidisoft.system.service;

import java.util.List;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Function;
import com.zhidisoft.system.entity.Role;

public interface IFunctionService extends BaseService<Function> {

	/**
	 * 根据角色信息获取对应的权限
	 * @param roles
	 * @return
	 */
	List<Function> findByRoles(Integer parentId,List<Role> roles);
/**
 * 查询没有父类的权限
 * @return
 */
	List<Function> getNOparentId();
/**
 * 保存一个权限
 */
	boolean insert(Function function);
	
	/**
	 * 根据id 拿到权限的信息
	 * 
	 */
	Function getFunction(Integer id);
	/**
	 * 修改一个权限
	 */
	boolean updateFuncyion(Function function);
	/**
	 * 根据id删除一个权限
	 */
	boolean deleteId(Integer id);
		/**
		 * 批量查询权限根据id
		 * @param ids
		 * @return
		 */
	 List<Function> findByRoleIds(List<Integer> ids);
}
