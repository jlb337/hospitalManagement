<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<!-- 搜索工具栏 -->
<div style="margin:100px;">
<div id="toolbar">
   <div id="showorhide" class="showQuery">
          <form class="form-inline" id="showQuery">
          	  <div class="form-group">
				    <label for="exampleInputName2">手术费用:</label>
				    <input type="text" name="operationCost1" class="form-control" id="operationCostSearch" placeholder="最低手术费用">
				  	&nbsp;到&nbsp;
				  	<input type="text" name="operationCost2" class="form-control" id="operationCostSearch" placeholder="最高手术费用">
			  </div>
			  <div class="form-group">
			    	<label for="exampleInputName2">病人姓名:</label>
			    	<input type="text" name="patientName" class="form-control" id="patientNameSearch" placeholder="病人姓名">
			   </div>
			   <div class="form-group">
				    <label for="exampleInputName2">手术名称:</label>
				    <input type="text" name="operationName" class="form-control" id="operationNameSearch" placeholder="手术名称">
			   </div>
			   <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="add" class="btn ">添加</button>
   </div>
</div>
<table id="table"></table>
</div>



<!-- 工具栏 -->
<div id="toolbar"></div>
<div>

</div>
 <script type="text/javascript">
    $(function(){

    	//表格数据的加载
    	$('#table').bootstrapTable({
    		  url: '${pageContext.request.contextPath}/operation?method=query',//访问json数据   访问后台代码返回json数据
    		  method:"get",
    		  toolbar:"#toolbar",
    		  pagination: true,//允许分页
    		  pageSize:3,//每页显示3条
    		  pageList:[1,3,4,5,8,10],//每页显示的条数
    		//  search: true,//允许搜索
    		  striped:true,//各行换颜色
    		  showColumns:true,//可以需要显示的列
    		  showRefresh:true,//允许刷新
    		  showExport:true,//允许导出
    		  exportDataType:'all',//可以全部导出
    		  exportTypes:['pdf','excel'],//导出的数据类型（pdf文件、excel文件）
    		  columns: [{
    		    field: 'operationID',
    		    title: '手术编号',
    		    sortable:true
    		  }, {
    		    field: 'patient.patientName',
    		    title: '病人姓名'
    		  },{
    		    field: 'operationName',
    		    title: '手术名称'
    		  },{
    		    field: 'sleepMethod',
    		    title: '麻醉方式',
    		    formatter:function(value,row,index)
    		   	{ 
			        var value="";
			        if(row.sleepMethod=="1")
			        {
				        value = "局部麻醉";
			        }
			        else if(row.sleepMethod=="2")
			        {
			            value = "局麻+强化";
			        }else if(row.sleepMethod=="3")
			        {
		            	value = "针刺镇痛+麻醉";
		        	}else if(row.sleepMethod=="4")
			        {
		            	value = "部位麻醉";
		        	}else if(row.sleepMethod=="5")
			        {
		            	value = "基础麻醉";
		        	}else if(row.sleepMethod=="6")
			        {
		            	value = "全身麻醉";
		        	}
			        else
	          		{
	            		value = row.sleepMethod ;
	            	}
					return value;
	            }
    		  },{
    		    field: 'operationDate',
    		    title: '手术日期'
    		  },{
    		    field: 'operationResult',
    		    title: '手术结果'
    		  },{
    		    field: 'operationCost',
    		    title: '手术费用'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.operationID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.operationID+')" type="button" class="btn btn-default">删除</button>';
    				  
    				  return updateValue+deleteValue;}
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
	                var searchOperation = $("#mySearchForm").serializeArray();
	              
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/operation?method=queryByCondition",
	                     data: searchOperation,
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });  
  })
  
   //修改
   function updateFun(operationID){

	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/operation?method=sendUpdate",
		    data:{operationID:operationID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#operationIDUpdate").val(data.operationID);
		    		   $("#patientIDUpdate").val(data.patientID);
		    		   $("#operationDateUpdate").val(data.operationDate);
		    		   $("#operationResultUpdate").val(data.operationResult);
		    		   $("#operationCostUpdate").val(data.operationCost);
		    		   
		    	})
		    }
	  		})
  	}
  
  
  	//删除（假删除，更改状态，isDelete:0->1）
  	function deleteFun(operationID){
  		
  		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
				    $.ajax({
				    	type:"post",//提交方式
				    	 url:"${pageContext.request.contextPath}/operation?method=delete",
				    	 data:{operationID:operationID},//数据
				    	 dataType:"json",//返回的数据类型为json
						 success:function(data){
						    	$("#table").bootstrapTable("refresh");//刷新表格中的数据
						 }
					})
			  }
		}
  	}
 </script>

 
<script type="text/javascript">
$(function(){
	 //下拉数据加载  
    $.ajax({  
        type : 'get',  
        url : "${pageContext.request.contextPath}/patient?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#patientIDUpdate");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].patientID +"'>"  
                        + datas[i].patientName + "</option>");  
            }  
          
        } 
        
    })
})
</script>
 

