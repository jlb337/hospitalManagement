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
			    <label for="doctorNameSearch">医生姓名:</label>
			    <input type="text" name="user.userName" class="form-control" id="doctorNameSearch" placeholder="医生姓名">
			  </div>
			  
			   <div class="form-group">
			    <label for="diagnosisDateSearch">诊断日期:</label>
			    <input type="text" name="diagnosisDate" class="form-control" id="diagnosisDateSearch" placeholder="诊断日期">
			  </div>
			  
			  <div class="form-group">
			    <label for="patientHistoryRecordSearch">病历内容:</label>
			    <input type="text" name="patientHistoryRecord" class="form-control" id="patientHistoryRecordSearch" placeholder="病历内容">
			  </div>
			  
			  
			  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-5 control-label">病历类型:</label>
				    <div class="col-sm-4">
				         <select id="historytypeSearch" class="form-control" name="historytype">
				         		<option value=''>任意类型</option>
								<option value='1'>门诊病历</option>
								<option value='2'>住院病历</option>
				         </select>
				    </div>
			   </div>
			  
			 <button id="btn_query" type="button" class="btn ">查询</button>
			</form>
		</div>
		<div>
		 <button id="open" class="btn ">展开或折叠</button>
		 <button id="addRegistrationType" class="btn ">添加病历</button>
		</div> 
	</div>
	
	<table id="table"></table>
	</div>
<form id="myUpdateForm" method="post">

	<input type="hidden" name="patientHistoryID" id="patientHistoryIDUpdate">
	<input type="hidden"  id="userIdUpdate">
	<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	    
	        <div class="modal-content">
	        
	            <div class="modal-body">
	            
	            	<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医生:</label>
					    <div class="col-sm-10">
					         <select id="userUpdate" class="form-control" name="userId">

					         </select>
					    </div>
				   </div>
				   
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">诊断日期:</label>
					    <div class="col-sm-10">
					      <input type="text" name="diagnosisDate" class="form-control" id="diagnosisDateUpdate" placeholder="诊断日期">
					    </div>
				 </div>
					 
				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病历内容:</label>
					    <div class="col-sm-10">
					      <input type="text" name="patientHistoryRecord" class="form-control" id="patientHistoryRecordUpdate" placeholder="病历内容">
					    </div>
				 </div>	 
					
				<div class="form-group">
				    <label for="inputEmail3" class="col-sm-5 control-label">病历类型:</label>
				    <div class="col-sm-4">
				         <select  class="form-control" name="historytype">
				         		
								<option value='1'>门诊病历</option>
								<option value='2'>住院病历</option>
				         </select>
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
	<input type="hidden"  id="userIdAdd">
	<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-body">
		            	<div class="form-group">
						    <label for="inputEmail3" class="col-sm-2 control-label">医生:</label>
						    <div class="col-sm-10">
						         <select id="userAdd" class="form-control" name="userId">
	
						         </select>
						    </div>
					   </div>
					 <div class="form-group">
						    <label for="inputEmail3" class="col-sm-2 control-label">诊断日期:</label>
						    <div class="col-sm-10">
						      <input type="text" name="diagnosisDate" class="form-control" id="diagnosisDateAdd" placeholder="诊断日期">
						    </div>
					 </div>
						 
					<div class="form-group">
						    <label for="inputEmail3" class="col-sm-2 control-label">病历内容:</label>
						    <div class="col-sm-10">
						      <input type="text" name="patientHistoryRecord" class="form-control" id="patientHistoryRecordAdd" placeholder="病历内容">
						    </div>
					 </div>	 
						
					<div class="form-group">
				    <label for="inputEmail3" class="col-sm-5 control-label">病历类型:</label>
				    <div class="col-sm-4">
				         <select  class="form-control" name="historytype">
				      
								<option value='1'>门诊病历</option>
								<option value='2'>住院病历</option>
				         </select>
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
				  url:'${pageContext.request.contextPath}/patientHistory?method=query',
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
				    field: 'patientHistoryID',
				    title: '病历编号',
				    sortable:true
				  }, {
				    field: 'user.userName',
				    title: '医生姓名'
				  },{
					  field:'diagnosisDate',
					  title:'诊断日期'
				  }, {
					  field:'patientHistoryRecord',
					  title:'病历内容'
				  },{
					  field:'historytype',
					  title:'病历类型',
					  formatter:function(value,row,index)
					  {
						  var value="";
						  if(row.historytype=="1")
							  {
							 	 value="门诊病历";
							  }
						  else if(row.historytype=="2")
							  {
							  	value="住院病历";
							  }
						  else{
							  value=row.historytype;
						  }
						  return value;
					  }
				  },{//按钮
					  title:"操作",
					  formatter:function(value,row,index)
					  {
						  var updateValue=' <button onclick="updateFun(' +row.patientHistoryID+')" type="button" class="btn btn-default" >修改</button>';
						  var deleteValue=' <button onclick="deleteFun(' +row.patientHistoryID+')" type="button" class="btn btn-default" >删除</button>';
						  return updateValue+deleteValue;
					  }
				  }]
				})

				
	//展开或者折叠
