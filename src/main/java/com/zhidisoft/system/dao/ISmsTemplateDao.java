package com.zhidisoft.system.dao;

import com.zhidisoft.base.dao.BaseDao;
import com.zhidisoft.system.entity.SmsTemplate;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ISmsTemplateDao extends BaseDao<SmsTemplate>{

	SmsTemplate findByCondition(@Param("condition")Map<String, Object> condition);
  
}