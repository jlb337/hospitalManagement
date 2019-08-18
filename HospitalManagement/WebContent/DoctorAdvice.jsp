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
   <!-- patient./user./patienthistory/ -->
          <form class="form-inline" id="mySearchForm">
			  <div class="form-group">
			    <label for="exampleInputName2">病人姓名:</label>
			    <input type="text" name="patient.patientName" class="form-control" id="nameSearch" placeholder="病人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">医生姓名:</label>
			    <input type="text" name="user.userName" class="form-control" id="userNameSearch" placeholder="医生姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">病例编号:</label>
			    <input type="text" name="patienthistory.patientHistoryID" class="form-control" id="historytypeSearch" placeholder="病例类型">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">疾病名称:</label>
			    <input type="text" name="illnessName" class="form-control" id="illnessNameSearch" placeholder="疾病名称">
			  </div>
			  <div class="form-group">
				 <label for="exampleInputName2">是否出院:</label>
				 <div class="col-sm-10">
				         <select name="flagOut" class="form-control" id="flagOutUpdate">
<!-- 				         	  <option value="0">检查类型</option> -->
							  <option value="">请选择</option>
				              <option value="1">已出院</option>
				              <option value="2">未出院</option>
				         </select>
				    </div>
			  </div>
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="btn_insert" class="btn ">插入</button>
   </div>
</div>
<table id="table"></table>
<!-- 工具栏 -->
<div id="toolbar"></div>
 
 
 
<!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="willID" id="willIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改医嘱信息</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">启用日期:</label>
					    <div class="col-sm-10">
					      <input type="text" name="startDate" class="form-control" id="startDateUpdate" placeholder="启用日期；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处理日期:</label>
					    <div class="col-sm-10">
					      <input type="text" name="endDate" class="form-control" id="endDateUpdate" placeholder="处理日期；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医嘱:</label>
					    <div class="col-sm-10">
					      <input type="text" name="doctorAdvice" class="form-control" id="doctorAdviceUpdate" placeholder="医嘱；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">疾病名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="illnessName" class="form-control" id="illnessNameUpdate" placeholder="疾病名称；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否出院:</label>
					    <div class="col-sm-10">
					         <select name="flagOut" class="form-control" id="flagOutUpdate" >
					              <option value="1">已出院</option>
					              <option value="2">未出院</option>
					         </select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人:</label>
					    <div class="col-sm-10">
					         <select id="patientSelect" class="form-control"  name="patientID">
					         <!--  <option value = "0">请选择</option> --> 
					         </select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医生:</label>
					    <div class="col-sm-10">
					         <select id="userSelect" class="form-control" name="userId">
					         </select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病历序号:</label>
					    <div class="col-sm-10">
					         <select id="patientHistorySelect"class="form-control"  name="patientHistoryID">
					         </select>
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

<input type="hidden">

<div class="modal fade" id="myInsertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">插入一条新数据</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">启用日期:</label>
					    <div class="col-sm-10">
					      <input type="text" name="startDate" class="form-control" id="startDate_insert" placeholder="启用日期(xxxx-xx-xx)；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处理日期:</label>
					    <div class="col-sm-10">
					      <input type="text" name="endDate" class="form-control" placeholder="处理日期(xxxx-xx-xx)；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医嘱:</label>
					    <div class="col-sm-10">
					      <input type="text" name="doctorAdvice" class="form-control" id="doctorAdvice_insert" placeholder="医嘱；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">疾病名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="illnessName" class="form-control" id="illnessName_insert" placeholder="疾病名称；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否出院:</label>
					    <div class="col-sm-10">
					         <select name="flagOut" class="form-control">
					              <option value="1">已出院</option>
					              <option value="2">未出院</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人:</label>
					    <div class="col-sm-10">
					         <select id="patientSelect_insert" class="form-control" name="patientID">
					         <!-- <option value = "0">请选择</option>  -->
					         </select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">医生:</label>
					    <div class="col-sm-10">
					         <select id="userSelect_insert" class="form-control" name="userId">
					         <!--  <option value = "0">请选择</option> -->
					         </select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病历序号:</label>
					    <div class="col-sm-10">
					         <select id="patientHistorySelect_insert" class="form-control" name="patientHistoryID">
					         <option value = "0">请选择</option>
					         </select>
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

