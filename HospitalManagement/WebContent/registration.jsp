<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号单</title>
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
			    <label for="exampleInputName2">病历编号：</label>
			    <input type="text" class="form-control" id="patientHistoryIDSearch" name="patientHistoryID" placeholder="病历编号">
			  </div>
			   <div class="form-group">
			    <label for="exampleInputName2">病人姓名:</label>
			    <input type="text" name="patient.patientName" class="form-control" id="patientNameSearch" placeholder="病人姓名">
			  </div>
			  
			   <div class="form-group">
			    <label for="exampleInputName2">医生姓名:</label>
			    <input type="text" name="user.userName" class="form-control" id="userNameSearch" placeholder="医生姓名">
			  </div>
			  
			  
			  <div class="form-group">
			    <label for="exampleInputEmail2">挂号类型:</label>
			    <input type="text" name="registrationType.registrationTypeName" class="form-control" id="registrationTypeSearch" placeholder="挂号类型">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">科室:</label>
			    <input type="text" name="department.departmentName" class="form-control" id="departmentSearch" placeholder="科室">
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail2">挂号日期:</label>
			    <input type="text" name="registrationDate" class="form-control" id="registrationDateSearch" placeholder="挂号日期">
			  </div>
			  
			 <button id="btn_query" type="button" class="btn ">查询</button>
			</form>
			
		</div>
		<div>
		 <button id="open" class="btn ">展开或折叠</button>
		 <button id="addRegistration" class="btn ">添加挂号单</button>
		</div>
		 
	</div>
	
	<!-- 表格展示 -->
	<table id="table"></table>
	
<!-- 修改页面窗体 -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="registrationID" id="registrationIDUpdate">

<div class="modal fade " id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改挂号单信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病历编号:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="patientHistoryID" id="patientHistoryIDUpdate" placeholder="病历编号；">
					    </div>
				 </div>
				 
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人姓名:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="patient.patientName" id="patientNameUpdate" placeholder="病人姓名；" readonly="readonly">
					    </div>
				 </div>
				 
				  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医生姓名:</label>
					    <div class="col-sm-10">
					         <select id="userIdUpdate" name="userId"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">挂号类别:</label>
					    <div class="col-sm-10">
					         <select id="registrationTypeUpdate" name="registrationType"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室:</label>
					    <div class="col-sm-10">
					         <select id="departmentUpdate" name="departmentID"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">挂号费:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="registrationFee" id="registrationFeeUpdate" placeholder="挂号费；">
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">挂号日期:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="registrationDate" id="registrationDateUpdate" placeholder="挂号日期；">
					    </div>
				 </div>
				 
				
				 
			</div>
			
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnUpadte" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>


<form id="myAddForm" method="post">

<input type="hidden" name="registrationID" id="registrationIDUpdate">

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加挂号单信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病历编号:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="patientHistoryID" id="patientHistoryIDAdd" placeholder="病历编号；">
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人姓名:</label>
					    <div class="col-sm-10">
					         <select id="patientIDAdd" name="patientID"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医生姓名:</label>
					    <div class="col-sm-10">
					         <select id="userIdAdd" name="userId"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">挂号类别:</label>
					    <div class="col-sm-10">
					         <select id="registrationTypeAdd" name="registrationType"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">科室:</label>
					    <div class="col-sm-10">
					         <select id="departmentAdd" name="departmentID"  class="form-control">

					         </select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">挂号费:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="registrationFee" id="registrationFeeAdd" placeholder="挂号费；">
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">挂号日期:</label>
					    <div class="col-sm-10">
					      <input type="text"  class="form-control" name="registrationDate" id="registrationDateAdd" placeholder="挂号日期；">
					    </div>
				 </div>
				 
				
				 
			</div>
			
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnAdd" class="btn btn-primary">提交更改</button>
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
		  url:'${pageContext.request.contextPath}/registration?method=query',
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
			field: 'registrationID',
			title:'挂号单编号'
		  },{
		    field: 'patientHistoryID',
		    title: '病历编号',
		    sortable:true
		  }, {
		    field: 'patient.patientName',
		    title: '病人姓名'
		  },{
			    field: 'user.userName',
			    title: '医生'
	  	  },{
		    field: 'registrationType.registrationTypeName',
		    title: '挂号单类别'
		  },{
  		    field: 'department.departmentName',
		    title: '科室'
		  }, {
		    field: 'registrationFee',
		    title: '挂号费'
		  },{
		    field: 'registrationDate',
		    title: '挂号日期'
		  },{//按钮
		  title:"操作",
			  formatter:function(value,row,index)
		 	 {
				  var updateValue=' <button onclick="updateFun(' +row.registrationID+')" type="button" class="btn btn-default" >修改</button>';
				  var deleteValue=' <button onclick="deleteFun(' +row.registrationID+')" type="button" class="btn btn-default" >删除</button>';
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
		var registration = $("#mySerachForm").serializeArray();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/registration?method=query',
			data:registration,
			dataType:"json",
			success:function(json) {
				$("#table").bootstrapTable('load',json);
			}
		});
		
	})
	
	
