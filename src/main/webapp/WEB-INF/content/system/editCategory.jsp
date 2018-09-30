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

	<div align="center">
    		<form id="form" method="post" >  
                    <table cellpadding="80px">  
                    	<tr style="height: 50px" hidden="true"> 
                    		<td colspan="2"> 
                            <input  id="categoryId" class="easyui-textbox" name="id"  style="width: 200px"   value="${category.id }"/>
                            </td>  
                        </tr> 
                    
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">分类名：</td>  
                            <td style="width: 250px;">
                            <input  id="name" class="easyui-textbox" name="name"  style="width: 200px" value="${category.name }" />
                            </td>  
                        </tr> 
                         
                        <tr style="height: 50px">  
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">父类:</td>  
                            <td >
                            <input id="parent" class="easyui-combobox" name="parentId" style="width: 172px;" value="${category.parentId }">  
                             </input>  
                             </td>  
                        </tr>  
                        
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">描述:</td> 
                            <td ><input class="easyui-textbox" type="text" name="description" style="width: 200px;" value="${category.description }"></input></td>  
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5" style="text-align: center;">
                            <input id="saveBtn" type="button"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="保存"></input>
                             <input id="backBtn"  type="button"  class="easyui-linkbutton back-button"  style="width: 100px;height: 30px" value="取消"></input>
                            </td>  
                        </tr> 
                    </table>  
                </form>  
    		
    		
	
</div>
	



	
	
	
</body>
<script type="text/javascript">

			
			$(function(){
				//父类下拉框
				$("#parent").combobox({
					url : "system/product/listCategory",
					valueField : "id",
					textField : "name",
					loadFilter : function(data){
						if(data && data.success){
							return data.data;
						}
					}
				});
				//关闭添加分类页
				$("#backBtn").on('click',function(){  
					parent.closeDialog();
					
			     })

				//重置
	    		$("#resetBtn").on("click",function(){
	    			$("#form").form("reset");
	    		})

	    		//保存修改
	    		$("#saveBtn").on("click",function(){
					var isValid = $("#form").form("validate");
					if(!isValid){
						return;
					}	
					
					$.post("system/product/saveEditCategory",$("#form").serialize(),function(data){				
						if(data.b){
							$.messager.alert({
			           			title:"提示",
			           			msg:data.message,
		        			});
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