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
			  	<label for="exampleInputName2">检验结果:</label>
			    <input type="text" name="testResult" class="form-control" id="testResultSearch" placeholder="检验结果">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">检验费用:</label>
			    <input type="text" name="testCharge1" class="form-control" id="testChargeSearch" placeholder="最低检验费用">
			  	&nbsp;到&nbsp;
			  	<input type="text" name="testCharge2" class="form-control" id="testChargeSearch" placeholder="最高检验费用">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">用户:</label>
			    <input type="text" name="userName" class="form-control" id="userNameSearch" placeholder="用户">
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
    		  url: '${pageContext.request.contextPath}/testproject?method=query',//访问json数据   访问后台代码返回json数据
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
    		    field: 'testID',
    		    title: '门诊检验项目编号',
    		    sortable:true
    		  }, {
    		    field: 'user.userName',
    		    title: '用户名'
    		  },{
    		    field: 'patientHistoryID',
    		    title: '门诊病例ID'
    		  },{
    		    field: 'testDate',
    		    title: '检验日期'
    		  }, {
    		    field: 'testAnalysis',
    		    title: '检验分析'
    		  }, {
    		    field: 'testRecord',
    		    title: '检验内容'
    		  }, {
    		    field: 'testResult',
    		    title: '检验结果'
    		  }, {
    		    field: 'testCharge',
    		    title: '检验费用'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.testID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.testID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var searchTestProject = $("#mySearchForm").serializeArray();
	              
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/testproject?method=queryByCondition",
	                     data: searchTestProject,
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });

	    });
  
  })
  
   //修改
   function updateFun(testID){

	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/testproject?method=sendUpdate",
		    data:{testID:testID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#testIDUpdate").val(data.testID);
		    		   $("#testAnalysisUpdate").val(data.testAnalysis);
		    		   $("#testResultUpdate").val(data.testResult);
		    		   $("#testChargeUpdate").val(data.testCharge);
		    	})
		    }
	  		})
  	}
  

  	
  	//删除（假删除，更改状态，isDelete:0->1）
  	function deleteFun(testID){
  		
  		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
				    $.ajax({
				    	type:"post",//提交方式
				    	 url:"${pageContext.request.contextPath}/testproject?method=delete",
				    	 data:{testID:testID},//数据
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

<input type="hidden" name="testID" id="testIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改检验项目信息</h4>
            </div>
            <div class="modal-body">

                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户:</label>
					    <div class="col-sm-10">
					      <select id="userIdUpdate" name="userId" class="form-control"> </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="testDate" class="form-control" id="testDateUpdate" placeholder="检验日期；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验结果:</label>
					    <div class="col-sm-10">
					      <input type="text" name="testResult" class="form-control" id="testResultUpdate" placeholder="检验结果；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验费用:</label>
					    <div class="col-sm-10">
					      <input type="text" name="testCharge" class="form-control" id="testChargeUpdate" placeholder="检验费用；">
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
	     var TestProject = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/testproject?method=update",
	    	 data:TestProject,//数据
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
        url : "${pageContext.request.contextPath}/testproject?method=query",  
        dataType : 'json',      
        success : function(datas) {//返回list数据并循环获取  
        	
            var select = $("#patientHistoryIDAdd");
            for (var i = 0; i < datas.length; i++) { 
            	select.append("<option value='" + datas[i].patientHistoryID +"'>"  
                        + datas[i].patientHistoryID + "</option>");  
            }  
          
        } 
        
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

<input type="hidden" name="testID" id="testIDAdd">

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加门诊检验项目</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病例号:</label>
					    <div class="col-sm-10">
					    	<select id="patientHistoryIDAdd" name="patientHistoryID" class="form-control">
					      		<option value="">--请选择--</option>
					    	</select>
					    </div>
				 </div>
				 
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
					    <div class="col-sm-10">
					    	<select id="userIdAdd" name="userId" class="form-control">
					    		<option value="">--请选择--</option>
					    	</select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验日期:</label>
					    <div class="col-sm-10">
					    	<input type="date" name="testDate" class="form-control" id="testDateAdd" placeholder="检验日期；">
					    </div>
				 </div>
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验分析:</label>
					    <div class="col-sm-10">
					      <input type="text" name="testAnalysis" class="form-control" id="testAnalysisAdd" placeholder="检验分析；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验内容:</label>
					    <div class="col-sm-10">
					      <input type="text" name="testRecord" class="form-control" id="testRecordAdd" placeholder="检验内容；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验结果:</label>
					    <div class="col-sm-10">
					      <input type="text" name="testResult" class="form-control" id="testResultAdd" placeholder="检验结果；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">检验费用:</label>
					    <div class="col-sm-10">
					      <input type="text" name="testCharge" class="form-control" id="testChargeAdd" placeholder="检验费用；">
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
	    var TestProject = $("#myAddForm").serializeArray();
	    
	    if($("#patientHistoryIDAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'病例号不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#userIdAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'用户名不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		}else if($("#testDateAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'检验日期不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#testRecordAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'检验内容不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#testResultAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'检验结果不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}else if($("#testChargeAdd").val() == ""){
			   $.alert({
		            title:false,
		            content:'检验费用不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		      });
		}
		else{
	    
			    $.ajax({
			  	 	 type:"post",//提交方式
			   	 	 url:"${pageContext.request.contextPath}/testproject?method=add",
			   	 	 data:TestProject,//数据
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