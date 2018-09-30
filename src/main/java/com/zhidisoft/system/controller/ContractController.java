package com.zhidisoft.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.service.IContractService;

@Controller
@RequestMapping("system/contract")
public class ContractController {
	@Autowired
	IContractService contractService;
	@GetMapping("/list")
	public String tolist() {
		return "system/listContract";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public JsonResult list(PageBean<Map<String, Object>> pageBean) {
		System.out.println("---------------------------------------");
		pageBean.setTotal(contractService.count(pageBean.getCondition()));
		pageBean.setResult(contractService.findAllMap(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition()));
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	@GetMapping("/addcontract")
	public String toadd() {
		return "system/addContract";
	}
}
