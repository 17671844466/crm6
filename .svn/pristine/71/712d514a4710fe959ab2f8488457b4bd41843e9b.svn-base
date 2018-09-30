package com.zhidisoft.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.common.CustomerContacts;
import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Customer;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IContactsService;
import com.zhidisoft.system.service.ICustomerService;

@Controller
@RequestMapping("system/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	@Autowired
	IContactsService contactsService;
	@GetMapping("/customers")
	public String tocus() {
		return "system/listCustomer";
	}
	/**
	 * 分页获取所有数据
	 * @param pageBean
	 * @return
	 */
	@PostMapping("/findByPage")
	@ResponseBody
	public JsonResult findByPage(PageBean<Map<String, Object>> pageBean) {
		List<Map<String, Object>> cus = customerService.findByPageMap(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition());
		pageBean.setTotal(customerService.count(pageBean.getCondition()));
		pageBean.setResult(cus);
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	/**
	 * 分页获取所有客户池数据
	 * @param pageBean
	 * @return
	 */
	@PostMapping("/findByPages")
	@ResponseBody
	public JsonResult findByPages(PageBean<Map<String, Object>> pageBean) {
		List<Map<String, Object>> cus = customerService.findByPageMaps(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition());
		System.out.println("--------------------------"+cus.size());
		pageBean.setTotal(customerService.countpool(pageBean.getCondition()));
		pageBean.setResult(cus);
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	/**
	 * 保存数据
	 * @param name - 负责人名称
	 * @param cc
	 * @return
	 */
	@PostMapping("/saveCustomer")
	@ResponseBody
	public JsonResult saveCustomer(String name,CustomerContacts cc) {
		Customer customer = cc.getCustomer();
		if(name!=null && !name.isEmpty()) {
			User user = customerService.getCustomerByName(name);
			customer.setOwnerUserId(user.getId());
		}
		String address = cc.getProvince()+"-"+cc.getCity()+"-"+cc.getDistrict()+"-"+cc.getRoad();
		customer.setCreateTime(new Date());
		customer.setAddress(address);
		customer.setUpdateTime(new Date());
		customer.setDeleteStatus(0);
		customer.setIsLocked(0);
		Integer result = customerService.saveReturnId(customer);
		if(result>0 && cc.getContacts()!=null) {
			cc.getContacts().setCustomerId(customer.getId());
			cc.getContacts().setCreateTime(new Date());
			cc.getContacts().setUpdateTime(new Date());
			boolean save = contactsService.save(cc.getContacts());
			if(save==true) {
				return JsonResult.buildSuccessResult("插入成功");
			}
		}
		return JsonResult.buildFailureResult("插入失败！");
	}
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	@PostMapping("/delCustomer")
	@ResponseBody
	public JsonResult delCustomer(Integer id) {
		boolean result = customerService.deleteStatus(id);
		contactsService.deletecontacts(id);
		if(result) {
			return JsonResult.buildSuccessResult("删除成功");
		}
		return JsonResult.buildFailureResult("删除失败");
	}
	/**
	 * 转向编辑页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/editcustomer")
	public ModelAndView editcustomer(Integer id) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> customer = customerService.getCustomerById(id);
		String address = (String) customer.get("address");
		String[] addr = address.split("-");
		Integer size = addr.length;
		System.out.println(size);
		switch (size) {
		case 1:
			customer.put("province", addr[0]);
			break;
		case 2:
			customer.put("province", addr[0]);
			customer.put("city", addr[1]);
			break;
		case 3:
			customer.put("province", addr[0]);
			customer.put("city", addr[1]);
			customer.put("district", addr[2]);
			break;
		default:
			customer.put("province", addr[0]);
			customer.put("city", addr[1]);
			customer.put("district", addr[2]);
			customer.put("road", addr[3]);
			break;
		}
		
		mv.addObject("customer", customer);
		mv.setViewName("system/editCustomer");
		return mv;
	}
	/**
	 * 更新数据
	 * @param name
	 * @param cc
	 * @return
	 */
	@PostMapping("/updateCustomer")
	@ResponseBody
	public JsonResult updateCustomer(String name,CustomerContacts cc) {
		User user = customerService.getCustomerByName(name);
		String address = cc.getProvince()+"-"+cc.getCity()+"-"+cc.getDistrict()+"-"+cc.getRoad();
		Customer customer = cc.getCustomer();
		customer.setOwnerUserId(user.getId());
		customer.setAddress(address);
		customer.setUpdateTime(new Date());
		customer.setDeleteStatus(0);
		customer.setIsLocked(0);
		Integer result = customerService.updateCustomer(customer);
		if(result>0) {
			cc.getContacts().setUpdateTime(new Date());
			cc.getContacts().setCustomerId(customer.getId());
			cc.getContacts().setDeleteStatus(0);
			boolean save = contactsService.update(cc.getContacts());
			if(save==true) {
				return JsonResult.buildSuccessResult("修改成功");
			}
		}
		return JsonResult.buildFailureResult("修改失败！");
	}
	/**
	 * 转向添加数据页面
	 * @return
	 */
	@GetMapping("/addcustomer")
	public String toaddcustomer() {
		return "system/addCustomer";
	}
	/**
	 * 领取、分配客户
	 * @param id
	 * @param owner
	 * @return
	 */
	@PostMapping("/receive")
	@ResponseBody
	public JsonResult receive(Integer id,Integer owner) {
		Date updateTime = new Date();
		boolean result = customerService.receive(id,owner,updateTime);
		if(result) {
			return JsonResult.buildSuccessResult("领取成功");
		}
		return JsonResult.buildFailureResult("发生未知错误");
	}
	@PostMapping("/delscustomer")
	@ResponseBody
	public JsonResult delscustomer(String  ids) {
		List<Integer> id = new ArrayList<>();
		for (String i : ids.split(",")) {
			id.add(Integer.valueOf(i));
		}
		boolean result = customerService.delscustomer(id);
		contactsService.delscontacts(id);
		if(result) {
			return JsonResult.buildSuccessResult("删除成功");
		}
		return JsonResult.buildFailureResult("删除失败");
	}
}
