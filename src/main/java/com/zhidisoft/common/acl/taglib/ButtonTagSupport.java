package com.zhidisoft.common.acl.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import javax.swing.JComboBox.KeySelectionManager;

import org.apache.commons.lang3.StringUtils;

import com.zhidisoft.common.support.SystemProperties;
import com.zhidisoft.exception.UserStatusException;
import com.zhidisoft.system.entity.Function;

/**
 * <acl:button code="" cssCls="" click="" alt="" 其他动态属性/>标签支持类
 * @author Lu Jianliang
 *
 */
@SuppressWarnings("all")
public class ButtonTagSupport extends TagSupport implements DynamicAttributes {
	
	private String code;
	
	private String click;
	
	private String alt;
	
	private String cssClass;
	
	private List<String> keys = new ArrayList<String>();
	
	private List<Object> values = new ArrayList<Object>();
	
	@Override
	public int doEndTag() throws JspException {
		if(StringUtils.isBlank(code)){
			throw new UserStatusException("<acl:button>标签必须定义code属性");
		}
		
		Map<String, Function> permissions = (HashMap<String, Function>)pageContext.getAttribute(SystemProperties.LOGIN_USER_PERMISSION_SESSION_KEY_CODE, PageContext.SESSION_SCOPE);
		Function function = permissions.get(code);
		if(function != null){
			StringBuffer sb = new StringBuffer("<a href=\"");
			sb.append(function.getFuncurl());
			sb.append("\" ");
			
			if(StringUtils.isNotBlank(getId())){
				sb.append("id=\"");
				sb.append(getId());
				sb.append("\" ");
			}
			
			if(StringUtils.isNotBlank(alt)){
				sb.append("alt=\"");
				sb.append(alt);
				sb.append("\" ");
			}
			if(StringUtils.isNotBlank(click)){
				sb.append("onclick=\"");
				sb.append(click);
				sb.append("\" ");
			}
			if(StringUtils.isNotBlank(cssClass)){
				sb.append("class=\"");
				sb.append(cssClass);
				sb.append("\" ");
			}
			//动态属性的拼接
			if(keys!=null && !keys.isEmpty()){
				for(int i = 0; i < keys.size(); i++){
					String key = keys.get(i);
					Object value = values.get(i);
					if(StringUtils.isNoneBlank(key) && value!=null){
						sb.append(key);
						sb.append("=\"");
						sb.append(value.toString());
						sb.append("\" ");
					}
					
				}
			}
			
			sb.append(">");
			sb.append(function.getFuncname());
			sb.append("</a>");
			
			JspWriter out = pageContext.getOut();
			try {
				out.print(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return EVAL_PAGE;
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
		keys.add(localName);
		values.add(value);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	

}
