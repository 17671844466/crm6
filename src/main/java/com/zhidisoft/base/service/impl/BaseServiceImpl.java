package com.zhidisoft.base.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.base.service.BaseService;

/**
 * 基础Service实现
 * @author lx
 *
 * @param <E>
 */
public class BaseServiceImpl<E> implements BaseService<E>{
	
	@Autowired
	private BaseDao<E> baseDao;

	@Override
	public boolean save(E entity) {
		
		return baseDao.insert(entity) > 0;
	}

	@Override
	public boolean update(E entity) {
		return baseDao.updateByPrimaryKey(entity) > 0;
	}

	@Override
	public boolean delete(Integer id) {
		
		return baseDao.deleteByPrimaryKey(id) > 0;
	}

	@Override
	public List<E> findAll() {
		
		return (List<E>) baseDao.selectAll();
	}

	@Override
	public List<E> findByPage(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		return baseDao.findByPage(offset, pageSize, condition);
	}

	@Override
	public int count(Map<String, Object> condition) {
		
		return baseDao.count(condition);
	}

	@Override
	public E get(Integer id) {
		
		return baseDao.selectByPrimaryKey(Integer.valueOf(id));
	}

	

}
