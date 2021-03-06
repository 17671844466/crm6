package com.zhidisoft.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.dao.IUserRoleDao;
import com.zhidisoft.system.entity.Function;
import com.zhidisoft.system.entity.Role;
import com.zhidisoft.system.entity.RoleFunction;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.entity.UserRole;
import com.zhidisoft.system.service.IFunctionService;
import com.zhidisoft.system.service.IRoleFunction;
import com.zhidisoft.system.service.IRoleService;
import com.zhidisoft.system.service.IUserService;

/**
 * 负责权限管理的文本层
 * 
 * @author Administrator
 *
 */
@RequestMapping("/manage")
@Controller
public class Manage {

	@Autowired
	private IFunctionService funcService;

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IRoleFunction rolefunctionService;
	@Autowired
	private IUserRoleDao UserRoleDao;
	/**
	 * 跳转到权限页面
	 * 
	 * @return
	 */
	@RequestMapping("/manage")
	private String manage() {

		return "system/manage";
	}

	/**
	 * 获取用户树状菜单
	 */
	@RequestMapping("/menu")
	@ResponseBody
	public JsonResult menu(Integer id, HttpSession session) {
		// 从Session中获取角色信息 以角色信息
		List<Role> roles = (List<Role>) session.getAttribute("roles");

		// 将用户id和角色信息 进行查询
		List<Function> list = funcService.findByRoles(id, roles);

		// 创建一个map集合 用来存放查询到的信息
		List<Map<String, Object>> menu = new ArrayList<>();
		// 把功能权限信息转换为符合easyui-tree结构的数据
		for (Function function : list) {
			Map<String, Object> map = new HashMap<>();
			// 将方法的id和名字拿出来
			map.put("id", function.getId());
			map.put("text", function.getFuncname());
			// 判断权限是否有页面
			if (function.getFuncurl() != null && !function.getFuncurl().isEmpty()) {
				// 如果有页面就给前端一个属性
				map.put("state", "open");
				Map<String, Object> attributes = new HashMap<>();
				attributes.put("url", function.getFuncurl());
				map.put("attributes", attributes);
			} else {
				map.put("state", "closed");
			}
			menu.add(map);

		}

		return JsonResult.buildSuccessResult("加载成功", menu);
	}

	/**
	 * 将当前用户的所有的权限拿出来
	 */
	@RequestMapping("/root")
	@ResponseBody
	public JsonResult maneger(HttpServletRequest request, PageBean<Function> pageBean) {
		// 拿到总记录数
		int i = funcService.count(pageBean.getCondition());
		// 查询用户的权限
		List<Function> list = funcService.findByPage(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition());
		pageBean.setTotal(i);
		pageBean.setResult(list);
		System.out.println(pageBean);
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}

	/**
	 * 增加权限页面
	 */
	@RequestMapping("/addfunction")
	public ModelAndView addFunction(ModelAndView mv) {
		// 查询所有没有父类的权限
		List<Function> list = funcService.getNOparentId();
		mv.addObject("list", list);
		mv.setViewName("system/addandmodfunction");
		return mv;
	}

	/**
	 * 增加权限的方法和修改权限的方法
	 */
	@PostMapping("addfun")
	@ResponseBody
	public JsonResult addfunction(Function function, HttpSession session) {
		// 判断前端传来的对象 是否有id 没有就是增加反之就是修改
		if (function.getId() != null) {
			function.setUpdatetime(new Date());
			function.setUpdateby(((User) session.getAttribute("user")).getId());
			boolean b = funcService.updateFuncyion(function);
			if (b) {
				return JsonResult.buildSuccessResult("修改成功!");
			}
			return JsonResult.buildSuccessResult("修改成功!");
		}
		// 判断前端数据 加以修改
		if (function.getParentid() == -1) {
			function.setParentid(null);
		}
		function.setCreatetime(new Date());
		function.setCreateby(((User) session.getAttribute("user")).getId());

		// 进行保存
		boolean b = funcService.insert(function);
		if (b) {
			return JsonResult.buildSuccessResult("插入成功!");
		}
		System.out.println(function);

		return JsonResult.buildSuccessResult("失败了");
	}

