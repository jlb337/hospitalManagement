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
			    <label for="exampleInputName2">检查项目:</label>
			    <input type="text" name="checkName" class="form-control" id="checkNameSearch" placeholder="检查项目">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">病人姓名:</label>
			    <input type="text" name="patient.patientName" class="form-control" id="patientNameSearch" placeholder="病人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">身份证号:</label>
			    <input type="text" name="patient.ID" class="form-control" id="IDSearch" placeholder="身份证号">
			  </div>
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
    <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="add" class="btn ">增添数据</button>
   </div>
</div>

 <table id="table">
 


 <script type="text/javascript">
    $(function(){
    	
    	 //下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/patient?method=query_Name",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#patientNameSelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].patientID+ "'>"  
                            + datas[i].patientName + "</option>");  
                } 
                
                var select = $("#patientNameSelect1");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].patientID+ "'>"  
                            + datas[i].patientName + "</option>");  
                } 
              
            } 
            
        });
    	 
    	//表格数据的加载
    	$('#table').bootstrapTable({
    		  url: '${pageContext.request.contextPath}/inCheckProject?method=query',//访问json数据   访问后台代码返回json数据
    		  pagination: true,//允许分页
    		  pageSize:3,//每页显示3条
    		  pageList:[1,3,4,5,8,10],//每页显示的条数
    		//  search: true,//允许搜索
    		  striped:true,//各行换颜色
    		  showColumns:true,//可以需要显示的列
    		  showRefresh:true,//允许刷新
    		  showExport:true,//允许导出
    		  exportDataType:true,//可以全部导出
    		  exportTypes:['pdf','xlsx'],//导出的数据类型（pdf文件、excel文件）
    		  columns: [{
    		    field: 'checkName',
    		    title: '检查项目',
    		    sortable:true
    		  }, {
    		    field: 'checkDate',
    		    title: ' 检查日期'
    		  }, {
        		field: 'checkLeader',
          		title: '负责人'
          	  }, {
    		    field: 'patient.patientName',
    		    title: '病人姓名'
    		  }, {
    		    field: 'patient.id',
    		    title: '身份证号'
    		  }, {
      		    field: 'patient.sex',
      		    title: '性别'
      		  },{
    		    field: 'checkContent',
    		    title: '检查内容'
    		  },{
        		field: 'checkResult',
          		title: '检查结果'
          	  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.inCheckID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.inCheckID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
 </table>
 </div>
  
 
 <script type="text/javascript">
  $(function(){
	  <!--搜索条件-->
  	//条件搜索
		$("#btn_query").click(function() {
	                var checkName = $("#checkNameSearch").val();
	                var patientName = $("#patientNameSearch").val();
	                var ID = $("#IDSearch").val();
	                
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/inCheckProject?method=query",
	                     data: {checkName:checkName,patientName:patientName,ID:ID}, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });
  })
  
  //删除
  	function deleteFun(inCheckID) {
	  if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
			  $.ajax({
				    type:"post",//提交方式
				    url:"${pageContext.request.contextPath}/inCheckProject?method=delete",
				    data:{inCheckID:inCheckID},//传主键值
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
   function updateFun(inCheckID){
	  
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/inCheckProject?method=sendUpdate",
		    data:{inCheckID:inCheckID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		   $("#inCheckIDUpdate").val(data.inCheckID);
		    		   $("#checkNameUpdate").val(data.checkName);
		    		   $("#checkDateUpdate").val(data.checkDate);
		    		   $("#checkLeaderUpdate").val(data.checkLeader);
		    		   $("#checkContentUpdate").val(data.checkContent);
		    		   $("#checkResultUpdate").val(data.checkResult);
		    		   $("#patientNameSelect1").val(data.patientID);
		    		   
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
                <h4 class="modal-title" id="myModalLabel">增添入院检查项目</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查项目:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkName" class="form-control" id="checkNameAdd" placeholder="检查项目">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="checkDate" class="form-control" id="checkDateAdd" placeholder="检查日期">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">负责人:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkLeader" class="form-control" id="checkLeaderAdd" placeholder="负责人">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">收检病人:</label>
					    <div class="col-sm-10">
					         <select id="patientNameSelect" name="patientID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查内容:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkContent" class="form-control" id="checkContentAdd" placeholder="检查内容">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查结果:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkResult" class="form-control" id="checkResultAdd" placeholder="检查结果">
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

<input type="hidden" name="inCheckID" id="inCheckIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改检查项目信息</h4>
            </div>
              <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查项目:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkName" class="form-control" id="checkNameUpdate" placeholder="检查项目">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="checkDate" class="form-control" id="checkDateUpdate" placeholder="检查日期">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">负责人:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkLeader" class="form-control" id="checkLeaderUpdate" placeholder="负责人">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">收检病人:</label>
					    <div class="col-sm-10">
					         <select id="patientNameSelect1" name="patientID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查内容:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkContent" class="form-control" id="checkContentUpdate" placeholder="检查内容">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检查结果:</label>
					    <div class="col-sm-10">
					      <input type="text" name="checkResult" class="form-control" id="checkResultUpdate" placeholder="检查结果">
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
	  //alert("传数据");
	    //获取表单中的数据
	     var Check = $("#myUpdateForm").serializeArray();
	    
	     $.ajax({
             type: "post",//请求的方式
             url: "${pageContext.request.contextPath}/inCheckProject?method=update",
             data: Check, //查询条件
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
	   var CheckArray = $("#myAddForm").serializeArray();
	   if($("#checkNameAdd").val() == ""){
		   $.alert({
		            title:false,
		            content:'检查名称不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		  });
	   }else if($("#checkDateAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'检查日期不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#checkLeaderAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'负责人不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#checkContentAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'检查内容不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#checkResultAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'检查结果不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else{
		   $.ajax({
	             type: "post",//请求的方式
	             url: "${pageContext.request.contextPath}/inCheckProject?method=add",
	             data: CheckArray, //查询条件
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