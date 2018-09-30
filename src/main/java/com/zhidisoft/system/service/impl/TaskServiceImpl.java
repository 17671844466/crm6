package com.zhidisoft.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.ITaskDao;
import com.zhidisoft.system.entity.Task;
import com.zhidisoft.system.service.ITaskService;
@Service
public class TaskServiceImpl extends BaseServiceImpl<Task> implements ITaskService{
	@Autowired
	ITaskDao taskDao;

	/**
	 * 任务页面下拉框查询方法
	 */
	@Override
	public List<Map<String, Object>> findAlls() {
		return taskDao.findAlls();
	}
	
	/**
	 * 任务页面分页查询方法
	 */
	@Override
	public List<Map<String, Object>> findByPage(Integer pageNumber, Integer pageSize, Map<String, Object> condition) {
		Integer offset=(pageNumber-1) * pageSize;
		return taskDao.findByPage(offset, pageSize, condition);
	}
	
	
	/**
	 * 任务页面查询总数方法
	 */
	@Override
	public Integer countpool(Map<String, Object> condition) {
		
		return taskDao.count(condition);
	}
	
}
