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
		1.短信主题不能为空,不要添加同名的短信主题<br/>
		2.短信顺序号代表选择模板时的优先程度,顺序号小的排在前面,取值范围0-9,默认值为5<br/>
		3.短信内容不得多与65个字(空格,汉字,字母,数字均为一个字)
	</p><br/><br/>
	&nbsp;&nbsp;短信主题:<input id="subject" type="text" style="border:solid 1px black"/><span id="msg1"></span><br/>
	<br/><br/>
	短信顺序号:<select id="order">
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
	
	短信内容:<br/>
	
	<textarea id="content" rows="15" cols="40" placeholder="在这里填写你的模板内容..."></textarea>
	<span id="smsL">您还可以输入<span style="color:red">65</span>个字</span><br/><br/>
	<a href="javascript:void(0)" id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加模板</a>
</body>


<script type="text/javascript">
	//定义参数进行前端校验
	var sub = false;
	var con = false;
	//短信内容框提示剩余数字
	$("#content").on("input",function(){
		var size = 65-$("#content").val().length;
		con = size>=0;
		$("#smsL").html(con ? "您还可以输入<span style='color:red'>"+size+"</span>个字" : "<span style='color:red'>您输入的字数过多</span>");
	})

	//判断是否存在同名主题
	$("#subject").blur(function(){
		var subject = $("#subject").val();
		if(!subject.trim().length){
			$("#msg1").html("<span style='color:red'>*短信主题不能为空</span>");
		}else{
			$.post("system/Marketing/selectSmsTem",
					{"condition[subject]":subject},
					function(data){
						if(data.success){
							$("#msg1").html("<span style='color:red'>*该主题已存在</span>");
							sub = false;
						}else{
							$("#msg1").html("<span style='color:green'>*该主题可用</span>");
							sub = true;
						}
					})
			}
	})

	

	
	//添加模板提交按钮功能
	$("#add").on("click",function(){
		if(!sub){
			parent.$.messager.show({"title":"提示","msg":"请检查模板主题"});
			return;
		}
		if(!con){
			parent.$.messager.show({"title":"提示","msg":"请检查模板内容"});
			return;
		}

		$.post("system/Marketing/addSmsTemplate",
				{"subject": $("#subject").val(),
				 "content":$("#content").val(),
				 "order":$("#order").val()
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