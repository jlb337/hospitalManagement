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
			    <label for="exampleInputName2">值班姓名:</label>
			    <input type="text" name="user.username" class="form-control" id="usernameSearch" placeholder="值班姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">值班电话:</label>
			    <input type="text" name="user.telephone" class="form-control" id="telephoneSearch" placeholder="值班电话">
			  </div>
			  <button id="btn_query" type="button" class="btn btn-success">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button  id="add" class="btn ">增添数据</button>
   </div>
</div>

 <table id="table">



 <script type="text/javascript">
    $(function(){
    	 //下拉数据加载  
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/user?method=query",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#userNameSelect");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].userId+ "'>"  
                            + datas[i].userName + "</option>");  
                } 
                
                var select = $("#userNameSelect1");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].userId+ "'>"  
                            + datas[i].userName + "</option>");  
                }
              
            } 
            
        });
    	//表格数据的加载
    	$('#table').bootstrapTable({
    		  url: '${pageContext.request.contextPath}/duty?method=query',//访问json数据   访问后台代码返回json数据
    		  pagination: true,//允许分页
    		  pageSize:1,//每页显示3条
    		  pageList:[1,3,4,5,8,10],//每页显示的条数
    		//  search: true,//允许搜索
    		  striped:true,//各行换颜色
    		  showColumns:true,//可以需要显示的列
    		  showRefresh:true,//允许刷新
    		  showExport:true,//允许导出
    		  exportDataType:true,//可以全部导出
    		  exportTypes:['pdf','xlsx'],//导出的数据类型（pdf文件、excel文件）
    		  columns: [{
    		    field: 'dutyID',
    		    title: '值班编号',
    		    sortable:true
    		  }, {
    		    field: 'dutyDate',
    		    title: '值班日期'
    		  }, {
    		    field: 'user.userName',
    		    title: '值班人姓名'
    		  },{
      		    field: 'user.telephone',
      		    title: '电话'
      		  },{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.dutyID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.dutyID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var userName = $("#usernameSearch").val();
	                var telephone = $("#telephoneSearch").val();
	                
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/duty?method=query",
	                     data: {userName:userName,telephone:telephone}, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });
  })
  
  //删除
  	function deleteFun(dutyID) {
	   if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
      if(window.confirm("请再次确认你真的需要删除本数据吗？")){
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/duty?method=delete",
		    data:{dutyID:dutyID},//传主键值
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
   function updateFun(dutyID){
	  
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/duty?method=sendUpdate",
		    data:{dutyID:dutyID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		   $("#dutyIDUpdate").val(data.dutyID);
		    		   $("#dutyDateUpdate").val(data.dutyDate);
		    		   $("userNameSelect").val(data.userId);
		    	})
		    }
	  })
  }
 </script>
 
 <!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="dutyID" id="dutyIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改值班信息</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">值班日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="dutyDate" class="form-control" id="dutyDateUpdate" placeholder="值班日期">
					    </div>
				 </div>				 
            </div>
            <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">值班者:</label>
					    <div class="col-sm-10">
					         <select id="userNameSelect" name="userId" class="form-control">
					             
					         </select>
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


 <!-- 增加页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myAddForm"  method="post">

<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加值班信息</h4>
            </div>
           <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">值班日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="dutyDate" class="form-control" id="dutyDateAdd" placeholder="值班日期">
					    </div>
				 </div>				 
            </div>
            <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">值班者:</label>
					    <div class="col-sm-10">
					         <select id="userNameSelect1" name="userId" class="form-control">
					             
					         </select>
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

<script type="text/javascript">
  $("#btnUpadte").click(function(){
	  
	    //获取表单中的数据
	     var dutyArray = $("#myUpdateForm").serializeArray();
	    
	     $.ajax({
             type: "post",//请求的方式
             url: "${pageContext.request.contextPath}/duty?method=update",
             data: dutyArray, //查询条件
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
	     var dutyArray = $("#myAddForm").serializeArray();
	  
	   if($("#dutyDateAdd").val() == ""){
		   $.alert({
		            title:false,
		            content:'值班日期不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		  });
	   }else{
		   $.ajax({
	             type: "post",//请求的方式
	             url: "${pageContext.request.contextPath}/duty?method=add",
	             data: dutyArray, //查询条件
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