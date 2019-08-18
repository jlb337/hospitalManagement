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
			    <label for="exampleInputName2">主管姓名:</label>
			    <input type="text" name="user.username" class="form-control" id="usernameSearch" placeholder="主管姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">主管电话:</label>
			    <input type="text" name="user.telephone" class="form-control" id="telephoneSearch" placeholder="主管电话">
			  </div>
			   <div class="form-group">
			    <label for="exampleInputName2">病区名称:</label>
			    <input type="text" name="illnessEreaName" class="form-control" id="illnessEreaNameSearch" placeholder="病区名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">治愈率高于:</label>
			    <input type="text" name="cureRate1" class="form-control" id="cureRate1Search" placeholder="最低限额">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">死亡率低于:</label>
			    <input type="text" name="deathRate1" class="form-control" id="deathRate1Search" placeholder="最高限额">
			  </div>
			  <button id="btn_query" type="button" class="btn btn-success">查询</button>
			  
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
            type :'get',  
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
    		  url: '${pageContext.request.contextPath}/illnessErea?method=query',//访问json数据   访问后台代码返回json数据
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
    		    field: 'illnessEreaName',
    		    title: '病区名称',
    		    sortable:true
    		  }, {
    		    field: 'bedCount',
    		    title: '总床位'
    		  }, {
    		    field: 'inPeopleCount',
    		    title: '入院人数'
    		  }, {
    		    field: 'outPeopleCount',
    		    title: '出院人数'
    		  }, {
      		    field: 'cureRate',
      		    title: '治愈率'
      		  }, {
        		field: 'betterRate',
          		title: '好转率'
          	  }, {
            	field: 'badRate',
              	title: '恶化率'
              }, {
          		field: 'deathRate',
          		title: '死亡率'
          	  }, {
          		field: 'user.userName',
          		title: '主管姓名'
          	  }, {
          		field: 'user.telephone',
          		title: '主管电话'
          	  },             
      		  {
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.illnessEreaID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.illnessEreaID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                var illnessEreaName = $("#illnessEreaNameSearch").val();
	                var cureRate1 = $("#cureRate1Search").val();
	                var deathRate1 = $("#deathRate1Search").val();
	                
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/illnessErea?method=query",
	                     data: {userName:userName,telephone:telephone,illnessEreaName:illnessEreaName,cureRate1:cureRate1,deathRate1:deathRate1}, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });
	    });
  })
  
  //删除
  	function deleteFun(illnessEreaID) {
	  if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
		  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
			  $.ajax({
				    type:"post",//提交方式
				    url:"${pageContext.request.contextPath}/illnessErea?method=delete",
				    data:{illnessEreaID:illnessEreaID},//传主键值
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
   function updateFun(illnessEreaID){
	  
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/illnessErea?method=sendUpdate",
		    data:{illnessEreaID:illnessEreaID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		   $("#illnessEreaIDUpdate").val(data.illnessEreaID);
		    		   $("#bedCountUpdate").val(data.bedCount);
		    		   $("#inPeopleCountUpdate").val(data.inPeopleCount);
		    		   $("#outPeopleCountUpdate").val(data.outPeopleCount);
		    		   $("#cureRateUpdate").val(data.cureRate);
		    		   $("#betterRateUpdate").val(data.betterRate);
		    		   $("#badRateUpdate").val(data.badRate);	   
		    		   $("#deathRateUpdate").val(data.deathRate);
		    		   $("#userNameSelect1").val(data.userId);
		    		   $("#illnessEreaNameUpdate").val(data.illnessEreaName);
		    		   

	//------------------------------------------------------------------	    		   
		    	})
		    }
	  })
  }
 </script>
 
 <!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="illnessEreaID" id="illnessEreaIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改病区信息</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病区名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="illnessEreaName" class="form-control" id="illnessEreaNameUpdate" placeholder="病区名称">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">总床位:</label>
					    <div class="col-sm-10">
					      <input type="text" name="bedCount" class="form-control" id="bedCountUpdate" placeholder="总床位">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院人数:</label>
					    <div class="col-sm-10">
					      <input type="text" name="inPeopleCount" class="form-control" id="inPeopleCountUpdate" placeholder="入院人数">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">出院人数:</label>
					    <div class="col-sm-10">
					      <input type="text" name="outPeopleCount" class="form-control" id="outPeopleCountUpdate" placeholder="出院人数">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">治愈率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="cureRate" class="form-control" id="cureRateUpdate" placeholder="治愈率">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">好转率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="betterRate" class="form-control" id="betterRateUpdate" placeholder="好转率">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">恶化率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="badRate" class="form-control" id="badRateUpdate" placeholder="恶化率">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">死亡率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="deathRate" class="form-control" id="deathRateUpdate" placeholder="死亡率">
					    </div>
				 </div>				 
            </div>
            <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病区主管:</label>
					    <div class="col-sm-10">
					         <select id="userNameSelect1" name="userId" class="form-control">
					             
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
                <h4 class="modal-title" id="myModalLabel">添加病区信息</h4>
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">病区名称:</label>
					    <div class="col-sm-10">
					      <input type="text" name="illnessEreaName" class="form-control" id="illnessEreaNameAdd" placeholder="病区名称">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">总床位:</label>
					    <div class="col-sm-10">
					      <input type="text" name="bedCount" class="form-control" id="bedCountAdd" placeholder="总床位">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">入院人数:</label>
					    <div class="col-sm-10">
					      <input type="text" name="inPeopleCount" class="form-control" id="inPeopleCountAdd" placeholder="入院人数">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">出院人数:</label>
					    <div class="col-sm-10">
					      <input type="text" name="outPeopleCount" class="form-control" id="outPeopleCountAdd" placeholder="出院人数">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">治愈率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="cureRate" class="form-control" id="cureRateAdd" placeholder="治愈率">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">好转率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="betterRate" class="form-control" id="betterRateAdd" placeholder="好转率">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">恶化率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="badRate" class="form-control" id="badRateAdd" placeholder="恶化率">
					    </div>
				 </div>				 
            </div>
            <div class="modal-body">
                 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">死亡率:</label>
					    <div class="col-sm-10">
					      <input type="text" name="deathRate" class="form-control" id="deathRateAdd" placeholder="死亡率">
					    </div>
				 </div>				 
            </div>
            <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label" class="form-control">病区主管:</label>
			    <div class="col-sm-10">
			         <select id="userNameSelect" name="userId">
			             
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
	     var illArray = $("#myUpdateForm").serializeArray();
	    
	     $.ajax({
             type: "post",//请求的方式
             url: "${pageContext.request.contextPath}/illnessErea?method=update",
             data: illArray, //查询条件
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
	   var TestArray = $("#myAddForm").serializeArray();
	   if($("#illnessEreaNameAdd").val() == ""){
		   $.alert({
		            title:false,
		            content:'病区名称不能为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
		  });
	   }else if($("#bedCountAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'床位总数不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#inPeopleCountAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'入院人数不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#outPeopleCountAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'出院人数不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#cureRateAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'治愈率不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#betterRateAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'好转率不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#badRateAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'恶化率不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }else if($("#deathRateAdd").val() == ""){
		   $.alert({
	            title:false,
	            content:'死亡率不能为空！',
	            columnClass:'col-sm-12 no-padding',
	            boxWidth:'100%'
	     });
	   }
	   else{
		   $.ajax({
	             type: "post",//请求的方式
	             url: "${pageContext.request.contextPath}/illnessErea?method=add",
	             data: TestArray, //查询条件
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