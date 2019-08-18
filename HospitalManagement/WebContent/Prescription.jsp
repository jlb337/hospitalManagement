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
          	  <!-- 
			  <div class="form-group">
			    <label for="exampleInputName2">处方日期:</label>
			    <input type="text" name="prescriptionDate" class="form-control" id="drugNameSearch" placeholder="药品名称">
			  </div>  
			  -->
			  <div class="form-group">
			    <label for="exampleInputName2">处方内容:</label>
			    <input type="text" name="prescriptionContent" class="form-control" id="drugTypeSearch" placeholder="药品种类">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">处方花费:</label>
			    <input type="text" name="prescriptionCost1" class="form-control" id="prescriptionCostSearch" placeholder="最低检查费用">
			    &nbsp;到&nbsp;<input type="text" name="prescriptionCost2" class="form-control" id="prescriptionCostSearch" placeholder="最高检查费用">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">病人姓名:</label>
			    <input type="text" name="patient.patientName" class="form-control" id="drugStoreLeaderSearch" placeholder="药房负责人ID">
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

<input type="hidden" name="prescriptionID2" id="prescriptionID2Update">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改处方信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处方内容:</label>
					    <div class="col-sm-10">
					      <input type="text" name="prescriptionContent" class="form-control" id="prescriptionContentUpdate" placeholder="是否转院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处方日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="prescriptionDate" class="form-control" id="prescriptionDateUpdate" placeholder="是否转院；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处方花销:</label>
					    <div class="col-sm-10">
					      <input type="text" name="prescriptionCost" class="form-control" id="prescriptionCostUpdate" placeholder="是否转院；">
					    </div>
				 </div>
<!-- 				 <div class="form-group"> -->
<!-- 					    <label for="inputEmail3" class="col-sm-2 control-label">药品名称:</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					         <select name="drugID" class="form-control" id="drugNameUpdate" > -->
<!-- 					              <option value="">请选择</option> -->
<!-- 					              <option value="1">马来酸吡咯替尼片</option> -->
<!-- 					              <option value="3">盐酸阿来替尼胶囊</option> -->
<!-- 					              <option value="4">青霉素</option> -->
<!-- 					              <option value="5">益母草颗粒</option> -->
<!-- 					              <option value="6">四消丸</option> -->
<!-- 					              <option value="7">七珍丹</option> -->
<!-- 					              <option value="8">钙尔奇</option> -->
<!-- 					              <option value="9">麝香壮骨膏</option> -->
<!-- 					              <option value="10">阿莫西林克拉维酸钾</option> -->
<!-- 					         </select> -->
<!-- 					    </div> -->
<!-- 				 </div> -->
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人姓名:</label>
					    <div class="col-sm-10">
					         <select id="patientID_" class="form-control" name="patientID">
					         </select>
					    </div>
				 </div>				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">备注:</label>
					    <div class="col-sm-10">
					      <input type="text" name="note" class="form-control" id="noteUpdate" placeholder="是否转院；">
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
					    <label for="inputEmail3" class="col-sm-2 control-label">处方内容:</label>
					    <div class="col-sm-10">
					      <input type="text" name="prescriptionContent" class="form-control" id="a" placeholder="处方内容；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处方日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="prescriptionDate" class="form-control" id="b" placeholder="处方日期；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">处方花销:</label>
					    <div class="col-sm-10">
					      <input type="text" name="prescriptionCost" class="form-control"placeholder="处方花销；">
					    </div>
				 </div>
<!-- 				 <div class="form-group"> -->
<!-- 					    <label for="inputEmail3" class="col-sm-2 control-label">药品名称:</label> -->
<!-- 					    <div class="col-sm-10"> -->
<!-- 					         <select name="drugID" class="form-control" id="drugNameUpdate" > -->
<!-- 					              <option value="">请选择</option> -->
<!-- 					              <option value="1">马来酸吡咯替尼片</option> -->
<!-- 					              <option value="3">盐酸阿来替尼胶囊</option> -->
<!-- 					              <option value="4">青霉素</option> -->
<!-- 					              <option value="5">益母草颗粒</option> -->
<!-- 					              <option value="6">四消丸</option> -->
<!-- 					              <option value="7">七珍丹</option> -->
<!-- 					              <option value="8">钙尔奇</option> -->
<!-- 					              <option value="9">麝香壮骨膏</option> -->
<!-- 					              <option value="10">阿莫西林克拉维酸钾</option> -->
<!-- 					         </select> -->
<!-- 					    </div> -->
<!-- 				 </div> -->
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病人姓名:</label>
					    <div class="col-sm-10">
					         <select id="patientID_insert" class="form-control"name="patientID">
					         </select>
					    </div>
				 </div>				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">备注:</label>
					    <div class="col-sm-10">
					      <input type="text" name="note" class="form-control" placeholder="备注；">
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

<input type="hidden" name="prescriptionID2" id="drugIDDelete">

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
            	
                var select = $("#patientID_");
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
            	
                var select = $("#patientID_insert");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" + datas[i].patientID + "'>"  
                            + datas[i].patientName + "</option>");  
                }  
            } 
        });
		
    	
    	
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/prescription?method=selectByCondition",//访问地址
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
	    		    field: 'prescriptionID2',
	    		    title: '编号',
	    		    sortable:true
    		  	}, 
    		  	{
	    		    field: 'patient.patientName',
	    		    title: '病人姓名'
    		  	}, 
    		  	{
	    		    field: 'prescriptionContent',
	    		    title: '处方内容'
    		  	}, 
    		  	{
	    		    field: 'prescriptionDate',
	    		    title: '处方日期'
    		  	}, 
    		  	{
	    		    field: 'prescriptionCost',
	    		    title: '处方花费'
    		  	}, 
//     		  	{
// 	    		    field: 'drug.drugName',
// 	    		    title: '药品名称'
//     		  	}, 
    		  	{
        		    field: 'note',
        		    title: '备注'
        		  	}, 
    		  	{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.prescriptionID2+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.prescriptionID2+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                     url: "${pageContext.request.contextPath}/prescription?method=selectByCondition",
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
   function updateFun(prescriptionID2){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/prescription?method=sendUpdate",
		    data:{ prescriptionID2 : prescriptionID2 },//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#prescriptionID2Update").val(data.prescriptionID2);
		    		   $("#patientIDUpdate").val(data.patientID);
		    		   $("#prescriptionContentUpdate").val(data.prescriptionContent);
		    		   $("#noteUpdate").val(data.note);
		    		   $("#prescriptionDateUpdate").val(data.prescriptionDate);
		    		   $("#prescriptionCostUpdate").val(data.prescriptionCost);
		    	})
		    }
	  })
  }
  
  
  function deleteFun(prescriptionID2)
  {
		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	  
	    $.ajax({
	    	type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/prescription?method=Delete",
	    	 data:{ prescriptionID2 : prescriptionID2 },//数据
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
	    	 url:"${pageContext.request.contextPath}/prescription?method=update",
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
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">处方内容不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
		   
		   else if($("#b").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">处方时间不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
			else{
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/prescription?method=insert",
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
	    	 url:"${pageContext.request.contextPath}/prescription?method=Delete",
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