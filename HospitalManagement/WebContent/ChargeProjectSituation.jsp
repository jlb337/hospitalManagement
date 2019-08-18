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
   <div id="showOrHide" class="showQuery">
          <form class="form-inline" id="mySearchForm">
			  <div class="form-group">
			    <label for="exampleInputName2">病人姓名:</label>
			    <input type="text" name="patient.patientName" class="form-control" id="nameSearch" placeholder="病人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">检查类型:</label>
			    <input type="text" name="chargeType" class="form-control" id="flagCheckOutSearch" placeholder="检查类型">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">检查费用:</label>
			    <input type="text" name="chargeTypeMoney1" class="form-control" id="chargeTypeMoneySearch" placeholder="最低检查费用">
			    &nbsp;到&nbsp;<input type="text" name="chargeTypeMoney2" class="form-control" id="chargeTypeMoneySearch" placeholder="最高检查费用">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">是否出院:</label>
			    <input type="text" name="flagCheckOut" class="form-control" id="flagCheckOutSearch" placeholder="是否出院">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">是否转院:</label>
			    <input type="text" name="flagTransfer" class="form-control" id="flagTransferSearch" placeholder="是否转院">
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

<input type="hidden" name="chargeID" id="chargeIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改检查费用信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查类型:</label>
					    <div class="col-sm-10">
					         <select name="chargeType" class="form-control" id="chargeTypeUpdate">
					              <option value="1">手术费</option>
					              <option value="2">药品费</option>
					              <option value="3">床位费</option>
					              <option value="4">治疗费</option>
					              <option value="5">检验费</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查费用:</label>
					    <div class="col-sm-10">
					      <input type="text" name="chargeTypeMoney" class="form-control" id="chargeTypeMoneyUpdate" placeholder="相应金额；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否出院:</label>
					    <div class="col-sm-10">
					         <select name="flagCheckOut" class="form-control" id="flagCheckOutUpdate" >
					              <option value="1">已出院</option>
					              <option value="2">未出院</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否转院:</label>
					    <div class="col-sm-10">
					         <select name="flagTransfer" class="form-control" id="flagTransferUpdate">
					              <option value="1">已转院</option>
					              <option value="2">未转院</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人:</label>
					    <div class="col-sm-10">
					         <select id="userSelect" class="form-control" name="patientID" ">
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

<input type="hidden">  <!--name="chargeID" id="chargeIDInsert"-->

<div class="modal fade" id="myInsertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">插入一条新数据</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查类型:</label>
					    <div class="col-sm-10">
					         <select name="chargeType" class="form-control" >
					              <option value="1">手术费</option>
					              <option value="2">药品费</option>
					              <option value="3">床位费</option>
					              <option value="4">治疗费</option>
					              <option value="5">检验费</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查费用:</label>
					    <div class="col-sm-10">
					      <input type="text" name="chargeTypeMoney" class="form-control" id="chargeTypeMoneyID" placeholder="相应金额；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否出院:</label>
					    <div class="col-sm-10">
					         <select name="flagCheckOut" class="form-control">
					              <option value="1">已出院</option>
					              <option value="2">未出院</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否转院:</label>
					    <div class="col-sm-10">
					         <select name="flagTransfer" class="form-control" >
					              <option value="1">已转院</option>
					              <option value="2">未转院</option>
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人:</label>
					    <div class="col-sm-10">
					         <select id="userSelect_insert" class="form-control" name="patientID">
					         </select>
					    </div>
				 </div>            </div>
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

