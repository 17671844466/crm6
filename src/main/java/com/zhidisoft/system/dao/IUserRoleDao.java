package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.entity.UserRole;
import java.util.List;

public interface IUserRoleDao extends BaseDao<UserRole>{
    /**
     * 删除用户所有的权限
     * @param userId
     * @return
     */
	int deleteByUserId(Integer userId);
	/**
	 * 给用户批量增加权限
	 * @param list
	 * @return
	 */
	int insertBatch(List<UserRole> list);
	
	//找室友其他用户
	List<User> findUser(Integer id);
}