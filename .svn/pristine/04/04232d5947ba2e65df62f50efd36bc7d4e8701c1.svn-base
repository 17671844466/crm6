<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="acl" uri="http://www.zhidisoft.com/taglib/acl" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<title>权限管理</title>
		<%@include file="../script.html" %>
	</head>
	<body>
		<div class="toolbar">
			<div class="left">
			工具:
			</div>
			<div class="right">
			<acl:hasPermission code="add" >
 				<a class="easyui-linkbutton add-button" data-options="iconCls:'icon-add'">新增</a>
			</acl:hasPermission>
			<acl:hasPermission code="edit" >
 				<a class="easyui-linkbutton edit-button" data-options="iconCls:'icon-edit'">修改</a>
			</acl:hasPermission>
			<acl:hasPermission code="delete" >
 				<a class="easyui-linkbutton delete-button" data-options="iconCls:'icon-remove'">删除</a>
			</acl:hasPermission>
 
			</div>
		</div>
		<table id="dataList"></table>
	</body>
	<script type="text/javascript">
/* 新增权限 */
	$(function(){
		$(".add-button").on('click',function(event){
			event.preventDefault();
			
			parent.parent.openDialog({
				title : "新增权限",
				url : "manage/addfunction",
				width : 600,
				height : 400,
				close : function (){
					$("#dataList").datagrid("reload");
				}
			});
		});
	});
	
/*  修改权限*/
	$(function(){
		$(".edit-button").on('click',function(event){
			event.preventDefault();
			var rows = $("#dataList").datagrid("getChecked");
		
			if(!rows.length){
				parent.$.messager.alert("警告","必须至少选择一行数据");
				return;
			}
			//获取去选中第一行的userId
			var id = rows[0].id;
			
			parent.parent.openDialog({
				title : "修改权限",
				url : "manage/edit?funcid="+id,
				width : 600,
				height : 400,
				close : function (){
					$("#dataList").datagrid("reload");
				}
			});
		});
	});
	/*  删除权限*/
	$(function(){
		$(".delete-button").on('click',function(event){
			event.preventDefault();
			var rows = $("#dataList").datagrid("getChecked");
		
			if(!rows.length){
				parent.$.messager.alert("警告","必须至少选择一行数据");
				return;
			}
			//获取去选中第一行的userId
			var id = rows[0].id;
			
			$.messager.confirm("警告","是否删除数据",function(b){
				if(b){
				$.ajax({
					   type: "get",
					   url: "manage/deletaid?id="+id,
					   success: function(data){
							parent.$.messager.show({
			           			title:"提示",
			           			msg:data.message,
			       			})
						  $("#dataList").datagrid("reload");
					   }
					})};
				});
		});
	});
	/* 查找数据 */
		$(function(){
			$("#dataList").datagrid({
				url : "manage/root",
				pagination : true,
				toolbar : ".toolbar",
				rownumbers : true,
				loadFilter : function(data){
					if(data && data.success){
						return data.data;
					}
				},
				columns : [[
			        {field:'id',checkbox:true},
			        {field:'funcName',title:'功能名'},
			        {field:'funcURL',title:'功能页面',width:150},
			        {field:'funcCode',title:'功能编码'},
			        {field:'paname',title:'功能所属'},
			        {field:'funcType',title:'功能类型',formatter:function(value){
			        	if(value == 1){
			        		return "菜单";
			        	}else if(value == 0){
			        		return "按钮";
			        	}else{
			        		return "已删除";
			        	}
			        }},
			        {field:'funcNote',title:'功能备注',width:100},
			        {field:'state',title:'状态',formatter: function(value){
			        	if(value == 1){
			        		return "正常";
			        	}else if(value == 0){
			        		return "禁用";
			        	}else{
			        		return "已删除";
			        	}}},
			        {field:'crename',title:'创建者'},
			        {field:'createTime',title:'创建时间',width:100},
			        {field:'upname',title:'修改者'},
			        {field:'updateTime',title:'修改时间',width:100}
			        

			    ]]
			});
		})
		
	</script>
</html>