// 挂号单类型更改及添加-下拉数据加载
 $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/registrationType?method=listRegistrationType",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            var updateSelect = $("#registrationTypeUpdate");
            var addSelect = $("#registrationTypeAdd");
            for (var i = 0; i < datas.length; i++) { 
            	updateSelect.append("<option value='" +datas[i].registrationTypeID+ "'>"  
                        + datas[i].registrationTypeName + "</option>");  
            	addSelect.append("<option  value='" +datas[i].registrationTypeID+ "'>"  
                        + datas[i].registrationTypeName + "</option>");  
            }  
        } 
  }); 
  
//部门更改及添加-下拉菜单加载
	$.ajax({  
        type : 'get',  
        url : "${pageContext.request.contextPath}/department?method=listDepartment",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        var updateSelect = $("#departmentUpdate");
        var addSelect = $("#departmentAdd");
        for (var i = 0; i < datas.length; i++) { 
        	updateSelect.append("<option value='" +datas[i].departmentID+ "'>"  
                    + datas[i].departmentName + "</option>");  
        	addSelect.append("<option  value='" +datas[i].departmentID+ "'>"  
                    + datas[i].departmentName + "</option>");  
        }  
    } 
}); 

//医生更改及添加-下拉菜单加载
	$.ajax({  
        type : 'get',  
        url : "${pageContext.request.contextPath}/user?method=listDoctor",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        var updateSelect = $("#userIdUpdate");
        var addSelect = $("#userIdAdd");
        for (var i = 0; i < datas.length; i++) { 
        	updateSelect.append("<option value='" +datas[i].userId+ "'>"  
                    + datas[i].userName + "</option>");  
        	addSelect.append("<option  value='" +datas[i].userId+ "'>"  
                    + datas[i].userName + "</option>");  
        }  
    } 
}); 


  
//申请添加按钮，弹出添加窗体
	$("#addRegistration").click(function(){
		$('#myAddModal').modal().on('shown.bs.modal',function() {	
 		})
		//弹出添加窗体
	})
	
//提交添加按钮，添加数据到数据库
	$("#btnAdd").click(function(deptName,deptAddress,deptPhone,deptUser){
		
		var registration = $("#myAddForm").serializeArray();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/registration?method=add',
			data:registration,
			dataType:"json",
			success:function(json) {
				$("#myAddModal").modal('hide'); 
				$("#table").bootstrapTable('load',json);
			}
		});

	})
	
})
	
</script>
<script type="text/javascript">

//申请更新，弹出修改窗体
function updateFun(registrationID){
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/registration?method=sendUpdate",
		    data:{registrationID:registrationID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		   $("#registrationIDUpdate").val(data.registrationID);
		    		   $("#patientHistoryIDUpdate").val(data.patientHistoryID);
		    		   //alert(data.patient.patientName);
		    		   $("#patientNameUpdate").val(data.patient.patientName);
		    		   //$("patientID").val(patientID);
		    		   //$("#userIdUpdate").val(data.user.userName)
		    		   $("#registrationFeeUpdate").val(data.registrationFee);
		    		   $("#registrationDateUpdate").val(data.registrationDate);
		    	})
		    }
	  })
}

//提交更新按钮，更新数据到数据库
$("#btnUpadte").click(function(){
    //获取表单中的数据
    var registration = $("#myUpdateForm").serializeArray();
    $.ajax({
    	 type:"post",//提交方式
    	 url:"${pageContext.request.contextPath}/registration?method=update",
    	 data:registration,
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
function deleteFun(registrationID)
{
	if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/registration?method=delete",
		data:{registrationID:registrationID},//传主键值
		dataType:"json",
		success:function(json){
			 if(json ==1){
    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据 
    		 }
		}
		 
	})
	}
	}
}

</script>
	
</body>
</html>