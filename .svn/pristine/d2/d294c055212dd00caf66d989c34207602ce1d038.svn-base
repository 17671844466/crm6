package com.zhidisoft.common.spring.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {
	
	private String pattern = "yyyy-MM-dd";

	@Override
	public String print(Date date, Locale locale) {
		if(date != null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
			return simpleDateFormat.format(date);
		}
		return null;
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if(text != null && !text.isEmpty()){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
			return simpleDateFormat.parse(text);
		}
		return null;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
