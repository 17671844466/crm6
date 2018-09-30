<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>增加修改角色</title>
<meta charset="utf-8">
<%@include file="../script.html" %>
<script type="text/javascript" src="static/easyui/common.js">
	</script>	
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>


    		
<form id="form" method="post">  

   <table cellpadding="100" border="0">  
   <!-- 第一行 -->
       <tr style="height: 50px">  
     
          <td style="width: 100px;text-align: right;background-color:#fafafa ">角色名:</td>  
          <td style="width: 200px;">
          <input class="easyui-textbox" type="text" name="rolename" value="${role.rolename }" style="width: 200px"/>
          </td>  
     	<td style="width: 100px;text-align: right;background-color:#fafafa ">角色状态:</td> 
     	<td>
				<select id="parentid" class="easyui-combobox" name="state"  style="width: 200px;">  
         			<option value="1">可用</option> 
                 	<option value="0">禁用</option> 
                 	<option value="2">删除</option> 
              </select>      	
        </td>
      </tr>  
      <!-- 第二行 -->
      <tr style="height: 50px">  
         <td style="width: 100px;text-align: right;background-color:#fafafa ">描述信息:</td>  
        <td colspan="3">
         <input class="easyui-textbox" type="text" name="rolenote" value="${role.rolenote }" style="width: 100%"></input>
         </td>
         </tr>  
         <!-- 第三行 -->
        <tr>
        <td  colspan="4" align="center">
     	<div id="chak">
     	
     	
        <c:forEach items="${list }" var="li">
        
        <input name="role" value="${li.id }" type="checkbox" style="font-size:40px;"> ${li.funcname }</input>
        &nbsp  &nbsp
       
        </c:forEach>
     
       </div>
        </td>
        </tr>
        
         <!-- 第五行-->
         <tr style="height: 50px">  
             <td colspan="5" style="text-align: center;">
             <input id="saveBtn" type="button"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="保存"></input>
             <input id="resetBtn" type="button"   class="easyui-linkbutton reset-button" style="width: 100px;height: 30px"  value="重置"></input>
              <input id="backBtn"  type="button"  class="easyui-linkbutton back-button"  style="width: 100px;height: 30px" value="返回"></input>
             </td>  
         </tr> 
     </table> 
     <input name="id" type="hidden" value="${role.id }" /> 
     <input id="func" name="func" type="hidden" /> 
 </form>  

</body>
<script type="text/javascript">
$(function(){
	var s= "${list2}";
	var strs= new Array(); //定义一数组

	strs=s.split(","); //字符分割 
	
	
	
	$("#parentid").combobox('setValue','${role.state}');
 
	$.each(strs,function(index,li){
		 $("input[value='"+li+"']").attr("checked","true"); 
		}) ; 
	
});
			
$(function(){

	
	
	//返回上一页
	$("#backBtn").on('click',function(){  
		parent.$("#topWindow").dialog("close");  
     })

	//重置
  		$("#resetBtn").on("click",function(){
  			$("#form").form("reset");
  		})

  		//保存
  		$("#saveBtn").on("click",function(){
		var isValid = $("#form").form("validate");
		if(!isValid){
			return;
		}	
		//拼接多选框
		obj = document.getElementsByName("role");
	    check_val = [];
	    for(k in obj){
	        if(obj[k].checked)
	            check_val.push(obj[k].value);
	    }
	    $("#func").val(check_val);
		
		$.post("manage/roles",$("#form").serialize(),function(data){				
			parent.$("#topWindow").dialog("close");
			parent.$.messager.show({
           			title:"提示",
           			msg:data.message,
       			})
    			
			
		},"json")			
	})
     
});

/* 拿到后台数据 */


</script>
</html>