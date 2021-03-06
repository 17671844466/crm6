package com.zhidisoft.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;
import com.zhidisoft.common.DateUtil;
import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Business;
import com.zhidisoft.system.entity.Task;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IBusinessService;
import com.zhidisoft.system.service.ITaskService;
/**
 * 任务版块
 * 钟晶
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/task")
@SuppressWarnings("all")
public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	@Autowired
	private IBusinessService businessService;
	
	@GetMapping("/task")
	public String toTask(){
		return "system/task";
	}
	
	@PostMapping("/task")
	public void index(){
		
	}
	
	/**
	 * 删除功能
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult Delete(String id,Task task,HttpSession session){
		task.setCreateDate(new Date());
		task.setDeleteTime(new Date());
		User user = (User) session.getAttribute("user");
		task.setCreatorUserId(user.getId());
		boolean data = taskService.delete(Integer.valueOf(id));
		if(data){
			return JsonResult.buildSuccessResult("删除成功", data);
		}else
			return JsonResult.buildFailureResult("删除失败");
	}
	
	/**
	 * 下拉框查询表格数据
	 * @return
	 */
	@PostMapping("/findAll")
	@ResponseBody
	public JsonResult findAll(){
		List<Map<String, Object>> list=taskService.findAlls();
		List<String> keys = new ArrayList<>();
		List<Object> values=new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("keys", keys);
		map.put("values", values);
		Iterator<Entry<String, Object>> iterator = list.get(0).entrySet().iterator();
		while (iterator.hasNext()) {
			keys.add(iterator.next().getKey());
			values.add(iterator.next().getValue());
		}
		list.add(map);
		return JsonResult.buildSuccessResult("查询成功", list);
	}
	
	
	/**
	 * 任务页面分页、搜索框查询
	 * @return
	 */
	@RequestMapping("/findByPage")
	@ResponseBody
	public JsonResult findByPage(PageBean<Map<String, Object>> pagebean){
		int total = taskService.count(pagebean.getCondition());
		List<Map<String, Object>> list=taskService.findByPage(pagebean.getPage(),pagebean.getRows(),pagebean.getCondition());
		for (Map map : list) {
			Date before =(Date)map.get("due_date");
			int diffDate=0;
			if(before !=null ){
				System.out.println(before);
				diffDate = DateUtil.diffDate(before, new Date());
				System.out.println(diffDate);
			}
			diffDate=30-diffDate;
			
			map.put("overDates", diffDate);
		}
		pagebean.setTotal(total);
		pagebean.setResult(list);
		return JsonResult.buildSuccessResult("查询成功", pagebean);
	}
	
	
	/**
	 * 修改任务
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public ModelAndView editTask(@RequestParam("id")Integer id){
		Task task = taskService.get(id);
		ModelAndView view = new ModelAndView();
		view.setViewName("system/editTask");
		view.addObject("task", task);
		return view;
	}
	
	/**
	 * 修改任务
	 */
	@RequestMapping("/updateTask")
	@ResponseBody
	public JsonResult updateTask(Task task,HttpSession session){
		task.setCreateDate(new Date());
		task.setUpdateDate(new Date());
		User user = (User) session.getAttribute("user");
		task.setCreatorUserId(user.getId());
		boolean data = taskService.update(task);
		if(data){
			return JsonResult.buildSuccessResult("修改成功");
		}
			return JsonResult.buildSuccessResult("修改失败");
	}
	
	/**
	 * 新建任务
	 */
	@RequestMapping("/addTask")
	public String add(){
		return "system/addTask";
	}
	
	/**
	 * 负责人下拉框功能
	 */
	@RequestMapping("/subject1")
	@ResponseBody
	public JsonResult addSubject1(){
		List<Task> data = taskService.findAll();
		List<Map<String, Object>> list = new ArrayList<>();
		for (Task task : data) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", task.getId());
			map.put("text", task.getOwnerUserId());
			list.add(map);
		}
		return JsonResult.buildSuccessResult("查询成功", list);
	}
	
	/**
	 * 任务相关人下拉框
	 * @return
	 */
	@RequestMapping("/subject2")
	@ResponseBody
	public JsonResult addSubject2(){
		List<Task> data = taskService.findAll();
		List<Map<String, Object>> list = new ArrayList<>();
		for (Task task : data) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", task.getId());
			map.put("text", task.getAboutUsers());
			list.add(map);
		}
		return JsonResult.buildSuccessResult("查询成功", list);
	}
	
	
	/**
	 * 获取关联商机表名称属性
	 */
	@RequestMapping("/addBussiness")
	@ResponseBody
	public JsonResult addBussiness(){
		List<Business> data = businessService.findAll();
		List<Map<String, Object>> list=new ArrayList<>();
		for (Business business:data) {
			Map<String, Object> map=new HashMap<>();
			map.put("id", business.getId());
			map.put("text",business.getName());
			list.add(map);
		}
		return JsonResult.buildSuccessResult("查询成功", list);
	}
	
	/**
	 * 新建任务
	 * @param task
	 * @param session
	 * @return
	 */
	@PostMapping("/save")
	@ResponseBody
	public JsonResult save(Task task,HttpSession session){
		task.setCreateDate(new Date());
		task.setUpdateDate(new Date());
		task.setDeleteTime(new Date());
		User user = (User)session.getAttribute("user");
		
		task.setCreatorUserId(user.getId());
		boolean data = taskService.save(task);
		if(data){
		return JsonResult.buildSuccessResult("保存成功");
		}
		return JsonResult.buildSuccessResult("保存失败");
	}
}
