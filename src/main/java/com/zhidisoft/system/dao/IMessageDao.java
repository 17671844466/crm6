package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.Message;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IMessageDao extends BaseDao<Message>{

	List<Map<String, Object>> findMapByPage(@Param("offset") int offset,@Param("pageSize")int pageSize,@Param("condition")Map<String,Object> condition);

	Map<String, Object> getMessage(@Param("messageId")Integer messageId);
	
	boolean changeStatus(@Param("messageId")Integer messageId,@Param("date")Date date);

	boolean changeMessageStatus(@Param("condition")Map<String, Object> condition);

	boolean send(@Param("toUserId")Integer toUserId, @Param("content")String content,@Param("fromUserId") Integer fromUserId,@Param("date")Date date);
    
}