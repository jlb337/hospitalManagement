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
			    <label for="exampleInputName2">病人姓名:</label>
			    <input type="text" name="patientName" class="form-control" id="nameSearch" placeholder="病人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">年龄:</label>
			    <input type="text" name="age" class="form-control" id="ageSearch" placeholder="年龄">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">身份证号:</label>
			    <input type="text" name="ID" class="form-control" id="IDSearch" placeholder="身份证号">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">邮政编码:</label>
			    <input type="text" name="postCode" class="form-control" id="postCodeSearch" placeholder="邮政编码">
			  </div>
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="btn_insert" class="btn ">插入</button>
   </div>
</div>
<table id="table"></table>
<!-- 工具栏 -->
<div id="toolbar"></div>


 
 
 
 
<!-- 修改页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">

<input type="hidden" name="patientID" id="patientIDUpdate">

<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改病人信息</h4>
            </div>
            <div class="modal-body">
				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">病人姓名:</label>
					    <div class="col-sm-8">
					      <input type="text" name="patientName" class="form-control" id="nameUpdate" placeholder="病人姓名；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">性别:</label>
					    <div class="col-sm-8">
					      <input type="text" name="sex" class="form-control" id="sexUpdate" placeholder="性别；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">生日:</label>
					    <div class="col-sm-8">
					      <input type="date" name="birthday" class="form-control" id="birthdayUpdate" placeholder="生日；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">年龄:</label>
					    <div class="col-sm-8">
					      <input type="text" name="age" class="form-control" id="ageUpdate" placeholder="年龄；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">职业:</label>
					    <div class="col-sm-8">
					      <input type="text" name="occupation" class="form-control" id="occupationUpdate" placeholder="职业；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">出生地:</label>
					    <div class="col-sm-8">
					      <input type="text" name="birthPlace" class="form-control" id="birthPlaceUpdate" placeholder="出生地；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">民族:</label>
					    <div class="col-sm-8">
					      <input type="text" name="nation" class="form-control" id="nationUpdate" placeholder="民族；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">身份证:</label>
					    <div class="col-sm-8">
					      <input type="text" name="ID" class="form-control" id="IDUpdate" placeholder="身份证；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">国籍:</label>
					    <div class="col-sm-8">
					      <input type="text" name="nationality" class="form-control" id="nationalityUpdate" placeholder="国籍；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">工作地:</label>
					    <div class="col-sm-8">
					      <input type="text" name="workPlace" class="form-control" id="workPlaceUpdate" placeholder="工作地；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">电话:</label>
					    <div class="col-sm-8">
					      <input type="text" name="tel" class="form-control" id="telUpdate" placeholder="电话；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">邮政编码:</label>
					    <div class="col-sm-8">
					      <input type="text" name="postCode" class="form-control" id="postCodeUpdate" placeholder="邮政编码；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">户口地址:</label>
					    <div class="col-sm-8">
					      <input type="text" name="permanentAddress" class="form-control" id="permanentAddressUpdate" placeholder="户口地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人姓名:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonName" class="form-control" id="contactPersonNameUpdate" placeholder="联系人姓名；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人地址:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonAddress" class="form-control" id="contactPersonAddressUpdate" placeholder="联系人地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人关系:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonRelationship" class="form-control" id="contactPersonRelationshipUpdate" placeholder="联系人关系；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人电话:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonTel" class="form-control" id="contactPersonTelUpdate" placeholder="联系人电话；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">婚姻状况:</label>
					    <div class="col-sm-8">
					      <input type="text" name="marrySituation" class="form-control" id="marrySituationUpdate" placeholder="婚姻状况；">
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

<input type="hidden">  <!--name="patientID" id="patientIDInsert"-->

<div class="modal fade" id="myInsertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">插入一条新数据</h4>
            </div>
            <div class="modal-body">
 				<div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">病人姓名:</label>
					    <div class="col-sm-8">
					      <input type="text" name="patientName" class="form-control" id="name_insert" placeholder="病人姓名；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">性别:</label>
					    <div class="col-sm-8">
					      <input type="text" name="sex" class="form-control"   placeholder="性别；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">生日:</label>
					    <div class="col-sm-8">
					      <input type="date" name="birthday" class="form-control"  placeholder="生日；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">年龄:</label>
					    <div class="col-sm-10">
					      <input type="text" name="age" class="form-control" placeholder="年龄；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">职业:</label>
					    <div class="col-sm-8">
					      <input type="text" name="occupation" class="form-control" placeholder="职业；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">出生地:</label>
					    <div class="col-sm-8">
					      <input type="text" name="birthPlace" class="form-control" placeholder="出生地；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">民族:</label>
					    <div class="col-sm-8">
					      <input type="text" name="nation" class="form-control" placeholder="民族；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">身份证:</label>
					    <div class="col-sm-8">
					      <input type="text" name="ID" class="form-control" id = "ID_insert" placeholder="身份证；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">国籍:</label>
					    <div class="col-sm-8">
					      <input type="text" name="nationality" class="form-control" placeholder="国籍；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">工作地:</label>
					    <div class="col-sm-8">
					      <input type="text" name="workPlace" class="form-control" placeholder="工作地；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">电话:</label>
					    <div class="col-sm-10">
					      <input type="text" name="tel" class="form-control" id="tel_insert" placeholder="电话；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">邮政编码:</label>
					    <div class="col-sm-8">
					      <input type="text" name="postCode" class="form-control" placeholder="邮政编码；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">户口地址:</label>
					    <div class="col-sm-8">
					      <input type="text" name="permanentAddress" class="form-control" placeholder="户口地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人姓名:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonName" class="form-control" placeholder="联系人姓名；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人地址:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonAddress" class="form-control" placeholder="联系人地址；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人关系:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonRelationship" class="form-control" placeholder="联系人关系；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">联系人电话:</label>
					    <div class="col-sm-8">
					      <input type="text" name="contactPersonTel" class="form-control" id="contacttel_insert" placeholder="联系人电话；">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-4 control-label">婚姻状况:</label>
					    <div class="col-sm-8">
					      <input type="text" name="marrySituation" class="form-control" placeholder="婚姻状况；">
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

