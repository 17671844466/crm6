package com.zhidisoft.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IFunctionDao;
import com.zhidisoft.system.entity.Function;
import com.zhidisoft.system.entity.Role;
import com.zhidisoft.system.service.IFunctionService;

@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements IFunctionService{
	
	@Autowired
	private IFunctionDao funcDao;

	@Override
	public List<Function> findByRoles(Integer parentId,List<Role> roles) {
		List<Integer> roleIds = new ArrayList<>();
		//将用户角色的所有权限拿出
		for(Role role : roles){
			roleIds.add(role.getId());
		}
		return funcDao.findByParentId(roleIds,parentId,1);
	}

	@Override
	public List<Function> getNOparentId() {
		List<Function> list = funcDao.getNOparentId();
		return list;
	}

	@Override
	public boolean insert(Function function) {
		int i = funcDao.insert(function);
		return i>0;
	}

	@Override
	public Function getFunction(Integer id) {
		Function function = funcDao.selectByPrimaryKey(id);
		return function;
	}

	@Override
	public boolean updateFuncyion(Function function) {
		int i = funcDao.updateByPrimaryKey(function);
		return i>0;
	}

	@Override
	public boolean deleteId(Integer id) {
		int i = funcDao.deleteByPrimaryKey(id);
		
		return i>0;
	}
		
		@Override
		public List<Function> findByRoleIds(List<Integer> ids) {
			
			return funcDao.findByRoleIds(ids,1);
	 }

}
