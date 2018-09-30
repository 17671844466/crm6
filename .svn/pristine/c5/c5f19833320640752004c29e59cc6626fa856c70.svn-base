package com.zhidisoft.system.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IEmailRecordDao;
import com.zhidisoft.system.entity.EmailRecord;
import com.zhidisoft.system.service.IEmailRecordService;
@Service
public class IEmailRecordServiceImpl extends BaseServiceImpl<EmailRecord> implements IEmailRecordService
{
	@Autowired
	private IEmailRecordDao emailRecordDao;
	@Override
	public boolean sendEmail(String emailTo, String title, Integer userId, String content)
	{
		Date date = new Date();
		//切割字符串获取所有接收人信息
		String[] getters = emailTo.split("\n");
		//遍历数组并获取接收人号码和姓名,然后发送信息并保存至数据库
		for (String getter : getters)
		{
			//新建状态码
			int status = 1;
			//获取名字和地址
			String toAddr = getter;
			String name = "";
			//判断是否存在','
			if(getter.indexOf(',')>0){
				toAddr = getter.substring(0, getter.indexOf(','));
				name = getter.substring(getter.indexOf(',')+1);
			}
			//替换名称
			System.out.println(name);
			String message = content.replace("{$name}",name);
			/**
			  这里的send为通过地址和内容等自动发送短信的方法,返回值boolean,未实现,写在注释中
			if(!send(args[])){
				status = -1;
				}
			  */
			emailRecordDao.save(userId,toAddr,title,message,date,status);
			if(status == -1){
				return false;
			}
		}
		return true;
	}

}
