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
<title>站内信</title>
<meta charset="utf-8">
<%@include file="../script.html" %>
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>
	<h4>站内信</h4>
	<a href="javascript:void(0)" id="write" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">写信</a>
	<div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">
		<div  id="tab1" data-options="iconCls:'icon-man'"title="收件箱">
			<!-- 收件箱内容 -->
			<form>
			<div>发件人:<input id="fromuser" class="easyui-textbox" style="width:100px"> &nbsp; 
			读取状态:<select id="ready" height="3px" width="10px">
				<option value="-1">所有</option>
				<option value="0">未读</option>
				<option value="1">已读</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			接收时间:<input id="fromstart" class="easyui-datebox">到<input id="fromend" class="easyui-datebox">
			<a href="javascript:void(0)" id="serchget" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>	
			 </div>
			<table margin-left="100px" id="getMassageList"></table>
			</form>
		</div>
		<div id="tab2" title="发件箱">
		<div>收件人:<input id="touser" class="easyui-textbox" style="width:100px"> &nbsp; 
		发送时间:<input id="tostart" class="easyui-datebox">到<input id="toend" class="easyui-datebox">
		<a href="javascript:void(0)" id="serchset" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			<table margin-left="100px" id="setMassageList"></table>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	
	//分页查询所有站内信的方法,参数为查询条件
	function findByPage(condition){
		$("#getMassageList").datagrid({
			url : "system/message/fingByPage?"+condition,
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
	       	 {field:'content',title:'内容',width:400},
	       	 {field:'settername',title:'发件人',width:100},
	       	 {field:'status',title:'读取时间',width:100,formatter:function(value,row){
	        		if(row.status == 1){
	        			return row.readTime;
	       	 		}else{
	        			return "未读";
	        		}
	       	 }},
	       	 {field:'sendTime',title:'发送时间',width:100},
	       	 {field:'operation',title:'操作',width:100,formatter:function(value,row){
					return "<a href='javascript:void(0)' onclick='checkMessage("+row.id+")' >查看</a> | <a href='javascript:void(0)' onclick='deleteMessage("+row.id+",0)'>删除</a>"
		       }}
	    	]]
		});
	}

	//加载页面时进行分页查询添加数据,初始添加用户Id,以及用户是收件人还是发件人
	$(function(){
		findByPage("condition[userId]=${user.id}&condition[userType]=0");
		setterFindByPage("condition[userId]=${user.id}&condition[userType]=1");
	})

	//查看信息方法
	function checkMessage(messageId){
		parent.openDialog({
			title : "阅读信息",
			url : "system/message/read?messageId="+messageId,
			width : 400,
			height : 600,
			close : function (){
				$("#getMassageList").datagrid("reload");
			}
		});
	}
	//删除方法
	function deleteMessage(messageId,userType){
		$.post("system/message/delete?condition[messageId]="+messageId+"&condition[userType]="+userType,
				function(data){
					if(data.success){
						parent.$.messager.show({"title":"提示","msg":"删除成功"});
					}else{
						parent.$.messager.show({"title":"提示","msg":"删除失败"});
					}
					if(userType = 0){
						$("#getMassageList").datagrid("reload");
					}else{
						$("#setMassageList").datagrid("reload");
						}
					
			})
	}
	//收件人的搜素方法
	$("#serchget").on("click",function(){
		findByPage("condition[userId]=${user.id}"+
				   "&condition[userType]=0"+
				   "&condition[fromstart]="+($("#fromstart").val() ? $("#fromstart").val() : '')+
				   "&condition[fromend]="+($("#fromend").val() ? $("#fromend").val() : '' )+
				   "&condition[ready]="+($("#ready").val() != -1 ? $("#ready").val() : '')+
				   "&condition[fromuser]="+($("#fromuser").val() ? $("#fromuser").val() :'')
				   );
	})

	
	//发件人检查收件箱
		function setterFindByPage(condition){
		$("#setMassageList").datagrid({
			url : "system/message/fingByPage?"+condition,
			pagination : true,
			rownumbers : true,
			toolbar : "#toolbar",
			loadFilter : function(data){
				if(data && data.success){
					return data.data;
				}
			},
			columns : [[
	       	 {field:'id',checkbox:true,formatter:function(value,row){
						returnvalue.subsrt(0,30)+"...";	
		       	 }},
	       	 {field:'content',title:'内容',width:400},
	       	 {field:'gettername',title:'收件人',width:100},
	       	 {field:'sendTime',title:'发送时间',width:100},
	       	 {field:'operation',title:'操作',width:100,formatter:function(value,row){
					return "<a href='javascript:void(0)' onclick='checkMessage("+row.id+")' >查看</a> | <a href='javascript:void(0)' onclick='deleteMessage("+row.id+",1)'>删除</a>"
		       }}
	    	]]
		});
	}


	//发件人的搜素方法
	$("#serchset").on("click",function(){
		setterFindByPage("condition[userId]=${user.id}"+
				   "&condition[userType]=1"+
				   "&condition[tostart]="+($("#tostart").val() ? $("#tostart").val():'')+
				   "&condition[toend]="+($("#toend").val() ? $("#toend").val() :'')+
				   "&condition[touser]="+($("#touser").val() ? $("#touser").val() : '')
				   );
	})
	
	//写信
	$("#write").on("click",function(){
		parent.openDialog({
			title : "写信",
			url : "system/message/write",
			width : 700,
			height : 600,
			close : function (){
				$("#setMassageList").datagrid("reload");
			}
		});
		})
	
</script>

</html>