package com.zhidisoft.system.service;

import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.SmsTemplate;

public interface ISmsTemplateService extends BaseService<SmsTemplate>
{
	SmsTemplate findByCondition(Map<String, Object> condition);
}
