package com.zhidisoft.system.service;

import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.EmailTemplate;
import com.zhidisoft.system.entity.SmsTemplate;

public interface IEmailTemplateService extends BaseService<EmailTemplate>
{

	EmailTemplate findByCondition(Map<String, Object> condition);

	

}
