<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>修改任务</title>
<%@include file="../script.html"%>
<script type="text/javascript" src="static/easyui/common.js">
	</script>
<script type="text/javascript" charset="utf-8"
	src="static/js/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="static/js/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="static/js/zh-cn.js"></script>
<style type="text/css">
#form {
	border: 1px solid #e5e5e5;
}

</style>
</head>
<body>
	<div id="master-layout" style="height: 100%; width: 100%">
			<div id="addForm" class="easyui-panel" title="修改任务信息"
				style="width: 100%; height: 100%; padding: 10px; background-color: white;">
				<form id="form" method="post">
				<input type="text" hidden value="${task.id }" name="id"/>
					<table cellpadding="100">
						<tr style="height: 50px">
							<td
								style="width: 150px; text-align: right; background-color: #f5f5f5">主题</td>
							<td style="width: 400px;">
								<input type="text" name="subject" value="${task.subject }" class="easyui-textbox" style="width:260px;height: 30px;">
							</td>
							<td
								style="width: 150px; text-align: right; background-color: #f5f5f5">发送通知</td>
							<td><label>
								<input type="checkbox" id="letter"name="letter" checked="checked">站内信</label>
								<label><input type="checkbox" id="email" name="email" checked="checked">邮件</label>
							</td>
						</tr>
						<tr style="height: 50px">
							<td	
								style="width: 150px; text-align: right; background-color: #f5f5f5">负责人</td>
							<td colspan=5 >
								<label>
									<input  id="ownerUserId" class="easyui-combobox" name="ownerUserId" value="${task.ownerUserId }" style="width: 500px"  />
									
								</label> <label>(单击选择)</label></td>
						</tr>
						<tr style="height: 50px">
							<td
								style="width: 150px; text-align: right; background-color: #f5f5f5">任务相关人</td>
							<td  colspan=5 style="width: 250px;">
								<label>
									<input  id="aboutUsers" class="easyui-combobox" name="aboutUsers"  value="${task.aboutUsers }" style="width: 500px"  />
								</label><label>(单击选择)</label></td>
						</tr>
						<tr style="height: 50px">
							<td style="width: 150px; text-align: right; background-color: #f5f5f5">状态</td>
							<td style="width: 280px;">
							<select id="status" name="status" value="${task.status }" class="easyui-combobox theme-textbox-radius" style="width: 260px">
								<option value="1" >正常</option>
								<option value="0" >禁用</option>
								<option value="2" >已删除</option>
							</select>
							</td>
							<td style="width: 150px; text-align: right; background-color: #f5f5f5">优先级</td>
							<td>
								<select style="height: 30px;width: 200px;" id="priority" name="priority" value="${task.priority }" >
									<option value="0"></option>
									<option value="高">高</option>
									<option value="中">中</option>
									<option value="低">低</option>
								</select>
							</td>
						</tr>
                          	<td
								style="width: 150px; text-align: right; background-color: #f5f5f5">描述</td>

							<td colspan="4">
								<script id="editor" name="description" value="${task.description }" type="text/plain"style="width: 750px; height: 200px;"></script>
							</td>
						</tr>
						<tr style="height: 50px">
							<td colspan="5" style="text-align: center;">
								<input id="saveBtn" type="button" class="easyui-linkbutton save-button"
									style="width: 100px; height: 30px" value="保存">
								</input> 
								<input	id="resetBtn" type="button" class="easyui-linkbutton reset-button"
									style="width: 100px; height: 30px" value="重置"/>
								<input	id="backBtn" type="button" class="easyui-linkbutton back-button"
									style="width: 100px; height: 30px" value="返回"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
	</div>

</body>
<script type="text/javascript">
		//富文本框
		var ue = UE.getEditor('editor');
			
			$(function(){
				 //负责人下拉框
				$("#ownerUserId").combobox({
					url:"task/subject1",
					valueField:"id",
					textFilter:"ownerUserId",
					loadFilter:function(data){
						if(data && data.success){
							return data.data
								}
							}
					})
					
				//任务相关人下拉框
				$("#aboutUsers").combobox({
					url:"task/subject2",
					valueField:"id",
					textFilter:"aboutUsers",
					loadFilter:function(data){
						if(data && data.success){
							return data.data
							}
						}	
					})
					
				
					 
				//获取关联商机产品属性
				$("#name").combobox({
					url:"task/addBussiness",
					valueField:"id",
					textFilter:"name",
					loadFilter:function(data){
						if(data && data.success){
							return data.data
							}
						}	
					})
				
				//返回上一页
				$("#backBtn").on('click',function(){  
					window.location.replace("task/task");  
			     })

				//重置
	    		$("#resetBtn").on("click",function(){
	    			$("#form").form("reset");
	    		})

	    		//保存修改
	    		$("#saveBtn").on("click",function(){
	    			event.preventDefault();
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}	
					
					$.post("task/updateTask",
							$("#form").serialize(),
							function(data){				
						if(data && data.success){
							parent.$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
		     			}else{
		     				parent.$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
							parent.closeDialog();
		     			}
					},"json")	

				})
			});
</script>
</html>
</body>
</html>