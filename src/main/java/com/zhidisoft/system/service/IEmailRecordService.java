package com.zhidisoft.system.service;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.system.entity.EmailRecord;

public interface IEmailRecordService extends BaseService<EmailRecord>
{

	boolean sendEmail(String emailTo, String title, Integer userId, String content);

}
