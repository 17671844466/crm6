package com.zhidisoft.system.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhidisoft.common.JsonResult;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.service.IUserService;

/**
 * 处理用户的上传和修改资料
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserPersonal {
	
	@Autowired
	private IUserService userService;
	/**
	 * 跳转到修改页面
	 */
	@RequestMapping("updateuser")
	ModelAndView updateUser(ModelAndView mv){
		System.out.println("页面交转");
		mv.setViewName("system/user");
		return mv;
	}
	/**
	 * 新增或修改用户
	 * @throws Exception 
	 * @throws IllegalStateException 
	 */
	@PostMapping("addeditusers")
	@ResponseBody
	public JsonResult addusers(User user,HttpSession session) throws IllegalStateException, Exception{
		// 判断前端传来的对象 是否有id 没有就是增加反之就是修改
		if (user.getId() != null) {
			user.setPassword(((User) session.getAttribute("user1")).getPassword());
			user.setSalt(((User) session.getAttribute("user1")).getSalt());
			user.setUpdatetime(new Date());
			user.setUpdateby(((User) session.getAttribute("user")).getId());
			boolean b = userService.update(user);
			//boolean b = funcService.updateFuncyion(function);
			if (b) {
				return JsonResult.buildSuccessResult("修改成功!");
			}
			return JsonResult.buildSuccessResult("修改成功!");
		}
		// 判断前端数据 加以修改
		
		user.setCreatetime(new Date());
		user.setCreateby(((User) session.getAttribute("user")).getId());
		user.setSalt(""+new Date());
		boolean b = userService.save(user);
		// 进行保存
		
		if (b) {
			return JsonResult.buildSuccessResult("插入成功!");
		}
		//System.out.println(function);

		return JsonResult.buildSuccessResult("失败了");
		
	}
	/**
	 * 处理用户头像上传问题
	 * @throws Exception 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("upload")
	@ResponseBody
	public JsonResult upload( MultipartFile file,HttpSession session) throws  Exception{
		
		if(file.getSize()>0){
			
			String name = file.getOriginalFilename();
			if (name.endsWith("jpg")||name.endsWith("png")||name.endsWith("gif")) {
				
				//拼接绝对路径
				String path = session.getServletContext().getRealPath("/img");
				
				//System.out.println(path);
				File file2 = new File(path, name);
				file.transferTo(file2);
				User user= (User) session.getAttribute("user");
				user.setUsernote("img\\"+name);
				boolean b = userService.update(user);
				return JsonResult.buildSuccessResult("上传成功");
			}
			
			return JsonResult.buildFailureResult("文件格式不对");
		}
		
		
		
		return JsonResult.buildFailureResult("请选择文件");
	}
	/**
	 * 上传头像页面
	 */
	@RequestMapping("uploadindex")
	public String uploadindex(){
		return "system/uploadindex";
		
	} 
	/**
	 * deletuser 根据id删除用户
	 */
	@RequestMapping("deletuser")
	@ResponseBody
	public JsonResult deletaroleid(@RequestParam("id") Integer id) {

		boolean b = userService.delete(id);

		if (b) {

			return JsonResult.buildSuccessResult("删除成功");
		}

		return JsonResult.buildSuccessResult("删除失败");

	}
	
}
