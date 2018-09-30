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
<div id="addLeads" class="easyui-panel" title="推进信息"
    style="width:100%;height:100%;padding:10px;background-color:white;" >
    
    <div id="addForm" class="easyui-panel" title="推进信息 "
    style="width:100%;height:100%;padding:10px;background-color: white;" >
    		
    <form id="form" method="post">  
        <table cellpadding="100">  
           <tr style="height: 50px">  
               <td style="width: 200px;text-align: right;background-color:#fafafa;padding-left: 250px">遇到阶段:</td> 
              <td  >
                 <select class="easyui-combobox" style="width: 200px">
                    <option value="-1">项目成功</option>
                 </select>
              
              </td>
               
             <!--  <td style="width: 250px;"><input class="easyui-textbox" type="text" name="owner"  style="width: 200px"/></td>   -->
          
          </tr>  
       
         <tr>
           <!--   <td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系:</td>   -->
           

       <td style="width: 200px;text-align: right;background-color:#fafafa;padding-left: 250px">下次联系时间:</td> 
      <td><input class="easyui-datebox"  name="nextstepTime" style="width: 200px;padding-left: 10px"></input></td> 
      
                                                                                                           			                               
         </tr>      
         <tr>
           <td style="width: 200px;text-align: right;background-color:#fafafa;padding-left: 250px">下次联系内容:</td>  
         <td><input type="text" class="easyui-textbox" style="width: 200px"/></td>                          
         </tr>       
  
                     
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">阶段描述:</td> 
                            <td colspan="4" ><input class="easyui-textbox" type="text" name="note" style="width: 200px;height: 200px"></input></td>  
                        </tr> 
                       <tr style="height: 50px">  
                            <td colspan="5">
                            <input id="saveBtn" type="button" class="easyui-linkbutton" style="width: 60px;height:30px; margin-left: 450px" value="推进">
                            <input id="setBtn" type="button" class="easyui-linkbutton" style="width: 60px;height:30px; margin-left: 80px" value="返回">
                             
                     
                            </td>  
                        </tr> 
                    </table>  
                </form>  
	</div>
	
</div>
</div>

</body>
    <script type="text/javascript">
           $(function(){
              $("#setBtn").on('click',function(){
            	  window.location.replace("system/business/business");  

                  })

              	$("#saveBtn").on("click",function(){
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}	
					
					$.post("system/business/advance",$("#form").serialize(),function(data){				
						if(data.b){
							$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
		       				window.location.replace("system/business/business");  				
		     			}else{
		    				$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
		     			}
					},"json")	

					
				})
 
         
                  
               })




    </script>
  
</html>