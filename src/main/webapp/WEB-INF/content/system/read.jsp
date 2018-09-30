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
    body{
		font-size:15px;    
    }
</style>
</head>
<body align="center">
	
	发件人:${message.gettername}<br/>
	收件人:${message.settername}<br/>
	信件内容:<br>
	<textarea rows="30" cols="30"  readonly>${message.content }</textarea><br>
	发送时间:${ message.sendTime}
</body>
</html>