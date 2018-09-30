package com.zhidisoft.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.ISmsRecordDao;
import com.zhidisoft.system.entity.SmsRecord;
import com.zhidisoft.system.service.ISmsRecordService;
@Service
public class ISmsRecordServiceImpl extends BaseServiceImpl<SmsRecord> implements ISmsRecordService
{
	@Autowired 
	private ISmsRecordDao smsRecordDao;
	
	@Override
	public boolean sendSms(String messageTo, Integer userId, String content)
	{
		Date date = new Date();
		//切割字符串获取所有接收人信息
		String[] getters = messageTo.split("\n");
		//遍历数组并获取接收人号码和姓名,然后发送信息并保存至数据库
		for (String getter : getters)
		{
			//获取名字和号码
			String phoNumber = getter;
			String name = "";
			//判断是否存在','
			if(getter.indexOf(',')>0){
				phoNumber = getter.substring(0, getter.indexOf(','));
				name = getter.substring(getter.indexOf(',')+1);
			}
			//替换名称
			System.out.println(name);
			String message = content.replace("{$name}",name);
			
			/**
			  这里的send为通过号码和内容自动发送短信的方法,返回值boolean,未实现,写在注释中
			if(!send){
			 	return false;
			 } */
			if(!smsRecordDao.save(userId,phoNumber,message,date)){
				return false;
			}
			
		}
		return true;
	}

	
	
	@Override
	public List<Map<String, Object>> findSmsByPage(Integer pageNumber, Integer pageSize, Map<String, Object> condition) 
	{
		int offset = (pageNumber-1)*pageSize;
		return smsRecordDao.findSmsByPage(offset, pageSize, condition);
	}

	

}
