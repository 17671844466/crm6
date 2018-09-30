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
<title>线索</title>
<meta charset="utf-8">
<%@include file="../script.html" %>
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>

 

<div id="master-layout" style="height: 100%;width: 100%">
	<div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">

		<div id="tab1" title="产品列表">
				<div id="toolbar" class="right" style="margin-left: 10px;">
				 <span class="dropdown-option">
	                <select style="height: 30px;" class="taskbox" name="task1" id="taskId">
	                      <option value="-1">任意字段</option> 
	                       <option value="name">产品名称</option> 
	                </select>
	          	</span>
	          
	           	<span class="dropdown-option">
	                <select style="height: 30px;" name="task2" id="bussId">
	                      <option value="-1">包含</option> 
	                     
	                </select>
	           </span>
	           	<input id="criteria" type="text" class="easyui-textbox" style="width:150px;height: 30px;" />
				<a id="searchBy" class="easyui-linkbutton search-button" data-options="iconCls:'icon-search'">搜索</a>
				<a id="addPro" class="easyui-linkbutton add-button" data-options="iconCls:'icon-add'">添加产品</a>
				<a id="removeBtn" class="easyui-linkbutton delete-button" data-options="iconCls:'icon-remove'">删除</a>
				<a id="resetBtn" class="easyui-linkbutton delete-button" data-options="iconCls:'icon-remove'">重置</a>
			</div>

					<table id="dataList"></table> 
		
		</div>	
			


			
	

		<div id="tab2" title="产品分类">
			<div class="right" style="margin-left: 10px;">
				 
				<a id="addPro2" class="easyui-linkbutton add-button" data-options="iconCls:'icon-add'">添加产品类别</a>
				<a id="removeBtn2" class="easyui-linkbutton delete-button" data-options="iconCls:'icon-remove'">删除</a>

			</div>
	
			
				<table id="dataList2"></table>
					
			</div>
			
			
	</div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$("#removeBtn").on('click',function(event){
		event.preventDefault();
		var rows = $("#dataList").datagrid("getChecked");
		
		if(!rows.length){
			parent.$.messager.alert("警告","必须至少选择一行数据");
			return;
		}
		else {
			  $.messager.confirm('操作提示', '确定要删除吗?', function(r){

				  var productId;
				  $.each(rows, function (i, n) { 

					  if (i == 0) { 

						  productId = n.id; 

					   } else { 

						   productId += "," + n.id; 

					   } 

					   }); 
					  							
				  
					if (r){
						
						$.post("system/product/deleteProduct","id="+productId,function(data){
							$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
							searchPro();
			           		
			           	},"json")
			        
			           
					}
			   }); 

		}

	});
});

function searchPro(condition){     	   
	$("#dataList").datagrid({
		url : "system/product/findProByPage?"+condition,
		pagination : true,
		toolbar : "#toolbar",
		rownumbers : true,
		idField : "id",
		loadFilter : function(data){
			if(data && data.success){
				return data.data;
			}
		},
		columns : [[
	        {field:'id',checkbox:true},
	        {field:'path',title:'图片',width:120,align:'center',formatter:function(value,row,index){return '<img src="'+row.path+'" width=30px/>';}},
	        {field:'name',title:'产品名称',width:140},
	        {field:'link',title:'详情链接',width:150},
	        {field:'creatorUser',title:'创建人',width:200},
	       
	        {field:'operation',title:'操作',formatter:function(value,row,index){
	        	return '<a href="javascript:void(0)" onclick="editPro('+row.id+')">编辑   |</a>'
	        	+'  <a href="javascript:void(0)" onclick="pro('+row.id+')">查看产品</a>'
	        }},

	    ]]
	});
	}




		//跳转添加产品
		$(function(){
			$("#addPro").on('click',function(){   
				window.location.replace("system/product/addPro"); 
		     })
			});





			

	
	</script>
	<script type="text/javascript">
	$(function(){
		$("#removeBtn2").on('click',function(event){
			event.preventDefault();
			var rows = $("#dataList2").datagrid("getChecked");
			
			if(!rows.length){
				parent.$.messager.alert("警告","必须至少选择一行数据");
				return;
			}
			else {
				  $.messager.confirm('操作提示', '确定要删除吗?', function(r){

					  var categoryId;
					  $.each(rows, function (i, n) { 

						  if (i == 0) { 

						   categoryId = n.id; 

						   } else { 

							   categoryId += "," + n.id; 

						   } 

						   }); 
						  							
					  
						if (r){
							
							$.post("system/product/deleteCategory","id="+categoryId,function(data){
								$.messager.alert({
				           			title:"提示",
				           			msg:data.message,
			        			});
								searchCategory();
				           		
				           	},"json")
				        
				           
						}
				   }); 

			}

		});
	});

	function searchCategory(condition){     	   
		$("#dataList2").datagrid({
			url : "system/product/findByPage?"+condition,
			pagination : true,
			toolbar : "#toolbar",
			rownumbers : true,
			idField : "id",
			loadFilter : function(data){
				if(data && data.success){
					return data.data;
				}
			},
			columns : [[
		        {field:'id',checkbox:true},
		        {field:'NAME',title:'分类名',width:120},
		        {field:'productNum',title:'产品数',width:140},
		        {field:'products',title:'产品',width:150},
		        {field:'description',title:'分类描述',width:200},
		       
		        {field:'operation',title:'操作',formatter:function(value,row,index){
		        	return '<a href="javascript:void(0)" onclick="edit('+row.id+')">编辑   |</a>'
		        	+'  <a href="javascript:void(0)" onclick="pro('+row.id+')">查看产品</a>'
		        }},

		    ]]
		});
		}


	//自动刷新页面
	$(function(){
		searchPro();
		
		$("#tabs").tabs({
			onSelect: function(){
				searchCategory(),
				searchPro();
			}
			});
	})

	//searchBy
			$("#searchBy2").on('click',function(){
				var conditionVal=$("#taskId2").val();
				var inputVal=$("#criteria2").val();
				alert(inputVal);

				$("#dataList2").datagrid("load",{
					//"condition[deleteStatus]":0,
					"condition[value]" : inputVal,
					"condition[column]" : conditionVal
				});
				
				});
	
		//reset
		
		$("#resetBtn2").on("click",function(){
	       //文本框的内容清空
	       	$("#taskId2").val("-1");           
	       	$("#criteria2").textbox("setValue","");   

			$("#dataList2").datagrid("load",{
				
			});
       });
		
	//新建分类
	$("#addPro2").on('click',function(){
		parent.openDialog({
			title:"添加产品类别",
			url:"system/product/addProCategory",
			width:"600px",
			height:"400px",
			close : function(){
				$("#dataList2").datagrid("reload");
			}

		});
	
	});
	
	//编辑分类
	function edit(id){
		parent.openDialog({
			title:"编辑产品类别",
			url:"system/product/editProCategory?id="+id,
			width:"600px",
			height:"400px",
			close : function(){
				$("#dataList2").datagrid("reload");
			}

		});
	
	};	
			
	
	</script>
</html>