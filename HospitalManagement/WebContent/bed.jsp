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
<!-- 搜索工具栏 -->
<div style="margin:100px;">
<div id="toolbar">
   <div id="showorhide" class="showQuery">
          <form class="form-inline" id="mySearchForm">
			  <div class="form-group">
			    <label for="exampleInputName2">床位编号:</label>
			    <input type="text" name="bedID" class="form-control" id="bedIDSearch" placeholder="床位编号">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">治疗结果:</label>
			    <input type="text" name="cureResult" class="form-control" id="cureResultSearch" placeholder="治疗结果">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">病区名称:</label>
			    <input type="text" name="illnessErea.illnessEreaName" class="form-control" id="illnessEreaNameSearch" placeholder="病区名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">总花销介于:</label>
			    <input type="text" name="bedCost1" class="form-control" id="bedCost1Search" placeholder="最低限额">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">至:</label>
			    <input type="text" name="bedCost2" class="form-control" id="bedCost2Search" placeholder="最高限额">
			  </div>
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="add" class="btn ">增添数据</button>
   </div>
</div>

 <table id="table"> </table>
 </div>


 <script type="text/javascript">
    $(function(){
    	
    	 //下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/illnessErea?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#illnessEreaNameSelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].illnessEreaID+ "'>"  
                            + datas[i].illnessEreaName + "</option>");  
                } 
                
                var select = $("#illnessEreaNameSelect1");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].illnessEreaID+ "'>"  
                            + datas[i].illnessEreaName + "</option>");  
                } 
              
            } 
            
        });
    	 
    	//表格数据的加载
    	$('#table').bootstrapTable({
    		  url: '${pageContext.request.contextPath}/bed?method=query',//访问json数据   访问后台代码返回json数据
    		  pagination: true,//允许分页
    		  pageSize:3,//每页显示3条
    		  pageList:[1,3,4,5,8,10],//每页显示的条数
    		//  search: true,//允许搜索
    		  striped:true,//各行换颜色
    		  showColumns:true,//可以需要显示的列
    		  showRefresh:true,//允许刷新
    		  showExport:true,//允许导出
    		  exportDataType:true,//可以全部导出
    		  exportTypes:['pdf','excel'],//导出的数据类型（pdf文件、excel文件）
    		  columns: [{
    		    field: 'bedID',
    		    title: '床位编号',
    		    sortable:true
    		  }, {
    		    field: 'isEmpty',
    		    title: ' 是否为空',
    		    formatter:function(value,row,index){ 
	            	var value="";
	            	if(row.isEmpty=="1"){
	            		value = "空床";
	            	}else if(row.isEmpty=="0"){
	            		value = "已有病人";
	            	}else{
	            		value = row.isEmpty ;
	            	}
	            	
						return value;
    		    }
    		    
    		  }, {
    		    field: 'bedCost',
    		    title: '总花销'
    		  }, {
    		    field: 'cureResult',
    		    title: '治疗情况'
    		  }, 
    		  {
      		    field: 'illnessErea.illnessEreaName',
      		    title: '所属病区'
      		  },
      		{
      		    field: 'illnessErea.bedCount',
      		    title: '该病区床位总数'
      		  },{
    		    field: 'illnessErea.cureRate',
    		    title: '该病区治愈率'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.bedID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.bedID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var bedID = $("#bedIDSearch").val();
	                var cureResult = $("#cureResultSearch").val();
	                var illnessEreaName = $("#illnessEreaNameSearch").val();
			        var bedCost1 = $("#bedCost1Search").val();
	                var bedCost2 = $("#bedCost2Search").val();
	               
	               
	                
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/bed?method=query",
	                     data: {bedID:bedID,cureResult:cureResult,illnessEreaName:illnessEreaName,bedCost1:bedCost1,bedCost2:bedCost2}, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });
  })
  
  //删除
  	function deleteFun(bedID) {
	  if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
			  $.ajax({
				    type:"post",//提交方式
				    url:"${pageContext.request.contextPath}/bed?method=delete",
				    data:{bedID:bedID},//传主键值
				    dataType:"json",//返回的数据类型为json
		          success : function(json) {
		         	 if(json ==1){
		         		 $("#myUpdateModal").modal('hide');  //手动关闭
		         		 $("#table").bootstrapTable("refresh");//刷新表格中的数据
		         	 }
		         }
		     });  
		  }
	  }
	  
	}
     //增加
     $("#add").click(function(){
 		    //alert("123");
 		    	  //弹出修改窗体
 		    	 $('#myAddModal').modal().on('shown.bs.modal',function() {
 		    		 //$("illnessEreaNameSelect1").val(data.illnessEreaID);
 		    		 })
     })

     //修改
   function updateFun(bedID){
	  
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/bed?method=sendUpdate",
		    data:{bedID:bedID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		   $("#bedIDUpdate").val(data.bedID);
		    		   $("#isEmptyUpdate").val(data.isEmpty);
		    		   $("#cureResultUpdate").val(data.cureResult);
		    		   $("#bedCostUpdate").val(data.bedCost);
		    		   $("illnessEreaNameSelect").val(data.illnessEreaID);
		    		   
		    	})
		    }
	  })
  }
 </script>
 <!-- 增加页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myAddForm"  method="post">
