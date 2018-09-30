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
<title>推进商机</title>
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
<div id="master-layout" style="height: 100%;width: 100%">

    
    
    		
    <form id="form" method="post">  
        <table cellpadding="100">  
           <tr style="height: 50px">  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">合同编号:</td>  
              <td style="width: 250px;"><input class="easyui-textbox" type="text" id="number" name="number"  /></td>  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">签约时间:</td> 
              <td><input class="easyui-datebox" type="text" name="name"  ></input></td>
          </tr>  
                        
         <tr style="height: 50px">  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">来源商机:</td>  
              <td style="width: 250px;"><input class="easyui-textbox" type="text" name="total_price"  /></td>  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">联系人 :</td> 
              <td><input class="easyui-textbox" type="text" name="contact" id="contact"  ></input></td>
          </tr>  
                        
          <tr>
              <td style="width: 200px;text-align: right;background-color:#fafafa ">来源客户:</td>  
               <td style="width: 250px;"><input class="easyui-textbox" type="text" id="customer" name="customer" /></td>  
                             
        </tr>
        <tr style="height: 50px">  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">负责人:</td>  
               <td><input type="text" class="easyui-textbox" value="${sessionScope.user.username }" name="owner"/> 
                   </td>  
                 <td style="width: 200px;text-align: right;background-color:#fafafa ">合同金额(元):</td>  
                         <td colspan="2"><input type="text" class="easyui-textbox" name="price"/>
                             </td>                
                        </tr>
                          <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">合同生效时间:</td>  
                           <td><input type="text" class="easyui-datetimebox" name="startdate"/>  
                   </td>  
                       		 <td style="width: 200px;text-align: right;background-color:#fafafa ">合同到期时间 :</td> 
                             <td><input class="easyui-datetimebox" type="text" name="enddate" /></td>
                        </tr>  
                        
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">条件和条款:</td>  
                       		<td colspan="2"><textarea cols="80" rows="10"></textarea></td>
                        </tr>  
                        <tr>
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">合同描述:</td> 
                            <td ><input class="easyui-textbox" type="text" name="nextStep"  ></input></td> 
                        </tr>
                        <tr style="height: 50px">  
                            <td colspan="5" style="text-align: center;">
                            <input id="saveBtn" type="button"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="保存"></input>
                            <input id="resetBtn" type="button"   class="easyui-linkbutton reset-button" style="width: 100px;height: 30px"  value="重置"></input>
                            </td>  
                        </tr> 
                    </table>  
                </form>  
	
</div>

</body>
<script type="text/javascript">
	$(function(){
		$('#contact').textbox('readonly',true);
		$('#customer').textbox('readonly',true);
		$("#number").textbox('setValue','rw'+new Date().getTime());
	});
	
</script>

</html>