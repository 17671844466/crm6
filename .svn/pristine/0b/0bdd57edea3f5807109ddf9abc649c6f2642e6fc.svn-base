package com.zhidisoft.exception.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.common.JsonResult;

public class ExceptionHandler implements HandlerExceptionResolver {
	
	private String error = "error";
	
	public void setError(String error){
		this.error = error;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//当前请求是不是ajax请求
		String xhr = request.getHeader("X-Requested-With");
		if(xhr == null || !"XMLHttpRequest".equals(xhr)){
			
			ModelAndView mView = new ModelAndView(error);
			return mView;
		}
		
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			JsonResult jsonResult = JsonResult.buildFailureResult(ex.getMessage());
			
			ObjectMapper mapper = new ObjectMapper();
			PrintWriter out = response.getWriter();
			mapper.writeValue(out, jsonResult);
			out.flush();
			out.close();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	

}
