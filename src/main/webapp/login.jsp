<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

    <head>
		<base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录CRM系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="static/login/css/reset.css">
        <link rel="stylesheet" href="static/login/css/supersized.css">
        <link rel="stylesheet" href="static/login/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>

    <body>

        <div class="page-container">
            <h1>登陆CRM系统</h1>
            <form id="form1" action="" method="post">
            	<p id="msg" style="margin-bottom: -20px;"></p>
                <input type="text" name="username" class="username" placeholder="用户名">
                <input type="password" name="password" class="password" placeholder="密码">
                <button type="submit">登陆</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>
                  
                </p>
            </div>
        </div>

        <!-- Javascript -->
        <script src="static/login/js/jquery-1.8.2.min.js"></script>
        <script src="static/login/js/supersized.3.2.7.min.js"></script>
        <script src="static/login/js/supersized-init.js"></script>
        <script src="static/login/js/scripts.js"></script>
		<script type="text/javascript">
			function check(value,pattern){
				var regexp = new RegExp(pattern);
				return regexp.test(value);
			}
			$(document).ready(function(){
				$("input[name=username]").on("input",function(){
					var pattern = "[A-Za-z0-9_\-\u4e00-\u9fa5]{5,12}";
					var username = $("input[name=username]").val();
					if(username == ''){
						$("#msg").html("用户名不能为空").css({"color":"red","font-size":"12px","font-weight":"bold"});
					}else if(!check(username,pattern)){
						$("#msg").html("用户名是数字英文组合，且长度在5~12之间").css({"color":"red","font-size":"12px","font-weight":"bold"});
					}
					else{
						$("#msg").html("");
					}
				});
				$("input[name=password]").on("input",function(){
					var pattern = "^[a-zA-Z0-9]{6,16}$";
					var password = $("input[name=password]").val();
					if(password == ''){
						$("#msg").html("密码不能为空").css({"color":"red","font-size":"12px","font-weight":"bold"});
					}else if(!check(password,pattern)){
						$("#msg").html("密码必须是数字英文字母组合，且长度在6~16之间").css({"color":"red","font-size":"12px","font-weight":"bold"});
					}
					else{
						$("#msg").html("");
					}
					
				});
	
				$("#form1").on("submit",function(event){
					event.preventDefault();
					var password = $("input[name=password]").val();
					var username = $("input[name=username]").val();
					if(password == ''){
						$("#msg").html("密码不能为空").css({"color":"red","font-size":"12px","font-weight":"bold"});
						return;
					}else if(!check(password,"^[a-zA-Z0-9]{6,16}$")){
						$("#msg").html("密码必须是数字英文字母组合，且长度在6~16之间").css({"color":"red","font-size":"12px","font-weight":"bold"});
						return;
					}
					else{
						$("#msg").html("");
					}
					
					if(username == ''){
						$("#msg").html("用户名不能为空").css({"color":"red","font-size":"12px","font-weight":"bold"});
						return;
					}else if(!check(username,"[a-zA-Z][0-9a-zA-Z]{1,9}")){
						$("#msg").html("用户名是数字英文组合，且长度在5~12之间").css({"color":"red","font-size":"12px","font-weight":"bold"});
						return;
					}
					else{
						$("#msg").html("");
					}
					$.post("logon",$("#form1").serialize(),function(data){
						if(data && !data.success){
							$("#msg").html(data.message).css({"color":"red","font-size":"12px","font-weight":"bold"});
						}else{
							window.location.href = "index";
						}
					},"json")
				});
			});
		</script>
    </body>

</html>

