package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IContactsDao;
import com.zhidisoft.system.entity.Contacts;
import com.zhidisoft.system.service.IContactsService;
@Service
public class ContactsServiceImpl extends BaseServiceImpl<Contacts> implements IContactsService{
	@Autowired
	IContactsDao contactsDao;
	/**
	 * 分页查询数据
	 */
	@Override
	public List<Map<String, Object>> findByPageMap(Integer offset, Integer rows, Map<String, Object> condition) {
		return contactsDao.findByPageMap(offset,rows,condition);
	}
	/**
	 * 更新数据
	 */
	@Override
	public boolean updateMore(Contacts contacts) {
		return contactsDao.updateMore(contacts) >0;
	}
	/**
	 * 删除单条数据
	 */
	@Override
	public void deletecontacts(Integer id) {
		contactsDao.deletecontacts(id);
	}
	/**
	 * 批量删除数据
	 */
	@Override
	public void delscontacts(List<Integer> id) {
		contactsDao.delscontacts(id);
	}
	
}