<input type="hidden" name="chargeID" id="chargeIDDelete">

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
            type : 'get',  
            url : "${pageContext.request.contextPath}/patient?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#userSelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientID + "'>"  
                            + datas[i].patientName + "</option>");  
                }  
            } 
        }); 
		
		
		//下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/patient?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#userSelect_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientID + "'>"  
                            + datas[i].patientName + "</option>");  
                }  
            } 
        });
    	
    	
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/chargeprojectsituation?method=selectByCondition",//访问地址
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
	    		    field: 'chargeID',
	    		    title: '编号',
	    		    sortable:true
    		  	}, 
    		  	{
	    		    field: 'patient.patientName',
	    		    title: '病人姓名'
    		  	}, 
    		  	{
	    		    field: 'chargeType',
	    		    title: '收费类型',
	    		    
	    		    
	    		    
	    		   	formatter:function(value,row,index)
	    		   	{ 
				        var value="";
				        if(row.chargeType=="1")
				        {
					        value = "手术费";
				        }
				        else if(row.chargeType=="2")
				        {
				            	value = "药品费";
				        }
				        else if(row.chargeType=="3")
				        {
				            	value = "床位费";
				        }
				        else if(row.chargeType=="4")
				        {
				            	value = "治疗费";
				        }
				        else if(row.chargeType=="5")
				        {
				            	value = "检验费";
				        }
				        else
		          		{
		            		value = row.chargeType ;
		            	}
						return value;
		            }

	    		    
	    		    
    		  	}, 
    		  	{
	    		    field: 'chargeTypeMoney',
	    		    title: '相应费用'
    		  	}, 
    		  	{
	    		    field: 'flagCheckOut',
	    		    title: '是否出院',
	    		    
	    		    
	    		   	formatter:function(value,row,index)
	    		   	{ 
				        var value="";
				        if(row.flagCheckOut=="1")
				        {
					        value = "已出院";
				        }
				        else if(row.flagCheckOut=="2")
				        {
				            	value = "未出院";
				        }
				        else
		          		{
		            		value = row.flagCheckOut ;
		            	}
						return value;
						}
						
    		  		}, 
    		  		{
        		    field: 'flagTransfer',
        		    title: '是否转院',
        		    
	    		   	formatter:function(value,row,index)
	    		   	{ 
				    var value="";
			        if(row.flagTransfer=="1")
			        {
				        value = "已转院";
			        }
			        else if(row.flagTransfer=="2")
			        {
			            	value = "未转院";
			        }
			        else
	          		{
	            		value = row.flagTransfer ;
	            	}
					return value;
	    		   	}
        		  	}, 
        		  	
    		  	{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.chargeID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.chargeID+')" type="button" class="btn btn-default">删除</button>';
    				  
    				  return updateValue+deleteValue;
    			  }
    		  }]
    	})
    	
    	
    	//<!--展开或折叠   #:id名称     .:class名称-->
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
	                     url: "${pageContext.request.contextPath}/chargeprojectsituation?method=selectByCondition",
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
   function updateFun(chargeID){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/chargeprojectsituation?method=sendUpdate",
		    data:{chargeID:chargeID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#chargeIDUpdate").val(data.chargeID);
		    		   $("#chargeTypeUpdate").val(data.chargeType);
		    		   $("#chargeTypeMoneyUpdate").val(data.chargeTypeMoney);
		    		   $("#flagCheckOutUpdate").val(data.flagCheckOut);
		    		   $("#flagTransferUpdate").val(data.flagTransfer);
		    		   $("#PatientNameUpdate").val(data.PatientID);
		    	})
		    }
	  })
  }
  
  
  function deleteFun(chargeID)
  {
		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	  
	    $.ajax({
	    	type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/chargeprojectsituation?method=Delete",
	    	 data:{chargeID:chargeID},//数据
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
	    	 url:"${pageContext.request.contextPath}/chargeprojectsituation?method=update",
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
	    
	
	    
		   if($("#chargeTypeMoneyID").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">相应费用不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
			else{
				    $.ajax({
				    	 type:"post",//提交方式
				    	 url:"${pageContext.request.contextPath}/chargeprojectsituation?method=insert",
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
	    	 url:"${pageContext.request.contextPath}/chargeprojectsituation?method=Delete",
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