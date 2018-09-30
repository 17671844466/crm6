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
	<script type="text/javascript">
	function viewmypic(mypic,imgfile) {

		if(imgfile.files && imgfile.files[0])

		{

		mypic.style.display="";


		//火狐下，直接设img属性

		//mypic.src = imgfile.files[0].getAsDataURL();

		  //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式  
		 mypic.src = window.URL.createObjectURL(imgfile.files[0]);


		}

		else

		{

		//IE下


		if (imgfile.value){
		 mypic.src=imgfile.value;
		 mypic.style.display="";
		 mypic.border=1;
		 }


		}

		}
	</script>
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>
<div id="master-layout" style="height: 100%;width: 100%">
<div id="addLeads" class="easyui-panel" title="添加产品"
    style="width:100%;height:100%;padding:10px;background-color:white;" >
    
    <div id="addForm" class="easyui-panel" title="主要信息"
    style="width:100%;height:100%;padding:10px;background-color: white;" >
   		 <form id="form1" action="system/product/uploadImg" enctype="multipart/form-data" method="post">
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">主图:</td> 
                            <td>
                            <img  name="showimg" id="showimg" width="80px" src="" style="display:none;" alt="预览图片" />
                            </td>
                            <td colspan="2">
                            <input id="imgfile"  type="file"  name="image" style="width: 200px"  onchange="viewmypic(showimg,this.form.imgfile);" ></input>
                            <input id="uploadImg" type="submit"   class="easyui-linkbutton save-button" style="width: 100px;height: 30px"  value="上传图片"></input>
                            </td>  
                         </tr>    
         </form> 
    		
    		<form id="form" method="post">  
                    <table cellpadding="100">  
                   
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">产品名称:</td>  
                            <td style="width: 250px;">
                            <input  id="name" class="easyui-textbox" name="name"  style="width: 200px"  data-options="required:true" />
                            </td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">产品类别:</td>  
                            <td >
                            <input id="category" class="easyui-combobox" name="categoryId" style="width: 172px;">  
                           			
                              </input>  
                             </td>  
                       		
                        </tr>  
                        <tr style="height: 50px">  
                           <td style="width: 200px;text-align: right;background-color:#fafafa ">研发时间:</td>  
                            <td >
                            <input class="easyui-datebox"  name="developmentTime" style="width: 200px" ></input>
                             </td>  
                             <td style="width: 200px;text-align: right;background-color:#fafafa ">详情链接:</td>  
                            <td style="width: 250px;">
                            <input class="easyui-textbox" type="text" name="link"  style="width: 200px"/>
                            </td>  
                             
                        </tr>  
                        
                        
                        <tr style="height: 50px">  
                           	<td style="width: 200px;text-align: right;background-color:#fafafa ">开发团队:</td> 
                            <td >
                            <input class="easyui-textbox" type="text" name="developmentTeam"  style="width: 200px"></input>
                            </td>  
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">成本价:</td> 
                       		<td >
                       		<input class="easyui-textbox" type="text" name="costPrice"  style="width: 200px"></input>
                             </td>  
                        </tr>  
                        <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">建议售价:</td> 
                            <td colspan="3">
                            <input class="easyui-textbox"  name='suggestedPrice' style="width: 200px"></input>
                            
                        </tr>  
                       
                       
                       <tr style="height: 50px">  
                            <td colspan="4">产品图片</td> 
                        </tr> 


						
                        
                        <tr style="height: 50px">    
                       		<td style="width: 200px;text-align: right;background-color:#fafafa ">副图:</td> 
                            <td colspan="3">
                            <input type="file"  name="path2" style="width: 200px" ></input>
                            </td>  
                        </tr> 
                        <tr style="height: 50px">  
                            <td colspan="5">附加信息</td> 
                        </tr> 
                         <tr style="height: 50px">  
                            <td style="width: 200px;text-align: right;background-color:#fafafa ">备注:</td> 
                            <td colspan="4"><input class="easyui-textbox" type="text" name="description" style="width: 200px"></input></td>  
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
				//分类下拉框
				$("#category").combobox({
					url : "system/product/listCategory",
					valueField : "id",
					textField : "name",
					loadFilter : function(data){
						if(data && data.success){
							return data.data;
						}
					}
				});
				//返回上一页
				$("#backBtn").on('click',function(){  
					window.location.replace("system/product/product");  
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

					$.post("system/product/saveProduct",$("#form").serialize(),function(data){				
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

				//上传图片
				$("#form1").on("submit",function(event) 
						{
								event.preventDefault();
							      
							         var formData = new FormData($( "#form1" )[0]);  
							         $.ajax({  
							              url: 'system/product/uploadImg' ,  
							              type: 'POST',  
							              data: formData,  
							              async: false,  
							              cache: false,  
							              contentType: false,  
							              processData: false,  
							              dataType:'json',
							              success: function (data) { 
									
											
								       if (data && data.success) {
							  					
							            		  $.messager.alert({
									           			title:"提示",
									           			msg:data.message,
								        			});
							  					
							  				}   
							                  
							              } ,
											



						              
							         });  
							      
						})
								

				
				
			     
			});

		
		

</script>
</html>