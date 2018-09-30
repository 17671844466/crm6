package com.zhidisoft.common;

/**
 * 用于封装Json结果{"success": true,"message":"","data":操作的数据}
 * @author Lu jianliang
 *
 */
public class JsonResult {
	
	private boolean success;
	
	private String message;
	
	private Object data;
	
	public JsonResult(){}
	
	public JsonResult(boolean success,String message,Object data){
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * 构建成功结果,该结果有消息，也有数据
	 * @param message
	 * @param data
	 * @return
	 */
	public static JsonResult buildSuccessResult(String message,Object data){
		return new JsonResult(true, message, data);
	}
	
	/**
	 * 构建成功结果，只有消息，没有数据
	 * @param message
	 * @return
	 */
	public static JsonResult buildSuccessResult(String message){
		return buildSuccessResult(message, null);
	}
	
	/**
	 * 构建失败结果，既有数据，也有消息
	 * @param message
	 * @param data
	 * @return
	 */
	public static JsonResult buildFailureResult(String message,Object data){
		return new JsonResult(false, message, data);
	}
	
	/**
	 * 只有信息，不包含数据
	 * @param message
	 * @return
	 */
	public static JsonResult buildFailureResult(String message){
		return buildFailureResult(message, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}
	

}
