package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.SmsRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ISmsRecordDao extends BaseDao<SmsRecord>{

	boolean save(@Param("userId")Integer userId, @Param("phoNumber")String phoNumber,@Param("content") String content,@Param("date") Date date);

	List<Map<String, Object>> findSmsByPage(@Param("offset") int offset,@Param("pageSize")int pageSize,@Param("condition")Map<String,Object> condition);
}