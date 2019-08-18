<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- jsp包含指令 -->
<%@ include file="common/commoncss.jsp" %>
<%@ include file="common/commonjs.jsp" %>

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
<!-- 搜索工具栏 -->
<div id="toolbar">
   <div id="showorhide" class="showQuery">
          <form class="form-inline" id="mySearchForm">
			  <div class="form-group">
			    <label for="exampleInputName2">信贷状况:</label>
			    <input type="text" name="supplierReditStatus" class="form-control" id="nameSearch" placeholder="病人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">地址:</label>
			    <input type="text" name="supplierAddress" class="form-control" id="IDSearch" placeholder="身份证号">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">电话:</label>
			    <input type="text" name="supplierTel" class="form-control" id="ageSearch" placeholder="年龄">
			  </div>
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="btn_insert"  class="btn ">插入</button>
   </div>
</div>
<table id="table"></table>
<!-- 工具栏 -->
<div id="toolbar"></div>


 
 
 
 
<!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="supplierID" id="supplierIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改供应商信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">信贷状况:</label>
					    <div class="col-sm-10">
					         <select name="supplierReditStatus" class="form-control" >
					              <option value="1">优</option>
					              <option value="2">良</option>
					              <option value="3">差</option>
					         </select>
					    </div>
				</div>
				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">地址:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierAddress" class="form-control" id="supplierAddressUpdate" placeholder="病人姓名；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">电话:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierTel" class="form-control" id="supplierTelUpdate" placeholder="性别；">
					    </div>
				 </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnUpadte" class="btn btn-primary">更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>






<!--插入页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myInsertForm" method="post">

<input type="hidden">  <!--name="patientID" id="patientIDInsert"-->

<div class="modal fade" id="myInsertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">插入一条新数据</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">信贷状况:</label>
					    <div class="col-sm-10">
					         <select name="supplierReditStatus" class="form-control" >
					              <option value="1">优</option>
					              <option value="2">良</option>
					              <option value="3">差</option>
					         </select>
					    </div>
				</div>
				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">地址:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierAddress" class="form-control" id="a" placeholder="地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">电话:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierTel" class="form-control" id="b" placeholder="电话；">
					    </div>
				 </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnInsert" class="btn btn-primary">更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>



<!-- 删除页面窗体 -->
<!-- 模态框（Modal） -->
<form id= "myDeleteForm" method="post">

<input type="hidden" name="supplierID" id="supplierIDDelete">

<div class="modal fade" id="myDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">是否删除</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnDelete" class="btn btn-primary">确定</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>

</div>




<script type="text/javascript">
    $(function(){
    	
    	 
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/supplier?method=selectByCondition",//访问地址
    		method:"get",//请求的方式
    		toolbar:"#toolbar",//工具栏
    		pagination:true,//允许分页
    		pageSize:8,//每页显示的条数
    		pageList:[2,3,5,8,10],//每页显示的条数集合
    		showColumns:true,//是否显示所有的列
    		showRefresh:true,//是否显示刷新
    		striped:true,//隔行变色   每一行的唯一标识，一般为主键列
		    showExport:true,//允许导出
  		    exportDataType:'all',//可以全部导出
  		    exportTypes:['pdf','excel'],//导出的数据类型（pdf文件、excel文件）
    		columns: [ 
    		 	{
	    		    field: 'supplierID',
	    		    title: '编号',
	    		    sortable:true
    		  	}, 
    		  	{
	    		    field: 'supplierReditStatus',
	    		    title: '信贷状况',
	    		    
	    		   	formatter:function(value,row,index)
	    		   	{ 
				    var value="";
			        if(row.supplierReditStatus=="1")
			        {
				        value = "优";
			        }
			        else if(row.supplierReditStatus=="2")
			        {
			            	value = "良";
			        }
			        else if(row.supplierReditStatus=="3")
			        {
			            	value = "差";
			        }
			        else
	          		{
	            		value = row.supplierReditStatus ;
	            	}
					return value;
	    		   	}
    		  	}, 
    		  	{
	    		    field: 'supplierAddress',
	    		    title: '地址'
    		  	}, 
    		  	{
	    		    field: 'supplierTel',
	    		    title: '电话'
    		  	}, 
    		  	{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.supplierID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.supplierID+')" type="button" class="btn btn-default">删除</button>';
    				  
    				  return updateValue+deleteValue;
    			  }
    		  }]
    	})
    	
    	
    	
    	<!--展开或折叠   #:id名称     .:class名称-->
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
    	
    	
    })
 </script>


