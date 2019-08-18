<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室部门</title>

<!-- 包含指令 -->
<%@include file="common/commoncss.jsp"%>
<%@include file="common/commonjs.jsp"%>
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
<div style="margin:100px;">
	<!-- 工具栏：展开折叠，添加按钮 -->
	<div id="toolbar">
		<div id="showOrHide" class="showQuery">
			<form class="form-inline" id="mySerachForm">
			
			  <div class="form-group">
			    <label for="departmentName">科室名称</label>
			    <input type="text" class="form-control" id="departmentNameSearch" name="departmentName" placeholder="科室名称">
			  </div>
			   <div class="form-group">
			    <label for="exampleInputName2">科室地址:</label>
			    <input type="text" name="departmentAddress" class="form-control" id="departmentAddressSearch" placeholder="科室地址">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">科室电话:</label>
			    <input type="text" name="departmentPhone" class="form-control" id="departmentPhoneSearch" placeholder="科室电话">
			  </div>
			 <button id="btn_query" type="button" class="btn ">查询</button>
				
			</form>
		</div>
		<div>
		 <button id="open" class="btn ">展开或折叠</button>
		 <button id="addDept" class="btn ">添加部门</button>
		</div>
		 
	</div>
	
	<!-- 表格展示 -->
	<table id="table"></table>
	
<!-- 修改页面窗体 -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="departmentID" id="departmentIDUpdate">
<!-- <input type="hidden"  id="userIdUpdate"> -->
<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改科室信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="departmentName" class="form-control" id="departmentNameUpdate" placeholder="科室名称；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室地址:</label>
					    <div class="col-sm-10">
					      <input type="text" name="departmentAddress" class="form-control" id="departmentAddressUpdate" placeholder="科室地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室电话:</label>
					    <div class="col-sm-10">
					      <input type="text" name="departmentPhone" class="form-control" id="departmentPhoneUpdate" placeholder="科室电话；">
					    </div>
				 </div>
<!-- 				 <div class="form-group"> -->
<!-- 					    <label for="inputEmail3" class="col-sm-2 control-label">科室负责人:</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					         <select id="userUpdate" > -->

<!-- 					         </select> -->
<!-- 					    </div> -->
<!-- 				 </div> -->
			</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnUpadte" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>

<!-- 添加部门窗体 -->
<form id="myAddForm" method="post">
<!-- <input type="hidden"  id="userIdAdd"> -->
<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加部门信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">部门名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="departmentName" class="form-control" id="departmentNameAdd" placeholder="科室名称；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室地址:</label>
					    <div class="col-sm-10">
					      <input type="text" name="departmentAddress" class="form-control" id="departmentAddressAdd" placeholder="科室地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室电话:</label>
					    <div class="col-sm-10">
					      <input type="text" name="departmentPhone" class="form-control" id="departmentPhoneAdd" placeholder="科室电话；">
					    </div>
				 </div>
				 
				 
<!-- 				 <div class="form-group"> -->
<!-- 					    <label for="inputEmail3" class="col-sm-2 control-label">科室负责人:</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					         <select id="userAdd" > -->
								
<!-- 					         </select> -->
<!-- 					    </div> -->
<!-- 				 </div> -->
				 
			</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnAdd" class="btn btn-primary">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>

</div>

<script type="text/javascript">
$(function(){
	
//初始化表格
	$('#table').bootstrapTable({
		  url:'${pageContext.request.contextPath}/department?method=query',
		  method:"post",
		  pagination:true,//允许分页
		  pageSize:9,//每页显示的条数
		  pageList:[1,2,7,9],//每页显示的条数集合
		  showColumns:true,//是否显示所有的列
		  striped:true,//隔行变色
		  showRefresh:true,//是否显示刷新
		  showExport:true,//允许导出
		  exportDataType:'all',//可以全部导出
		  exportTypes:['pdf','excel'],//导出的数据类型（pdf文件、excel文件）
		  toolbar:"#toolbar",//工具栏
		  
		columns: [{
		    field: 'departmentID',
		    title: '部门编号',
		    sortable:true
		  }, {
		    field: 'departmentName',
		    title: '部门名字'
		  }, {
		    field: 'departmentAddress',
		    title: '部门地址'
		  },{
  		    field: 'departmentPhone',
		    title: '部门电话'
		  },  
		  //{
			//    title: '负责人'
			  //},
			  {//按钮
				  title:"操作",
				  formatter:function(value,row,index)
				  {
					  var updateValue=' <button onclick="updateFun(' +row.departmentID+')" type="button" class="btn btn-default" >修改</button>';
					  var deleteValue=' <button onclick="deleteFun(' +row.departmentID+')" type="button" class="btn btn-default" >删除</button>';
					  return updateValue+deleteValue;
				  }
			  }]
		})
		
		
//展开或者折叠
	$("#open").click(function(){
		if($("#showOrHide").attr("class")=="showQuery"){
			$("#showOrHide").attr("class","hideQuery");
			$("#showOrHide").slideDown("fast");
		}
		else{
			$("#showOrHide").attr("class","showQuery");
			$("#showOrHide").slideUp("fast");
		}
	})
	
//条件查询
	$("#btn_query").click(function(){
		//获取表单的值(查询的输入框)
		var departmentName=$("#departmentNameSearch").val();
		var departmentAddress=$("#departmentAddressSearch").val();
		var departmentPhone = $("#departmentPhoneSearch").val();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/department?method=query',
			data: {"departmentName":departmentName,"departmentAddress":departmentAddress,"departmentPhone":departmentPhone},
			dataType:"json",
			success:function(json) {
				$("#table").bootstrapTable('load',json);
			}
		});
		
	})
	
