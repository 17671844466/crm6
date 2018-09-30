package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Contacts;

public interface IContactsService extends BaseService<Contacts>{
	/**
	 * 分页查询数据
	 * @param offset - 开始索引
	 * @param rows - 每页显示条数
	 * @param condition - 查询条件
	 * @return
	 */
	List<Map<String, Object>> findByPageMap(Integer offset, Integer rows, Map<String, Object> condition);
	/**
	 * 更新数据
	 * @param contacts
	 * @return
	 */
	boolean updateMore(Contacts contacts);
	/**
	 * 删除数据
	 * @param id
	 */
	void deletecontacts(Integer id);
	/**
	 * 批量删除
	 * @param id
	 */
	void delscontacts(List<Integer> id);
}
