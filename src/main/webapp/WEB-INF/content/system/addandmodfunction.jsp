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
<title>增加修改权限</title>
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
     
          <td style="width: 100px;text-align: right;background-color:#fafafa ">权限名:</td>  
          <td style="width: 200px;">
          <input class="easyui-textbox" type="text" name="funcname" value="${function.funcname }" style="width: 200px"/>
          </td>  
     	<td style="width: 100px;text-align: right;background-color:#fafafa ">权限地址:</td> 
     	<td>
     	<input class="easyui-textbox" type="text" name="funcurl" value="${function.funcurl }" data-options="required:true" style="width: 200px"></input>
     	</td>
      </tr>  
      <!-- 第二行 -->
      <tr style="height: 50px">  
         <td style="width: 100px;text-align: right;background-color:#fafafa ">所属父类:</td>  
          <td>
          <select id="parentid" class="easyui-combobox" name="parentid"  style="width: 200px;">  
         			<option value="-1">--不选择--</option> 
                 	 <c:forEach items="${list}" var="li" >
                 	 
                 	 <option value="${li.id }">${li.funcname }</option> 
                 	
                 	 </c:forEach>
              </select>  
           </td>  
          <td style="width: 100px;text-align: right;background-color:#fafafa ">模块编码:</td>  
          <td colspan="2">
               	<input class="easyui-textbox" type="text" name="funccode" value="${function.funccode }" data-options="required:true" style="width: 200px"></input></td>
           </td>
         </tr>  
         <!-- 第三行 -->
         <tr style="height: 50px">  
            	<td style="width: 100px;text-align: right;background-color:#fafafa ">功能类型:</td> 
             <td>
             <select id="functype" class="easyui-combobox" name="functype"  style="width: 200px;">  
         			
                  <option value="1">菜单</option>  
                  <option value="0">按钮</option>  
              </select> 
			</td>  
        		<td style="width: 100px;text-align: right;background-color:#fafafa ">状态:</td> 
        		<td>
				<select id="state" class="easyui-combobox" name="state" style="width: 200px;">  
         			
                  <option value="1">可用</option>  
                  <option value="0">禁用</option>  
              </select>              
               </td>  
         </tr>  
        <!-- 第四行 -->
         <tr style="height: 50px">  
             <td colspan="5">附加信息</td> 
         </tr> 
          <tr style="height: 50px">  
             <td style="width: 100px;text-align: right;background-color:#fafafa ">备注:</td> 
             <td colspan="4"><input class="easyui-textbox" type="text" name="funcnote" value="${function.funcnote }" style="width: 100%"></input></td>  
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
     <input name="id" type="hidden" value="${function.id }" /> 
 </form>  

</body>
<script type="text/javascript">
$(function(){
	$("#parentid").combobox('setValue','${function.parentid}');
	$("#functype").combobox('setValue','${function.functype}');
	$("#state").combobox('setValue','${function.state}');
	
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
		
		$.post("manage/addfun",$("#form").serialize(),function(data){				
			parent.$("#topWindow").dialog("close");
			parent.$.messager.show({
           			title:"提示",
           			msg:data.message,
       			})
    			
			
		},"json")			
	})
     
});

		


</script>
</html>