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
<title>管理</title>
<meta charset="utf-8">
<%@include file="../script.html" %>
 
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>

<body>
    <div class="easyui-layout" style="width:100%;height:100%;">
    	<div region="west" split="true" title="权限菜单" style="width:150px;">
    		<p style="padding:5px;margin:0;">菜单:</p>
    		<ul id="menu"></ul>
    	</div>
    	<div id="content" region="center" title="" style="padding:5px">
    		<iframe id="iframe"  width=100% height=100% frameborder=0 scrolling="auto"></iframe>
    	</div>
    </div>
	</body>
	<script type="text/javascript">
	$(function(){
		
		//初始化菜单树
		$("#menu").tree({
			"url" : "manage/menu",
			"loadFilter" : function(data){
				
				if(data && data.success){

					
					return data.data;
				}
				return null;
			},
			"onClick" : function(node){
				if(node && node.attributes){
					if(node.attributes.url){
						$("#iframe").attr("src",node.attributes.url) 
						/*  addTab(node.text, node.attributes.url);*/
					}
				}
			}
		});
	});


	</script>
	
	</html>
	