// // 下拉数据加载  
//  $.ajax({  
//             type : 'get',  
//             url : "${pageContext.request.contextPath}/user?method=listUserId",  
//             dataType : 'json',      
//             success : function(datas) {//返回list数据并循环获取  
//             var updateSelect = $("#userUpdate");
//             var addSelect = $("#userAdd");
//             for (var i = 0; i < datas.length; i++) { 
//             	updateSelect.append("<option value='" +datas[i].userId+ "'>"  
//                         + datas[i].userName + "</option>");  
//             	addSelect.append("<option id='addSelectUserId' value='" +datas[i].userId+ "'>"  
//                         + datas[i].userName + "</option>");  
//             }  
//         } 
//   }); 
//   //下拉框改值则记录值
// $("#userAdd").change(function(){
// 	var userId=$(this).val();
// 	$("#userIdAdd").val(userId);
	
//   })
  
//   $("#userUpdate").change(function(){
// 	var userId=$(this).val();
// 	$("#userIdUpdate").val(userId);
	
//   })
//申请添加按钮，弹出添加窗体
	$("#addDept").click(function(){
		$('#myAddModal').modal().on('shown.bs.modal',function() {	
 		})
		//弹出添加窗体
	})
	
//提交添加按钮，添加数据到数据库
	$("#btnAdd").click(function(departmentName,departmentAddress,departmentPhone,deptUser){
		//var departmentName=$("#departmentNameAdd").val();
		//var departmentAddress=$("#departmentAddressAdd").val();
		//var departmentPhone=$("#departmentPhoneAdd").val();
		//var userId=$("#userIdAdd").val();
		
		//var userId=$("#deptUserAdd").val();
		
		//$("#userIdUpdate").val(userId)
		var departemnt = $("#myAddForm").serializeArray();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/department?method=add',
			//data:{departmentName:departmentName,departmentAddress:departmentAddress,departmentPhone:departmentPhone,userId:userId},
			data:departemnt,
			dataType:"json",
			success:function(json) {
				$("#myAddModal").modal('hide'); 
				$("#table").bootstrapTable('load',json);
				$("#table").bootstrapTable("refresh");//刷新表格中的数据 
			}
		});

	})
	
})
	
</script>
<script type="text/javascript">

//申请更新，弹出修改窗体
function updateFun(departmentID){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/department?method=sendUpdate",
		    data:{departmentID:departmentID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#departmentIDUpdate").val(data.departmentID);
		    		   $("#departmentNameUpdate").val(data.departmentName);
		    		   $("#departmentAddressUpdate").val(data.departmentAddress);
		    		   $("#departmentPhoneUpdate").val(data.departmentPhone);
		    	})
		    }
	  })
}



//提交更新按钮，更新数据到数据库
$("#btnUpadte").click(function(){
    //获取表单中的数据
     var departemnt = $("#myUpdateForm").serializeArray();
    //var  departmentID=$("#departmentIDUpdate").val();
    //var departmentName=$("#departmentNameUpdate").val();
	//var departmentAddress=$("#departmentAddressUpdate").val();
	//var departmentPhone=$("#departmentPhoneUpdate").val();
	//var userId=$("#userIdUpdate").val();
    $.ajax({
    	 type:"post",//提交方式
    	 url:"${pageContext.request.contextPath}/department?method=update",
    	 //data:{departmentID:departmentID,departmentName:departmentName,departmentAddress:departmentAddress,departmentPhone:departmentPhone,userId:userId},
    	 data:departemnt,
         dataType:"json",//返回的数据类型为json
    	 success:function(json){
    		 if(json ==1){
    			 
    			 $("#myUpdateModal").modal('hide');  //手动关闭
    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据 
    		 }
    	 }
    })
} )

//删除数据
function deleteFun(departmentID) {
	  if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
			  $.ajax({
				    type:"post",//提交方式
				    url:"${pageContext.request.contextPath}/department?method=delete",
				    data:{departmentID:departmentID},//传主键值
				    dataType:"json",//返回的数据类型为json
		          success : function(json) {
		         	 if(json ==1){
		         		 $("#table").bootstrapTable("refresh");//刷新表格中的数据
		         	 }
		         }
		     });  
		  }
	  }
	  
	}

</script>
	
</body>
</html>