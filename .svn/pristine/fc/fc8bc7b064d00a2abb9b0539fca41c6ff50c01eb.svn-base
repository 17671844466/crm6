package com.zhidisoft.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IEmailTemplateDao;
import com.zhidisoft.system.entity.EmailTemplate;
import com.zhidisoft.system.entity.SmsTemplate;
import com.zhidisoft.system.service.IEmailTemplateService;
@Service
public class IEmailTemplateServiceImpl extends BaseServiceImpl<EmailTemplate> implements IEmailTemplateService
{
	@Autowired
	private IEmailTemplateDao emailTemplateDao;

	@Override
	public EmailTemplate findByCondition(Map<String, Object> condition)
	{
		
		return emailTemplateDao.findByCondition(condition);
	}

	

}