	/**
	 * 修改权限信息
	 */
	@RequestMapping("edit")
	@ResponseBody
	public ModelAndView edit(@RequestParam("funcid") Integer id, ModelAndView mv) {
		Function function = funcService.getFunction(id);
		// 查询所有没有父类的权限
		List<Function> list = funcService.getNOparentId();
		mv.addObject("list", list);
		mv.addObject("function", function);
		mv.setViewName("system/addandmodfunction");

		return mv;
	}

	/**
	 * 根据id删除一个权限的方法
	 */
	@RequestMapping("deletaid")
	@ResponseBody
	public JsonResult deleteFunctionId(@RequestParam("id") Integer id) {

		boolean b = funcService.deleteId(id);

		if (b) {

			return JsonResult.buildSuccessResult("删除成功");
		}

		return JsonResult.buildSuccessResult("删除失败");
	}

	/**
	 * 分页拿到所有的角色
	 */
	@RequestMapping("getroles")
	@ResponseBody
	public JsonResult zuanRoles(PageBean<Role> pageBean) {
		// 得到总记录数
		int i = roleService.count(pageBean.getCondition());
		List<Role> list = roleService.findByPage(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition());

		pageBean.setTotal(i);
		pageBean.setResult(list);
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}

	/**
	 * 增加角色页面
	 */
	@RequestMapping("addroles")
	public ModelAndView addRoles(ModelAndView mv) {
		// 查询所有没有父类的权限
		// List<Role> list = roleService.findState();
		List<Function> list = funcService.findAll();
		mv.addObject("list", list);
		mv.setViewName("system/addandeitdrole");
		return mv;
	}

	/**
	 * 增加角色和修改角色的方法
	 */
	@PostMapping("roles")
	@ResponseBody
	public JsonResult addroles(Role role, HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		// 判断有没有id值 有就是进行修改没有就是新增
		if (role.getId() != null) {
			role.setUpdateby(user.getId());
			role.setUpdatetime(new Date());

			String parameter = request.getParameter("func");
			String[] split = parameter.split(",");
			List<RoleFunction> list = new ArrayList<>();

			// Integer id = roleService.saveRetunId(role);
			for (String str : split) {
				Integer i = Integer.valueOf(str);
				RoleFunction roleFunction = new RoleFunction();
				roleFunction.setRoleid(role.getId());
				roleFunction.setFuncid(i);
				list.add(roleFunction);
			}
			// 调用修改的方法
			boolean b = rolefunctionService.updateFunction(list);
			if (b) {
				return JsonResult.buildSuccessResult("修改成功!");
			}
			return JsonResult.buildSuccessResult("修改成功!");
		}

		// 将数据插入到数据库
		role.setCreateby(user.getId());
		role.setCreatetime(new Date());
		String parameter = request.getParameter("func");

		String[] split = parameter.split(",");
		List<RoleFunction> list = new ArrayList<>();
		// 保存角色返回id
		Integer id = roleService.saveRetunId(role);
		for (String str : split) {
			Integer i = Integer.valueOf(str);
			RoleFunction roleFunction = new RoleFunction();
			roleFunction.setRoleid(id);
			roleFunction.setFuncid(i);
			list.add(roleFunction);
		}
		boolean b = rolefunctionService.updateFunction(list);
		if (b) {
			return JsonResult.buildSuccessResult("插入成功!");
		}

		return JsonResult.buildSuccessResult("失败了");
	}

	/**
	 * 修改角色信息
	 * 
	 * @throws JsonProcessingException
	 */
	@RequestMapping("editrole")
	@ResponseBody
	public ModelAndView editRole(@RequestParam("roleid") Integer id, ModelAndView mv) throws JsonProcessingException {
		Role role = roleService.get(id);
		// 查询所有可用的权限
		List<Function> list = funcService.findAll();
		// 查询选择的权限
		List<RoleFunction> list2 = rolefunctionService.getRoleFunction(id);

		mv.addObject("list", list);
		StringBuffer sb = new StringBuffer();

		for (RoleFunction roles : list2) {
			sb.append(roles.getFuncid() + ",");
		}
		System.out.println(sb);
		sb.append(-2);
		ObjectMapper mapper = new ObjectMapper();
		// String json = mapper.writeValueAsString(s);

		mv.addObject("list2", sb);
		mv.addObject("role", role);
		mv.setViewName("system/addandeitdrole");

		return mv;
	}

