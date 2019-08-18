<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挂号单类型</title>

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
	<div id="toolbar">
		<div id="showOrHide" class="showQuery">
			<form class="form-inline" id="mySerachForm">
			   <div class="form-group">
			    <label for="registrationTypeNameSearch">挂号单类型:</label>
			    <input type="text" name="registrationTypeName" class="form-control" id="registrationTypeNameSearch" placeholder="挂号单类型">
			  </div>
			 <button id="btn_query" type="button" class="btn ">查询</button>
			</form>
		</div>
		<div>
		 <button id="open" class="btn ">展开或折叠</button>
		 <button id="addRegistrationType" class="btn ">添加挂号单类型</button>
		</div>
		 
	</div>
	
	<table id="table"></table>
	</div>
	<form id="myUpdateForm" method="post">

	<input type="hidden" name="registrationTypeID" id="registrationTypeIDUpdate">
	<!-- <input type="hidden"  id="userIdUpdate"> -->
	<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">修改挂号单类型</h4>
	            </div>
	            <div class="modal-body">
	            	
					 <div class="form-group">
						    <label for="inputEmail3" class="col-sm-2 control-label">挂号单类型:</label>
						    <div class="col-sm-10">
						      <input type="text" name="registrationTypeName" class="form-control" id="registrationTypeNameUpdate" placeholder="挂号单类型；">
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
	<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">添加挂号单类型</h4>
	            </div>
	            <div class="modal-body">
	            	
					 <div class="form-group">
						    <label for="inputEmail3" class="col-sm-2 control-label">挂号单类型:</label>
						    <div class="col-sm-10">
						      <input type="text" name="registrationTypeName" class="form-control" id="registrationTypeNameAdd" placeholder="挂号单类型；">
						    </div>
					 </div>
					 </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                <button type="button" id="btnAdd" class="btn btn-primary">提交</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	</form>
	
	<script type="text/javascript">
	$(function(){
		
		//初始化表格
			$('#table').bootstrapTable({
				  url:'${pageContext.request.contextPath}/registrationType?method=query',
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
				    field: 'registrationTypeID',
				    title: '挂号单类型编号',
				    sortable:true
				  }, {
				    field: 'registrationTypeName',
				    title: '挂号单类型名'
				  },
				  {//按钮
					  title:"操作",
					  formatter:function(value,row,index)
					  {
						  var updateValue=' <button onclick="updateFun(' +row.registrationTypeID+')" type="button" class="btn btn-default" >修改</button>';
						  var deleteValue=' <button onclick="deleteFun(' +row.registrationTypeID+')" type="button" class="btn btn-default" >删除</button>';
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
	
	
	$("#addRegistrationType").click(function(){
		$('#myAddModal').modal().on('shown.bs.modal',function() {	
 		})
	})
	
	
	$("#btnAdd").click(function(){
		
		 var registrationType = $("#myAddForm").serializeArray();
		
		 $.ajax({
				type:"post",
				url:'${pageContext.request.contextPath}/registrationType?method=add',
				data:registrationType,
				dataType:"json",
				success:function(json) {
					$("#myAddModal").modal('hide'); 
					$("#table").bootstrapTable('load',json);
					$("#table").bootstrapTable("refresh");//刷新表格中的数据 
				}
			});
	});
	
		
	$("#btn_query").click(function(){
		//获取表单的值(查询的输入框)
		var registrationType = $("#mySerachForm").serializeArray();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/registrationType?method=query',
			data:registrationType,
			dataType:"json",
			success:function(json) {
				$("#table").bootstrapTable('load',json);
				
			}
		});
		
	})
	
	})
	</script>
	
	<script type="text/javascript">
	
	function updateFun(registrationTypeID) {
		$.ajax({
			 type:"post",//提交方式
			 url:'${pageContext.request.contextPath}/registrationType?method=sendUpdate',
			 data:{registrationTypeID:registrationTypeID},
			 dataType:"json",
			 success:function(data){
				 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
					 $('#registrationTypeIDUpdate').val(data.registrationTypeID);
					 $('#registrationTypeNameUpdate').val(data.registrationTypeName);
				 })
				 
			 }
		})
	}
	
	$("#btnUpadte").click(function(){
	    //获取表单中的数据
	     var registrationType = $("#myUpdateForm").serializeArray();
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/registrationType?method=update",
	    	 data:registrationType,
	         dataType:"json",//返回的数据类型为json
	    	 success:function(json){
	    		 if(json ==1){ 
	    			 $("#myUpdateModal").modal('hide');  //手动关闭
	    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据 
	    		 }
	    	 }
	    })
	} )
	
			
function deleteFun(registrationTypeID)
{
	if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/registrationType?method=delete",
		data:{registrationTypeID:registrationTypeID},//传主键值
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