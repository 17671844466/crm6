package com.zhidisoft.system.controller;
 
import java.util.ArrayList;
import java.util.HashMap;
 import java.util.List;
import java.util.Map;
 
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 
 import com.zhidisoft.common.JsonResult;
 import com.zhidisoft.exception.UserStatusException;
import com.zhidisoft.system.entity.Function;
 import com.zhidisoft.system.entity.Role;
 import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IFunctionService;
 import com.zhidisoft.system.service.IRoleService;
 import com.zhidisoft.system.service.IUserService;
 
 @Controller
 public class LoginController {
 	
 	@Autowired
 	private IUserService userService;
 	
 	@Autowired
 	private IRoleService roleService;
	@Autowired
	private IFunctionService functionService;
 	
 	@PostMapping("/logon") //@RequestMapping(value="/",method=RequestMethod.POST)
 	@ResponseBody
 	public JsonResult login(String username,String password,HttpSession session,HttpServletRequest request){
 		//获取到用户
 		User user = userService.login(username, password);
 		//获取用户角色
 		List<Role> roles = roleService.findByUserId(user.getId() );
 		//判断当前用户是否有可用的角色
 		if(roles == null || roles.isEmpty() ){
 			throw new UserStatusException("未给用户"+username+"提供可用系统权限");
 		}
		//获取登录用户的权限信息
		List<Integer> ids = new ArrayList<>();
		for(Role role : roles){
			ids.add(role.getId());
		}
		//获取当前登录用户所有的权限信息
		List<Function> functions = functionService.findByRoleIds(ids);
		if(functions == null || functions.isEmpty()){
			throw new UserStatusException("当前用户无系统使用权限!");
		}
		//将权限信息转换为Map集合，便于对权限进行校验
		Map<String, Function> permissionsByURL = new HashMap<>();
		Map<String, Function> permissionsByCode = new HashMap<>();
		//Map<Integer, Function> permissionsByFuncId = new HashMap<>();
		for(Function function : functions){
			permissionsByURL.put(function.getFuncurl(), function);
			permissionsByCode.put(function.getFunccode(), function);
			//permissionsByFuncId.put(function.getf, function);
		}
		//将用户信息放入会话中
		
 		session.setAttribute("user", user);
 		session.setAttribute("roles", roles);
		session.setAttribute("url", permissionsByURL);//保存了当前登录用户的权限信息到Session中
		session.setAttribute("code", permissionsByCode);
		System.out.println(permissionsByCode);
 		//request.getRequestDispatcher("/index");
 		return JsonResult.buildSuccessResult("登录成功");
 	}
 	/**
 	 * 访问主页
 	 * @return
 	 */
 	@RequestMapping("/index")
 	public String index(){
 		
 		return "index";
 	}
 	
 	
}