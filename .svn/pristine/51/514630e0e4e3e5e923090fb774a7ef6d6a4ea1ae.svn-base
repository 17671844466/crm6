package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Function;
import com.zhidisoft.system.entity.User;

public interface IUserService extends BaseService<User>{
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	boolean save(User user);
	
	/**
	 * 登录方法
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username,String password);

	/**
	 * 为指定的用户分配角色
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	boolean assignRoles(Integer userId, String roleIds);
	
	
	
	/**
	 * 分页查询所有权限
	 * @param rows 
	 * @param page 
	 */

	List<Map<String, String>> getFunctionAll(Integer page, Integer rows);
	/**
	 * 拿到所有的记录数
	 */
	int getcount();

	List<Map<String, String>> getFunctionAll();
	
	//找到出自己外其他所有用户--by 万尧
	List<User> findUser(Integer id);

}




