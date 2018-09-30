<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>客户</title>
<meta charset="utf-8">
<%@include file="../script.html"%>
<style type="text/css">
.layout-panel-west {
	border-right: 1px solid #c5c5c5;
}
</style>
</head>
<body>
	<div id="master-layout">
		<div id="tabs" data-options="region:'center',border:false,height:800"
			class="easyui-tabs">
			<div id="customer" data-options="iconCls:'icon-man'" title="客户">
				<div class="theme-user-info-panel" style="float: left;">
					<div class="center">
						视图：<a href="javascript:findall('customers')">全部</a>|<a
							href="javascript:mycus('customers')">我负责的</a>|<a
							href="javascript:mydown('customers')">下属负责</a>|<a
							href="javascript:mydcreate('customers')">下属创建</a>
					</div>
				</div>
				<div id="mm" style="width: 70px;">
					<div data-options="iconCls:'icon-edit'" onclick="editCustomer('customers')" id="editbtn1">编辑</div>
					<div data-options="iconCls:'icon-remove'" onclick="delscustomer('customers')" id="delbtn1">批量删除</div>
					<div class="menu-sep"></div>
				</div>
				<div class="right"
					style="float: right; margin-top: 30px; margin-right: 30px;">
					<a href="javascript:add()" class="easyui-linkbutton add-button"
						data-options="iconCls:'icon-add'" style="margin-right: 10px;">新建客户</a>
					<a class="easyui-menubutton edit-button"
						data-options="menu:'#mm',iconCls:'icon-edit'">客户工具</a>
				</div>
				<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
					<div class="toolbar"></div>
					<table id="customers"></table>
				</div>
			</div>
			<div id="cuspool" data-options="iconCls :'icon-user-config'"
				title="客户池">
				<div class="theme-user-info-panel" style="float: left;">
					<div class="center">
						视图：<a href="javascript:findall()">全部</a>|我负责的|下属负责|下属创建
					</div>
				</div>

				<div class="right"
					style="float: right; margin-top: 30px; margin-right: 30px;">
					<a class="easyui-linkbutton add-button"
						data-options="iconCls:'icon-add'" style="margin-right: 10px;">新建客户</a>
					<a class="easyui-linkbutton edit-button"
						data-options="menu:'#mm',iconCls:'icon-edit'">客户工具</a>
				</div>
				<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
					<div class="toolbar"></div>
					<table id="pool"></table>
				</div>
			</div>
			<div id="contact" title="联系人">
				<div class="theme-user-info-panel" style="float: left;">
					<div class="center">
						视图：<a href="javascript:findall()">全部</a>|<a
							href="javascript:mycus()">我负责的</a>|下属负责|下属创建
					</div>
				</div>

				<div class="right"
					style="float: right; margin-top: 30px; margin-right: 30px;">
					<a class="easyui-linkbutton add-button"
						data-options="iconCls:'icon-add'" style="margin-right: 10px;">新建客户</a>
					<a class="easyui-linkbutton edit-button"
						data-options="menu:'#mm',iconCls:'icon-edit'">客户工具</a>
				</div>
				<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
					<div class="toolbar"></div>
					<table id="contacts"></table>
				</div>
			</div>
			<div id="count" title="客户统计">
				<div class="theme-user-info-panel" style="float: left;">
					<div class="center">
						视图：<a href="javascript:findall()">全部</a>|我负责的|下属负责|下属创建
					</div>
				</div>

				<div class="right"
					style="float: right; margin-top: 30px; margin-right: 30px;">
					<a class="easyui-linkbutton add-button"
						data-options="iconCls:'icon-add'" style="margin-right: 10px;">新建客户</a>
					<a class="easyui-linkbutton edit-button"
						data-options="iconCls:'icon-edit'">客户工具</a>
				</div>
			</div>
			<div id="help" title="帮助">
				<h1 style="color: red;">帮助</h1>
			</div>

		</div>
