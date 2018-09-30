<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>首页</title>

<meta charset="utf-8">
<title>系统首页</title>
<%@include file="script.html" %>
  
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>

<body>
	<div id="master-layout">
		<!--顶部banner区开始-->
		<div
			data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
			<div class="theme-navigate">
				<div class="left">
					<h3 onclick="index()" style="display: inline;">京唐国际CRM</h3>
					<a   id="leads" style="margin-left: 20px;color: white;font-size: 15px">线索</a>
					<a   id="customer" style="margin-left: 20px;color: white;font-size: 15px">客户</a>
					<a   id="business" style="margin-left: 20px;color: white;font-size: 15px">商机</a>
					<a   id="product" style="margin-left: 20px;color: white;font-size: 15px">产品</a>
					<a   id="task" style="margin-left: 20px;color: white;font-size: 15px">任务</a>
					<a   id="" style="margin-left: 20px;color: white;font-size: 15px">日程</a>
					<a   id="contract" style="margin-left: 20px;color: white;font-size: 15px">合同</a>
					<a   id="" style="margin-left: 20px;color: white;font-size: 15px">财务</a>
					<a   id="" style="margin-left: 20px;color: white;font-size: 15px" class="easyui-menubutton" data-options="menu:'#more',hasDownArrow:false">更多</a>
					<div id="more" class="theme-navigate-menu-panel" data-options="iconCls:'icon-more'" style="width:180px;">
						<div id="">日志</div>
						<div id="">知识</div>
						<div id="Marketing">营销</div>
						<div id="message">站内信</div>
						<div class="menu-sep"></div>
						<div id="">个性化设置</div>
					</div>
				</div>
				<div class="right">
					<a href="#" class="easyui-menubutton" data-options="menu:'#mm1',hasDownArrow:false">消息
						<span class="badge color-orange">15</span>
					</a>
					<div id="mm1" class="theme-navigate-menu-panel"
						style="width:180px;">
						<div id="insideMessage">
							站内消息<span id="messagecount" class="badge color-success">5</span>
						</div>
						<div>
							公司公告<span class="badge color-important">10</span>
						</div>
						<div>服务消息</div>
						<div class="menu-sep"></div>
						<div>查看历史消息</div>
						<div class="menu-sep"></div>
						<div>清除消息提示</div>
					</div>
					<a href="#" class="easyui-menubutton theme-navigate-user-button"
						data-options="menu:'.theme-navigate-user-panel'">${sessionScope.user.username }</a>

					<div class="theme-navigate-user-panel">
						<dl>
							<dd>
								
								<img id="img" src="${sessionScope.user.usernote}" width="86" height="86"> 
								
								
								
								<b class="badge-prompt">${sessionScope.user.username }</b> 
								<span>${sessionScope.user.email}</span>
		
								<p>
									安全等级：<i class="text-success">高</i>
								</p>
							</dd>
							<dt>
								<!-- <a class="theme-navigate-user-modify">修改资料</a>  -->
								
								<a id="personal" class="easyui-linkbutton button-line-purple">修改资料</a>
								<a id="Right"  class="easyui-linkbutton button-line-purple">管理</a>
								<a id="colesa" class="easyui-linkbutton button-line-purple">注销</a>
								

								<!-- <a class="theme-navigate-user-logout">注销</a> -->
							</dt>
						</dl>
					</div>
				</div>
			</div>

		</div>
		<!--顶部banner区结束-->
		
		<!--右侧功能展示区开始-->
		<div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">
			<div id="tab1" title="个人中心">
				<div class="theme-user-info-panel">
					<div class="left">
						<img src="${sessionScope.user.usernote}" width="86" height="86">
					</div>
					
					<div class="center">
						<h1>
							${sessionScope.user.username }<span class="badge color-success">已认证</span>
						</h1>

						<h2>
							角色名
						</h2>
						<ul>
							<li><i class="iconfont">&#xe61c;</i> ${sessionScope.user.email}</li>
							<li><i class="iconfont">&#xe65d;</i> ${sessionScope.user.phone}</li>
						</ul>
					</div>
				</div>
				
				<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
					<div title="待办事项" style="padding:10px"></div>
					<div title="任务列表" style="padding:10px"></div>
					<div title="站内信息" style="padding:10px"></div>
				</div>
			</div>
		</div>
		<!--右侧功能展示区结束-->
		
		<div id="topWindow" style="overflow: hidden;"></div>
	</div>
	
	<!-- 在主页面打开一个标签页 -->
	<script type="text/javascript">
		//为各个连接添加点击事件的方法
		$(function(){
			$("#message").on('click',function(){   
				document.getElementById('tabs').innerHTML='<iframe src="system/message/message" width=100% height=100%></iframe>';
		     })
			$("#leads").on('click',function(){   
				document.getElementById('tabs').innerHTML='<iframe src="system/leads/leads" width=100% height=100%></iframe>';            
		     })

		     $("#Marketing").on('click',function(){   
				document.getElementById('tabs').innerHTML='<iframe src="system/Marketing/Marketing" width=100% height=100%></iframe>';
		     })
			

		     $("#product").on('click',function(){   
				document.getElementById('tabs').innerHTML='<iframe src="system/product/product" width=100% height=100%></iframe>';
		     })

	});
		//任务版块(钟晶)
		$(function(){
			var obj = document.getElementById('task'); 

			obj.onclick=function(){   

				document.getElementById('tabs').innerHTML='<iframe src="task/task" width=100% height=100%></iframe>';            

		     }
			});


      
		/**
		   跳转商机
		*/
		$(function(){
			var obj = document.getElementById('business'); 

			obj.onclick=function(){   

				document.getElementById('tabs').innerHTML='<iframe src="system/business/business" width=100% height=100%></iframe>';            

		     }

			});

	//返回主页的方法
	function index(){
	
		window.location.href="index";

		}


		$(function(){
			$("#contract").on("click",function(){
				$("#tabs").html('<iframe src="system/contract/list" width=100% height=100%></iframe>');
			});
			var obj = document.getElementById('customer'); 

			obj.onclick=function(){   

				document.getElementById('tabs').innerHTML='<iframe src="system/customer/customers" width=100% height=100%></iframe>';            

		     }

			});


	
		$(function () {
	        /*布局部分*/
	        $('#master-layout').layout({
	            fit: true/*布局框架全屏*/
	        });
	
	        $(".navigate-user-modify").on("click", function () {
	            $('.navigate-user-panel').menu('hide');
	           // $.insdep.window({id: "personal-set-window", href: "user.html", title: "修改资料"});
	        });
	    });

