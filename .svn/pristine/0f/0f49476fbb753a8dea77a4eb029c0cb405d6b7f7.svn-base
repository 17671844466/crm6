package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.Customer;
import com.zhidisoft.system.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ICustomerDao extends BaseDao<Customer>{
	/**
	 * 查询所有数据
	 * @param offset - 开始索引
	 * @param pageSize - 每页显示的条数
	 * @param condition - 查询条件
	 * @return - 
	 */
	List<Map<String, Object>> findByPageMap(@Param("offset")int offset,@Param("pageSize") Integer pageSize,@Param("condition") Map<String,Object> condition);
	/**
	 * 查询所有没有负责人的客户
	 * @param offset - 开始索引
	 * @param pageSize - 每页显示的条数
	 * @param condition - 查询条数
	 * @return
	 */
	List<Map<String, Object>> findByPageMaps(@Param("offset")int offset,@Param("pageSize") Integer pageSize,@Param("condition") Map<String,Object> condition);
	/**
	 * 查询总记录数
	 * @param condition - 查询条件
	 * @return
	 */
	Integer countpool(@Param("condition")Map<String,Object> condition);
	/**
	 * 保存数据并返回id
	 * @param customer - 要保存的对象
	 * @return
	 */
	Integer saveReturnId(Customer customer);
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	int deleteStatus(@Param("id")Integer id);
	/**
	 * 根据id获取单个对象
	 * @param id
	 * @return
	 */
	Map<String, Object> getCustomerById(@Param("id")Integer id);
	/**
	 * 根据Name获取单个对象
	 * @param name
	 * @return
	 */
	User getCustomerByName(@Param("name")String name);
	/**
	 * 分配客户
	 * @param id
	 * @param owner
	 * @param updatetime
	 * @return
	 */
	Integer receive(@Param("id")Integer id, @Param("owner")Integer owner,@Param("updatetime")Date updatetime);
	/**
	 * 批量删除数据
	 * @param id
	 * @return
	 */
	int delscustomer(@Param("id")List<Integer> id);
}