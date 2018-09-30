package com.zhidisoft.system.controller;




import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.common.CustomerContacts;
import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Customer;
import com.zhidisoft.system.entity.Leads;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IContactsService;
import com.zhidisoft.system.service.ICustomerService;
import com.zhidisoft.system.service.ILeadsService;
import com.zhidisoft.system.service.IUserService;

@Controller
@RequestMapping("/system/leads")
public class LeadsController {
	@Autowired
	private ILeadsService leadsService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private  ICustomerService customerService;
	
	@Autowired
	private  IContactsService contactsService;
	
	
	
	@RequestMapping("/leads")
	public String index(){
		return "system/listLeads";
	}
	
	
	@RequestMapping("/addLeads")
	public String index2(){
		return "system/addLeads";
	}
	
	@RequestMapping("/datailed")
	public String index3(){
		return "system/leadsInfo";
	}
	
	@RequestMapping("/editLeads")
		public String index4(){
			return "system/editLeads";
		}

	@RequestMapping("/leadsConversion")
	public String index5(){
		return "system/leadsConversion";
	}
	
	
	/**
	 * 分页查询用户信息
	 * @param pageNumber
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	@RequestMapping("/findByPage")
	@ResponseBody
	public JsonResult findByPage(PageBean<Map<String , Object>> pageBean,HttpSession session){
		
		
		int total = leadsService.count(pageBean.getCondition());
		List<Map<String , Object>> list = leadsService.findMapByPage(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
		
		pageBean.setTotal(total);
		pageBean.setResult(list);
		
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	//分页查询线索池
	@RequestMapping("/findByPageInPool")
	@ResponseBody
	public JsonResult findByPageInPool(PageBean<Map<String , Object>> pageBean){
			
		int total = leadsService.count(pageBean.getCondition());
		List<Map<String , Object>> list = leadsService.findMapByPageInPool(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
		
		
		pageBean.setTotal(total);
		pageBean.setResult(list);
		
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	//查询用户，负责人下拉框
	@RequestMapping("/listUser")
	@ResponseBody
	public JsonResult listUser(){
		List<User> list = userService.findAll();
		
		return JsonResult.buildSuccessResult("查询成功", list);
	}
	
	//保存线索
	@RequestMapping("/saveLeads")
	@ResponseBody
	public JsonResult saveLeads(Leads leads,HttpSession session,String province,String city,String district,String road){
		
			leads.setCreateTime(new Date());
			leads.setUpdateTime(new Date());
			leads.setHaveTime(new Date());
			String address = province+"-"+city+"-"+district+"-"+road;
			leads.setAddress(address);
			User user = (User) session.getAttribute("user");
			leads.setCreatorUserId(user.getId());

			
			boolean b = leadsService.save(leads);
				
			
			if (b) {
					return JsonResult.buildSuccessResult("创建成功");
				}else {
					return JsonResult.buildSuccessResult("创建失败");
				}
			}
			
		

	

		//删除线索
		@RequestMapping("/deleteLeads")
		@ResponseBody
		public JsonResult deleteLeads(String id,HttpSession session,Integer deleteStatus){
			String[] ids = id.split(",");
			int d = 0;
			for (String leadsId : ids) {
				int i = Integer.parseInt(leadsId);
				
				Leads leads = leadsService.get(i);
				if (deleteStatus!=null&&deleteStatus==1) {
					leads.setDeleteStatus(1);
				}

			//判断DeleteStatus
			if (leads.getDeleteStatus()==0) {
				leads.setDeleteStatus(1);
				leads.setDeleteTime(new Date());
				User user = (User) session.getAttribute("user");
				leads.setDeleteUserId(user.getId());
				boolean b = leadsService.update(leads);
				if (!b) {
					break;
				}
				d=1;
			}else {
				boolean b = leadsService.delete(i);
				if (!b) {
					break;
				}
				d=2;
			}
			
		}
		if (d==1) {
			return JsonResult.buildSuccessResult("您所选择的数据已放入回收站",1);
		}else if (d==2) {
			return JsonResult.buildSuccessResult("您所选择的数据已彻底删除",2);
		}else {
			return JsonResult.buildSuccessResult("删除失败",0);
		}
		
	}
	
		//查看详情
		@RequestMapping(value="/detail",method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView  detailed(ModelAndView model,String ownerName,Integer id){
			
			Leads leads = leadsService.get(id);
			Date date = leads.getNextstepTime();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextstepTime = simpleDateFormat.format(date);
			model.addObject("leads", leads);
			model.addObject("ownerUser", ownerName);
			model.addObject("nextstepTime", nextstepTime);
			model.setViewName("forward:datailed");
		    return model;
		}
	
		

		//查看修改页面
		@RequestMapping(value="/edit",method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView  edit(ModelAndView model,String ownerName,Integer id){
			
			Leads leads = leadsService.get(id);
			Date date = leads.getNextstepTime();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String nextstepTime = simpleDateFormat.format(date);
			String createTime = simpleDateFormat.format(leads.getCreateTime());
			String haveTime = simpleDateFormat.format(leads.getHaveTime());
			
			String address = (String) leads.getAddress();
			String[] addr = address.split("-");
		
			model.addObject("province", addr[0]);
			model.addObject("city", addr[1]);
			model.addObject("district", addr[2]);
			model.addObject("road", addr[3]);
			
			model.addObject("leads", leads);
			model.addObject("ownerUser", ownerName);
			model.addObject("nextstepTime", nextstepTime);
			model.addObject("createTime", createTime);
			model.addObject("haveTime", haveTime);
			model.setViewName("forward:editLeads");
		    return model;
		}

		
		
		//保存修改
		@RequestMapping("/updateLeads")
		@ResponseBody
		public JsonResult updateLeads(Leads leads,HttpSession session,String province,String city,String district,String road){
			
				leads.setUpdateTime(new Date());
				String address = province+"-"+city+"-"+district+"-"+road;
				leads.setAddress(address);
				
				boolean b = leadsService.update(leads);
				if (b) {
					return JsonResult.buildSuccessResult("修改成功");
				}else {
					return JsonResult.buildSuccessResult("修改失败");
				}
			
			}
		
		//领取线索
		@RequestMapping("/receive")
		@ResponseBody
		public JsonResult receive(Integer id,HttpSession session){
				Leads leads = leadsService.get(id);	
				leads.setUpdateTime(new Date());
				User user = (User) session.getAttribute("user");
				leads.setOwnerUserId(user.getId());		
				
				boolean b = leadsService.update(leads);
				if (b) {
					return JsonResult.buildSuccessResult("领取成功",1);
				}else {
					return JsonResult.buildSuccessResult("领取失败",2);
				}
				
			}
		
		
			//查看转化页面
				@RequestMapping(value="/conversion",method=RequestMethod.GET)
				@ResponseBody
				public ModelAndView  conversion(ModelAndView model,String ownerName,Integer id){
					
					Leads customer = leadsService.get(id);
					Date date = customer.getNextstepTime();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String nextstepTime = simpleDateFormat.format(date);
					String createTime = simpleDateFormat.format(customer.getCreateTime());
					String haveTime = simpleDateFormat.format(customer.getHaveTime());
					
					String address = (String) customer.getAddress();
					String[] addr = address.split("-");
				
					model.addObject("province", addr[0]);
					model.addObject("city", addr[1]);
					model.addObject("district", addr[2]);
					model.addObject("road", addr[3]);
					
					
					model.addObject("customer", customer);
					model.addObject("ownerUser", ownerName);
					model.addObject("nextstepTime", nextstepTime);
					model.addObject("createTime", createTime);
					model.addObject("haveTime", haveTime);
					model.setViewName("forward:leadsConversion");
				    return model;
				}
				
				//转换线索
				@PostMapping("/doConversion")
				@ResponseBody
				public JsonResult doConversion(String name,CustomerContacts cc,Integer leadsId) {
					
					
					User user = customerService.getCustomerByName(name);
					String address = cc.getProvince()+"-"+cc.getCity()+"-"+cc.getDistrict()+"-"+cc.getRoad();
					Customer customer = new Customer();
					customer = cc.getCustomer();
					customer.setOwnerUserId(user.getId());
					customer.setCreateTime(new Date());
					customer.setAddress(address);
					customer.setUpdateTime(new Date());
					customer.setDeleteStatus(0);
					customer.setIsLocked(0);
					
					Integer result = customerService.saveReturnId(customer);
					
					
					if(result>0) {
						cc.getContacts().setCustomerId(customer.getId());
						cc.getContacts().setCreateTime(new Date());
						cc.getContacts().setUpdateTime(new Date());
						boolean save = contactsService.save(cc.getContacts());
						
						
						Leads leads = leadsService.get(leadsId);
						leads.setIsTransformed(1);
						leads.setTransformUserId(customer.getCreatorUserId());
						leads.setCustomerId(customer.getId());
						leads.setContactsId(cc.getContacts().getId());
						leadsService.update(leads);
						
						if(save==true) {
							return JsonResult.buildSuccessResult("插入成功");
							
							
						}
					}
					return JsonResult.buildFailureResult("插入失败！");
				}
		
		
	
}
