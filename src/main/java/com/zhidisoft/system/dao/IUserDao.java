package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface IUserDao extends BaseDao<User>{
	/**
	 * 保存用户信息到数据库
	 * @param user
	 * @return
	 */
	int save(User user);

	/**
	 * 通过用户获取用户信息
	 * @param username
	 * @return
	 */
	User findByUsername(@Param("username")String username);
	
	//找所有其他用户
	List<User> findUser(@Param("id")Integer id);
}