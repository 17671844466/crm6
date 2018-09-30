package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.Contacts;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IContactsDao extends BaseDao<Contacts>{
	/**
	 * 分页查询数据
	 * @param offset - 开始索引
	 * @param rows - 每页显示条数
	 * @param condition - 查询条件
	 * @return
	 */
	List<Map<String, Object>> findByPageMap(@Param("offset")Integer offset, @Param("pageSize")Integer rows,@Param("condition") Map<String, Object> condition);
	/**
	 * 更新单个对象
	 * @param contacts
	 * @return
	 */
	Integer updateMore(Contacts contacts);
	/**
	 * 删除数据
	 * @param id
	 */
	void deletecontacts(@Param("id")Integer id);
	/**
	 * 批量删除
	 * @param id
	 */
	void delscontacts(@Param("ids")List<Integer> id);
   
}