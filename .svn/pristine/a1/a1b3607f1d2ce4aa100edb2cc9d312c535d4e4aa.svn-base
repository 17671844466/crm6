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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商机</title>
<%@include file="../script.html" %>
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>
   
     <div class="master-layout">
     	
      <div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">
         <div id="tab1" title="商机">  
                                 
             <div class="theme-user-info-panel">  
                <div class="center" style="font-size: 18px;color: red;text-align: center;background-color: pink">
                 <span style="font-size: 18px">视图:</span>
            <a id="whole" style="font-size: 18px;color: red" >全部 |</a> 
            <a id="responsible" style="font-size: 18px;color: red">我负责的 |</a>
            <a style="font-size: 18px;color: red">我创建的 |</a>
            <a style="font-size: 18px;color: red">下属负责 |</a>
            <a style="font-size: 18px;color: red">下属创建的 </a>  
            
                  今日需联系| 本周需联系 |7日未联系 |15日未联系 | 30日未联系 |最近创建 | 最近更新    回收站
                </div>
         </div>   
         
         
          <div class="right">
              <div class="dropdown-option" >
                  <select style="height: 30px;" class="taskbox" name="task1" id=box>
                      <option value="-1">--请选择筛选条件--</option>
                  
                  </select>
               	<span class="dropdown-option" >
	                <select style="height: 30px;" name="task2" id="bussId">
	                      <option value="-1">包含</option> 
	                </select>
	          </span>
              
          
          
           	<a id="edit" class="easyui-linkbutton add-button" data-options="iconCls:'icon-add'" >新增商机</a>
			<a id="correct" class="easyui-linkbutton edit-button" data-options="iconCls:'icon-edit'">修改</a>
			<a id="remove" class="easyui-linkbutton delete-button" data-options="iconCls:'icon-remove'">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
            商机名: <input id="criteria" type="text" class="easyui-textbox" style="width:150px;height: 30px;">
		    <a id="search" class="easyui-linkbutton search-button" data-options="iconCls:'icon-search'">搜索</a>
            <a id="resetBtn" class="easyui-linkbutton " data-options="iconCls:'icon-edit'">重置</a>
         </div>
          
         </div>
       	<div id="user-info-more"
					class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
					data-options="tools:'#tab-tools',fit:true">
			   <div class="toolbar">
			
				</div>
                				
					<table id="dataList"></table>
				</div>
			</div>
			
			<div id="tab1" title="统计">
				     统计 
			</div>
			<div id="tab1" title="帮助">
				
			</div>
		
	</div>
     
   
</body>
  

    <script type="text/javascript">
          /**
                                      商机删除功能
          
          **/
          $(function(){
           $("#remove").on("click",function(event){
              event.preventDefault();
              var rows = $("#dataList").datagrid("getChecked");

               if(!rows.length){
                   parent.$.messager.alert("警告","要选取一行数据");
                   return;
                   }else{
                      parent.$.messager.confirm("提示","是否要删除?",function(f){
                        if(f){
                           $.post("system/business/delete",
                                 {"id":rows[0].id},
                                function(data){
                                 alert(data.message);
                                 $("#dataList").datagrid("reload");
                                     },"json")

                                     }
                            

                          });
                       }

               })
              })


              
              
        
   $(function(){
		$(".edit-button").on('click',function(event){
			event.preventDefault();
			var rows = $("#dataList").datagrid("getChecked");
			
			if(!rows.length){
				parent.$.messager.alert("警告","必须至少选择一行数据");
				return;
			}
			//获取选中第一行的businessId
			var businessId = rows[0].businessId;
			alert(3);
		    //弹出div ,获取信息回写到表单
			parent.openDialog("修改商业信息","system/business/editBusiness?businessId="+businessId,function(){
				alert(2);
				$("#dataList").datagrid("reload");//刷新页面
				
			
			});
		});
	}); 
	

    function test(condition){
		$("#dataList").datagrid({
			url : "system/business/findByPage",
			pagination : true,
			toolbar : "#toolbar",
			rownumbers : true,
			idField : "id",
			loadFilter : function(data){
				if(data && data.success){
				  return data.data;
				}
			},
			columns : [[
		        {field:'id',checkbox:true},
		        {field:'name',title:'商机名',width:100},
		        {field:'origin',title:'商机来源',width:100},
		        {field:'nextstep_time',title:'下次联系时间',width:100},	
		        {field:'nextstep',title:'下次联系内容',width:100},
		        {field:'owner_user_id',title:'负责人',width:80},
		        {field:'creator_user_id',title:'创建人',width:80},
		        {field:'create_time',title:'创建时间',width:100},
		        {field:'update_time',title:'更新时间',width:100},
		        {field:'operation',title:'操作',width:150,formatter:function(value,row,index){
		        	return '<a href="javascript:void(0)" onclick="detail('+row.id+')">查看 |</a>'
		        	+ "<a href='system/business/acc'>推进|</a>"
		        	+ '<a href="javascript:void(0)" onclick="edit('+row.id+')">修改 </a>'
		        }},

		    ]]
		});
	}
    $(function(){
		test("condition[deleteStatus]=0");
	})
         
       //查询功能
       $("#search").on('click',function(){
            var box=$("#box").val();
            var criteria=$("#criteria").val();
           
            alert("查询成功");  
        $("#dataList").datagrid("load",{
           "condition[value]":criteria,
           "condition[column]":box,
            });
           });   

      
      //重置
       $("#resetBtn").on("click",function(){
           $("#box").val("-1");
           $("#criteria").textbox("setValue","");
           $("#dataList").datagrid("load",{

               });
           });  
       //全部
       $("#whole").on('click',function(){
			test("condition[deleteStatus]=0");
			});  

   	   //我负责的
		$("#responsible").on('click',function(){
			test("condition[deleteStatus]=0&condition[ownerUserId]=${sessionScope.user.id}");
			}); 
         //添加商机跳转
		$(function(){
			$("#edit").on('click',function(){   
				window.location.replace("system/business/addBusiness"); 
		     })
			});
 
         /* //修改商机跳转
         $(function(){
            $("#correct").on('click',function(){
                window.location.replace("system/business/editBusiness");
                })
             });  	 
 */

             //修改商机
         function edit(id,ownerName){
		 	 window.location.replace("system/business/editBusiness?id="+id+"&ownerName="+ownerName)	          
		 		 	
		 	} 

           //查看详情
    		 function detail(id){
    			 parent.openDialog({
                    title: "提示",
                    url : "system/business/detail?id="+id,
                    close:function(){
                    	$("#dataList").datagrid("reload");
                        }
        			 });
        			 
        			 
    			

 		
          
        } 


  	        
    
    </script>
 

</html>