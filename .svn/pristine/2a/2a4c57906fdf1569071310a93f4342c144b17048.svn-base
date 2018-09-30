package com.zhidisoft.common.util;

import java.util.UUID;

public class AuthUtils {
	
	/**
	 * 生成随机的UUID字符串
	 * @return -返回的uuid字符串将未包含分隔符"-"，且将其转换为大小
	 */
	public static String generateUUID(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 获取随机的盐值
	 * @return -返回密码加密所需盐值
	 */
	public static String generateSalt(){
		return generateUUID();
	}
	
	/**
	 * 对密码进行加密
	 * @param password -原始密码
	 * @param salt -盐值
	 * @return -返回利用md5加密后的密码
	 */
	public static String encryptPassword(String password, String salt){
		
		if(salt != null && !salt.isEmpty()){
			return EncryptUtils.encryptMD5(password+salt);
		}
		return EncryptUtils.encryptMD5(password);
	}
}
