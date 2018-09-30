package com.zhidisoft.common.copy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 将字符串日期按照指定模式转换为java.util.Date对象
	 * @param date -待转换的日期字符串
	 * @param pattern -模式
	 * @return -返回java.util.Date对象，如果date字符串为null，返回null
	 */
	public static Date parseDate(String date,String pattern){
		try {
			if(date!=null && !date.isEmpty()){
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				return sdf.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取两个日期相隔的天 数
	 * @param before -日期对象
	 * @param after -日期对象
	 * @return -返回日期天数差
	 */
	public static int diffDate(Date before,Date after){
		long diff = after.getTime() - before.getTime();
		return (int)diff/(24*60*60*1000);
	}
	
	public static String parseString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
