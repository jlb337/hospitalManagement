<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
			    <label for="exampleInputName2">病人姓名:</label>
			    <input type="text" name="patient.name" class="form-control" id="nameSearch" placeholder="病人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">身份证号:</label>
			    <input type="text" name="patient.ID" class="form-control" id="IDSearch" placeholder="身份证号">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">所属科室:</label>
			    <input type="text" name="department.departmentName" class="form-control" id="departmentNameSearch" placeholder="所属科室">
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
		     url : "${pageContext.request.contextPath}/department?method=query",  
		     dataType : 'json',      
		     success : function(datas) {//返回list数据并循环获取  
		     	
		         var select = $("#departmentNameSelect");
		         for (var i = 0; i < datas.length; i++) { 
		         	select.append("<option value='" +datas[i].departmentID+ "'>"  
		                     + datas[i].departmentName + "</option>");  
		         } 
		         
		         var select = $("#departmentNameSelect1");
		         for (var i = 0; i < datas.length; i++) { 
		         	select.append("<option value='" +datas[i].departmentID+ "'>"  
		                     + datas[i].departmentName + "</option>");  
		         }  
		         
		     } 
 		});
    	 
       //下拉数据加载  
         $.ajax({  
		     type : 'get',  
		     url : "${pageContext.request.contextPath}/bed?method=query",  
		     dataType : 'json',      
		     success : function(datas) {//返回list数据并循环获取  
		     	
		         var select = $("#bedIDSelect");
		         for (var i = 0; i < datas.length; i++) { 
		         	select.append("<option value='" +datas[i].bedID+ "'>"  
		                     + datas[i].bedID + "</option>");  
		         } 
		         
		         var select = $("#bedIDSelect1");
		         for (var i = 0; i < datas.length; i++) { 
		         	select.append("<option value='" +datas[i].bedID+ "'>"  
		                     + datas[i].bedID + "</option>");  
		         }  
		     } 
 		});
       
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
    		  url: '${pageContext.request.contextPath}/inRecord?method=query',//访问json数据   访问后台代码返回json数据
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
    		    field: 'patient.patientName',
    		    title: '病人姓名',
    		    sortable:true
    		  }, {
    		    field: 'patient.id',
    		    title: '身份证号'
    		  }, {
    		    field: 'bedID',
    		    title: '床位编号'
    		  }, {
    		    field: 'department.departmentName',
    		    title: '所住科室'
    		  }, 
    		  {
      		    field: 'inTime',
      		    title: '入院时间'
      		  },
      		{
      		    field: 'inSituation',
      		    title: '入院情况',
      		  	formatter:function(value,row,index){ 
	            	var value="";
	            	if(row.inSituation=="1"){
	            		value = "危急";
	            	}else if(row.inSituation=="0"){
	            		value = "一般";
	            	}else{
	            		value = row.inSituation ;
	            	}
	            	
						return value;
  		    	}
      		  },{
    		    field: 'changeDepartmentSituation',
    		    title: '转移科室情况'
    		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.inID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.inID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var name = $("#nameSearch").val();
	                var ID = $("#IDSearch").val();
	                var departmentName = $("#departmentNameSearch").val();
	                
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/inRecord?method=query",
	                     data: {name:name,ID:ID,departmentName:departmentName},//查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });
  })
  
  //删除
  	function deleteFun(inID) {
	  if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
			  $.ajax({
				    type:"post",//提交方式
				    url:"${pageContext.request.contextPath}/inRecord?method=delete",
				    data:{inID:inID},//传主键值
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
 		    	  //弹出修改窗体
 		    	 $('#myAddModal').modal().on('shown.bs.modal',function() {
 		    		 //$("illnessEreaNameSelect1").val(data.illnessEreaID);
 		    		 })
     })

     //修改
   function updateFun(inID){
	  
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/inRecord?method=sendUpdate",
		    data:{inID:inID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		 $("#inIDUpdate").val(data.inID);
		    		 $("patientNameSelect").val(data.patientID);
		    		 $("bedIDSelect").val(data.bedID);
		    		 $("departmentNameSelect").val(data.departmentID);
		    		 $("#inTimeUpdate").val(data.inTime);
		    		 $("#inSituationUpdate").val(data.inSituation);
		    		 $("#changeDepartmentSituationUpdate").val(data.changeDepartmentSituation);		    		   
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
                <h4 class="modal-title" id="myModalLabel">增添入院记录</h4>
            </div>
            <div class="modal-body">
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院病人:</label>
					    <div class="col-sm-10">
					         <select id="patientNameSelect1" name="patientID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">床位编号:</label>
					    <div class="col-sm-10">
					         <select id="bedIDSelect1" name="bedID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">所属科室:</label>
					    <div class="col-sm-10">
					         <select id="departmentNameSelect1" name="departmentID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院时间:</label>
					    <div class="col-sm-10">
					      <input type="date" name="inTime" class="form-control" id="inTimeAdd" placeholder="入院时间">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院情况:</label>
					    <div class="col-sm-10">
					    	<select id="inSituationAdd" name="inSituation" class="form-control">
								<option value="1" <c:if test="${inSituation=='1'}"></c:if>>危急</option>
								<option value="0" <c:if test="${inSituation=='0'}"></c:if>>一般</option>
							</select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">转移科室情况:</label>
					    <div class="col-sm-10">
					      <input type="text" name="changeDepartmentSituation" class="form-control" id="changeDepartmentSituationAdd" placeholder="转移科室情况">
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

<input type="hidden" name="inID" id="inIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改入院记录</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院病人:</label>
					    <div class="col-sm-10">
					         <select id="patientNameSelect" name="patientID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">床位编号:</label>
					    <div class="col-sm-10">
					         <select id="bedIDSelect" name="bedID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">所属科室:</label>
					    <div class="col-sm-10">
					         <select id="departmentNameSelect" name="departmentID" class="form-control">
					             
					         </select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院时间:</label>
					    <div class="col-sm-10">
					      <input type="date" name="inTime" class="form-control" id="inTimeUpdate" placeholder="入院时间">
					    </div>
				 </div>
				  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院情况:</label>
					    <div class="col-sm-10">
					    	<select id="inSituationAdd" name="inSituation" class="form-control">
								<option value="1" <c:if test="${inSituation=='1'}"></c:if>>危急</option>
								<option value="0" <c:if test="${inSituation=='0'}"></c:if>>一般</option>
							</select>
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">转移科室情况:</label>
					    <div class="col-sm-10">
					      <input type="text" name="changeDepartmentSituation" class="form-control" id="changeDepartmentSituationUpdate" placeholder="转移科室情况">
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
	     var RecordArray = $("#myUpdateForm").serializeArray();
	    
	     $.ajax({
             type: "post",//请求的方式
             url: "${pageContext.request.contextPath}/inRecord?method=update",
             data: RecordArray, //查询条件
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
	     var Record = $("#myAddForm").serializeArray();
	     
	   if($("#inTimeAdd").val() == ""){
		   $.alert({
		            title:false,
		            content:'入院时间不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		  });
	   }else if($("#inSituationAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'入院情况不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#changeDepartmentSituationAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'转移科室情况不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else{
		   $.ajax({
	             type: "post",//请求的方式
	             url: "${pageContext.request.contextPath}/inRecord?method=add",
	             data: Record, //查询条件
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