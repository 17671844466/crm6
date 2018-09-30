package com.zhidisoft.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.exception.UserStatusException;
import com.zhidisoft.system.dao.ICustomerDao;
import com.zhidisoft.system.entity.Customer;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.ICustomerService;
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService{
	@Autowired
	ICustomerDao customerDao;
	/**
	 * 分页获取数据
	 */
	@Override
	public List<Map<String, Object>> findByPageMap(Integer page, Integer rows, Map<String,Object> condition) {
		if(condition.get("userid")!=null) {
			String userid = (String) condition.get("userid");
			condition.put("userid", Integer.parseInt(userid));
		}
		List<Map<String, Object>> list = customerDao.findByPageMap((page-1)*rows, rows, condition);
		for (Map<String, Object> map : list) {
			Long delete_time =30-(System.currentTimeMillis()-((Date)map.get("update_time")).getTime())/ (1000 * 60 * 60 * 24);
			map.put("delete_time", delete_time);
		}
		return list;
	}
	/**
	 * 分页获取客户池数据
	 */
	@Override
	public List<Map<String, Object>> findByPageMaps(Integer page, Integer rows, Map<String, Object> condition) {
		List<Map<String, Object>> list = customerDao.findByPageMaps((page-1)*rows, rows, condition);
		return list;
	}
	/**
	 * 客户池总记录数
	 */
	@Override
	public Integer countpool(Map<String, Object> condition) {
		return customerDao.countpool(condition);
	}
	/**
	 * 保存数据并返回id
	 */
	@Override
	public Integer saveReturnId(Customer customer) {
		return customerDao.saveReturnId(customer);
	}
	/**
	 * 删除客户
	 */
	@Override
	public boolean deleteStatus(Integer id) {
		return customerDao.deleteStatus(id)>0;
	}
	/**
	 * 根据id获取单个对象
	 */
	@Override
	public Map<String, Object> getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}
	/**
	 * 根据name获取单个对象
	 */
	@Override
	public User getCustomerByName(String name) {
		User user = customerDao.getCustomerByName(name);
		if(user == null) {
			throw new UserStatusException("用户"+name+"不存在!");
		}
		return user;
	}
	/**
	 * 更新数据
	 */
	@Override
	public Integer updateCustomer(Customer customer) {
		return customerDao.updateByPrimaryKey(customer);
	}
	/**
	 * 领取，分配客户
	 */
	@Override
	public boolean receive(Integer id, Integer owner,Date updaetime) {
		return customerDao.receive(id,owner,updaetime)>0;
	}
	/**
	 * 批量删除客户
	 */
	@Override
	public boolean delscustomer(List<Integer> id) {
		return customerDao.delscustomer(id)>0;
	}
	
}
