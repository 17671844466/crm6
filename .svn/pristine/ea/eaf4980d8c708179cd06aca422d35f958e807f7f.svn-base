package com.zhidisoft.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSException;

import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Business;
import com.zhidisoft.system.entity.Leads;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IBusinessService;
import com.zhidisoft.system.service.IUserService;



@Controller
@RequestMapping("/system/business")
public class BusinessController  {
        
       @Autowired	
	  private IBusinessService businessService;
       @Autowired
       private IUserService userService;
	private Integer total;
	   
        /**
         * 转向到addBusiness.jsp页面
         * @return
         *  
         */
         @RequestMapping("/business")  
        public String toListPage(){
            
        	return "system/listBusiness";
        	
        }
         
         /**
          *  转向到editBusiness.jsp页面
          * @param id
          * @return
          */
        
       @RequestMapping("/addBusiness") 	
        public String toPage(){
        	return "system/addBusiness";
        }
       
         
    
       /**
        *  跳转到修改页面
        * @return
        */
        @RequestMapping("/editBusiness")
        public String edit(){
        	return "system/editBusiness";
        	
        }
        
        /**
         *  跳转到推进
         * @return
         */
        @RequestMapping("/acc")
        public String acc(){
        	
        	
        	return "system/accBusiness";
        }
         
       
       /**
        *   分页查询商机信息
        * @param pageNumber
        * @param pageSize
        * @param condition
        * @return
        */
	 @RequestMapping("/findByPage")
	 @ResponseBody
	 public JsonResult findByPage(PageBean<Map<String, Object>>pageBean){
		  //获取总记录数 
		 int total= businessService.count(pageBean.getCondition());
		 //每页展示的数据 
		 List<Map<String, Object>> list= businessService.findMapByPage(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
	
		  pageBean.setTotal(total);
		  pageBean.setResult(list);
		  
		  
		  return JsonResult.buildSuccessResult("查询成功", pageBean);
		 
		 
	 }
	 
	   @RequestMapping("/listUser")
		@ResponseBody
		public JsonResult listUser(){
			List<User> list = userService.findAll();
			
			return JsonResult.buildSuccessResult("查询成功", list);
		}
		
	   
	   @RequestMapping("/findByPages")
	   @ResponseBody
	   public JsonResult findByPages(PageBean<Map<String, Object>>pageBean){
		   List<Map<String, Object>> list = businessService.findMapByPages(pageBean.getPage(), pageBean.getRows(), pageBean.getCondition());
		  
		 pageBean.setTotal(total);
		 pageBean.setResult(list); 
		    
		   return JsonResult.buildSuccessResult("查询成功", pageBean);
		   
		     
	   }
	  
	 
	 /**
	  *  删除功能 
	  * @param id
	  * @return
	  */
	 @RequestMapping("delete")
	 @ResponseBody
	 public JsonResult Remove(Integer id){
	   boolean b = businessService.delete(id);
	   if (b) {
		 return JsonResult.buildSuccessResult("删除成功",b);
	}else{
		return JsonResult.buildSuccessResult("删除失败");
		
	}	 
	 }
	 
	  //保存修改
	 @RequestMapping("/updateBusiness")
	 @ResponseBody
	 public JsonResult updateBusiness(Business business,HttpSession session){
	/*	business.setCreateTime(new Date());
		business.setUpdateTime(new Date());  */
	
		 boolean b = businessService.update(business);
		 if (b) {
				return JsonResult.buildSuccessResult("修改成功",b);
			}else {
				return JsonResult.buildSuccessResult("修改失败");
			}
		 
	
	 }
	 
	 /**
	  *  商机推进
	  * @param business
	  * @return
	  */
	 @RequestMapping("/advance")
	 @ResponseBody
	 public JsonResult advance(Business business,HttpSession session){
	      
	       business.setUpdateTime(new Date());
	       business.setNextstepTime(new Date());
	       business.setContactsId(1);
	       business.setName("");
	      business.setEstimatePrice(Double.valueOf(0));
	   
	      
		 boolean b = businessService.save(business);
		 if (b) {
			return JsonResult.buildSuccessResult("推进成功",b);
		}else{
			
			return JsonResult.buildSuccessResult("推进失败");
		}
		 
	 }
	 
	
	 /**
	  *    添加商机保存
	  * @param business
	  * @return
	  */
 
	  @RequestMapping("/saveBusiness")
	  @ResponseBody
	 public JsonResult saveBusiness(Business business,HttpSession session){
	      
	      business.setEstimatePrice(Double.valueOf(0));
		  business.setUpdateTime(new Date());
		  business.setCreateTime(new Date());
		  business.setNextstepTime(new Date());
		  business.setContactsId(2);
		  business.setCustomerId(1);
		  business.setNextstep("成交");
		  business.setOrigin("网络营销");	
		  
		  
	   boolean b = businessService.save(business);
	   if (b) {
		 return JsonResult.buildSuccessResult("保存成功");
	}else{
		
		return JsonResult.buildSuccessResult("保存失败");
	}
		
		
		 
		  
	 }
	
	  //查看修改页面 
	  @RequestMapping(value="/edit",method=RequestMethod.GET)
	  @ResponseBody
	public ModelAndView edit(ModelAndView mode1,String ownerName,Integer id){
		
		Business business = businessService.get(id);
		Date date = business.getNextstepTime();
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM--dd");
		String nextstepTime = sFormat.format(date);
		String createTime = sFormat.format(business.getCreateTime());
		mode1.addObject("business", business);
		mode1.addObject("ownerUser",ownerName);
	    mode1.addObject("nextstepTime",nextstepTime);
	    mode1.addObject("createTime", createTime);
		mode1.setViewName("forward:editBusiness");
		
		return mode1;
		
		
		
	}
	
	  		
       
		//查看详情
		@RequestMapping(value="/detail",method=RequestMethod.GET)
		@ResponseBody
		public ModelAndView detailed(@RequestParam("id")Integer id){
		Business business=  businessService.get(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("business", business);
		mv.setViewName("system/listBusiness");
	
			return mv;
		}  
}
