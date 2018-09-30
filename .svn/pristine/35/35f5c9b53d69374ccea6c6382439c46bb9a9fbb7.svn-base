package com.zhidisoft.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 权限控制器web层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("system")
public class FunctionController {
	/**
	 * 跳转到权限页面
	 * @author Administrator
	 *
	 */
	@RequestMapping("/function")
	public String function(){
		return "system/function";
	}
	/**
	 * 跳转到角色页面
	 * @return
	 */
	@RequestMapping("/roles")
	public String roles(){
		return "system/roles";
	}
	/**
	 * 跳转到人员管理页面
	 */
	@RequestMapping("/users")
	public String systemuser(){
		
		return "system/manageuser";
		
	}
}