// 	$("#open").click(function(){
// 		$("#showOrHide").slideToggle("slow");
// 	})
	
	
	$("#open").click(function(){
    		
    		 //判断  attr：属性   a:显示      b：隐藏
    		 if($("#showOrHide").attr("class")=="showQuery"){
    			 
    			 $("#showOrHide").attr("class","hideQuery");//由显示变为隐藏
    			 $("#showOrHide").slideDown("fast");//向下快速滑动
    		 }else{
    			 $("#showOrHide").attr("class","showQuery");//由显示变为隐藏
    			 $("#showOrHide").slideUp("fast");//向上快速滑动
    		 }
    	})
	
	$("#addRegistrationType").click(function(){
		$('#myAddModal').modal().on('shown.bs.modal',function() {	
 		})
	})
	
	$("#btn_query").click(function(){
		//获取表单的值(查询的输入框)
		var registrationType = $("#mySerachForm").serializeArray();
		$.ajax({
			type:"post",
			url:'${pageContext.request.contextPath}/patientHistory?method=query',
			data:registrationType,
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
  

  

  
</script>

<script type="text/javascript">

function updateFun(patientHistoryID) {
	$.ajax({
		 type:"post",//提交方式
		 url:'${pageContext.request.contextPath}/patientHistory?method=sendUpdate',
		 data:{patientHistoryID:patientHistoryID},
		 dataType:"json",
		 success:function(data){
			 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
				 $('#patientHistoryIDUpdate').val(data.patientHistoryID);
				 $('#patientHistoryRecordUpdate').val(data.patientHistoryRecord);
				 $('#diagnosisDateUpdate').val(data.diagnosisDate);
				 $('#historytypeUpdate').val(data.historytype);
			 })
			 
		 }
	})
}


$("#btnUpadte").click(function(){
    //获取表单中的数据
     var patientHistory = $("#myUpdateForm").serializeArray();
    $.ajax({
    	 type:"post",//提交方式
    	 url:"${pageContext.request.contextPath}/patientHistory?method=update",
    	 data:patientHistory,
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
		 var patientHistory = $("#myAddForm").serializeArray();
		
		 $.ajax({
				type:"post",
				url:'${pageContext.request.contextPath}/patientHistory?method=add',
				data:patientHistory,
				dataType:"json",
				success:function(json) {
					$("#myAddModal").modal('hide'); 
					$("#table").bootstrapTable('load',json);
					$("#table").bootstrapTable("refresh");//刷新表格中的数据 
				}
			});
	});
	
	
function deleteFun(patientHistoryID)
{
	if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/patientHistory?method=delete",
		data:{patientHistoryID:patientHistoryID},//传主键值
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