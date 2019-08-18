<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
     <!-- 配置文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/plugin/ueditor/ueditor.config.js"></script>

<!-- 编辑器源码文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/plugin/ueditor/ueditor.all.js"></script>
    
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>


<title>用户操作界面</title>

<!-- jsp包含指令 -->
<%@ include file="common/commoncss.jsp" %>
<%@ include file="common/commonjs.jsp" %>
<%-- <%@ include file="ztree/ztree.jsp" %> --%>
<style type="text/css">
	.showQuery{
	display: inline;
	}
	.hideQuery{
	display: none;
	}
</style>

</head>
<body>
 
<!-- 搜索工具栏 -->
<div style="margin:100px;">
<div id="toolbar">
   <div id="showorhide" class="showQuery">
          <form class="form-inline" id="mySearchForm">
			  <div class="form-group">
			    <label for="exampleInputName2">用户名称:</label>
			    <input type="text" name="userName" class="form-control" id="userNameSearch" placeholder="员工姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">职位名称:</label>
			    <select name="poId" id="poIdSearch">
			        <option value="">请选择职位名称</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">科室:</label>
			    <select name="departmentID" id="departmentIDSearch">
			        <option value="">请选择科室</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">用户性别:</label>
			    <select name="userSex" id="userSex">
			        <option value="">请选择</option>
			        <option value="男">男</option>
			        <option value="女">女</option>
			    </select>
			  </div>
			  
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="btn_add" class="btn ">增加数据</button>
   </div>
</div>
<table id="table"></table>
</div>

<!-- <button type="button" id="btnAdd">添加</button> -->
<!-- 工具栏 -->
<div id="toolbar"></div>


<script type="text/javascript">

    $(function(){
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/user?method=queryPositionAndDepartmentByCondition",//访问地址
    		method:"get",//请求的方式
    		toolbar:"#toolbar",//工具栏
    		pagination:true,//允许分页
    		pageSize:4,//每页显示的条数
    		pageList:[2,3,5,8,10],//每页显示的条数集合
    		showColumns:true,//是否显示所有的列
    		showRefresh:true,//是否显示刷新
    		striped:true,//隔行变色   每一行的唯一标识，一般为主键列
		    showExport:true,//允许导出
  		    exportDataType:'all',//可以全部导出
  		    exportTypes:['pdf','excel'],//导出的数据类型（pdf文件、excel文件）
  		    
  			
  		    
    		columns: [{
    		    field: 'userId',
    		    title: '用户编号',
    		    sortable:true
    		  }, {
    		    field: 'userName',
    		    title: '用户姓名'
    		  },
    		  {
    		    field: 'userPhoto',
    		    title: '用户图片',
//     		    detailView : true,
//       			detailFormatter : function (index, row) {
//       		   		var image = '<div class="photos">'
//       		        	+'<a target="_blank" href="'+row['jumpUrl']+'"><img alt="image" class="feed-photo" src="'+row.userPhoto+'"></a>'
//       		        	+'</div>';
//       		    	return image;
//       			}
    		    ///bobhospital/WebContent/plugin/img/skin_/p01.png
    		    formatter : function (value, row, index) {
    		        return "<img style='width: 50px;height: 50px;' src='"+value+"' alt=''>"
    		    }
    		  },
    		  {
      		    field: 'userSex',
      		    title: '用户性别'
      		  },
      		  {
      		    field: 'userBirthday',
      		    //type:'date',
      		    title: '用户生日'
      		  },
      		  {
      		    field: 'userCard',
      		    title: '用户身份证号'
      		  },
      		  {
      		    field: 'userState',
      		    title: '用户在离职状态',
      		  	formatter:function(value,row,index)
  		   		{ 
			        var value="";
			        if(row.userState=="1")
			        {
				        value = "在职";
			        }
			        else if(row.userState=="2")
			        {
			            value = "离职";
			        }
			        else
	          		{
	            		value = row.userState ;
	            	}
					return value;
	            }
      		  },
      		  {
      		    field: 'userDescribe',
      		    title: '用户描述'
      		  },
    		  {
    		    field: 'department.departmentName',
    		    title: '科室名称'
    		  }, 
    		  {
    		    field: 'position.poName',
    		    title: '职位名称'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.userId+')" type="button" class="btn btn-default">修改</button>';
//     				  var authorityValue = ' <button  onclick="authorityFun('+row.Id+')" type="button" class="btn btn-success">分配权限</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.userId+')" type="button" class="btn btn-default">删除</button>';
    				  
    				  return updateValue+deleteValue;
//     				  return updateValue+authorityValue+deleteValue;
    			  }
    		  }]
    	})
    	
    	//<!--展开或折叠   #:id名称     .:class名称-->
    	$("#open").click(function(){
    		
    		 //判断  attr：属性   a:显示      b：隐藏
    		 if($("#showorhide").attr("class")=="showQuery"){
    			 
    			 $("#showorhide").attr("class","hideQuery");//由显示变为隐藏
    			 $("#showorhide").slideDown("fast");//向下快速滑动
    		 }else{
    			 $("#showorhide").attr("class","showQuery");//由显示变为隐藏
    			 $("#showorhide").slideUp("fast");//向上快速滑动
    		 }
    	})
    	
    	 //下拉数据加载  
    	 //加载部门
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/department?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	//alert("部门");
                var select = $("#departmentIDSearch");
                var select2 = $("#departmentIDUpdate");
                var select3 = $("#departmentIDAdd");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].departmentID+ "'>"  
                            + datas[i].departmentName + "</option>");  
                }
                for (var i = 0; i < datas.length; i++) { 
                	select2.append("<option value='" +datas[i].departmentID+ "'>"  
                            + datas[i].departmentName + "</option>");  
                } 
                for (var i = 0; i < datas.length; i++) { 
                	select3.append("<option value='" +datas[i].departmentID+ "'>"  
                            + datas[i].departmentName + "</option>");  
                } 
              
            } 
            
        }); 
    	//加载职位
    	$.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/position?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#poIdSearch");
                var select2 = $("#poIdUpdate");
                var select3 = $("#poIdAdd");
                
            	//alert("获取职位信息！");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].poId+ "'>"  
                            + datas[i].poName + "</option>");  
                }
                for (var i = 0; i < datas.length; i++) { 
                	select2.append("<option value='" +datas[i].poId+ "'>"  
                            + datas[i].poName + "</option>");  
                }
                for (var i = 0; i < datas.length; i++) { 
                	select3.append("<option value='" +datas[i].poId+ "'>"  
                            + datas[i].poName + "</option>");  
                }

            } 
            
        }); 
    	
    })
 </script>
 
