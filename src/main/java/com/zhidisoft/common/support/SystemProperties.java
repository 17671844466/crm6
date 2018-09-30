package com.zhidisoft.common.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统中常用配置属性支持类
 * @author Lu Jianliang
 *
 */
@Component
public class SystemProperties {
	
	/** 登录用户在Session中key */
	public static String LOGIN_USER_SESSION_KEY;
	
	/** 登录用户角色在Session中key */
	public static String LOGIN_USER_ROLE_SESSION_KEY;
	
	/** 登录用户权限在Session中key */
	public static String LOGIN_USER_PERMISSION_SESSION_KEY_URL;
	
	/** 登录用户权限在Session中key */
	public static String LOGIN_USER_PERMISSION_SESSION_KEY_CODE;
	
	/** 登录用户权限在Session中key */
	public static String LOGIN_USER_PERMISSION_SESSION_KEY_FUNCID;
	
	/** 所有用户权限在ServletContext中key */
	public static String ALL_PERMISSION_APPLICATION_KEY="";
	
	@Value("${login.user.session.key}")
	public void setUserSessionKey(String userSessionKey){
		SystemProperties.LOGIN_USER_SESSION_KEY = userSessionKey;
	}
	
	@Value("${login.user.role.session.key}")
	public void setRoleSessionKey(String roleSessionKey){
		SystemProperties.LOGIN_USER_ROLE_SESSION_KEY = roleSessionKey;
	}
	
	@Value("${login.user.permission.session.key.url}")
	public void setPermissionSessionKeyURL(String permissionSessionKey){
		SystemProperties.LOGIN_USER_PERMISSION_SESSION_KEY_URL = permissionSessionKey;
	}
	
	@Value("${login.user.permission.session.key.code}")
	public void setPermissionSessionKeyCode(String permissionSessionKey){
		SystemProperties.LOGIN_USER_PERMISSION_SESSION_KEY_CODE = permissionSessionKey;
	}
	
	@Value("${login.user.permission.session.key.funcid}")
	public void setPermissionSessionKeyFuncId(String permissionSessionKey){
		SystemProperties.LOGIN_USER_PERMISSION_SESSION_KEY_FUNCID = permissionSessionKey;
	}
	
	@Value("${all.permission.application.key}")
	public void setAllPermissionApplicationKey(String allPermissionApplicationKey){
		SystemProperties.ALL_PERMISSION_APPLICATION_KEY = allPermissionApplicationKey;
	}

}