<input type="hidden" name="willID" id="willIDDelete">

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

    	//下拉数据加载  
        $.ajax({  
            //
        	type : 'get',  
            url : "${pageContext.request.contextPath}/patient?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#patientSelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientID + "'>"  
                            + datas[i].patientName + "</option>");  
                }  
            } 
        }); 

		
		
		//下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/user?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#userSelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].userId + "'>"  
                            + datas[i].userName + "</option>");  
                }  
            } 
        }); 
		
		
		//下拉数据加载  
		//需要修改为PatientHistory的query!!!
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/patienthistory?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
               var select = $("#patientHistorySelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientHistoryID + "'>"  
                            + datas[i].patientHistoryID + "</option>");  
                	
                	
                }  
            } 
        });
		
		
    	
    	//下拉数据加载  
        $.ajax({  
            //
        	type : 'get',  
            url : "${pageContext.request.contextPath}/patient?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#patientSelect_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientID + "'>"  
                            + datas[i].patientName + "</option>");  
                }  
            } 
        }); 

		
		
		//下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/user?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#userSelect_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].userId + "'>"  
                            + datas[i].userName + "</option>");  
                }  
            } 
        }); 
		
		
		//下拉数据加载  
		//需要修改为PatientHistory的query!!!
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/patienthistory?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
               var select = $("#patientHistorySelect_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientHistoryID + "'>"  
                            + datas[i].patientHistoryID + "</option>");  
                	
                	
                }  
            } 
        });
    	
		
    	
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/doctoradvice?method=selectByCondition",//访问地址
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
	    		    field: 'willID',
	    		    title: '编号',
	    		    sortable:true
    		  	}, 
    		  	{
	    		    field: 'patient.patientName',
	    		    title: '病人姓名'
    		  	}, 
    		  	{
	    		    field: 'user.userName',
	    		    title: '医生姓名'
    		  	}, 
    		  	{
	    		    field: 'patienthistory.patientHistoryID',
	    		    title: '病例编号'
    		  	}, 
    		  	{
	    		    field: 'startDate',
	    		    title: '启用日期'
    		  	}, 
    		  	{
        		    field: 'endDate',
        		    title: '处理日期'
        		  	}, 
    		  	{
        		    field: 'doctorAdvice',
        		    title: '医嘱'
        		  	}, 
    		  	{
        		    field: 'illnessName',
        		    title: '疾病名称'
        		  	}, 
    		  	{
        		    field: 'flagOut',
        		    title: '是否出院',
        		    
	    		   	formatter:function(value,row,index)
	    		   	{ 
				    var value="";
			        if(row.flagOut=="1")
			        {
				        value = "已出院";
			        }
			        else if(row.flagOut=="2")
			        {
			            	value = "未出院";
			        }
			        else
	          		{
	            		value = row.flagOut ;
	            	}
					return value;
	    		   	}
        		  	}, 
    		  	{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.willID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.willID+')" type="button" class="btn btn-default">删除</button>';
    				  
    				  return updateValue+deleteValue;
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
	                     url: "${pageContext.request.contextPath}/doctoradvice?method=selectByCondition",
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
   function updateFun(willID){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/doctoradvice?method=sendUpdate",
		    data:{ willID : willID },//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#willIDUpdate").val(data.willID);
		    		   $("#startDateUpdate").val(data.startDate);
		    		   $("#endDateUpdate").val(data.endDate);
		    		   $("#doctorAdviceUpdate").val(data.doctorAdvice);
		    		   $("#illnessNameUpdate").val(data.illnessName);
		    		   $("#flagOutUpdate").val(data.flagOut);
		    	})
		    }
	  })
  }
  
  
  function deleteFun(willID)
  {
		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	  
	    $.ajax({
	    	type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/doctoradvice?method=Delete",
	    	 data:{ willID : willID },//数据
	    	 dataType:"json",//返回的数据类型为json
			 success:function(data){
			    	  //弹出修改窗体
			    	// $('#myDeleteModal').modal().on('shown.bs.modal',function() {
			    		  $("#table").bootstrapTable("refresh");//刷新表格中的数据
			    		  // $("#chargeIDDelete").val(data.chargeID);
	    		 
				    	//})
			    }
		  })
		  
			  }
	  }
  
  }
  
 </script>
 

 
<script type="text/javascript">
  $("#btnUpadte").click(function(){
	     //获取表单中的数据
	     var situation = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/doctoradvice?method=update",
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
	    
		if($("#illnessName_insert").val() == ""){
		$.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">疾病名称不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
		
		else if($("#doctorAdvice_insert").val() == ""){
		$.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">医嘱内容不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
		
		else if($("#startDate_insert").val() == ""){
		$.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">开始日期不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
			else{
	    
					    $.ajax({
					    	 type:"post",//提交方式
					    	 url:"${pageContext.request.contextPath}/doctoradvice?method=insert",
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
	     var situation = $("#myDeleteForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/doctoradvice?method=Delete",
	    	 data:situation,//数据
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