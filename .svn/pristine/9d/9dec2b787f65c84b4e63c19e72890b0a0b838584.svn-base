package com.zhidisoft.common.support;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义JacksonObjectMapper
 * @author Lu Jianliang
 *
 */
public class JacksonObjectMapper extends ObjectMapper{
	
	private static final long serialVersionUID = 1L;
	

	public JacksonObjectMapper(){
		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		this.setLocale(Locale.CHINA);
	}
	
}
