package com.zhidisoft.common.support;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;

/**
 * Servlet API支持类，通过该类可以获取当前客户端ip以及当前请求对应的请求对象、响应对象和会话对象
 * @author Lu Jianliang
 *
 */
public class HttpSupport {
	
	/**
	 * 获取当前请求的客户端ip
	 * @return
	 */
	public static String getClientIP(){
		HttpServletRequest request = getRequest();
		
		String clientIP = request.getHeader("x-forwarded-for");
	    if(clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
	        clientIP = request.getHeader("Proxy-Client-IP");
	    }
	    if(clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
	        clientIP = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(clientIP == null || clientIP.length() == 0 || "unknown".equalsIgnoreCase(clientIP)) {
	        clientIP = request.getRemoteAddr();
	        if(clientIP.equals("127.0.0.1") || clientIP.equals("0:0:0:0:0:0:0:1")){
	            //根据网卡取本机配置的IP
	            InetAddress inet = null;
	            try {
	                inet = InetAddress.getLocalHost();
	            } catch (UnknownHostException e) {
	                e.printStackTrace();
	            }
	            clientIP = inet.getHostAddress();
	        }  
	    }  
	    //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	    if(clientIP != null && clientIP.length() > 15){ //"***.***.***.***".length() = 15  
	        if(clientIP.indexOf(",") > 0){
	            clientIP = clientIP.substring(0,clientIP.indexOf(","));
	        }
	    }
		
		return clientIP;
	}
	
	/**
	 * 获取当前请求的请求对象
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * 获取当前请求对应的响应对象
	 * @return
	 */
	public static HttpServletResponse getResponse(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	/**
	 * 获取当前请求对应的HttpSession对象
	 * @return
	 */
	public static HttpSession getSession(){
		return getRequest().getSession();
	}
	
	/**
	 * 判断是否ajax请求
	 * spring ajax 返回含有 ResponseBody 或者 RestController注解
	 * @param handlerMethod HandlerMethod
	 * @return 是否ajax请求
	 */
	public static boolean isAjax(HandlerMethod handlerMethod) {
		//判断请求头中是否包含x-reqeusted-with请求头
		String xhr = getRequest().getHeader("X-Requested-With");
		if(xhr != null && !xhr.isEmpty()){
			return true;
		}
		
		// 判断当前请求处理方法上是否定义了@ResponseBody注解
		ResponseBody responseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
		if (null != responseBody) {
			return true;
		}
		// 获取当前请求处理方法所在的类上面的Annotation，可能包含组合注解，故采用spring的工具类
		Class<?> beanType = handlerMethod.getBeanType();
		responseBody = AnnotationUtils.getAnnotation(beanType, ResponseBody.class);
		if (null != responseBody) {
			return true;
		}
		return false;
	}
	

}
