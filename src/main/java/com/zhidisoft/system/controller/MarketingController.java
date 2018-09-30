package com.zhidisoft.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.EmailRecord;
import com.zhidisoft.system.entity.EmailTemplate;
import com.zhidisoft.system.entity.SmsRecord;
import com.zhidisoft.system.entity.SmsTemplate;
import com.zhidisoft.system.service.IEmailRecordService;
import com.zhidisoft.system.service.IEmailTemplateService;
import com.zhidisoft.system.service.ISmsRecordService;
import com.zhidisoft.system.service.ISmsTemplateService;

@Controller
@RequestMapping("/system/Marketing")
public class MarketingController
{
	@Autowired
	private ISmsTemplateService smsTemplateService;
	
	@Autowired
	private ISmsRecordService smsRecordService;
	
	@Autowired
	private IEmailTemplateService emailTemplateService;
	
	@Autowired
	private IEmailRecordService emailRecordService;
	
	@RequestMapping("/Marketing")
	public String index(){
		return "system/Marketing";
	}
	
	@RequestMapping("/smsTemAdd")
	public String smsTemAdd(){
		return "system/smsTemAdd";
	}
	
	@RequestMapping("/emailTemAdd")
	public String emailTemAdd(){
		return "system/emailTemAdd";
	}
	
	//差找所有短信模板
	@RequestMapping("/selectSmsTem")
	@ResponseBody
	public JsonResult selectSmsTem(PageBean<Map<String,Object>> pageBean){
		SmsTemplate smsTemplate = smsTemplateService.findByCondition(pageBean.getCondition());
		if(smsTemplate!=null){
			return JsonResult.buildSuccessResult("查询成功", smsTemplate);
		}else{
			return JsonResult.buildFailureResult("模板不存在");
		}
	}
	
	
	//向数据库添加短信模板
	@RequestMapping("/selectEmailTem")
	@ResponseBody
	public JsonResult selectEmailTem(PageBean<Map<String,Object>> pageBean){
		EmailTemplate emailTemplate = emailTemplateService.findByCondition(pageBean.getCondition());
		if(emailTemplate!=null){
			return JsonResult.buildSuccessResult("查询成功", emailTemplate);
		}else{
			return JsonResult.buildFailureResult("模板不存在");
		}
	}
	
	//添加短信模板
	@RequestMapping("/addSmsTemplate")
	@ResponseBody
	public JsonResult addSmsTemplate(String subject,Integer order,String content){
		//新建smsTem对象
		SmsTemplate smsTem= new SmsTemplate();
		smsTem.setSubject(subject);
		smsTem.setContent(content);
		smsTem.setOrderId(order);
		 
		if(smsTemplateService.save(smsTem)){
			return JsonResult.buildSuccessResult("模板保存成功");
		}else{
			return JsonResult.buildFailureResult("模板保存失败");
		}
	}
	
	
	
	//找所有短信模板并返回
	@RequestMapping("/findAllSmsTem")
	@ResponseBody
	public JsonResult findAllSmsTem(){
		List<SmsTemplate> tems = smsTemplateService.findAll();
		return JsonResult.buildSuccessResult("查询成功", tems);
	}
	
	//向数据库添加邮件模板
	@RequestMapping("/addEmailTemplate")
	@ResponseBody
	public JsonResult addEmailTemplate(String subject,String title,Integer order,String content){
		//新建smsTem对象
		EmailTemplate emailTem= new EmailTemplate();
		emailTem.setSubject(subject);
		emailTem.setTitle(title);
		emailTem.setContent(content);
		emailTem.setOrderId(order);
		 
		if(emailTemplateService.save(emailTem)){
			return JsonResult.buildSuccessResult("模板保存成功");
		}else{
			return JsonResult.buildFailureResult("模板保存失败");
		}
	}
	
	//找所有邮件模板并返回
	@RequestMapping("/findAllEmailTem")
	@ResponseBody
	public JsonResult findAllEmailTem(){
		List<EmailTemplate> tems = emailTemplateService.findAll();
		return JsonResult.buildSuccessResult("查询成功", tems);
	}
	
	//发送短信
	@RequestMapping("/sendSms")
	@ResponseBody
	public JsonResult sendSms(String messageTo,Integer userId,String content){
		if(smsRecordService.sendSms(messageTo,userId,content)){
			return JsonResult.buildSuccessResult("发送成功");
		}else{
			return JsonResult.buildFailureResult("发送失败");
		}
	}
	
	//发送邮件
	@RequestMapping("/sendEmail")
	@ResponseBody
	public JsonResult sendEmail(String emailTo,String title,Integer userId,String content){
		if(emailRecordService.sendEmail(emailTo,title,userId,content)){
			return JsonResult.buildSuccessResult("发送成功");
		}else{
			return JsonResult.buildFailureResult("发送失败");
		}
	}
	
	//夫人也查询已发信息
	@RequestMapping("/fingSmsByPage")
	@ResponseBody
	public JsonResult fingSmsByPage(PageBean<Map<String,Object>> pageBean){
		//查询总记录数
		int total =smsRecordService.count(pageBean.getCondition());
		
		//根据条件查询结果
		List<Map<String, Object>> data = smsRecordService.findSmsByPage(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
		pageBean.setTotal(total);
		pageBean.setResult(data);
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	//批量删除已发短信
	@RequestMapping("/deleteSms")
	@ResponseBody
	public JsonResult deleteSms(String smsIds){
		//将传过来的字符串进行分割
				String[] smsId = smsIds.split("-");
				for(String sms : smsId){
					Integer id = Integer.valueOf(sms);
					if( !smsRecordService.delete(id)){
						return JsonResult.buildFailureResult("删除失败");
					}
				}
				return JsonResult.buildSuccessResult("删除成功");
	}
	
}
