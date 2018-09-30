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
			


	<form id="upload" name="" action="user/upload" method="post" enctype="multipart/form-data">
	<input id="file" name="file" type="file">
	<br>
	<input type="submit">
	</form>
	
			</div>
	
	<script type="text/javascript">
	
	/* 上传方法 */
	 $(function(){
		$("#upload").on("submit",function(event) 
		{
	event.preventDefault();
      
         var formData = new FormData($( "#upload" )[0]);  
         $.ajax({  
              url: 'user/upload' ,  
              type: 'POST',  
              data: formData,  
              async: false,  
              cache: false,  
              contentType: false,  
              processData: false,  
              success: function (data) { 
            	  parent.$("#topWindow").dialog("close");
            	  if (data && data.success) {
            		
  					parent.$.messager.show({
  		           			title:"提示",
  		           			msg:data.message,
  		       			})
  				}  
                  
              },
              error: function (returndata) {  
                  alert(returndata);  
              } 
         });  
			      
		})

	}) 

	
	</script>
</body>
</html>