/*权限的点击事件
 * 
 */

 
	 $(function(){
			var obj = document.getElementById('Right'); 

			obj.onclick=function(){   

				document.getElementById('tabs').innerHTML='<iframe src="manage/manage" width=100% height=100%></iframe>';            

		     }});


	/**
	注销功能colesa
	**/
	$(function(){
	$("#colesa").on("click",function(){

	$.post("manage/colesa",function(data){
		$.messager.confirm("提示","确认要注销吗?",function(b){
			if(b){
				window.location.href=data.message;
			}
		});

		})


		})
	
		})
	 /*修改资料的点击事件
	  * 
	  */
	  $(function(){
	 			var obj = document.getElementById('personal'); 
	
	 			obj.onclick=function(){   
	
	 				document.getElementById('tabs').innerHTML='<iframe src="user/updateuser" width=100% height=100%></iframe>';            
	
	 }});
/**
 * 修改头像事件 img
 */
 $("#img").on("click",function(){


openDialog({
		title : "修改头像",
		url : "user/uploadindex",
		width : 600,
		height : 250,
		close : function (){
			$("#dataList").datagrid("reload");
		}
	});
	 })
/* 打开一个窗口 */
		function openDialog(options){
			
			$("#topWindow").dialog({
				"title" : options.title,
				"width" : options.width ? options.width : 800,
				"height" : options.height ? options.height : 600,
				"content" : "<iframe width='100%' height='100%' scrolling='no' frameborder='0' src='"+options.url+"' ></iframe>",
				"onClose" : options.close ? options.close : function(){}
			});
		}
	/*关闭窗口事件*/
		function closeDialog(){
			$("#topWindow").dialog("close");
		}


		//添加
	</script>
</html>
