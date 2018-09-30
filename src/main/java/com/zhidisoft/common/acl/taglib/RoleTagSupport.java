package com.zhidisoft.common.acl.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.zhidisoft.common.support.SystemProperties;
import com.zhidisoft.common.util.BeanUtils;
import com.zhidisoft.system.entity.Role;

/**
 * <acl:role property=""/>标签支持类
 * @author Lu Jianliang
 *
 */
@SuppressWarnings("all")
public class RoleTagSupport extends SimpleTagSupport{
	
	private String property = "roleName";
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		List<Role> roles = (List<Role>)this.getJspContext().getAttribute(SystemProperties.LOGIN_USER_ROLE_SESSION_KEY, PageContext.SESSION_SCOPE);
		if(roles == null || roles.isEmpty()){
			return ;
		}
		
		StringBuffer sb = new StringBuffer();
		for(Role role : roles){
			sb.append(BeanUtils.getProperty(role, property));
			sb.append(",");
		}
		out.print(sb.toString());
		
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		if(property == null || property.isEmpty()){
			this.property = "roleName";
			return;
		}
		this.property = property;
	}
	
}