<!-- <input type="hidden" name="bedID" id="bedIDAdd"> -->

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">增添床位信息</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">治疗情况:</label>
					    <div class="col-sm-10">
					      <input type="text" name="cureResult" class="form-control" id="cureResultAdd" placeholder="治疗情况">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">总花销:</label>
					    <div class="col-sm-10">
					      <input type="text" name="bedCost" class="form-control" id="bedCostAdd" placeholder="总花销">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病区负责人:</label>
					    <div class="col-sm-10">
					         <select id="illnessEreaNameSelect1" name="illnessEreaID"  class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnAdd" class="btn btn-primary">增加</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>


 <!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="bedID" id="bedIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改床位信息</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">是否为空:</label>
					    <div class="col-sm-10">
					    
					    	<select id="inEmptyUpdate" name="isEmpty" class="form-control">
								<option value="1" <c:if test="${inSituation=='1'}"></c:if>空床</option>
								<option value="0" <c:if test="${inSituation=='0'}"></c:if>已有病人</option>
							</select>
					    	
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">治疗情况:</label>
					    <div class="col-sm-10">
					      <input type="text" name="cureResult" class="form-control" id="cureResultUpdate" placeholder="治疗情况">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">总花销:</label>
					    <div class="col-sm-10">
					      <input type="text" name="bedCost" class="form-control" id="bedCostUpdate" placeholder="总花销">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病区负责人:</label>
					    <div class="col-sm-10">
					         <select id="illnessEreaNameSelect" name="illnessEreaID"  class="form-control">
					             
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

<script type="text/javascript">
  $("#btnUpadte").click(function(){
	  
	    //获取表单中的数据
	     var BedArray = $("#myUpdateForm").serializeArray();
	    
	     $.ajax({
             type: "post",//请求的方式
             url: "${pageContext.request.contextPath}/bed?method=update",
             data: BedArray, //查询条件
             dataType:"json",//返回的数据类型为json
             success : function(json) {
            	 if(json ==1){
            		 $("#myUpdateModal").modal('hide');  //手动关闭
            		 $("#table").bootstrapTable("refresh");//刷新表格中的数据
            	 }
            }
        });
  })
  
   $("#btnAdd").click(function(){
	   
	 //获取表单中的数据
	     var BedArray = $("#myAddForm").serializeArray();
	  
	   if($("#cureResultAdd").val() == ""){
		   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">治疗结果不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		  });
	   }else if($("#bedCostAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'总花销不为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else{
		   $.ajax({
	             type: "post",//请求的方式
	             url: "${pageContext.request.contextPath}/bed?method=add",
	             data: BedArray, //查询条件
	             dataType:"json",//返回的数据类型为json
	             success : function(json) {
	            	 if(json ==1){
	            		 $("#myAddModal").modal('hide');  //手动关闭
	            		 $("#table").bootstrapTable("refresh");//刷新表格中的数据
	            	 }
	            }
	        });
	   }
  })
</script>
<!-- 修改页面窗体 -->

</body>
</html>