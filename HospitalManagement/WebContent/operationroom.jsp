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
          <form class="form-inline" id="mySearchForm">
			  <div class="form-group">
			    	<label for="exampleInputName2">用户:</label>
			    	<input type="text" name="user.userName" class="form-control" id="userNameSearch" placeholder="用户名">
			   </div>
			   <div class="form-group">
				    <label for="exampleInputName2">手术室地址:</label>
				    <input type="text" name="operationRoomAddress" class="form-control" id="operationRoomAddressSearch" placeholder="手术室地址">
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

 <script type="text/javascript">
    $(function(){

    	//表格数据的加载
    	$('#table').bootstrapTable({
    		  url: '${pageContext.request.contextPath}/operationroom?method=query',//访问json数据   访问后台代码返回json数据
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
    		    field: 'operationRoomID',
    		    title: '手术室编号',
    		    sortable:true
    		  }, {
    		    field: 'user.userName',
    		    title: '用户名'
    		  },{
    		    field: 'operationRoomAddress',
    		    title: '手术室地址'
    		  },{
    		    field: 'operationDescrip',
    		    title: '手术室描述'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.operationRoomID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.operationRoomID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var searchOperationRoom = $("#mySearchForm").serializeArray();
	              
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/operationroom?method=queryByCondition",
	                     data: searchOperationRoom,
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });  
  })
  
   //修改
   function updateFun(operationRoomID){

	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/operationroom?method=sendUpdate",
		    data:{operationRoomID:operationRoomID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#operationRoomIDUpdate").val(data.operationRoomID);
		    		   $("#userIdUpdate").val(data.userId);
		    		   $("#operationRoomAddressUpdate").val(data.operationRoomAddress);
		    		   
		    	})
		    }
	  		})
  	}
  
  	
  	
  	//删除（假删除，更改状态，isDelete:0->1）
  	function deleteFun(operationRoomID){
  		
  		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
				    $.ajax({
				    	type:"post",//提交方式
				    	 url:"${pageContext.request.contextPath}/operationroom?method=delete",
				    	 data:{operationRoomID:operationRoomID},//数据
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
        url : "${pageContext.request.contextPath}/user?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#userIdUpdate");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].userId +"'>"  
                        + datas[i].userName + "</option>");  
            }  
          
        } 
        
    })
})
</script>
 

<!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="operationRoomID" id="operationRoomIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改手术室信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
					    <div class="col-sm-10">
					      <select id="userIdUpdate" name="userId" class="form-control"> </select>
					    </div>
				 </div>
				 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">手术室地址:</label>
			    		<div class="col-sm-10">
			    			<input type="text" name="operationRoomAddress" class="form-control" id="operationRoomAddressUpdate" placeholder="检查结果">
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
	     var OperationRoom = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/operationroom?method=update",
	    	 data: OperationRoom,//数据
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
        url : "${pageContext.request.contextPath}/user?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#userIdAdd");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].userId +"'>"  
                        + datas[i].userName + "</option>");  
            }  
          
        } 
        
    })
})
</script>


<!-- 添加页面窗体 -->
<!-- 模态框（Modal） 
<select id="userIdSearch" name="userId"> </select>
<input type="text" name="userId" class="form-control" id="userIdAdd" placeholder="用户ID；">
-->
<form id="myAddForm" method="post">

<input type="hidden" name="operationRoomID" id="operationRoomIDAdd">

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加手术室信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-3 control-label">用户名:</label>
					    <div class="col-sm-9">
					    	<select id="userIdAdd" name="userId" class="form-control"> 
					    		<option value="">--请选择--</option>
					    	</select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-3 control-label">手术室地址:</label>
					    <div class="col-sm-9">
					      <input type="text" name="operationRoomAddress" class="form-control" id="operationRoomAddressAdd" placeholder="手术室地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-3 control-label">手术室描述:</label>
					    <div class="col-sm-9">
					      <input type="text" name="operationDescrip" class="form-control" id="operationDescripAdd" placeholder="手术室描述；">
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
	    var OperationRoom = $("#myAddForm").serializeArray();
	    
	    if($("#userIdAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'用户名不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#operationRoomAddressAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'手术室地址不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		}
		else{
	    
			    $.ajax({
			  	 	 type:"post",//提交方式
			   	 	 url:"${pageContext.request.contextPath}/operationroom?method=add",
			   	 	 data: OperationRoom,//数据
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