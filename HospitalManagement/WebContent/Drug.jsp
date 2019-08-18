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
			    <label for="exampleInputName2">药品名称:</label>
			    <input type="text" name="drugName" class="form-control" id="drugNameSearch" placeholder="药品名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">药品类型:</label>
			    <input type="text" name="drugType" class="form-control" id="drugTypeSearch" placeholder="药品种类">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">药品单价:</label>
			    <input type="text" name="drugUnitPrice1" class="form-control" id="drugUnitPriceSearch" placeholder="最低检查费用">
			    &nbsp;到&nbsp;<input type="text" name="drugUnitPrice2" class="form-control" id="drugUnitPriceSearch" placeholder="最高检查费用">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">药房负责人编号:</label>
			    <input type="text" name="drugstore.drugStoreLeader" class="form-control" id="drugStoreLeaderSearch" placeholder="药房负责人ID">
			  </div>
<!-- 			  <div class="form-group"> -->
<!-- 			    <label for="exampleInputEmail2">处方编号:</label> -->
<!-- 			    <input type="text" name="prescriptionID2" class="form-control" id="prescriptionID2ContentSearch" placeholder="处方内容"> -->
<!-- 			  </div> -->
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

<input type="hidden" name="drugID" id="drugIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改药品信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugName" class="form-control" id="drugNameUpdate" placeholder="是否出院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品类型:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugType" class="form-control" id="drugTypeUpdate" placeholder="是否转院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品单位:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugUnit" class="form-control" id="drugUnitUpdate" placeholder="是否转院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品单价:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugUnitPrice" class="form-control" id="drugUnitPriceUpdate" placeholder="是否转院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">生产日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="drugProductionDate" class="form-control" id="drugProductionDateUpdate" placeholder="是否转院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">保质期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="drugLife" class="form-control" id="drugLifeUpdate" placeholder="是否转院；">
					    </div>
				 </div>
<!-- 				 <div class="form-group"> -->
<!-- 					    <label for="inputEmail3" class="col-sm-2 control-label">处方日期:</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					         <select id="prescriptionID_" class="form-control" name="prescriptionID2"> -->
<!-- 					         </select> -->
<!-- 					    </div> -->
<!-- 				 </div>				  -->
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药房负责人:</label>
					    <div class="col-sm-10">
					         <select id="drugStoreID_" class="form-control" name="drugStoreID">
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
					    <label for="inputEmail3" class="col-sm-2 control-label">药品名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugName" class="form-control" id="drug_insert" placeholder="药品名称；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品类型:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugType" class="form-control" placeholder="药品类型；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品单位:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugUnit" class="form-control" id="drugunit_insert"  placeholder="药品单位；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药品单价:</label>
					    <div class="col-sm-10">
					      <input type="text" name="drugUnitPrice" class="form-control" id="drugunitprice_insert" placeholder="药品单价；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">生产日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="drugProductionDate" class="form-control" id ="start_insert"placeholder="生产日期；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">保质期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="drugLife" class="form-control" placeholder="保质期；">
					    </div>
				 </div>
<!-- 				 <div class="form-group"> -->
<!-- 					    <label for="inputEmail3" class="col-sm-2 control-label">处方日期:</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					         <select id="prescriptionID_insert" class="form-control" name="prescriptionID2"> -->
<!-- 					         </select> -->
<!-- 					    </div> -->
<!-- 				 </div>				  -->
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">药房负责人:</label>
					    <div class="col-sm-10">
					         <select id="drugStoreID_insert" class="form-control" name="drugStoreID">
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

<input type="hidden" name="drugID" id="drugIDDelete">

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
            url : "${pageContext.request.contextPath}/prescription?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#prescriptionID_");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].prescriptionID2 + "'>"  
                            + datas[i].prescriptionDate + "</option>");  
                }  
            } 
        }); 
		
		
		//下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/drugstore?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#drugStoreID_");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].drugStoreID + "'>"  
                            + datas[i].drugStoreLeader + "</option>");  
                }  
            } 
        });
		
		
		//下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/prescription?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#prescriptionID_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].prescriptionID2 + "'>"  
                            + datas[i].prescriptionDate + "</option>");  
                }  
            } 
        });		

		
		
		//下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/drugstore?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#drugStoreID_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].drugStoreID + "'>"  
                            + datas[i].drugStoreLeader + "</option>");  
                }  
            } 
        });
    	
    	
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/drug?method=selectByCondition",//访问地址
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
	    		    field: 'drugID',
	    		    title: '编号',
	    		    sortable:true
    		  	}, 
    		  	{
	    		    field: 'drugName',
	    		    title: '药品名称'
    		  	}, 
//     		  	{
// 	    		    field: 'prescription.prescriptionDate',
// 	    		    title: '处方日期'
//     		  	}, 
    		  	{
	    		    field: 'drugstore.drugStoreLeader',
	    		    title: '药房负责人'
    		  	}, 
    		  	{
	    		    field: 'drugType',
	    		    title: '药品类型'
    		  	}, 
    		  	{
        		    field: 'drugUnit',
        		    title: '药品单位'
        		  	}, 
    		  	{
        		    field: 'drugUnitPrice',
        		    title: '药品单价'
        		  	}, 
    		  	{
        		    field: 'drugProductionDate',
        		    title: '生产日期'
        		  	}, 
    		  	{
        		    field: 'drugLife',
        		    title: '保质期'
        		  	}, 
    		  	{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.drugID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.drugID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                     url: "${pageContext.request.contextPath}/drug?method=selectByCondition",
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
   function updateFun(drugID){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/drug?method=sendUpdate",
		    data:{ drugID : drugID },//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#drugIDUpdate").val(data.drugID);
		    		   $("#drugProductionDateUpdate").val(data.drugProductionDate);
		    		   $("#drugLifeUpdate").val(data.drugLife);
		    		   $("#drugNameUpdate").val(data.drugName);
		    		   $("#drugTypeUpdate").val(data.drugType);
		    		   $("#drugUnitUpdate").val(data.drugUnit);
		    		   $("#drugUnitPriceUpdate").val(data.drugUnitPrice);
		    		   
		    	})
		    }
	  })
  }
  
  
  function deleteFun(drugID)
  {
		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	  
	    $.ajax({
	    	type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/drug?method=Delete",
	    	 data:{ drugID : drugID },//数据
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
	    	 url:"${pageContext.request.contextPath}/drug?method=update",
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
	    
		 if($("#drug_insert").val() == ""){
			 $.alert({
		           title:false,
		           content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">药品名称不为空！',
		           columnClass:'col-sm-12 no-padding',
		           boxWidth:'100%'
			  });
		   }
	    
		 else if($("#drugunit_insert").val() == ""){
			 $.alert({
		           title:false,
		           content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">药品单位不为空！',
		           columnClass:'col-sm-12 no-padding',
		           boxWidth:'100%'
			  });
		   }
	    
		 else if($("#drugunitprice_insert").val() == ""){
			 $.alert({
		           title:false,
		           content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">药品单价不为空！',
		           columnClass:'col-sm-12 no-padding',
		           boxWidth:'100%'
			  });
		   }
	    
		 else if($("#start_insert").val() == ""){
			 $.alert({
		           title:false,
		           content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">生产日期不为空！',
		           columnClass:'col-sm-12 no-padding',
		           boxWidth:'100%'
			  });
		   }
			else{
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/drug?method=insert",
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
	    	 url:"${pageContext.request.contextPath}/drug?method=Delete",
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