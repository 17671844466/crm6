package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Role;
import com.zhidisoft.system.entity.RoleFunction;

public interface IRoleService extends BaseService<Role>{
	/**
	 * 根据ID拿到角色
	 * @param userId
	 * @return
	 */
	List<Role> findByUserId(Integer userId);
	
	/**
	 * 拿到所有可用的角色
	 */
	List<Role> findState();
	/**
	 * 保存一个对象 返回对象保存后的id
	 */
	Integer saveRetunId(Role role);
	/**
	 * 将角色id传入 删除原来的权限修改为新的权限
	 */
	boolean updateFunction(List<RoleFunction>list);
	/**
	 * 根据角色id删除该角色的所有权限和该角色
	 * @param id
	 * @return
	 */
	boolean deleteId(Integer id);
	/**
	 * 查询所有可用的角色
	 *
	 */
	List<Role> selectAll();

}