<script type="text/javascript">
  $(function(){
	  <!--搜索条件-->
  	//条件搜索
		$("#btn_query").click(function() {
	                //var name = $("#nameSearch").val();
	                //var chargeType = $("#chargeTypeSearch").val();
	                //var flagCheckOut = $("#flagCheckOutSearch").val();
	                //var flagTransfer = $("#flagTransferSearch").val();
	              	var searchPosition = $("#mySearchForm").serializeArray();
	                
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/supplier?method=selectByCondition",
	                     data: searchPosition, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });

	    });
  	
  	
		   
		//插入
		$("#btn_insert").click(function() {
		
		$('#myInsertModal').modal().on('shown.bs.modal',function() 
		{
			//$("#chargeIDInsert").val(null);
		})
				
		});
  		
  	  
  	  
  })
  

 //修改
   function updateFun(supplierID){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/supplier?method=sendUpdate",
		    data:{ supplierID : supplierID },//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#supplierIDUpdate").val(data.supplierID);
		    		   $("#supplierAddressUpdate").val(data.supplierAddress);
		    		   $("#supplierTelUpdate").val(data.supplierTel);
		    		   $("#supplierReditStatusUpdate").val(data.supplierReditStatus);
		    	})
		    }
	  })
  }
  
  
  function deleteFun(supplierID)
  {
		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
				  
				  
				  
	    $.ajax({
	    	type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/supplier?method=Delete",
	    	 data:{ supplierID : supplierID },//数据
	    	 dataType:"json",//返回的数据类型为json
			 success:function(data){
			    	  //弹出修改窗体
					$("#table").bootstrapTable("refresh");//刷新表格中的数据

			    	 //$('#myDeleteModal').modal().on('shown.bs.modal',function() {
			    		 
			    		   //$("#patientIDDelete").val(data.patientID);
	    		 
				    	//})
			    }
		  })
				  
				  
			  }}
	  	
	  }
  
  
  
 </script>
 

 
<script type="text/javascript">
  $("#btnUpadte").click(function(){
	     //获取表单中的数据
	     var situation = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/supplier?method=update",
	    	 data:situation,//数据
	    	 dataType:"json",//返回的数据类型为json
	    	 success:function(json){
	    		 if(json ==1){
	    			 
	    			 $("#myUpdateModal").modal('hide');  //手动关闭
	    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
	    			 
	    			 
	    		 }
	    	 }
	    })
  })
  
  
   $("#btnInsert").click(function(){
	    //获取表单中的数据
	     var situation = $("#myInsertForm").serializeArray();
	    
		   if($("#a").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">供应商地址不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
	    
		   else if($("#b").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">供应商电话不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
		   
		   
			else{
	    
					    $.ajax({
					    	 type:"post",//提交方式
					    	 url:"${pageContext.request.contextPath}/supplier?method=insert",
					    	 data:situation,//数据
					    	 dataType:"json",//返回的数据类型为json
					    	 success:function(json){
					    		 if(json ==1){
					    			 $("#myInsertModal").modal('hide');  //手动关闭
					    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
					    		 }
					    	 }
					    });
			}
  })
  
  
  
 	 $("#btnDelete").click(function(){
	    //获取表单中的数据
	     var patient = $("#myDeleteForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/supplier?method=Delete",
	    	 data:patient,//数据
	    	 dataType:"json",//返回的数据类型为json
	    	 success:function(json){
	    		 if(json ==1){
	    			 
	    			 $("#myDeleteModal").modal('hide');  //手动关闭
	    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
	    			 
	    			 
	    		 }
	    	 }
	    })
  })
  
</script>
<!-- 修改页面窗体 -->


</body>
</html>