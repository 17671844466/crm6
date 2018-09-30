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
<title>营销模块</title>
<meta charset="utf-8">
<%@include file="../script.html" %>
<style type="text/css">
    .layout-panel-west {
        border-right: 1px solid #c5c5c5;
    }
</style>
</head>
<body>
	<div id="tabs" data-options="region:'center',border:false,height:800" class="easyui-tabs">
		<div  id="tab1" data-options="iconCls:'icon-man'"title="发送短信">
			<div style="float:left;margin:30px;width:15%;border:1px solid black;background:#f0f0f0">
				<h4>操作提示:</h4><br/><br/>
				<p>
					1.手机号码格式为:<p style="color:red">13366337778</p><br/>
					2.短信群发时,以换行间隔每个客户,如:<p style="color:red">13366337778<br/>13366337779<br/></p>
					3.如需在短信中加入姓名信息,请在短信内容中以<span style="color:red">{$name}</span>代替,<p style="color:red">手机格式必须如下:<br/>13366337778,张三<br/>13366337779,李四<br/>*注:半角,(英文模式下的逗号)</p>
					4.<span style="color:red">请不要在短信内容中填写特殊字符,包括换行符</span>
					5.短信内容不得多与65个字(空格,汉字,字母,数字均为一个字)<br/>
					6.同一手机发送短信间隔不得少于28秒<br/>
					7.请仔细阅读右页面右边的使用说明,请严格按照系统设定标准格式发送短信
				</p>
			</div>
			
			<div style="float:left;margin:30px;width:20%">
				<div style="background:lightblue;width:260px;height:50px">
					<p style="font-size:17px">在此输入手机号<br/>注意多个联系人换行隔开</p>
				</div>
				<textarea id="messageTo" rows="15" cols="24" style="font-size:20px"></textarea>
			</div>
			
			<div style="float:left;margin:30px;width:20%">
				<select id="smsTem">
					<option value="-1">--请选择短信模板--</option>
				</select>
				<a href="javascript:void(0)" id="smsTemAdd" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加模板</a>
				<div style="background:lightblue;width:260px;height:50px;margin-top:5px">
					<p>在此输入短信内容<br/>注意:<p style="color:red">请务必阅读操作提示</p></p>
				</div>
				<textarea id="smsContent" rows="15" cols="40" placeholder="在这里填写你的短信内容..."></textarea>
				<span id="smsL">您还可以输入<span style="color:red">65</span>个字</span><br/><br/>
				<a href="javascript:void(0)" id="MessageSend" class="easyui-linkbutton" data-options="iconCls:'icon-save'">发送</a>
			</div>
			
			<div style="float:left;margin:30px;width:15%;border:1px solid black;background:#f0f0f0">
				<h4>使用说明:</h4>
				<br/>
				<p>
					(您视同本系统发送短信,即表明您同意并接受以下内容)<br/>
					1.不得发送包含以下文字、内容的短信息:非法的、骚扰性的、中伤他人的、辱骂性的、恐吓性的、伤害性、庸俗的、淫秽的信息,教唆他人犯罪的信息,危害国家安全的信息;及任何不符合国家法律、国际惯例、地方法律规定的信息。<br/><br/>
					2.不能违反运营商规定,不得发送竞争对手的广告,不能按手机段号形式进行广告业务的宣传等,不能发送与本行业无关和移动运营商限制和禁止发送的短信内容,特别是广告类信息,群发短信等,对违反此声明产生的一切后果由发送者及其单位承担。<br/><br/>
					3.最好不要再晚22:00至早7:00时段发送短信,以免引起客户反感。
				</p>
			
			</div>
		</div>
		
		
		<div  id="tab2" data-options="iconCls:'icon-man'" title="短信发件箱">
		收件号码:<input id="telephone" class="easyui-textbox" style="width:100px"> &nbsp; 
		接收时间:<input id="sendstart" class="easyui-datebox">到<input id="sendend" class="easyui-datebox">
		<a href="javascript:void(0)" id="serchSmsByCondition" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>	
		<a href="javascript:void(0)" id="deleteSms" class="easyui-linkbutton" data-options="iconCls:'icon-delete'">删除</a>	
		<table margin-left="100px" id="getSmsList"></table>
		</div>
		
		
		<div  id="tab3" data-options="iconCls:'icon-man'"title="发送邮件">
			<div style="float:left;margin:30px;width:15%;border:1px solid black;background:#f0f0f0">
				<h4>操作提示:</h4><br/><br/>
				<p>
					1.邮箱地址格式为:<p style="color:red">liudejian123@163.com</p><br/>
					2.邮件群发时,以换行间隔每个客户,如:<p style="color:red">liudejian123@163.com<br/>dejianliu@163.com</p><br/>
					3.如需在邮件中加入姓名信息,请在邮件内容中以<span style="color:red">{$name}</span>代替,<p style="color:red">邮件必须如下:<br/>dejianliu@163.com,张三<br/>liudejian123@163.com,李四<br/>*注:半角,(英文模式下的逗号)</p><br/>
					4.<span style="color:red">请不要在邮件内容中填写特殊字符,包括换行符</span>
					
				</p>
			</div>
			
			<div style="float:left;margin:30px;width:20%">
				<div style="background:lightblue;width:260px;height:50px">
					<p style="font-size:16px">在此输入邮箱<br/>注意多个联系人换行隔开</p>
				</div>
				<textarea id="emailTo" rows="15" cols="24" style="font-size:20px"></textarea>
			</div>
			
			<div style="float:left;margin:30px;width:40%">
				<select id="emailTem">
					<option value="-1">--请选择邮件模板--</option>
				</select>
				<a href="javascript:void(0)" id="emailTemAdd" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加模板</a>
				<br>
				邮件标题:<input id="emailTitle" type="text" style="width:560px;border:solid 1px black"></input>
				<div style="background:lightblue;width:560px;height:50px;margin-top:5px">
					<p>在此输入邮件内容<br/>注意:<p style="color:red">请务必阅读操作提示</p></p>
				</div>
				<textarea id="emailContent" rows="15" cols="60" placeholder="在这里填写你的邮件内容..." style="font-size:17px"></textarea>
				<a href="javascript:void(0)" id="emailSend" class="easyui-linkbutton" data-options="iconCls:'icon-save'">发送</a>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">

	//匹配正则表达式的方法
	function check(value,pattern){
		var regexp = new RegExp(pattern);
		return regexp.test(value);
	}
	//短信内容框提示剩余数字
	$("#smsContent").on("input",function(){
		var size = 65-$("#smsContent").val().length;
		
		$("#smsL").html(size>=0 ? "您还可以输入<span style='color:red'>"+size+"</span>个字" : "<span style='color:red'>您输入的字数过多</span>");
	})

	//添加短信模板功能的实现
	$("#smsTemAdd").on("click",function(){
		parent.openDialog({
			title : "添加短信模板",
			url : "system/Marketing/smsTemAdd",
			width : 400,
			height : 600,
			close : function(){
				$("#tabs").datagrid("reload");
			}
		});
	})
	
	//加载短信模板
	$.post("system/Marketing/findAllSmsTem",
			function(data){
				$.each(data.data,function(index,obj){
					$("#smsTem").append($("<option value='"+obj.id+"'>"+obj.subject+"</option>"));
				})
			},"json")
	$("#smsTem").on("change",function(){
			$.post("system/Marketing/selectSmsTem",
					{"condition[id]":$("#smsTem").val()},
					function(data){
						if(data.success){
							$("#smsContent").html(data.data.content);
						}else{
							parent.$.messager.show({"title":"提示","msg":"未找到此模板"});
							return;
						}
					},"json")
		})
	
	
	$("#MessageSend").on("click",function(){
			//将将信息发送人以换行符分割为数组
			var messageTo = $("#messageTo").val().split("\n");
			if(!messageTo.length){
				parent.$.messager.show({"title":"提示","msg":"联系人不能为空"});
				return;}
			//循环查找判断联系方式是否存在问题
			for (var i = 0; i < messageTo.length; i++) {
				var obj = messageTo[i];
				if(!check(obj.split(",")[0],'^1[3|4|5|7|8][0-9]{9}$')){
					parent.$.messager.show({"title":"提示","msg":"请检查联系人"});
					return;
				}
			}
			var size = 65-$("#smsContent").val().length;
			if(size<0 || size>64){
				parent.$.messager.show({"title":"提示","msg":"请检查内容"});
				return;
			}

			//验证完毕后发送短信
			$.post("system/Marketing/sendSms",
					{"userId":${user.id },
					 "messageTo":$("#messageTo").val(),
					 "content":$("#smsContent").val()
					},function(data){
							parent.$.messager.show({"title":"提示","msg":data.message});			
			})
		})
		
	$("#tabs").tabs({onSelect:function(title){
		switch (title) {
			case '短信发件箱':
				findSmsByPage("condition[userId]="+${user.id  });
				break;
			case '发送邮件':
				onEmile();
				break;
			}
		}
	})
	
	
	//搜索按钮
	$("#serchSmsByCondition").on("click",function(){
		findSmsByPage("condition[userId]="+${user.id}+
					  "&condition[telephone]="+($("#telephone").val() ?$("#telephone").val() : '' )+
					  "&condition[sendstart]="+($("#sendstart").val() ?$("#sendstart").val() : '' )+
					  "&condition[sendend]="+($("#sendend").val() ?$("#sendend").val() : '' )
					  );
		
		})
		
	//删除按钮
	$("#deleteSms").on("click",function(){
		var rows = $("#getSmsList").datagrid("getChecked");
		if(!rows.length){
			parent.$.messager.alert("警告","必须至少选择一条短信");
			return;
		}
		for (i=0;i<rows.length;i++) {
			 rows[i]=rows[i].id; 
		}
		var smsIds = rows.join("-");
		$.post("system/Marketing/deleteSms",
			   {"smsIds":smsIds},
			   function(data){
						parent.$.messager.show({"title":"提示","msg":data.message});
						$("#getSmsList").datagrid("reload");
				}
				   
			)
	})
	
	//分页查询短信的方法
	function findSmsByPage(condition){
		$("#getSmsList").datagrid({
			url : "system/Marketing/fingSmsByPage?"+condition,
			pagination : true,
			toolbar : "#toolbar",
			rownumbers : true,
			loadFilter : function(data){
				if(data && data.success){
					return data.data;
				}
			},
			columns : [[
	       	 {field:'id',checkbox:true},
	       	 {field:'content',title:'内容',width:400},
	       	 {field:'settername',title:'发件人',width:100,formatter:function(){
						return "${user.username}";
		       	 }},
	       	 {field:'telephone',title:'收件号码',width:100},
	       	 {field:'sendtime',title:'发送时间',width:100},
	    	]]
		});
	}

	//添加邮件模板功能的实现
	$("#emailTemAdd").on("click",function(){
		parent.openDialog({
			title : "添加短信模板",
			url : "system/Marketing/emailTemAdd",
			width : 400,
			height : 600,
			close : function(){
				$("#tabs").datagrid("reload");
			}
		});
	})
	
	
	//加载邮件模板绑定时间
	function onEmile(){
		
		$.post("system/Marketing/findAllEmailTem",
				function(data){
					$.each(data.data,function(index,obj){
						$("#emailTem").append($("<option value='"+obj.id+"'>"+obj.subject+"</option>"));
					})
				},"json")
		$("#emailTem").on("change",function(){
				$.post("system/Marketing/selectEmailTem",
						{"condition[id]":$("#emailTem").val()},
						function(data){
							if(data.success){
								$("#emailContent").html(data.data.content);
								$("#emailTitle").val(data.data.title);
							}else{
								parent.$.messager.show({"title":"提示","msg":"未找到此模板"});
								return;
							}
						},"json")
			})
	}



	//发送邮件按钮
	$("#emailSend").on("click",function(){
			//将将信息发送人以换行符分割为数组
			var emailTo = $("#emailTo").val().split("\n");
			if(!$("#emailTo").val()){
				parent.$.messager.show({"title":"提示","msg":"联系人不能为空"});
				return;}
			//循环查找判断联系方式是否存在问题
			for (var i = 0; i < emailTo.length; i++) {
				var obj = emailTo[i];
				
				if(!check(obj.split(",")[0],'^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$')){
					parent.$.messager.show({"title":"提示","msg":"请检查联系人"});
					return;
				}
			}
			if(!$("#emailContent").val().trim().length){
				parent.$.messager.show({"title":"提示","msg":"邮件内容不能为空"});
				return;
				}
			if(!$("#emailTitle").val().trim().length){
				parent.$.messager.show({"title":"提示","msg":"邮件标题不能为空"});
				return;
				}
			//验证完毕后发送邮件
			$.post("system/Marketing/sendEmail",
					{"userId":${user.id },
					 "emailTo":$("#emailTo").val(),
					 "title":$("#emailTitle").val(),
					 "content":$("#emailContent").val()
					},function(data){
							parent.$.messager.show({"title":"提示","msg":data.message});			
			})
		})
</script>
</html>