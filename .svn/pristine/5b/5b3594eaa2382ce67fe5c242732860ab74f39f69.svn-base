package com.zhidisoft.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.system.dao.IRoleFunctionDao;
import com.zhidisoft.system.entity.RoleFunction;
import com.zhidisoft.system.service.IRoleFunction;
@Service
public class RoleFunctionImpl implements IRoleFunction {
	@Autowired
	private IRoleFunctionDao rolefunctionDao;
	@Override
	public boolean updateFunction(List<RoleFunction>list) {
		
		rolefunctionDao.deleteroleId(list.get(0).getRoleid());
		
		int i = rolefunctionDao.saveRoleFunc(list);
		return i>0;
	}
	@Override
	public List<RoleFunction> getRoleFunction(Integer id) {
		List<RoleFunction> list = rolefunctionDao.getRoleFunction(id);
		return list;
	}
	@Override
	public int deleteRoleId(Integer id) {
		int i = rolefunctionDao.deleteroleId(id);
		return i;
	}

}
