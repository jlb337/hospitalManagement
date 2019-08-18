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
				    <label for="exampleInputName2">订单费用:</label>
				    <input type="text" name="sumCost1" class="form-control" id="sumCostSearch" placeholder="最低订单费用">
				  	&nbsp;到&nbsp;
				  	<input type="text" name="sumCost2" class="form-control" id="sumCostSearch" placeholder="最高订单费用">
			  </div>
			  <div class="form-group">
			    	<label for="exampleInputName2">批号:</label>
			    	<input type="text" name="batchNumber" class="form-control" id="batchNumberSearch" placeholder="批号">
			   </div>
			   <div class="form-group">
				    <label for="exampleInputName2">订单号:</label>
				    <input type="text" name="drugOrderID" class="form-control" id="drugOrderIDSearch" placeholder="订单号">
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
    		  url: '${pageContext.request.contextPath}/orderdetail?method=query',//访问json数据   访问后台代码返回json数据
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
    		    field: 'detailID',
    		    title: '订单细则编号',
    		    sortable:true
    		  }, {
    		    field: 'drugOrderID',
    		    title: '订单号'
    		  },{
    		    field: 'number',
    		    title: '数量'
    		  },{
    		    field: 'sumCost',
    		    title: '订单总价'
    		  },{
    		    field: 'batchNumber',
    		    title: '批号'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.detailID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.detailID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var searchOrderDetail = $("#mySearchForm").serializeArray();
	              
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/orderdetail?method=queryByCondition",
	                     data: searchOrderDetail,
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });  
  })
  
   //修改
   function updateFun(detailID){

	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/orderdetail?method=sendUpdate",
		    data:{detailID:detailID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#detailIDUpdate").val(data.detailID);
		    		   $("#drugOrderIDUpdate").val(data.drugOrderID);
		    		   $("#numberUpdate").val(data.number);
		    		   $("#sumCostUpdate").val(data.sumCost);
		    		   $("#batchNumberUpdate").val(data.batchNumber);
		    		   
		    	})
		    }
	  		})
  	}

  	
  	//删除（假删除，更改状态，isDelete:0->1）
  	function deleteFun(detailID){
  		
  		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
				    $.ajax({
				    	type:"post",//提交方式
				    	 url:"${pageContext.request.contextPath}/orderdetail?method=delete",
				    	 data:{detailID:detailID},//数据
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
        url : "${pageContext.request.contextPath}/drugorder?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#drugOrderIDUpdate");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].drugOrderID +"'>"  
                        + datas[i].drugOrderID + "</option>");  
            }  
          
        } 
        
    })
})
</script>
 

<!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="detailID" id="detailIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改订单细则信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">订单号:</label>
					    <div class="col-sm-10">
					      <select id="drugOrderIDUpdate" name="drugOrderID" class="form-control"> </select>
					    </div>
				 </div>
				 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">订单数量:</label>
			    		<div class="col-sm-10">
			    			<input type="text" name="number" class="form-control" id="numberUpdate" placeholder="订单数量">
			  	 		</div>
			  	 </div>
			  	 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">订单总价:</label>
			    		<div class="col-sm-10">
			    			<input type="text" name="sumCost" class="form-control" id="sumCostUpdate" placeholder="订单总价">
			  	 		</div>
			  	 </div>
			  	 <div class="form-group">
			  			<label for="exampleInputName2" class="col-sm-2 control-label">批号:</label>
			    		<div class="col-sm-10">
			    			<input type="text" name="batchNumber" class="form-control" id="batchNumberUpdate" placeholder="批号">
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
	     var OrderDetail = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/orderdetail?method=update",
	    	 data: OrderDetail,//数据
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
        url : "${pageContext.request.contextPath}/drugorder?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#drugOrderIDAdd");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].drugOrderID +"'>"  
                        + datas[i].drugOrderID + "</option>");  
            }  
          
        } 
        
    })
})
</script>


<!-- 添加页面窗体 -->
<!-- 模态框（Modal）-->
<form id="myAddForm" method="post">

<input type="hidden" name="detailID" id="detailIDAdd">

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加订单细则信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">订单号:</label>
					    <div class="col-sm-10">
					    	<select id="drugOrderIDAdd" name="drugOrderID" class="form-control"> 
					    		<option value="">--请选择--</option>
					    	</select>
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">数量:</label>
					    <div class="col-sm-10">
					      <input type="text" name="number" class="form-control" id="numberAdd" placeholder="数量；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">订单总价:</label>
					    <div class="col-sm-10">
					      <input type="text" name="sumCost" class="form-control" id="sumCostAdd" placeholder="订单总价；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">批号:</label>
					    <div class="col-sm-10">
					      <input type="text" name="batchNumber" class="form-control" id="batchNumberAdd" placeholder="批号；">
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
	    var OrderDetail = $("#myAddForm").serializeArray();
	    
	    if($("#drugOrderIDAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'订单号不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#numberAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'数量不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		}else if($("#sumCostAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'订单总价不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#batchNumberAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'订单批号不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}
		else{

			    $.ajax({
			  	 	 type:"post",//提交方式
			   	 	 url:"${pageContext.request.contextPath}/orderdetail?method=add",
			   	 	 data: OrderDetail,//数据
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