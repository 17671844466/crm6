package com.zhidisoft.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.exception.ObjectNotFoundException;
import com.zhidisoft.exception.UserStatusException;
import com.zhidisoft.system.dao.IFunctionDao;
import com.zhidisoft.system.dao.IUserDao;
import com.zhidisoft.system.dao.IUserRoleDao;
import com.zhidisoft.system.entity.Function;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.entity.UserRole;
import com.zhidisoft.system.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
	//将userdao注入到service层
	@Autowired
	private IUserDao userDao;
	//将用户权限注入到service层
	@Autowired
	private IUserRoleDao userRoleDao;
	
	//将权限接口注入
	@Autowired
	private IFunctionDao functiondao;
	
	//保存一个用户到数据库
	@Override
	public boolean save(User user) {
		
		return userDao.save(user) > 0;
	}

	@Override
	public User login(String username, String password) {
		User user = userDao.findByUsername(username);
		//说明用户名不存在
		if(user == null){
			throw new ObjectNotFoundException("用户名为"+username+"的用户不存在");
		}
		
		//判断如果用户状态不为1，说明用户为被禁用用户或者已经被删除的用户
		if(1 != user.getState()){
			throw new UserStatusException("用户"+username+"不可用，请联系系统管理员");
		}
		
		//如果密码不正确
		if(!password.equals(user.getPassword())){
			throw new UserStatusException("用户"+username+"密码错误");
		}
		
		return user;
	}

	@Override
	public boolean assignRoles(Integer userId, String roleIds) {
		//先把中间表中当前用户的所有的权限信息删除
		userRoleDao.deleteByUserId(userId);
		//在把新的权限信息插入到数据库中
		if(!roleIds.isEmpty()){
			String [] ids = roleIds.split(",");
			List<UserRole> list = new ArrayList<>();
			for(String id : ids){
				UserRole userRole = new UserRole();
				userRole.setUserid(userId);
				userRole.setRoleid(Integer.valueOf(id));
				list.add(userRole);
			}
			//执行批量插入
			userRoleDao.insertBatch(list);
		}
		
		return true;
	}

	@Override
	public List<Map<String, String>> getFunctionAll(Integer page, Integer rows) {
		
		List<Map<String, String>> list = functiondao.getAll(page,rows);
		int i = getcount();
		
		return list;
	}


	@Override
	public int getcount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	


	@Override//找到出自己外的所有其他用户
	public List<User> findUser(Integer id)
	{
		
		return userDao.findUser(id);
	}

	@Override
	public List<Map<String, String>> getFunctionAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
