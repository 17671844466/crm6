package com.zhidisoft.common.acl.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zhidisoft.common.support.SystemProperties;
import com.zhidisoft.common.util.BeanUtils;
import com.zhidisoft.system.entity.User;

/**
 * <acl:user property=""/>标签支持类
 * @author Lu Jianliang
 *
 */
public class UserTagSupport extends SimpleTagSupport{
	
	private String property = "userName";

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		User user = (User)this.getJspContext().getAttribute(SystemProperties.LOGIN_USER_SESSION_KEY, PageContext.SESSION_SCOPE);
		if(user == null){
			return ;
		}
		
		Object value = BeanUtils.getProperty(user, property);
		out.print(value != null ? value.toString() : "");
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		if(property == null || property.isEmpty()){
			this.property = "userName";
		}
		this.property = property;
	}
	

}
