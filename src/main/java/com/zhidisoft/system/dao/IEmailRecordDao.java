package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.EmailRecord;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IEmailRecordDao extends BaseDao<EmailRecord>{

	boolean save(@Param("userId")Integer userId, @Param("toAddr")String toAddr,@Param("title") String title, @Param("message")String message,@Param("date") Date date,@Param("status") Integer status);
  
}