<!--  增删改查 -->
 <script type="text/javascript">
  $(function(){
	  <!--搜索条件-->
  	//条件搜索
		$("#btn_query").click(function() {
	                
					//获取表单中的数据
				     var searchUser = $("#mySearchForm").serializeArray();
	              
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/user?method=queryPositionAndDepartmentByCondition",
	                     data: searchUser, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });

	    });
  		$("#btn_add").click(function() {
     		
			$('#myAddModal').modal().on('shown.bs.modal');
			//alert(1);
		});
  })
  
   //修改
   function updateFun(userId){
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/user?method=sendUpdate",
		    data:{userId:userId},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#userIdUpdate").val(data.userId);
		    		   $("#poIdUpdate").val(data.poId);
		    		   $("#departmentIDUpdate").val(data.departmentID);
		    		   $("#userNameUpdate").val(data.userName);
		    		   $("#userBirthdayUpdate").val(data.userBirthday);
		    	})
		    }
	  })
  }
//删除
  function deleteFun(userId){
  	if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){

	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/user?method=delete",
		    data:{userId:userId},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	 alert("删除成功");
		    	 $("#table").bootstrapTable("refresh");//刷新表格中的数据
		    }
	  })
	}
	}
 }
 </script>
<!--  对话框内按键 -->
 <script type="text/javascript">
 $(function(){
	 //实例化编辑器
	 var ue = UE.getEditor('editor');
	 
	 $("#btnUpadte").click(function(){
		  
		    //获取表单中的数据
		     alert("开始更新");
		     var list={};
		     var user = $("#myUpdateForm").serializeArray();
		     list[0]=user;
		     //alert(imageURL);
		     //var ue = UE.getEditor('editor');
		     var userDescribe=UE.getEditor('editor').getPlainTxt();
		     list[1]=userDescribe;
		   	 alert(list[1]);

		   	//JSONObject object=new JSONObject(students);
// 		   	 alert(user);
		   	 
		    $.ajax({
		    	 type:"post",//提交方式
		    	 url:"${pageContext.request.contextPath}/user?method=update&userDescribe="+encodeURI(userDescribe),
		    	 data:user,//数据
		    	 dataType:"json",//返回的数据类型为json
		    	 success:function(json){
		    		 
		    		 if(json ==1){
		    			 
		    			 $("#myUpdateModal").modal('hide');  //手动关闭
		    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
		    			 
		    			 
		    		 }
		    	 }
		    })
	  })
	  $("#btnAdd").click(function(){
		  
		    //获取表单中的数据
		     var user = $("#myAddForm").serializeArray();
		     var ue = UE.getEditor('container');
		    $.ajax({
		    	 type:"post",//提交方式
		    	 url:"${pageContext.request.contextPath}/user?method=add",
		    	 data:user,//数据
		    	 dataType:"json",//返回的数据类型为json
		    	 success:function(json){
		    		 
		    		 if(json ==1){
		    			 
		    			 $("#myAddModal").modal('hide');  //手动关闭
		    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
		 
		    		 }
		    	 }
		    })
	  })
	 
 })
  


