package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IRoleDao;
import com.zhidisoft.system.dao.IRoleFunctionDao;
import com.zhidisoft.system.entity.Role;
import com.zhidisoft.system.entity.RoleFunction;
import com.zhidisoft.system.service.IRoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService{
	
	@Autowired
	private IRoleDao roleDao;

	@Autowired
	private IRoleFunctionDao rolefuncion;
	
	
	
	@Override
	public List<Role> findByUserId(Integer userId) {
		
		return roleDao.findByUserId(userId,1);
	}

	@Override
	public List<Role> findState() {
		List<Role> list = roleDao.selectAll();
		
		return list;
	}

	@Override
	public Integer saveRetunId(Role role) {
		roleDao.saveRrtunId(role);
		Integer id = role.getId();
		return id;
	}

	@Override
	public boolean updateFunction(List<RoleFunction>list) {
		int j = rolefuncion.saveRoleFunc(list);
	
		//int i = rolefuncion.saveRoleFunc(list);
		return j>0;
	}

	@Override
	public boolean deleteId(Integer id) {
		int i = rolefuncion.deleteroleId(id);		
		int j = roleDao.deleteByPrimaryKey(id);
		return j>0;
	}

	@Override
	public List<Role> selectAll() {
		List<Role> list = roleDao.selectAll();
		return list;
	}
	
	

}