<!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="operationID" id="operationIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改手术信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人姓名:</label>
					    <div class="col-sm-10">
					      <select id="patientIDUpdate" name="patientID" class="form-control"> </select>
					    </div>
				 </div>
				 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">手术日期:</label>
			    		<div class="col-sm-10">
			    			<input type="date" name="operationDate" class="form-control" id="operationDateUpdate" placeholder="手术日期">
			  	 		</div>
			  	 </div>
			  	 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">手术结果:</label>
			    		<div class="col-sm-10">
			    			<input type="text" name="operationResult" class="form-control" id="operationResultUpdate" placeholder="手术结果">
			  	 		</div>
			  	 </div>
			  	 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">手术费用:</label>
			    		<div class="col-sm-10">
			    			<input type="text" name="operationCost" class="form-control" id="operationCostUpdate" placeholder="手术费用">
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
 
<script type="text/javascript">
  $("#btnUpadte").click(function(){
	  
	    //获取表单中的数据
	     var Operation = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/operation?method=update",
	    	 data: Operation,//数据
	    	 dataType:"json",//返回的数据类型为json
	    	 success:function(json){
	    		 
	    		 if(json ==1){
	    			 
	    			 $("#myUpdateModal").modal('hide');  //手动关闭
	    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据	 
	    		 }
	    	 }
	    })
  })
</script>


 
 <script type="text/javascript">
 $(function(){
 
	$("#add").click(function(){
		  $.ajax({		  
			    success:function(data){
			    	
			    	  //弹出添加窗体
			    	 $('#myAddModal').modal().on('shown.bs.modal',function() {
   		  		    		    
			    	})
			    }
		  	})	
		
	})
	
	
  })
 </script>

<script type="text/javascript">
$(function(){
	 //下拉数据加载  
    $.ajax({  
        type : 'get',  
        url : "${pageContext.request.contextPath}/patient?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#patientIDAdd");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].patientID +"'>"  
                        + datas[i].patientName + "</option>");  
            }  
          
        } 
        
    })
})
</script>


<!-- 添加页面窗体 -->
<!-- 模态框（Modal）-->
<form id="myAddForm" method="post">

<input type="hidden" name="operationID" id="operationIDAdd">

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加手术信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人姓名:</label>
					    <div class="col-sm-10">
					    	<select id="patientIDAdd" name="patientID" class="form-control"> 
					    		<option value="">--请选择--</option>
					    	</select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">手术名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="operationName" class="form-control" id="operationNameAdd" placeholder="手术名称；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">麻醉方式:</label>
					    <div class="col-sm-10">
					    	<select id="sleepMethodAdd" name="sleepMethod" class="form-control">
					    		<option value="">--请选择--</option>
					    		<option value="1">局部麻醉</option>
					    		<option value="2">局麻+强化</option>
					    		<option value="3">针刺镇痛+麻醉</option>
					    		<option value="4">部位麻醉</option>
					    		<option value="5">基础麻醉</option>
					    		<option value="6">全身麻醉</option>
					    	</select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">受伤情况:</label>
					    <div class="col-sm-10">
					      <input type="text" name="hurtSituation" class="form-control" id="hurtSituationAdd" placeholder="受伤情况；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">手术日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="operationDate" class="form-control" id="operationDateAdd" placeholder="手术日期；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">持续时间:</label>
					    <div class="col-sm-10">
					      <input type="text" name="operationPersistentTime" class="form-control" id="operationPersistentTimeAdd" placeholder="手术持续时间；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">手术结果:</label>
					    <div class="col-sm-10">
					      <input type="text" name="operationResult" class="form-control" id="operationResultAdd" placeholder="手术结果；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">手术费用:</label>
					    <div class="col-sm-10">
					      <input type="text" name="operationCost" class="form-control" id="operationCostAdd" placeholder="手术费用；">
					    </div>
				 </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnAdd" class="btn btn-primary">确认添加</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>

<script type="text/javascript">
  $("#btnAdd").click(function(){
	  //alert("hsoiad");
	    //获取表单中的数据
	    var Operation = $("#myAddForm").serializeArray();
	    
	    if($("#patientIDAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'病人姓名不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#operationNameAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'手术名称不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		}else if($("#sleepMethodAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'麻醉方式不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#operationDateAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'手术日期不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#operationResultAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'手术结果不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#operationCostAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'手术费用不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}
		else{
	    
			    $.ajax({
			  	 	 type:"post",//提交方式
			   	 	 url:"${pageContext.request.contextPath}/operation?method=add",
			   	 	 data: Operation,//数据
			   		 dataType:"json",//返回的数据类型为json
			    	 success:function(json){
			    		 
			    		 if(json == 1){
			    			 $("#myAddModal").modal('hide');  //手动关闭
			    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据	 
			    		 }
			    	 }
			    })
		}
  })
</script>
</body>
</html>