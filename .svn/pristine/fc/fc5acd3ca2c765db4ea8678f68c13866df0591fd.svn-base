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
<title>修改商机</title>
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
<div id="addLeads" class="easyui-panel" title="修改商机"
    style="width:100%;height:100%;padding:10px;background-color:white;" >
    
    <div id="addForm" class="easyui-panel" title="主要信息"
    style="width:100%;height:100%;padding:10px;background-color: white;" >
    	<form id="form" method="post"> 
    	  <table cellpadding="100">  
    	    <tr style="height: 50px" hidden="true">
    	        <td colspan="5" style="text-align: center;">
    		 
            <input id="businessId" type="text" hidden value="${business.id }" name="business.id"/>
    		<%-- <input id="createTime" type="text" hidden value="${business.create_time }" name="createTime"/>
   		
    		<input id="creatorUserId" type="text" hidden value="${business.creatoruserid }" name="creatorUserId"/> --%>
    		
                 </td>    
                    	
             </tr>                 
                            
                                                  
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">负责人:</td>  
                            <td style="width: 250px;">
                            <input  id="username" class="easyui-combobox" name="ownerUserId" value="${business.ownerUserId }" style="width: 200px"  />
                            </td>  
                    
                        </tr>  
                        
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">商机金额:</td>  
                            <td style="width: 250px;">
                            <input class="easyui-combobox" name="totalPrice" value="${business.totalPrice }" style="width: 200px"  />
                            </td>  
                       		
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">商机名:</td> 
                       		<td>
                       		<input class="easyui-textbox" type="text" name="name" style="width: 200px" value="${business.name }"></input>
                       		</td>
                        </tr>  
                         
                         
                       
                         
                         <tr>
                          <td style="width: 200px;text-align: right;background-color:#fafafa ">联系人:</td>  
                            <td style="width: 250px;">
                            <input class="easyui-textbox" type="text" name="name"  style="width: 200px" value="${business.name }"/>
                            </td>  
                         
                         
                         </tr>
                         
                          
                       <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">地址:</td> 
                            <td colspan="4"><input class="easyui-textbox" type="text" name="contractAddress"  style="width: 200px"  value="${business.contractAddress }"></input></td>  
                       		
                        </tr>  
                        
                        
                         <tr style="height: 50px">  
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">商机类型:</td> 
                       		<td>
                       		   <select class="easyui-combobox" name="type" style="width: 172px;">  
                           			<option value="${business.type }">${business.type }</option> 
                                    <option value="新业务">新业务</option>  
                                    <option value="旧业务">旧业务</option>  
                                   
                                </select>  
                       		</td>
                       		
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">状态:</td> 
                       		<td>
                       		<select class="easyui-combobox" name="status" style="width: 172px;">  
                           			<option value="${business.statusIid }">${business.statusIid }</option> 
                                    <option value="深度沟通">深度沟通</option>  
                                    <option value="接触">接触</option>  
                                   
                                </select>  
                       		</td>
                             
                        </tr>  
                        
                       <tr style="height: 50px">  
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">商机来源:</td> 
                       		<td>
                       		   <select class="easyui-combobox" name="origin" style="width: 172px;">  
                           			<option value="${business.origin }">${business.origin }</option> 
                                    <option value="网络营销">网络营销</option>  
                                    <option value="电话营销">电话营销</option>  
                                   
                                </select>  
                       		</td>
                       		
                       		
                       		
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">赢单率:</td> 
                       		<td>
                       		<input class="easyui-textbox" type="text" name="gainRrate" style="width: 200px" value="${business.gainRrate }"></input>(注:%)
                       		</td>
                             
                        </tr>  
                        
                        <tr style="height: 50px">  
                          
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">预计成交价:</td> 
                            <td >
                            <input class="easyui-textbox" name='estimatePrice' style="width: 200px" data-options="required:true" value="${business.estimatePrice }"></input>(单位:元)
                            </td> 
                            
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系时间:</td> 
                            <td colspan="2"><input class="easyui-datebox"  name="nextstepTime" style="width: 200px" value="${business.nextstepTime }"></input></td>  
                        </tr>  
                      
                       
                        <tr style="height: 50px">  
                            
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系内容:</td> 
                            <td ><input class="easyui-textbox" type="text" name="nextstep"  style="width: 200px" value="${business.nextstep }"></input></td> 
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5">附加信息</td> 
                        </tr> 
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">备注:</td> 
                            <td colspan="4"><input class="easyui-textbox" type="text" name="description" style="width: 200px" value="${business.description }"></input></td>  
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5" style="text-align: center;">
                            <input id="saveBtn" type="button"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="修改"></input>
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
				//负责人下拉框
				$("#username").combobox({
					url : "system/business/listUser",
					valueField : "id",
					textField : "username",

					loadFilter : function(data){
						if(data && data.success){
							return data.data;
						}
					}
				});
				//返回
				$("#backBtn").on('click',function(){  
					window.location.replace("system/business/business");  
			     })

				
	    		//修改
	    		$("#saveBtn").on("click",function(){
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}	
					
					$.post("system/business/updateBusiness",$("#form").serialize(),function(data){				
						if(data){
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

				
			});

		
		

</script>
</html>