	/*
	 * 删除角色的方法
	 */
	@RequestMapping("deletaroleid")
	@ResponseBody
	public JsonResult deletaroleid(@RequestParam("id") Integer id) {

		boolean b = roleService.deleteId(id);

		if (b) {

			return JsonResult.buildSuccessResult("删除成功");
		}

		return JsonResult.buildSuccessResult("删除失败");

	}
	/**
	 *拿到所有的用户信息 
	 */
	@RequestMapping("users")
	@ResponseBody
	public JsonResult zuanusers(PageBean<User> pageBean) {
		//拿到总记录数
		int i = userService.count(pageBean.getCondition());
		List<User> list = userService.findByPage(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition());
		pageBean.setTotal(i);
		pageBean.setResult(list);
		
		
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	/**
	 * 新增用户
	 */
	@RequestMapping("addusers")
	public String addusers() {
		
		return "system/adduser";
	}
	/**
	 * 修改用户页面
	 */
	@RequestMapping("edituser")
	public ModelAndView edituUser(@RequestParam("userid")Integer id,ModelAndView mv,HttpSession session){
		User user = userService.get(id);
		session.setAttribute("user1", user);
		mv.addObject("user", user);
		mv.setViewName("system/user");
		return mv;
	} 
	
	/**
	 * 分配角色页面
	 */
	@RequestMapping("fenroles")
	@ResponseBody
	public ModelAndView fenRoles(@RequestParam("id") Integer id, ModelAndView mv){
			
			User user = userService.get(id);
		List<Role> list= roleService.findByUserId(id);
		//Role role = roleService.get(id);
			// 查询所有可用的角色
			List<Role> findAll = roleService.selectAll();
	

			StringBuffer sb = new StringBuffer();

			for (Role roles : list) {
				
				sb.append(roles.getId() + ",");
			}
			System.out.println(sb);
			sb.append(-2);
			mv.addObject("user2",user);
			mv.addObject("list", findAll);
			mv.addObject("list2", sb);
			mv.setViewName("system/fenroles");

			return mv;
		
	}
	/**
	 * 保存修改分配角色信息
	 * @param role
	 * @param session
	 * @param request
	 * @return
	 */
	@PostMapping("edituser")
	@ResponseBody
	public JsonResult edituserroles(@RequestParam("id") Integer id, HttpSession session, HttpServletRequest request) {
		//User user = (User) session.getAttribute("user");
		// 判断有没有id值 有就是进行修改没有就是新增
		if (id != null) {
			
			String parameter = request.getParameter("func");
			String[] split = parameter.split(",");
			List<UserRole> list = new ArrayList<>();

			// Integer id = roleService.saveRetunId(role);
			for (String str : split) {
				Integer i = Integer.valueOf(str);
				UserRole userRole = new UserRole();
				userRole.setUserid(id);
				userRole.setRoleid(i);
				/*RoleFunction roleFunction = new RoleFunction();
				roleFunction.setRoleid(id);
				roleFunction.setFuncid(i);*/
				list.add(userRole);
			}
			// 调用修改的方法
			UserRoleDao.deleteByUserId(id);
			int i = UserRoleDao.insertBatch(list);
			//boolean b = rolefunctionService.updateFunction(list);
			if (i>0) {
				return JsonResult.buildSuccessResult("修改成功!");
			}
			return JsonResult.buildSuccessResult("修改成功!");
		}
		return null;
	}
	/**
	 * 注销功能
	 * 
	 */
	@RequestMapping("colesa")
	@ResponseBody
	public JsonResult colesa(HttpSession session){
		
		session.removeAttribute("user");
		session.removeAttribute("user1");
		session.removeAttribute("user2");
		session.removeAttribute("role");
		session.removeAttribute("function");
		session.invalidate();
		return JsonResult.buildSuccessResult("login.jsp");
		
		
	}
	
}
