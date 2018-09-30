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
    td{
    	height:30px;
    }
</style>
</head>
<body>
<div id="master-layout" style="height: 100%;width: 100%">
    		<form id="form" method="post">  
    		<input type="text" hidden value="${sessionScope.user.id} " name="customer.creatorUserId"/>
    		<input type="text" hidden value="${sessionScope.user.id} " name="contacts.creatorUserId"/>
                    <table cellpadding="100">  
                    <tr style="height:30px;"><td style="font-weight:bold;">主要信息</td></tr>
                        <tr style="height: 40px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">负责人:</td>  
                            <td style="width: 250px;"><input class="easyui-textbox" id="username" type="text" name="name" value="${sessionScope.user.username} " style="width: 200px"/></td>  
                       		<td style="width: 200px;"><input type="button" id="putpool" value="放入客户池" class="easyui-linkbutton" style="width: 100px;height: 30px" style="width: 200px"/></td>
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">客户名称:</td> 
                       		<td><input class="easyui-textbox" type="text" name="customer.name" data-options="required:true" style="width: 200px"></input></td>
                        </tr>  
                        <tr style="height: 40px">  
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">客户行业:</td>  
                            <td colspan="2"><select class="easyui-combobox" name="customer.industry" style="width: 200px;">  
                           			<option value="0">--请选择--</option> 
                                    <option value="保险业">保险业</option>  
                                    <option value="能源">能源</option>  
                                    <option value="餐饮">餐饮</option>  
                                    <option value="医疗服务">医疗服务</option>
                                    <option value="金融">金融</option>
                                    <option value="政府机关">政府机关</option>
                                    <option value="体育运动">体育运动</option>
                                    <option value="航空航天">航空航天</option>
                                    <option value="公益组织">公益组织</option>
                                </select>  
                             </td>  
                             <td style="width: 200px;text-align: right;background-color:#fafafa ">客户信息来源:</td>  
                             <td colspan="2"><select class="easyui-combobox" name="customer.origin" style="width: 200px;">  
                           			<option value="0">--请选择--</option> 
                                    <option value="网页">网页</option>  
                                    <option value="朋友推荐">朋友推荐</option>  
                                    <option value="微信">微信</option>  
                                    <option value="其他">其他</option>
                                </select>  
                             </td>  
                             
                             
                        </tr>  
                        <tr style="height: 40px">  
                           	<td style="width: 200px;text-align: right;background-color:#fafafa ">公司性质:</td> 
                            <td colspan="2"><input class="" type="radio" name="customer.ownership"  style="width: 30px" />台资
                            <input class="" type="radio" name="job"  style="width: 30px" value="国企"/>国企
                            <input class="" type="radio" name="job"  style="width: 30px" value="民营" />民营</td> 
                            
                             
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">邮编:</td> 
                       		<td><input style="width:200px;" name="customer.zipCode" type="text" class="easyui-textbox"/>
                             </td>  
                        </tr>  
                        <tr style="height: 40px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">年营业额:</td> 
                            <td colspan="2">
                            	<select class="easyui-combobox" name="customer.annualRevenue" style="width: 200px;text-align: center;background-color:#fafafa ">
                            		<option value="0">--请选择--</option>
                            	</select>
                            </td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">评分:</td> 
                            <td >
                            <input class="" type="radio" name="customer.rating"  style="width: 30px" value="一星" />一星
                            <input class="" type="radio" name="customer.rating"  style="width: 30px" value="二星"/>二星
                            <input class="" type="radio" name="customer.rating"  style="width: 30px" value="三星"/>三星</td> 
                            
                        </tr>  
                       
                       <tr style="height: 40px;" >  
                            <td  style="width: 200px;background-color:#fafafa;text-align: right; ">客户联系地址:</td>
                            <td colspan="4">
                            	<div data-toggle="distpicker" style="display: inline;">
	                            	<div class="form-group" style="display: inline;">
	                            		<label class="sr-only" for="province1"></label>
	                            		<select  class="form-control" name="province" id="province1"></select>
	                            	</div>
	                            	<div class="form-group" style="display: inline;">
	                            		<label class="sr-only" for="city1"></label>
	                            		<select  class="form-control" name="city" id="city1"></select>
	                            	</div>
	                            	<div class="form-group" style="display: inline;">
	                            		<label class="sr-only" for="district1"></label>
	                            		<select  class="form-control" name="district" id="district1"></select>
	                            	</div>
	                            	<input type="text" class="easyui-textbox" name="road"/>
                            	</div>
                            </td> 
                       		
                        </tr>  
                       <tr style="height:40px;">
                       <td colspan="4" style="font-weight:bold;">首要联系人信息</td></tr>
                        <tr style="height: 40px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">姓名:</td> 
                            <td colspan="2"><input class="easyui-textbox" type="text" name="contacts.name" style="width: 200px"></input></td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">称呼:</td> 
                            <td ><input class="easyui-textbox" type="text" name="contacts.saltname"  style="width: 200px"></input></td> 
                        </tr>
                        <tr style="height: 40px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">邮箱:</td> 
                            <td colspan="2"><input class="easyui-textbox" type="text" name="contacts.email" style="width: 200px"></input></td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">职位:</td> 
                            <td ><input class="easyui-textbox" type="text" name="contacts.post"  style="width: 200px"></input></td> 
                        </tr> 
                        <tr style="height: 40px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">QQ:</td> 
                            <td colspan="2"><input class="easyui-textbox" type="text" name="contacts.qqNo" style="width: 200px"></input></td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">手机:</td> 
                            <td ><input class="easyui-textbox" type="text" name="contacts.telephone"  style="width: 200px"></input></td> 
                        </tr> 
                        <tr style="height: 40px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">备注:</td> 
                            <td colspan="4"><textarea rows="5" cols="100" name="contacts.description" >
                            </textarea></td>  
                        </tr> 
                        <tr style="height: 40px">  
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
				//返回上一页
				$("#backBtn").on('click',function(){  
					window.location.replace("system/leads/leads");  
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
					
					$.post("system/customer/saveCustomer",$("#form").serialize(),function(data){				
						if(data.success){
							parent.$("#topWindow").dialog("close");
							parent.$.messager.show({
								title:'提示',
								msg:data.message,
								timeout:5000,
								showType:'slide'
							});
							return;
						}else{
							parent.$.messager.show({
								title:'警告',
								msg:data.message,
								timeout:5000,
								showType:'slide'
							});
						}
					},"json")			
				})

				//放入客户池
				$("#putpool").on('click',function(){
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}
					$("#username").textbox('setValue',"");
					$.post("system/customer/saveCustomer",$("#form").serialize(),function(data){				
						if(data.success){
							parent.$("#topWindow").dialog("close");
							parent.$.messager.show({
								title:'提示',
								msg:data.message,
								timeout:5000,
								showType:'slide'
							});
							return;
						}else{
							parent.$.messager.show({
								title:'警告',
								msg:data.message,
								timeout:5000,
								showType:'slide'
							});
						}
					},"json")			
				});
			});
</script>
</html>