<input type="hidden" name="patientID" id="patientIDDelete">

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
    	
    	 
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/patient?method=selectByCondition",//访问地址
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
	    		    field: 'patientID',
	    		    title: '编号',
	    		    sortable:true
    		  	}, 
    		  	{
	    		    field: 'patientName',
	    		    title: '病人姓名'
    		  	}, 
    		  	{
	    		    field: 'sex',
	    		    title: '性别'
    		  	}, 
    		  	{
	    		    field: 'birthday',
	    		    title: '生日'
    		  	}, 
    		  	{
	    		    field: 'age',
	    		    title: '年龄'
    		  	}, 
    		  	{
        		    field: 'occupation',
        		    title: '职业'
        		}, 
    		  	{
        		    field: 'birthPlace',
        		    title: '出生地'
        		}, 
    		  	{
        		    field: 'nation',
        		    title: '民族'
        		}, 
    		  	{
        		    field: 'id',
        		    title: '身份证'
        		  	}, 
    		  	{
        		    field: 'nationality',
        		    title: '国籍'
        		  	}, 
    		  	{
        		    field: 'workPlace',
        		    title: '工作地'
        		  	}, 
    		  	{
        		    field: 'tel',
        		    title: '电话'
        		  	}, 
    		  	{
        		    field: 'postCode',
        		    title: '邮政编号'
        		  	}, 
    		  	{
        		    field: 'permanentAddress',
        		    title: '户口地址'
        		  	}, 
    		  	{
        		    field: 'contactPersonName',
        		    title: '联系人姓名'
        		  	}, 
    		  	{
        		    field: 'contactPersonAddress',
        		    title: '联系人地址'
        		  	}, 
    		  	{
        		    field: 'contactPersonRelationship',
        		    title: '联系人关系'
        		  	}, 
    		  	{
        		    field: 'contactPersonTel',
        		    title: '联系人电话'
        		  	}, 
    		  	{
        		    field: 'marrySituation',
        		    title: '婚姻状况'
        		  	}, 
    		  	{
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.patientID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.patientID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
	                     url: "${pageContext.request.contextPath}/patient?method=selectByCondition",
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
   function updateFun(patientID){
	 
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/patient?method=sendUpdate",
		    data:{ patientID : patientID },//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		
		    		   $("#patientIDUpdate").val(data.patientID);
		    		   $("#nameUpdate").val(data.patientName);
		    		   $("#sexUpdate").val(data.sex);
		    		   $("#birthdayUpdate").val(data.birthday);
		    		   $("#ageUpdate").val(data.age);
		    		   $("#occupationUpdate").val(data.occupation);
		    		   $("#birthPlaceUpdate").val(data.birthPlace);
		    		   $("#nationUpdate").val(data.nation);
		    		   $("#IDUpdate").val(data.id);
		    		   $("#nationalityUpdate").val(data.nationality);
		    		   $("#workPlaceUpdate").val(data.workPlace);
		    		   $("#telUpdate").val(data.tel);
		    		   $("#postCodeUpdate").val(data.postCode);
		    		   $("#permanentAddressUpdate").val(data.permanentAddress);
		    		   $("#contactPersonNameUpdate").val(data.contactPersonName);
		    		   $("#contactPersonAddressUpdate").val(data.contactPersonAddress);
		    		   $("#contactPersonRelationshipUpdate").val(data.contactPersonRelationship);
		    		   $("#contactPersonTelUpdate").val(data.contactPersonTel);
		    		   $("#marrySituationUpdate").val(data.marrySituation);
		    		   $("#workUpdate").val(data.work);
		    	})
		    }
	  })
  }
  
  
  function deleteFun(patientID)
  {
		 if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
			  if(window.confirm("请再次确认你真的需要删除本数据吗？")){
				  
				  
				  
	    $.ajax({
	    	type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/patient?method=Delete",
	    	 data:{ patientID : patientID },//数据
	    	 dataType:"json",//返回的数据类型为json
			 success:function(data){
			    	  //弹出修改窗体
					$("#table").bootstrapTable("refresh");//刷新表格中的数据

			    	 //$('#myDeleteModal').modal().on('shown.bs.modal',function() {
			    		 
			    		   //$("#patientIDDelete").val(data.patientID);
	    		 
				    	//})
			    }
		  })
				  
				  
			  }}
	  	
	  }
  
  
  
 </script>
 

 
<script type="text/javascript">
  $("#btnUpadte").click(function(){
	     //获取表单中的数据
	     var situation = $("#myUpdateForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/patient?method=update",
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
	    
	    
	    
		   if($("#name_insert").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">病人姓名不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
	    
		   else if($("#ID_insert").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">身份证号用不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
	    
		   else if($("#tel_insert").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">电话不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
	    
		   else if($("#contacttel_insert").val() == ""){
			   $.alert({
		            title:false,
		            content:'<img alt="" src="${pageContext.request.contextPath}/plugin/image/bg-input-focus.png" width="20" height="20">联系人电话不为空！',
		            columnClass:'col-sm-12 no-padding',
		            boxWidth:'100%'
			  });
		   }
			else{
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/patient?method=insert",
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
	     var patient = $("#myDeleteForm").serializeArray();
	    
	    $.ajax({
	    	 type:"post",//提交方式
	    	 url:"${pageContext.request.contextPath}/patient?method=Delete",
	    	 data:patient,//数据
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