package com.zhidisoft.system.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Contacts;
import com.zhidisoft.system.service.IContactsService;

@Controller
@RequestMapping("system/contacts")
public class ContactsController {
	@Autowired
	IContactsService contactsService;
	/**
	 * 分页查询联系人数据
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/findByPages")
	@ResponseBody
	public JsonResult findByPageMap(PageBean<Map<String, Object>> pageBean) {
		pageBean.setResult(contactsService.findByPageMap(pageBean.getOffset(),pageBean.getRows(),pageBean.getCondition()));
		pageBean.setTotal(contactsService.count(pageBean.getCondition()));
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	/**
	 * 转向编辑联系人页面
	 * @param id
	 * @return
	 */
	@GetMapping("/editContacts")
	public ModelAndView toEdit(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contacts", contactsService.get(id));
		mv.setViewName("system/editContacts");
		return mv;
	}
	/**
	 * 更新联系人
	 * @param contacts
	 * @return
	 */
	@PostMapping("/editContacts")
	@ResponseBody
	public JsonResult edit(Contacts contacts) {
		boolean b = contactsService.updateMore(contacts);
		if(b) {
			return JsonResult.buildSuccessResult("修改成功！");
		}
		return JsonResult.buildFailureResult("修改失败");
	}
}
