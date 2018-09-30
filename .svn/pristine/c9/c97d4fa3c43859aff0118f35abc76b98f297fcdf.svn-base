package com.zhidisoft.system.service.impl;

import java.util.Date;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidisoft.base.service.impl.BaseServiceImpl;
import com.zhidisoft.system.dao.IMessageDao;
import com.zhidisoft.system.entity.Message;
import com.zhidisoft.system.service.IMessageService;

@Service
public class IMessageServiceImpl extends BaseServiceImpl<Message> implements IMessageService
{
	@Autowired
	private IMessageDao messageDao;
	
	public List<Map<String, Object>> findMapByPage(int pageNumber, Integer pageSize, Map<String, Object> condition) {
		int offset = (pageNumber-1)*pageSize;
		return messageDao.findMapByPage(offset, pageSize, condition);
	}

	@Override
	public Map<String, Object> getMessage(Integer messageId)
	{
		//通过Id获取站内信详细信息
		Map<String,Object> message = messageDao.getMessage(messageId);
		//判断信件阅读状态,未读则将读取时间修改为现在,且将读取状态改为1
		if((Integer)message.get("status")==0)
		{
			messageDao.changeStatus(messageId,new Date());
		}
		return message;
	}

	@Override
	public boolean delete(Map<String, Object> condition)
	{
		return messageDao.changeMessageStatus(condition);
	}

	@Override
	public boolean send(Integer toUserId, String content, Integer fromUserId)
	{
		return messageDao.send(toUserId,content,fromUserId,new Date());
	}
}