</script>
 
 
<link rel="stylesheet" href="${pageContext.request.contextPath }/plugin/kindeditor/themes/default/default.css" />
<script src="${pageContext.request.contextPath }/plugin/kindeditor/kindeditor.js"></script>
<script src="${pageContext.request.contextPath }/plugin/kindeditor/lang/zh_CN.js"></script>
<script>
			KindEditor.ready(function(K) {
				alert(123);
				var editor = K.editor({
					allowFileManager : true,
					uploadJson : '${pageContext.request.contextPath}/plugin/kindeditor/jsp/upload_json.jsp',
					fileManagerJson : '${pageContext.request.contextPath}/plugin/kindeditor/jsp/file_manager_json.jsp'
				});
				K('#image1').click(function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							imageUrl : K('#url1').val(),
							clickFn : function(url, title, width, height, border, align) {
								K('#url1').val(url);
								editor.hideDialog();
								var l="D:/SummerProject/project_zhenghe/HospitalManagement/WebContent/img/".length;
								alert("l=:"+l+"url=="+url+"substring:="+url.substring(l));
								
							}
						});
					});
				});
				//alert(K('#image1'));
			});	
</script>
<script>
// 		KindEditor.ready(function(K) {
// 			var editor1 = K.create('textarea[name="content1"]', {
// 				cssPath : '../plugins/code/prettify.css',
// 				uploadJson : '../jsp/upload_json.jsp',
// 				fileManagerJson : '../jsp/file_manager_json.jsp',
// 				allowFileManager : true,
// 				afterCreate : function() {
// 					var self = this;
// 					K.ctrl(document, 13, function() {
// 						self.sync();
// 						document.forms['example'].submit();
// 					});
// 					K.ctrl(self.edit.doc, 13, function() {
// 						self.sync();
// 						document.forms['example'].submit();
// 					});
// 				}
// 			});
// 			prettyPrint();
// 		});
	</script>

 <%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
 
<!-- 修改页面窗体  修改科室信息 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="userId" id="userIdUpdate">
<!-- <input type="hidden" name="poId" id="poIdUpdate"> -->
<!-- <input type="hidden" name="DepartmentID" id="departmentIDUpdate"> -->

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改职位信息</h4>
            </div>
            <div class="modal-body">
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="userName" class="form-control" id="userNameUpdate" placeholder="用户姓名:">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户生日:</label>
					    <div class="col-sm-10">
					      <input type="date" name="userBirthday" class="form-control" id="userBirthdayUpdate" placeholder="用户生日:">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户职位:</label>
					    <div class="col-sm-10">
					    	<select name="poId" id="poIdUpdate">
				    		</select>
					    </div>
				 </div>
				 <div class="form-group">
				    <label for="exampleInputEmail2">科室:</label>
				    <select name="departmentID" id="departmentIDUpdate">
<!-- 				        <option value="0">请选择</option> -->
				    </select>
			 	 </div>
				 <div class="form-group">
				    <label for="exampleInputEmail2">上传头像:</label>
				    	<p>
				    		<input type="text" id="url1" name="userPhoto" value="" /> 
				    		<input type="button" id="image1" value="选择图片" />（网络图片 + 本地上传）
				    	</p>
			 	 </div>
			 	 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户简介:</label>
<!-- 					    <div style="width: 500px;height: 300px;"> -->
<!-- 							<textarea rows="8" cols="8" id="container" name="userDescribe"></textarea> -->
<!-- 						</div> -->
							<script id="editor" type="text/plain" style="width:500px;height:250px;"></script>
				 </div>
				 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnUpadte" class="btn btn-primary">更改</button>
            </div>
        </div>/.modal-content
    </div>/.modal
</div>
</form>

<!-- 增加数据页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myAddForm" method="post">
<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">增加用户信息</h4>
            </div>
            <div class="modal-body">
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="userName" class="form-control" id="userNameAdd" placeholder="用户姓名:">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户生日:</label>
					    <div class="col-sm-10">
					      <input type="date" name="userBirthday" class="form-control" id="userBirthdayAdd" placeholder="用户生日:">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户职位:</label>
					    <div class="col-sm-10">
					    	<select name="poId" id="poIdAdd">
				    		</select>
					    </div>
				 </div>
				 <div class="form-group">
				    <label for="exampleInputEmail2">用户科室:</label>
				    <select name="departmentID" id="departmentIDAdd">
				    </select>
			 	 </div>
				 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnAdd" class="btn btn-primary">增加</button>
            </div>
        </div>/.modal-content
    </div>/.modal
</div>
</form>

</body>
</html>