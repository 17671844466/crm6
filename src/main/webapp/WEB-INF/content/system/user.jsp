<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>信息添加修改</title>
<%@include file="../script.html"%>


</head>
<body>
	<div id="center" style="margin:0 auto; width:400px; height:100px;">
			


	<!-- 第一行 -->

	<img width="20" height="20" alt="" src="${user.usernote }"><br>
	

	<!-- 第二行 -->

	<hr>
	
	<br>
	<form id="addupdateuser" name="form" action="">
	<span id="info"></span>
<br>
	<!-- 第三行 -->

	用户名: <input id="username" value="${user.username }" name="username" class="easyui-textbox"
		prompt="输入用户名" style="width: 300px"><br><br>

<!-- 	第四行 -->

	手机号: <input id="phone" name="phone" value="${user.phone }" class="easyui-textbox"
		prompt="输入手机号" style="width: 300px"><br><br>

	<!-- 第五行 -->

	工作邮箱: <input id="email" name="email" value="${user.email }" class="easyui-textbox"
		prompt="输入邮箱地址" style="width: 300px"><br><br>

	<!-- 第六行 -->

	<%-- 备注信息: <input id="usernote" name="usernote" value="${user.usernote }" class="easyui-textbox"
		multiline="true" style="width: 300px"><br><br> --%>

	<!-- 第7行 -->
用户状态:
		<select id="parentid" class="easyui-combobox" name="state"  style="width: 200px;">  
     			<option value="1">可用</option> 
             	<option value="0">禁用</option> 
             	<option value="2">删除</option> 
          </select>  
          <br><br>
		
	创建时间: <input id="createtime" value="${user.createtime }" class="easyui-textbox" readonly="true"
		style="width: 300px"><br> <br>
		<input id="id" name="id" value="${user.id }" type="hidden" />
		<a id="cc" class="easyui-linkbutton button-line-blue"
		onclick="a()">提交</a>
		<a id="colse" class="easyui-linkbutton button-line-blue">取消</a>


</form> 

			</div>
	
	<script type="text/javascript">
	
$(function(){
		$("#parentid").combobox('setValue','${user.state}');
	
		})
	
/* 正则验证 */
	function check(value, pattern){
		var regexp = new  RegExp(pattern);
		return regexp.test(value);
	};

	function a(){
	
	 $("form").submit(); 
	
		}
	/* 关闭窗口方法 */
 $(function(){

	 $("#colse").on("click",function(){

			parent.parent.$("#topWindow").dialog("close");
			})

		
	$("#addupdateuser").on("submit",function(event) 
	{
			event.preventDefault();

		
				//对表单数据进行校验
		if (!check($("input[name=username]").val(),'^[a-zA-Z0-9]{5,20}$')) 
	{
			$("#info").html("用户名必须是数字英文字母组合，且长度为5到20位").css({
				"font-weight" : "bold",
				"color" : "#F00"});return;
		}

	/* if (!check($("input[name=phone]").val(),
	'^1(3|5|7|8)\d{9}$')) 
	{
		$("#info").html("手机号码不正确").css({
	"font-weight" : "bold",
		"color" : "#F00"});
	return;
	} */
	/* if (!check($("input[name=email]").val(),
	'^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$')) 
	{
	$("#info").html("邮箱地址不正确").css({
		"font-weight" : "bold",
		"color" : "#F00"});
		return;
	}  */
				

			//发送ajax请求
			 $.post("user/addeditusers", $(this).serialize(), function(data) {
				
				if (data && data.success) {
					parent.$("#topWindow").dialog("close");
					parent.$.messager.show({
		           			title:"提示",
		           			msg:data.message,
		       			})
					return;
				} else if (data && !data.success) {
					$("#info").html(data.message).css({
						"font-weight" : "bold",
						"color" : "#F00"
					});
				}

			}, "json"); 

	})  
	});
	
	</script>
</body>
</html>

