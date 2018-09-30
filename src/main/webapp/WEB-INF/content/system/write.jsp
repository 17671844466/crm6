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
<title></title>
<meta charset="utf-8">
<%@include file="../script.html" %>
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>	
	
	<div style="float:left;margin-right:50px">
		<h4>选择收件人:</h4><br/>
		<table id="userList" width="250px"></table>
		
	</div>
	<div style="float:left">
		<h4>添加内容:</h4><br/>
		<textarea id="content" rows="30" cols="40" ></textarea><br/>
		<a href="javascript:void(0)" id="send" class="easyui-linkbutton" data-options="iconCls:'icon-save'">发送</a>
	</div>
	

</body>

<script type="text/javascript">
	//分页查询所有用户
	function findByPage(){
		$("#userList").datagrid({
			url : "system/message/getUsers?id="+${user.id},
			pagination : true,
			toolbar : ".toolbar",
			rownumbers : true,
				loadFilter : function(data){
					if(data && data.success){
						data.data
						return data.data;
					}
				},
			columns : [[
			{field:'id',checkbox:true},
       		{field:'username',title:'收件人姓名',width:170},
    		]]
		});
	}

	$(function(){
		findByPage();
		})
		
		
	$("#send").on("click",function(){
		var rows = $("#userList").datagrid("getChecked");
		var content = $("#content").val();
		if(!rows.length){
			parent.$.messager.alert("警告","必须至少选择一个收件人");
			return;
		}
		if(!content){
			parent.$.messager.alert("警告","信件内容不能为空");
			return;
		}
		for (i=0;i<rows.length;i++) {
			 rows[i]=rows[i].id; 
		}
		var toUsersId = rows.join(",");
		$.post("system/message/sendMessage",
				{"toUsersId":toUsersId,
				 "content":content,
				 "fromUserId":${user.id }
		 		},
					function(data){
						if(data.success){
							parent.$.messager.show({"title":"提示","msg":data.message});
							parent.closeDialog();
						}else{
							parent.$.messager.show({"title":"提示","msg":data.message});
							}	
					})
		})
</script>

</html>