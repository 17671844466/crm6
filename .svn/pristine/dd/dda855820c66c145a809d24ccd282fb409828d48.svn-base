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
<title>编辑联系人</title>
<%@include file="../script.html" %>
</head>
<body>
	<form style="margin-left:180px;margin-top:20px;" id="form1">
	<input hidden type="text" value="${contacts.id }" name="id"/>
	<table>
		<tr>
			<td style="text-align: right;">联系人姓名：</td>
			<td><input class="easyui-textbox border-pink" value="${contacts.name }" type="text" name="name"/></td>
			<td style="text-align: right;">尊称：</td>
			<td><input class="easyui-textbox border-pink" type="text" value="${contacts.saltname }" name="saltname"/></td>
		</tr>
		<tr>
			<td style="text-align: right;">电话：</td>
			<td><input class="easyui-textbox border-pink" value="${contacts.telephone }" type="text" name="telephone"/></td>
			<td style="text-align: right;">QQ：</td>
			<td><input class="easyui-textbox border-pink" value="${contacts.qqNo }" type="text" name="qqNo"/></td>
		</tr>
		<tr>
			<td style="text-align: right;">Email：</td>
			<td><input class="easyui-textbox border-pink" value="${contacts.email }" type="text" name="email"/></td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="4">
				<a href="javascript:void(0)" id="saveBtn" class="easyui-linkbutton">保存</a>
				<a href="javascript:void(0)" id="scloseBtn" class="easyui-linkbutton">取消</a>
				
			</td>
		</tr>
	</table>
	
</form>
</body>

<script type="text/javascript">
	$("#scloseBtn").on("click",function(){
		parent.$("#topWindow").dialog("close");
	});
	$("#saveBtn").on("click",function(){
		$.post("system/contacts/editContacts",$("#form1").serialize(),function(data){
			if(data.success){
				parent.$("#topWindow").dialog("close");
				
				parent.$.messager.show({
					title:'提示',
					msg:data.message,
					timeout:5000,
					showType:'slide'
				});
				return;
			}else{
				parent.$.messager.show({
					title:'警告',
					msg:data.message,
					timeout:5000,
					showType:'slide'
				});
			}
		});
	});
</script>
</html>
