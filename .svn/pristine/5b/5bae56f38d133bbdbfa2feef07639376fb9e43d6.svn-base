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
<title>任务信息版块</title>
<%@include file="../script.html" %>
</head>

<body>
	<div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">
		<div data-options="iconCls:'icon-man'" id="tab1" title="任务">
			<div class="theme-user-info-panel">
				<div class="view-box">
					视图：全部|我的任务|我分配的任务&nbsp;&nbsp;&nbsp;&nbsp;未启动|推迟|进行中|已完成|关闭的&nbsp;&nbsp;&nbsp;&nbsp;
					今日截止|本周截止|本月截止|最近分配|最近更新&nbsp;&nbsp;&nbsp;&nbsp;回收站
				</div>
			</div>
			<div class="taskbutton">
				<div class="right" style="margin-left: 10px;">
					<a class="easyui-linkbutton delete-button" data-options="iconCls:'icon-remove'">删除</a>
					 <span class="dropdown-option"/>
		                <select style="height: 30px;" id="taskbar" class="taskbox" name="task1" id="taskId">
		                      <option value="">任意字段</option>
		                      <option value="owner_user_id">负责人</option> 
		                      <option value="about_users">任务相关人</option> 
		                      <option value="due_date">任务截止日</option> 
		                      <option value="status">状态</option> 
		                      <option value="priority">优先级</option> 
		                      <option value="send_email">是否发送邮件通知</option> 
		                      <option value="description">描述</option> 
		                      <option value="create_user_id">创建人</option> 
		                      <option value="create_date">创建时间</option> 
		                      <option value="update_date">更新时间</option> 
		                      <option value="isclose">是否关闭</option> 
		                      <option value="delete_status">是否删除</option> 
		                      <option value="delete_user_id">删除人</option> 
		                      <option value="delete_time">删除时间</option> 
		                </select>
		          	</span>
		          
		           	<span class="dropdown-option"/>
		                <select style="height: 30px;" name="task2" id="bussId">
		                      <option value="-1">包含</option> 
		                </select>
		           </span>
		           		<input type="text" name="name" id="name" class="easyui-textbox" style="width:150px;height: 30px;">
					<a id="searchbttn" class="easyui-linkbutton search-button" data-options="iconCls:'icon-search'">搜索</a>
					<a class="easyui-linkbutton edit-button" data-options="iconCls:'icon-edit'"style="float: right;margin-right:10px;">任务工具</a>
					<a class="easyui-linkbutton add-button"  data-options="iconCls:'icon-add'" style="float: right;margin-right: 20px;">新建任务</a>
				</div>
			</div>
			<table id="dataList"></table>
		</div>
	
		<div id="tab1" title="统计">
			<div class="taskbutton">
				<div class="right" style="margin-left: 10px;">
					<span>选择部门:</span>
					<input type="text" name="subject"  class="easyui-textbox" style="width:260px;height: 30px;">
					<span>选择员工:</span>
					<input type="text" name="subject"  class="easyui-textbox" style="width:260px;height: 30px;">
		          	<span>选择日期:从</span>
		          	<input id="dueDate" type="date" class="easyui-datebox" name="dueDate"
						   style="width: 200px; border-radius: 10px" />
		           	<span class="dropdown-option"/>
		           	<span>至</span>
		          	<input id="dueDate" type="date" class="easyui-datebox" name="dueDate"
						   style="width: 200px; border-radius: 10px" />
					<a id="searchbttn" class="easyui-linkbutton search-button" data-options="iconCls:'icon-search'">搜索</a>
		           	<span class="dropdown-option"/>
		                <select style="height: 30px;" name="task2" id="bussId">
		                      <option value="-1">包含</option> 
		                </select>
		           </span>
				</div>
			</div>
		</div>
			<div id="tab1" title="帮助">
				
					帮助
			</div>
	</div>		
