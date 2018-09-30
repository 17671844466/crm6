package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.ISmsTemplateDao;
import com.zhidisoft.system.entity.SmsTemplate;
import com.zhidisoft.system.service.ISmsTemplateService;
@Service
public class ISmsTemplateServiceImpl extends BaseServiceImpl<SmsTemplate> implements ISmsTemplateService 
{
	@Autowired
	private ISmsTemplateDao smsTemplateDao;

	@Override
	public SmsTemplate findByCondition(Map<String, Object> condition)
	{
		return smsTemplateDao.findByCondition(condition);
	}
}
