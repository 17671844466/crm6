package com.zhidisoft.system.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Data;
import com.zhidisoft.common.JsonResult;
import com.zhidisoft.common.PageBean;
import com.zhidisoft.system.entity.Leads;
import com.zhidisoft.system.entity.Product;
import com.zhidisoft.system.entity.ProductCategory;
import com.zhidisoft.system.entity.ProductImages;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IProductCategoryService;
import com.zhidisoft.system.service.IProductService;

@Controller
@RequestMapping("/system/product")
public class ProductController {

	
	@Autowired
	private IProductCategoryService productCategoryService;
	
	
	@Autowired
	private IProductService productService;
	
	
	
	
	
	//跳转页面
	@RequestMapping("/product")
	public String index(){
		return "system/listProduct";
	}
	
	@RequestMapping("/addProCategory")
	public String index1(){
		return "system/addProCategory";
	}
	
	
	@RequestMapping("/editCategory")
	public String index2(){
		return "system/editCategory";
	}
	
	@RequestMapping("/addPro")
	public String index3(){
		return "system/addProduct";
	}
	
	
	
	
	
	
	
	
	
	//分页查询
	@RequestMapping("/findByPage")
	@ResponseBody
	public JsonResult findByPage(PageBean<Map<String , Object>> pageBean,HttpSession session){
		
		int total = productCategoryService.count(pageBean.getCondition());
		List<Map<String , Object>> list = productCategoryService.findMapByPage(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
		
		pageBean.setTotal(total);
		pageBean.setResult(list);
		
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	//下拉框查询分类
	@RequestMapping("/listCategory")
	@ResponseBody
	public JsonResult listCategory(){
		List<ProductCategory> list = productCategoryService.findAll();
		
		return JsonResult.buildSuccessResult("查询成功", list);
	}
	
	
	//保存分类
	@RequestMapping("/saveCategory")
	@ResponseBody
	public JsonResult saveCategory(ProductCategory category){
		boolean b = productCategoryService.save(category);
		
			if (b) {
					return JsonResult.buildSuccessResult("创建成功");
				}else {
					return JsonResult.buildSuccessResult("创建失败");
				}
			}
	
	//查看修改页面
			@RequestMapping(value="/editProCategory",method=RequestMethod.GET)
			@ResponseBody
			public ModelAndView  edit(ModelAndView model,Integer id){
				
				ProductCategory category = productCategoryService.get(id);
				
				model.addObject("category", category);
				model.setViewName("forward:editCategory");
			    return model;
			}

			
	//保存修改
	@RequestMapping("/saveEditCategory")
	@ResponseBody
	public JsonResult saveEditCategory(ProductCategory category){
		boolean b = productCategoryService.update(category);
		

		if (b) {
				return JsonResult.buildSuccessResult("修改成功");
			}else {
				return JsonResult.buildSuccessResult("修改失败");
			}
			
		}
	
	
	
	
	//删除类别
	@RequestMapping("/deleteCategory")
	@ResponseBody
	public JsonResult deleteCategory(Integer id){
		boolean b = productCategoryService.delete(id);
		
			if (b) {
					return JsonResult.buildSuccessResult("删除成功");
				}else {
					return JsonResult.buildSuccessResult("删除失败");
				}
			}	

	//分页查询产品
	@RequestMapping("/findProByPage")
	@ResponseBody
	public JsonResult findProByPage(PageBean<Map<String , Object>> pageBean,HttpSession session){
		
		int total = productService.count(pageBean.getCondition());
		List<Map<String , Object>> list = productService.findMapByPage(pageBean.getPage(),pageBean.getRows(),pageBean.getCondition());
		
		
		
		pageBean.setTotal(total);
		pageBean.setResult(list);
		
		return JsonResult.buildSuccessResult("查询成功", pageBean);
	}
	
	//上传图片
			@RequestMapping("/uploadImg")
			@ResponseBody
				public JsonResult uploadImg(MultipartFile image) throws IllegalStateException, IOException{
				//获取到上传的文件名
				String fileName = image.getOriginalFilename();
				//获取到文件大小
				long length = image.getSize();
				//获取到内容类型
				String contentType = image.getContentType();
				System.out.println(fileName);
				System.out.println(length);
				System.out.println(contentType);
				String tomcatPath = System.getProperty("catalina.home");
				//将文件写入到指定的位置
				if(!image.isEmpty()){
					image.transferTo(new File(tomcatPath+"/webapps/crm6/static/images/",fileName));
				}
				
				ProductImages productImages = new ProductImages();
				productImages.setIsMain(0);
				productImages.setName(fileName);
				productImages.setSize(Long.toString(length));
				
				
				
				
				return JsonResult.buildSuccessResult("图片上传成功",productImages);
				
				
				
			
				}
	
	
	
	
	
	//保存产品
		@RequestMapping("/saveProduct")
		@ResponseBody
			public JsonResult saveProduct(Product product,HttpSession session){
			product.setCreateTime(new Date());
			product.setUpdateTime(new Date());
			User user = (User) session.getAttribute("user");
			product.setCreatorUserId(user.getId());
			boolean b = productService.save(product);

			if (b) {
					return JsonResult.buildSuccessResult("保存成功");
				}else {
					return JsonResult.buildSuccessResult("保存失败");
				}
				
			}
		

		//删除产品
		@RequestMapping("/deleteProduct")
		@ResponseBody
		public JsonResult deleteProduct(Integer id){
			boolean b = productService.delete(id);
			
				if (b) {
						return JsonResult.buildSuccessResult("删除成功");
					}else {
						return JsonResult.buildSuccessResult("删除失败");
					}
				}	

		
	
	
	
}
