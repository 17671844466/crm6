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
	<h4>添加说明</h4>
	<p style="color:red">
		1.邮件主题为查找模板是的根据,不能为空,不要添加同名的短信主题<br/>
		2.邮件标题为发送邮件时的标题,不能为空
		3.邮件顺序号代表选择模板时的优先程度,顺序号小的排在前面,取值范围0-9,默认值为5<br/>
	</p><br/><br/>
	&nbsp;&nbsp;邮件主题:<input id="subject" type="text" style="border:solid 1px black"/><span id="msg1"></span><br/>
	<br/><br/>
	&nbsp;&nbsp;邮件标题:<input id="title" type="text" style="border:solid 1px black"/><span id="msg2"></span><br/>
	<br/><br/>
	邮件顺序号:<select id="order">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5" selected>5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>
	<br/>
	<br/>
	<br/>
	
	邮件内容:<br/>
	
	<textarea id="content" rows="15" cols="40" placeholder="在这里填写你的模板内容..."></textarea>
	<a href="javascript:void(0)" id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加模板</a>

</body>
<script type="text/javascript">
	//定义参数进行前端校验
	var sub = false;
	var tit = false;
	//判断邮件标题是否为空
	$("#title").blur(function(){
		var title = $("#title").val();
		if(!title.trim().length){
			$("#msg2").html("<span style='color:red'>*邮件标题不能为空</span>");
		}else{
			tit=true;
		}
	})
	//判断是否存在同名主题
	$("#subject").blur(function(){
		var subject = $("#subject").val();
		if(!subject.trim().length){
			$("#msg1").html("<span style='color:red'>*邮件主题不能为空</span>");
		}else{
			$.post("system/Marketing/selectEmailTem",
					{"condition[subject]":subject},
					function(data){
						if(data.success){
							$("#msg1").html("<span style='color:red'>*该主题已存在</span>");
						}else{
							$("#msg1").html("<span style='color:green'>*该主题可用</span>");
							sub = true;
						}
					})
			}
	})
	
	
	//提交模板功能
	//添加模板提交按钮功能
	$("#add").on("click",function(){
		if(!sub){
			parent.$.messager.show({"title":"提示","msg":"请检查模板主题"});
			return;
		}
		if(!tit){
			parent.$.messager.show({"title":"提示","msg":"请检查模板标题"});
			return;
		}

		$.post("system/Marketing/addEmailTemplate",
				{"subject": $("#subject").val(),
				 "content":$("#content").val(),
				 "order":$("#order").val(),
				 "title":$("#title").val()
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