package com.zhidisoft.system.service;

import java.util.List;
import java.util.Map;

import com.zhidisoft.base.service.BaseService;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Leads;
import com.zhidisoft.system.entity.Message;

public interface IMessageService extends BaseService<Message>
{
	List<Map<String, Object>> findMapByPage(int pageNumber, Integer pageSize, Map<String,Object> condition);

	Map<String, Object> getMessage(Integer messageId);

	boolean delete(Map<String,Object> condition);
	
	boolean send(Integer toUserId,String content,Integer fromUserId);
	
}
