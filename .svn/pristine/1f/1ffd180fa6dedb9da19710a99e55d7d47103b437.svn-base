package com.zhidisoft.system.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.Customer;
import com.zhidisoft.system.entity.User;

public interface ICustomerService extends BaseService<Customer>{
	/**
	 * 分页查询数据
	 * @param page - 开始索引
	 * @param rows - 每页显示条数
	 * @param condition - 查询条件
	 * @return
	 */
	List<Map<String, Object>> findByPageMap(Integer page, Integer rows, Map<String,Object> condition);

	List<Map<String, Object>> findByPageMaps(Integer page, Integer rows, Map<String, Object> condition);
	/**
	 * 总记录数
	 * @param condition
	 * @return
	 */
	Integer countpool(Map<String,Object> condition);
	/**
	 * 保存数据并返回id
	 * @param customer
	 * @return
	 */
	Integer saveReturnId(Customer customer);
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	boolean deleteStatus(Integer id);
	/**
	 * 根据id获取单个对象
	 * @param id
	 * @return
	 */
	Map<String, Object> getCustomerById(Integer id);
	/**
	 * 根据name获取单个对象
	 * @param name
	 * @return
	 */
	User getCustomerByName(String name);
	/**
	 * 更新单个对象
	 * @param customer
	 * @return
	 */
	Integer updateCustomer(Customer customer);
	/**
	 * 领取、分配客户
	 * @param id
	 * @param owner
	 * @param updateTime
	 * @return
	 */
	boolean receive(Integer id, Integer owner, Date updateTime);
	/**
	 * 批量删除数据
	 * @param id
	 * @return
	 */
	boolean delscustomer(List<Integer> id);
}
