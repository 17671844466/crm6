package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Task;

public interface ITaskService extends BaseService<Task>{
	/**
	 * 下拉框查询方法
	 * @return
	 */
	List<Map<String, Object>> findAlls();
	
	/**
	 * 任务页面分页方法
	 * @param pageNumber
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	List<Map<String, Object>> findByPage(Integer pageNumber,Integer pageSize,Map<String, Object> condition);
	
	/**
	 * 获取总记录数
	 * @param condition
	 * @return
	 */
	Integer countpool(Map<String, Object>condition);
}