</body>
<script type="text/javascript">
	$(function() {
		$(".edit-button").on(
				'click',
				function(event) {
					event.preventDefault();
					var rows = $("#dataList").datagrid("getChecked");

					if (!rows.length) {
						parent.$.messager.alert("警告", "必须至少选择一行数据");
						return;
					}
					//获取去选中第一行的leadsId
					var leadsId = rows[0].leadsId;

					parent.openDialog("修改线索信息", "system/users/edit?userId="
							+ userId, function() {
						$("#dataList").datagrid("reload");
					});
				});
	});
	//初始化加载
	$(function() {
		load(
				"customers",
				"system/customer/findByPage?condition[delete_status]=0",
				"<a id='del' href='javascript:delCustomer(\"customers\")'>删除</a> |  <a href='javascript:editCustomer(\"customers\")'>修改</a>");
		$('#tabs')
				.tabs(
						{
							border : false,
							onSelect : function(title) {
								switch (title) {
								case '客户':
									load(
											"customers",
											"system/customer/findByPage?condition[delete_status]=0",
											"<a href='javascript:delCustomer(\"customers\")'>删除</a> |  <a href='javascript:editCustomer(\"customers\")'>修改</a>");
									break;
								case '客户池':
									load(
											"pool",
											"system/customer/findByPages?condition[delete_status]=0&condition[owneruser]=1",
											"<a href='javascript:void(0)'>查看</a> | <a href='javascript:Receive(\"pool\")'>领取</a>| <a href='javascript:editCustomer(\"pool\")'>修改</a>");
									break;
								case '联系人':
									contacts();
									break;
								case '客户关怀':
									alert("客户关怀");
									break;
								case '客户统计':
									alert("客户统计");
									break;
								default:
									alert("帮助");
									break;
								}
							}
						});
	})
	//加载联系人
	function contacts() {
		$("#contacts")
				.datagrid(
						{
							url : "system/contacts/findByPages?condition[delete_status]=0&condition[owneruser]=1",
							pagination : true,
							rownumbers : true,
							loadFilter : function(data) {
								if (data && data.success) {
									return data.data;
								}
							},
							columns : [ [
									{
										field : 'id',
										checkbox : true
									},
									{
										field : 'name',
										title : '联系人姓名',
										width : 100
									},
									{
										field : 'saltname',
										title : '尊称',
										width : 80
									},
									{
										field : 'owner',
										title : '所属客户',
										width : 80
									},
									{
										field : 'telephone',
										title : '电话',
										width : 100
									},
									{
										field : 'qq_no',
										title : 'QQ',
										width : 100
									},
									{
										field : 'email',
										title : 'Email',
										width : 100
									},
									{
										field : 'creator',
										title : '创建人',
										width : 80
									},
									{
										field : 'create_time',
										title : '创建时间',
										width : 80
									},
									{
										field : 'delete_time',
										title : '距到期天数',
										width : 100
									},
									{
										field : 'operation',
										title : '操作',
										formatter : function(value, row, index) {
											return "<a href='javascript:void(0)'>查看</a> |  <a href='javascript:editContacts("+row.id+")'>编辑</a>";
										}
									}, ] ]
						});
	}
	//加载数据表格方法
	function load(datagr, url, options) {
		$('#' + datagr).datagrid({
			url : url,
			pagination : true,
			toolbar : "#toolbar",
			rownumbers : true,
			loadFilter : function(data) {
				if (data && data.success) {
					return data.data;
				}
			},
			columns : [ [ {
				field : 'id',
				checkbox : true
			}, {
				field : 'name',
				title : '客户名称',
				width : 100
			}, {
				field : 'industry',
				title : '客户行业',
				width : 80
			}, {
				field : 'rating',
				title : '评分',
				width : 80
			}, {
				field : 'address',
				title : '客户联系地址',
				width : 100
			}, {
				field : 'owner_user',
				title : '负责人',
				width : 100
			}, {
				field : 'creator_user',
				title : '创建人',
				width : 100
			}, {
				field : 'create_time',
				title : '创建时间',
				width : 80
			}, {
				field : 'update_time',
				title : '更新时间',
				width : 80
			}, {
				field : 'delete_time',
				title : '距到期天数',
				width : 100
			},

			{
				field : 'operation',
				title : '操作',
				formatter : function(value, row, index) {
					return options;
				}
			}, ] ]
		});

	}
	/* //全部
	function findall(da) {
		$("#" + da).datagrid("load", {
			"condition[delete_status]" : null
		});
	}
	//我负责的
	function mycus(da) {
		$("#" + da).datagrid("load", {
			"condition[delete_status]" : null,
			"condition[userid]" : parseInt("${sessionScope.user.id }")
		});
	}
	//下属负责的
	function mydown(da) {
		$("#" + da).datagrid("load", {
			"condition[delete_status]" : null,
			"condition[mydown]" : parseInt("${sessionScope.user.id }")
		});
	}
	//下属创建的
	function mydcreate(da) {
		$("#" + da).datagrid("load", {
			"condition[delete_status]" : null,
			"condition[mydowncreate]" : parseInt("${sessionScope.user.id }")
		});
	}*/
	//新建客户
	function add() {
		parent.openDialog({
			title : "添加客户",
			url : "system/customer/addcustomer",
			close : function(){
				$("#customer").datagrid("reload");
			}
		}) 
	
	}	
	
	/* //删除客户
	function delCustomer(da) {
		parent.$.messager.confirm("警告", "你确定要删除吗?", function(result) {
			if (result) {
				$.post("system/customer/delCustomer", "id="
						+ $("#" + da).datagrid("getChecked")[0].id, function(
						data) {
					$.messager.show({
						title : '提示',
						msg : data.message,
						timeout : 5000,
						showType : 'slide'
					});
					$("#" + da).datagrid("reload");
				});
			}

		});
	} */
	//编辑客户
	function editCustomer(da) {
		var rows = $("#"+da).datagrid("getChecked");

		if (!rows.length) {
			parent.$.messager.alert("警告", "必须至少选择一行数据");
			return;
		}
		parent.openDialog({
			title : "编辑客户",
			url : "system/customer/editcustomer?id="
					+ $("#" + da).datagrid("getChecked")[0].id,
			close : function(){
				$("#"+da).datagrid("reload");
			}
		});
	}
		//全部
		function findall(da){
			$("#"+da).datagrid("load",{
				"condition[delete_status]" : null
			});
		}
		//我负责的
		function mycus(da){
			$("#"+da).datagrid("load",{
				"condition[delete_status]" : null,
				"condition[userid]" : parseInt("${sessionScope.user.id }")
			});
		}
		//下属负责的
		function mydown(da){
			$("#"+da).datagrid("load",{
				"condition[delete_status]" : null,
				"condition[mydown]" : parseInt("${sessionScope.user.id }")
			});
		}
		//下属创建的
		function mydcreate(da){
			$("#"+da).datagrid("load",{
				"condition[delete_status]" : null,
				"condition[mydowncreate]" : parseInt("${sessionScope.user.id }")
			});
		}

		
		//删除客户
		function delCustomer(da){
			parent.$.messager.confirm("警告","你确定要删除吗?",function(result){
				if(result){
					$.post("system/customer/delCustomer","id="+$("#"+da).datagrid("getChecked")[0].id,function(data){
						$.messager.show({
							title:'提示',
							msg:data.message,
							timeout:5000,
							showType:'slide'
						});

						$("#"+da).datagrid("reload");

					})
		}
	})
		}
		//批量删除可客户
	function delscustomer(da){
		var rows = $("#"+da).datagrid("getChecked");

		if (!rows.length) {
			parent.$.messager.alert("警告", "必须至少选择一行数据");
			return;
		}
		var ids = $("#"+da).datagrid("getChecked");
		var idd = "";
		$.each(ids,function(index,obj){
			idd += obj.id+",";
		});
		parent.$.messager.confirm("警告","你确定要删除这"+ids.length+"条数据吗?",function(result){
			if(result){
				$.post("system/customer/delscustomer",{"ids":idd},function(data){
					if(data.success){
						$.messager.show({
							title:'提示',
							msg:data.message,
							timeout:5000,
							showType:'slide'
						});
					}else{
						$.messager.show({
							title:'提示',
							msg:data.message,
							timeout:5000,
							showType:'slide'
						});
					}
				},"json");
				$("#"+da).datagrid("reload");
			}
		});
	}
	function close() {
		parent.$("#topWindow").dialog("close");
	}
	//编辑联系人
	function editContacts(id){
		parent.openDialog({
			title : "编辑联系人",
			url : "system/contacts/editContacts?id="+id,
			close : function(){
				$("#contacts").datagrid("reload");
			}
		})
	}
	//领取客户
	function Receive(da){
	 	var id = $("#"+da).datagrid("getChecked")[0].id;
	 	var owner = "${sessionScope.user.id}";
	 	$.post("system/customer/receive",{"id":id,"owner":owner},function(data){
			$.messager.show({
				title:"提示",
				msg : data.message,
				timeout : 5000,
				showType : 'slide'
			});
			$("#tabs").tabs("select",'客户');
		},"json")
	}
</script>

</html>