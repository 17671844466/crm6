package com.zhidisoft.system.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhidisoft.system.entity.RoleFunction;

/**
 * 角色与权限的中间表
 * @author Administrator
 *
 */
public interface IRoleFunction{
	
	/**
	 * 将角色原来的权限删除 插入新的权限
	 */
	boolean updateFunction(@Param("list")List<RoleFunction>list);
	/**
	 * 根据角色id查询该角色所有的权限
	 */
	List<RoleFunction>getRoleFunction(Integer id);
	/**
	 * 根据角色id删除该角色所有的权限
	 */
	int deleteRoleId(Integer id);
}
