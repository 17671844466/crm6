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
<title>添加商机</title>
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
<div id="addLeads" class="easyui-panel" title="添加商机"
    style="width:100%;height:100%;padding:10px;background-color:white;" >
    
    <div id="addForm" class="easyui-panel" title="主要信息"
    style="width:100%;height:100%;padding:10px;background-color: white;" >
    		
    <form id="form" method="post">  
        <table cellpadding="100">  
           <tr style="height: 50px">  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">负责人:</td>  
              <td style="width: 250px;"><input class="easyui-textbox" type="text" name="owner"  style="width: 200px"/></td>  
             
          </tr>  
                        
         <tr style="height: 50px">  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">商机金额:</td>  
              <td style="width: 250px;"><input class="easyui-textbox" type="text" name="total_price"  style="width: 200px"/></td>  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">商机名 :</td> 
              <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 200px"></input></td>
          </tr>  
                        
          <tr>
              <td style="width: 200px;text-align: right;background-color:#fafafa ">联系人:</td>  
               <td style="width: 250px;"><input class="easyui-textbox" type="text" name="contact" style="width: 200px"/></td>  
                             
        </tr>
                        
         <td style="width: 200px;text-align: right;background-color:#fafafa ">合同签订地址:</td>  
                         <td colspan="2"><select class="easyui-combobox" name="contract_address" style="width: 100px;">  
                           			<option value="0">湖北</option> 
                                    <option value="1">上海</option>  
                                    <option value="2">南京</option>  
                                   
                                </select>  
                                
                                  <select class="easyui-combobox" name="contract_address" style="width: 100px;">  
                           			<option value="0">全部</option> 
                                    <option value="1">武汉</option>
                                    <option value="2">美国</option>  
                                       
                                </select>  
                             <select class="easyui-combobox" name="contract_address" style="width: 100px;">  
                           			<option value="0">全部</option> 
                                    <option value="1">光谷</option>  
                                       
                                </select>  
                              
              
                       		
         </tr>  
                        
                        
        <tr style="height: 50px">  
              <td style="width: 200px;text-align: right;background-color:#fafafa ">商机类型:</td>  
               <td><select class="easyui-combobox" name="type" style="width: 172px;">  
                     <option value="0">--请选择--</option> 
                    <option value="1">金融</option>  
                    <option value="2">市场</option>  
                                   
                   </select>  
                   </td>  
                            
                 <td style="width: 200px;text-align: right;background-color:#fafafa ">状态:</td>  
                         <td colspan="2"><select class="easyui-combobox" name="status" style="width: 172px;">  
                           			<option value="0">意向用户</option> 
                                    <option value="1"></option>  
                                    <option value="2"></option>  
                                   
                                </select>  
                             </td>                
                        
                        </tr>
                        
                          <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">商机来源:</td>  
                           <td><select class="easyui-combobox" name="origin" style="width: 172px;">  
                            <option value="0">--请选择--</option> 
                            <option value="1">网络营销</option>  
                            <option value="2">电话营销 </option>  
                                   
                          </select>  
                   </td>  
                       		 <td style="width: 200px;text-align: right;background-color:#fafafa ">赢单率 :</td> 
                             <td><input class="easyui-textbox" type="text" name="gain_rate" style="width: 200px"></input></td>
                        </tr>  
                        
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">预计成交价:</td>  
                            <td style="width: 250px;"><input class="easyui-textbox" type="text" name="estimate_price" data-options="required:true"   style="width: 200px"/></td>  
                       		 <td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系时间:</td> 
                            <td colspan="2"><input class="easyui-datebox" type="text" name="nextStepTime" style="width: 200px"></input></td>  
                        </tr>  
                        
                        <tr>
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系内容:</td> 
                            <td ><input class="easyui-textbox" type="text" name="nextStep"  style="width: 200px"></input></td> 
                        </tr>
                       
                        <tr style="height: 50px">  
                            <td colspan="5">附加信息</td> 
                        </tr> 
                         <tr style="height: 150px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">备注:</td> 
                            <td colspan="4" ><input class="easyui-textbox" type="text" name="note" style="width: 200px;height: 200px"></input></td>  
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5" style="text-align: center;">
                            <input id="saveBtn" type="button"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="保存"></input>
                            <input id="resetBtn" type="button"   class="easyui-linkbutton reset-button" style="width: 100px;height: 30px"  value="重置"></input>
                             <input id="backBtn"  type="button"  class="easyui-linkbutton back-button"  style="width: 100px;height: 30px" value="返回"></input>
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
				//重置
	    		$("#resetBtn").on("click",function(){
	    			$("#form").form("reset");
	    		})
                //返回
	      	   	$("#backBtn").on('click',function(){  
					window.location.replace("system/business/addBusiness");  
			     })
                //保存
	    		$("#saveBtn").on("click",function(){
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}	
					 
					$.post("system/business/saveBusiness",$("#form").serialize(),function(data){				
						if(data){	
		       			  parent.$.messager.alert({
			       				title:"提示",
			       				msg:data.message,
		       				}) 
		       				window.location.replace("system/business/business");  				
		     			}else{
		    				$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			})
		     			}
					},"json")	

				
				})

				
			     
			});

               

             
			


 </script>
</html>