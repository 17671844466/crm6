package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.SmsRecord;

public interface ISmsRecordService extends BaseService<SmsRecord>
{

	boolean sendSms(String messageTo, Integer userId, String content);

	List<Map<String,Object>> findSmsByPage(Integer page, Integer rows, Map<String, Object> condition);

}
