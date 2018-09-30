package com.zhidisoft.common.acl.taglib;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

import com.zhidisoft.common.support.SystemProperties;
import com.zhidisoft.exception.UserStatusException;
import com.zhidisoft.system.entity.Function;

/**
 * <acl:hasPermission url="" code=""/>标签支持类
 * @author lx
 *
 */
@SuppressWarnings("all")
public class HasPermissionTagSupport extends TagSupport {
	
	private String url;
	
	private String code;
	
	@Override
	public int doStartTag() throws JspException {
		if(StringUtils.isAllBlank(url,code)){
			throw new UserStatusException("<acl:hasPermission>标签必须定义url属性或code属性");
		}
		if(StringUtils.isNotBlank(url) && StringUtils.isNoneBlank(code)){
			throw new UserStatusException("<acl:hasPermission>标签只能定义url属性或code属性其中的之一");
		}
		
		//如果为当前标签指定了url属性
		if(StringUtils.isNotBlank(url)){
			Map<String, Function> permissions = (HashMap<String, Function>)pageContext.getAttribute("url", PageContext.SESSION_SCOPE);
			if(permissions.get(url)!=null){
				//执行当前标签的内容
				return EVAL_BODY_INCLUDE;
			}
		}
		
		//如果当前标签指定了code属性
		if(StringUtils.isNotBlank(code)){
			Map<String, Function> permissions = (HashMap<String, Function>)pageContext.getAttribute("code", PageContext.SESSION_SCOPE);
			if(permissions.get(code)!=null){
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
