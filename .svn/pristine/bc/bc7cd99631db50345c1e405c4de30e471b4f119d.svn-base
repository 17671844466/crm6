package com.zhidisoft.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IMessageService;
import com.zhidisoft.system.service.IUserService;

@Controller
@RequestMapping("/system/message")
public class MessageController
{
	@Autowired
	private IMessageService messageService;
		
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/message")
	public String index(){
		return "system/message";
	}
	
	@RequestMapping("/fingByPage")
	@ResponseBody
	public JsonResult fingByPage(PageBean<Map<String,Object>> pageBean){
		//根据条件查询符合条件的总记录数
		int total = messageService.count(pageBean.getCondition());
		
		pageBean.setTotal(total);
		
		//分页查询所有记录
	
		List<Map<String,Object>> data = messageService.findMapByPage(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
		//添加记录
		pageBean.setResult(data);
		//返回结果
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	@GetMapping("/read")
	public ModelAndView read(@RequestParam("messageId")Integer messageId){
		//根据Id查找信息详情
		Map<String,Object> message = messageService.getMessage(messageId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("system/read");
		mv.addObject("message", message);
		return mv;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public JsonResult delete(PageBean<Map<String,Object>> pageBean){
		//根据id执行删除操作
		boolean b = messageService.delete(pageBean.getCondition());
		return JsonResult.buildSuccessResult("删除成功", b);
	}
	
	@RequestMapping("/write")
	public String write(){
		return "system/write";
	}
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public JsonResult getUsers(Integer id){
		
		List<User> users = userService.findUser(id);
		
		return JsonResult.buildSuccessResult("查询成功",users);
	}
	
	
	//发送信息
	@RequestMapping("/sendMessage")
	@ResponseBody
	public JsonResult send(String toUsersId,String content,Integer fromUserId){
		//将传过来的字符串进行分割
		String[] users = toUsersId.split(",");
		for(String toUserId : users){
			if( !messageService.send(Integer.valueOf(toUserId), content, fromUserId)){
				return JsonResult.buildFailureResult("发送失败");
			}
		}
		return JsonResult.buildSuccessResult("发送成功");	
	}
}
