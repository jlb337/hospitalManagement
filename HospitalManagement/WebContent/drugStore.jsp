<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			    <label for="doctorNameSearch">工作人员姓名:</label>
			    <input type="text" name="user.userName" class="form-control" id="doctorNameSearch" placeholder="工作人员姓名">
			  </div>
			  
			  
			  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-5 control-label">药房类型:</label>
				    <div class="col-sm-4">
				         <select  class="form-control" name="drugStoreType">
				         		<option value=''>任意类型</option>
								<option value='住院药房'>住院药房</option>
								<option value='门诊药房'>门诊药房</option>
				         </select>
				    </div>
			   </div>
			   
			   
<!-- 			   <div class="form-group"> -->
<!-- 			    <label for="drugStoreTypeSearch">药房类型:</label> -->
<!-- 			    <input type="text" name="drugStoreType" class="form-control" id="drugStoreTypeSearch" placeholder="药房类型"> -->
<!-- 			  </div> -->
			  
			  <div class="form-group">
			    <label for="drugStoreAreaSearch">药房面积:</label>
			    <input type="text" name="drugStoreArea" class="form-control" id="drugStoreAreaSearch" placeholder="药房面积">
			  </div>
			  			  
			 <button id="btn_query" type="button" class="btn ">查询</button>
			</form>
		</div>
		<div>
		 <button id="open" class="btn ">展开或折叠</button>
		 <button id="addRegistrationType" class="btn ">添加药房</button>
		</div> 
	</div>
	
	<table id="table"></table>
</div>	
		
<form id="myUpdateForm" method="post">

	<input type="hidden" name="drugStoreID" id="drugStoreIDUpdate">
	<input type="hidden"  id="userIdUpdate">
	<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-body">
	            	<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">工作人员:</label>
					    <div class="col-sm-10">
					         <select id="userUpdate" name="userId">

					         </select>
					    </div>
				   </div>
				   
				   <div class="form-group">
				    <label for="inputEmail3" class="col-sm-5 control-label">药房类型:</label>
				    <div class="col-sm-4">
				         <select  class="form-control" name="drugStoreType">
				         		
								<option value='住院药房'>住院药房</option>
								<option value='门诊药房'>门诊药房</option>
				         </select>
				    </div>
			   </div>
			   
				
					
				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药房面积:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugStoreArea" class="form-control" id="drugStoreAreaUpdate" placeholder="药房面积">
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

	<input type="hidden" name="drugStoreID" id="drugStoreIDAdd">
	<input type="hidden"  id="userIdAdd">
	<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-body">
	            	<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">工作人员:</label>
					    <div class="col-sm-10">
					         <select id="userAdd" name="userId">

					         </select>
					    </div>
				   </div>
				 
				   <div class="form-group">
				    <label for="inputEmail3" class="col-sm-5 control-label">药房类型:</label>
				    <div class="col-sm-4">
				         <select  class="form-control" name="drugStoreType">
				         		
								<option value='住院药房'>住院药房</option>
								<option value='门诊药房'>门诊药房</option>
				         </select>
				    </div>
			   </div>
					 
					
				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药房面积:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugStoreArea" class="form-control" id="drugStoreAreaAdd" placeholder="药房面积">
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


	<script type="text/javascript">
$(function(){
		
		//初始化表格
			$('#table').bootstrapTable({
				  url:'${pageContext.request.contextPath}/drugStore?method=query',
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
				    field: 'drugStoreID',
				    title: '药房编号',
				    sortable:true
				  }, {
				    field: 'user.userName',
				    title: '工作人员姓名'
				  },{
					  field:'drugStoreType',
					  title:'药房类型'
				  }, {
					  field:'drugStoreArea',
					  title:'药房面积'
				  },{//按钮
					  title:"操作",
					  formatter:function(value,row,index)
					  {
						  var updateValue=' <button onclick="updateFun(' +row.drugStoreID+')" type="button" class="btn btn-default" >修改</button>';
						  var deleteValue=' <button onclick="deleteFun(' +row.drugStoreID+')" type="button" class="btn btn-default" >删除</button>';
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
	
	
	
	$("#btn_query").click(function(){
		//获取表单的值(查询的输入框)
		var drugStore = $("#mySerachForm").serializeArray();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/drugStore?method=query',
			data:drugStore,
			dataType:"json",
			success:function(json) {
				$("#table").bootstrapTable('load',json);
			}
		});
		
	})
})


//下拉框
 $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/user?method=listDoctor",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            var updateSelect = $("#userUpdate");
            var addSelect = $("#userAdd");
            for (var i = 0; i < datas.length; i++) { 
            	updateSelect.append("<option value='" +datas[i].userId+ "'>"  
                        + datas[i].userName + "</option>");  
            	addSelect.append("<option id='addSelectUserId' value='" +datas[i].userId+ "'>"  
                        + datas[i].userName + "</option>");  
            }  
        } 
  }); 	
  

$("#addRegistrationType").click(function(){
	$('#myAddModal').modal().on('shown.bs.modal',function() {	
		})
})


  
  function updateFun(drugStoreID) {
	$.ajax({
		 type:"post",//提交方式
		 url:'${pageContext.request.contextPath}/drugStore?method=sendUpdate',
		 data:{drugStoreID:drugStoreID},
		 dataType:"json",
		 success:function(data){
			 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
				 $('#drugStoreIDUpdate').val(data.drugStoreID);
				 $('#drugStoreTypeUpdate').val(data.drugStoreType);
				 $('#drugStoreAreaUpdate').val(data.drugStoreArea);
			 })
			 
		 }
	})
}






$("#btnUpadte").click(function(){
    //获取表单中的数据
     var drugStore = $("#myUpdateForm").serializeArray();
    $.ajax({
    	 type:"post",//提交方式
    	 url:"${pageContext.request.contextPath}/drugStore?method=update",
    	 data:drugStore,
         dataType:"json",//返回的数据类型为json
    	 success:function(json){
    		 if(json ==1){ 
    			 $("#myUpdateModal").modal('hide');  //手动关闭
    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据 
    		 }
    	 }
    })
} )

$("#btnAdd").click(function(){
		 var drugStroe = $("#myAddForm").serializeArray();
		
		 $.ajax({
				type:"post",
				url:'${pageContext.request.contextPath}/drugStore?method=add',
				data:drugStroe,  
				dataType:"json",
				success:function(json) {
					$("#myAddModal").modal('hide'); 
					$("#table").bootstrapTable('load',json);
					$("#table").bootstrapTable("refresh");//刷新表格中的数据 
				}            
			});
	});


function deleteFun(drugStoreID)
{
	if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){

	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/drugStore?method=delete",
		data:{drugStoreID:drugStoreID},//传主键值
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