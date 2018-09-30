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
<title>增加线索</title>
<meta charset="utf-8">
<%@include file="../script.html" %>
<script type="text/javascript" src="static/js/distpicker.data.js"></script>
<script type="text/javascript" src="static/js/distpicker.js"></script>
<script type="text/javascript" src="static/js/main.js"></script>
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
<div id="addLeads" class="easyui-panel" title="修改线索"
    style="width:100%;height:100%;padding:10px;background-color:white;" >
    
    <div id="addForm" class="easyui-panel" title="主要信息"
    style="width:100%;height:100%;padding:10px;background-color: white;" >
    		
    		<form id="form" method="post">  
                    <table cellpadding="100">  
                    	<tr style="height: 50px" hidden="true">  
                            <td colspan="5" style="text-align: center;">
                             <input  id="leadsId" class="easyui-textbox" name="id"  style="width: 200px"   value="${requestScope.leads.id }"/>
                            <input  id="createTime" class="easyui-textbox" name="createTime"  style="width: 200px"   value="${requestScope.createTime}"/>
                             <input  id="haveTime" class="easyui-textbox" name="haveTime"  style="width: 200px"   value="${requestScope.haveTime }"/>
                             <input  id="creatorUserId" class="easyui-textbox" name="creatorUserId"  style="width: 200px"   value="${requestScope.leads.creatorUserId }"/>
                             
                            </td>  
                        </tr> 
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">负责人:</td>  
                            <td style="width: 250px;">
                            <input  id="username" class="easyui-combobox" name="ownerUserId" value="${requestScope.leads.ownerUserId }" style="width: 200px"  />
                            </td>  
                       		<td style="width: 200px;">
                       		<input id="leadsPool" type="button" value="放入线索池" class="easyui-linkbutton" style="width: 100px;height: 30px" style="width: 200px"/>
                       		</td>
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">公司名:</td> 
                       		<td>
                       		<input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 200px" value="${requestScope.leads.name }"></input>
                       		</td>
                        </tr>  
                        <tr style="height: 50px">  
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">来源:</td>  
                            <td colspan="2"><select class="easyui-combobox" name="source" style="width: 172px;">  
                           			<option value="${requestScope.leads.source }">${requestScope.leads.source }</option> 
                                    <option value="网络">网络</option>  
                                    <option value="报刊">报刊</option>  
                                    <option value="微信">微信</option>  
                                </select>  
                             </td>  
                             <td style="width: 200px;text-align: right;background-color:#fafafa ">联系人姓名:</td>  
                            <td style="width: 250px;">
                            <input class="easyui-textbox" type="text" name="contactsName" data-options="required:true" style="width: 200px" value="${requestScope.leads.contactsName }"/>
                            </td>  
                             
                             
                        </tr>  
                        <tr style="height: 50px">  
                           	<td style="width: 200px;text-align: right;background-color:#fafafa ">职位:</td> 
                            <td colspan="2"><input class="easyui-textbox" type="text" name="position"  style="width: 200px" value="${requestScope.leads.position }"></input></td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">尊称:</td> 
                       		<td ><select class="easyui-combobox" name="saltname" style="width: 172px;">  
                           			<option value="${requestScope.leads.saltname }">${requestScope.leads.saltname }</option> 
                                    <option value="先生">先生</option>  
                                    <option value="女士">女士</option>  
                                </select>  
                             </td>  
                        </tr>  
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">手机:</td> 
                            <td colspan="2">
                            <input class="easyui-textbox" validType='mobile' name='mobile' invalidMessage="请输入正确的手机号码 "  data-options="required:true" style="width: 200px" value="${requestScope.leads.mobile }"></input>
                            </td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">邮箱:</td> 
                            <td >
                            <input class="easyui-textbox"  validType='email' name='email' invalidMessage="请输入正确的邮箱" style="width: 200px"  value="${requestScope.leads.email }"></input>
                            </td> 
                        </tr>  
                       
                       <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">地址:</td> 
                            <td colspan="4">
                            <div data-toggle="distpicker" style="display: inline;" data-province="${province }" data-city="${city }" data-district="${district }" >
	                            	<div class="form-group" style="display: inline;">
	                            		<label class="sr-only" for="province1"></label>
	                            		<select class="form-control" name="province" id="province1" style="height: 30px"></select>
	                            	</div>
	                            	<div class="form-group" style="display: inline;">
	                            		<label class="sr-only" for="city1"></label>
	                            		<select class="form-control" name="city" id="city1" style="height: 30px"></select>
	                            	</div>
	                            	<div class="form-group" style="display: inline;">
	                            		<label class="sr-only" for="district1"></label>
	                            		<select class="form-control" name="district" id="district1" style="height: 30px"></select>
	                            	</div>
	                            	<input class="easyui-textbox" type="text"  value="${road }" name="road" style="height: 30px"/>
                            	</div>
                            </td>  
                       		
                        </tr>  
                       
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系时间:</td> 
                            <td colspan="2"><input class="easyui-datebox"  name="nextstepTime" style="width: 200px" value="${requestScope.nextstepTime }"></input></td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">下次联系内容:</td> 
                            <td ><input class="easyui-textbox" type="text" name="nextstep"  style="width: 200px" value="${requestScope.leads.nextstep }"></input></td> 
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5">附加信息</td> 
                        </tr> 
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">备注:</td> 
                            <td colspan="4"><input class="easyui-textbox" type="text" name="leadnote" style="width: 200px" value="${requestScope.leads.leadnote }"></input></td>  
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5" style="text-align: center;">
                            <input id="saveBtn" type="button"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="保存修改"></input>
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
				$("select[name='province']").val('${province}');
				$("select[name='city']").val('${city}');
				$("select[name='district']").val('${district}');


				
				//负责人下拉框
				$("#username").combobox({
					url : "system/leads/listUser",
					valueField : "id",
					textField : "username",

					loadFilter : function(data){
						if(data && data.success){
							return data.data;
						}
					}
				});
				//返回上一页
				$("#backBtn").on('click',function(){  
					window.location.replace("system/leads/leads");  
			     })

				
	    		//保存
	    		$("#saveBtn").on("click",function(){
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}	
					
					$.post("system/leads/updateLeads",$("#form").serialize(),function(data){				
						if(data.b){
							$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
		       				window.location.replace("system/leads/leads");  				
		     			}else{
		    				$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
		     			}
					},"json")	

					
				})

				//放入线索池
	    		$("#leadsPool").on("click",function(){
	    			$('#username').combobox('setValue', '');
	    		})
			     
			});

		
		

</script>
</html>