</body>
<script type="text/javascript">

	//删除方法
	$(function(){
		$(".delete-button").on('click',function(event){
				event.preventDefault();
				var rows=$("#dataList").datagrid("getChecked");
				
				if(!rows.length){
					parent.$.messager.alert("警告","必需最少选择一行数据");
					return;
				}else{
					parent.$.messager.confirm('操作提示','确定删除吗?',function(r){
						if(r){
							$.post("task/delete",
									{"id":rows[0].id},
									function(data){
											alert(data.message);
											//刷新datagrid
											$("#dataList").datagrid("reload");
								},"json")
							}
						});
					}
			})
		})

	//下拉框查询方法
	$(document).ready(function(){
		$.post("task/findAll",
			function(data){
		$.each(data.data[1].keys,
		function(index,obj){
			var option = $("<option></option>");
			option.html(obj);
			option.attr("value",obj);
			$("#taskId").append(option);
		});
	},
		"json");
	});
	
	 $(document).ready(function(){
			$.post("task/findAll",
				function(data){
			$.each(data.data[1].values,
			function(index,obj){
				var option = $("<option></option>");
				option.html(obj);
				option.attr("value",obj);
				$("#bussId").append(option);
			});
		},
			"json");
		}); 

			//为搜索按钮添加事件处理函数
			function doSearch(){
				alert(1);
				var search=$("#name").val();
				var taskbar=$("#taskbar").val();
					$("#dataList").datagrid("load",{
						"condition[search]":search,
						"condition[taskbar]":taskbar
					})
				};
		
			$("#searchbttn").on("click",function(){
				alert($("#taskbar").val());
				doSearch();
				})
				
		//新建任务
		$(".add-button").on("click",function(){
			parent.openDialog({
				width:950,
				heigth:600,
				title:"添加任务",
				url:"task/addTask"
				});
			});
			
		//分页查询方法
		$(function(){
			$("#dataList").datagrid({
				url:"task/findByPage",
				pagination:true,
				toolbar:"#toolbar",
				rownumbers:true,
				loadFilter:function(data){
						if(data.success&&data){
							return data.data;
						}
					},
			    columns:[[
					{field:'id',checkbox:true},
					{field:'owner_user_id',title:'负责人',width:50},
					{field:'about_users',title:'任务相关人',width:70},
					{field:'subject',title:'主题',width:70},
					{field:'overDates',title:'任务截止日期',width:80},
					{field:'status',title:'状态',width:40,
						formatter:function(value){
							if(value == 1){
								return "正常";
							}else if(value == 0){
								return "禁用";
							}else if(value == 2){
								return "已删除";
							}
						}
					},
					{field:'priority',title:'优先级',width:40},
					{field:'send_email',title:'是否发送邮件通知',width:100},
					{field:'description',title:'描述',width:70},
					{field:'creator_user_id',title:'创建人',width:50},
					{field:'create_date',title:'创建时间',width:100},
					{field:'update_date',title:'更新时间',width:100},
					{field:'isclose',title:'是否关闭',width:50},
					{field:'operation',title:'操作',width:120,
						formatter:function(value,row,index){
							return "<a href='javascript:void(0)' onclick='detail("+row.id+")'>查看</a>&nbsp;&nbsp;&nbsp;"
							+ "<a href='javascript:void(0)' onclick='edit("+row.id+")'>修改</a>&nbsp;&nbsp;&nbsp;"
							 + "<a href='javascript:void(0)' onclick='transform("+row.id+")'>关闭</a>&nbsp;&nbsp;&nbsp;";	
						}
					},
			    ]]
				});
			})

			//修改
			 function edit(id){	
		//弹出一个div 获取任务信息回显到表单中
		parent.openDialog({
				width:950,
				heigth:600,
				title:"任务编辑信息",
			    url:"task/edit?id="+ id, 
			   close:function() {
		 		     $("#dataList").datagrid("reload",function(){
		 			   doSearch();  
			 		})
			   }
		 	    	          
		})  
	};
			
			
</script>
</body>
</html>