<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../script.html" %>
<title>   </title>
</head>
<body>
	<div id="tabs" data-options="region:'center',border:false,height:800"
			class="easyui-tabs">
			<div id="customer" data-options="iconCls:'icon-man'" title="合同">
				<div class="theme-user-info-panel" style="float: left;">
					<div class="center">
						视图：<a href="javascript:findall('customers')">全部</a>|<a
							href="javascript:mycus('customers')">我负责的</a>|<a
							href="javascript:mydown('customers')">下属负责</a>|<a
							href="javascript:mydcreate('customers')">下属创建</a>
					</div>
				</div>
				<div class="right"
					style="float: right; margin-top: 30px; margin-right: 30px;">
					<a href="javascript:add()" class="easyui-linkbutton add-button"
						data-options="iconCls:'icon-add'" style="margin-right: 10px;">新建合同</a>
				</div>
				<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
					<div class="toolbar"></div>
					<table id="contract"></table>
				</div>
			</div>
			</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
	$("#contract").datagrid({
		url: "system/contract/list",
		pagination : true,
		rownumbers : true,
		loadFilter : function(data){
			return data.data;
		},
		columns : [[
			{field : 'id',checkbox : true},
			{field : 'number',title : '合同编号',width : 100},
			{field : 'customer',title : '客户',width : 100},
			{field : 'contact',title : '联系人',width : 100},
			{field : 'owner',title : '负责人',width : 100},
			{field : 'due_time',title : '签约日期',width : 100},
			{field : 'price',title : '合同金额(元)',width : 100},
			{field : 'status',title : '状态',width : 100},
			{field : 'over',title : '合同到期天数',width : 100},
			{field : 'options',title : '操作',width : 100,
			formatter : function(value, row, index) {
				return "<a href='javascript:void(0)'>查看</a> |  <a href='javascript:editContract("+row.id+")'>编辑</a>";
			}}
		]]
	});

	})
	
	function add(){
		parent.openDialog({title:"添加合同",url:"system/contract/addcontract",close:function(){$("#contract").datagrid("reload")}});
	}
</script>
</html>
