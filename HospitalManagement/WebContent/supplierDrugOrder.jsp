<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户操作界面</title>

<!-- jsp包含指令 -->
<%@ include file="common/commoncss.jsp" %>
<%@ include file="common/commonjs.jsp" %>
<%-- <%@ include file="ztree/ztree.jsp" %> --%>
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
			    <label for="exampleInputName2">供应商订货日期:</label>
			    <input type="date" name="supplierOrderMakeDate" class="form-control" id="supplierOrderMakeDateSearch" placeholder="供应商订单生成日期">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">供应商交货日期:</label>
			    <input type="date" name="supplierOrderFinishDate" class="form-control" id="supplierOrderFinishDateSearch" placeholder="供应商订单完成日期">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">生产地点:</label>
			    <input type="text" name="supplierOrderAddress" class="form-control" id="supplierOrderAddressSearch" placeholder="生产地点">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputName2">订货项数:</label>
			    <input type="text" name="supplierOrderCount" class="form-control" id="supplierOrderCountSearch" placeholder="订货项数">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">供应商:</label>
			    <select name="supplierID" id="supplierIDSearch">
			        <option value="">请选择供应商名称</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">订单细则:</label>
			    <select name="drugOrderID" id="drugOrderIDSearch">
			        <option value="">请选择订单</option>
			    </select>
			  </div>
			  
			  <button id="btn_query" type="button" class="btn ">查询</button>
			  
		 </form>
   </div>
   <div>
   <button id="open" class="btn ">展开或折叠</button>
   <button id="btn_add" class="btn ">增加数据</button>
   </div>
</div>
<table id="table"></table>

</div>



<!-- 工具栏 -->
<div id="toolbar"></div>


<script type="text/javascript">

    $(function(){
    	$("#table").bootstrapTable({
    		url:"${pageContext.request.contextPath}/supplierDrugOrder?method=queryByCondition",//访问地址
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
    		columns: [{
    		    field: 'supplierID',
    		    title: '供应商编号',
    		    sortable:true
    		  }, {
    		    field: 'drugOrderID',
    		    title: '订单细则'
    		  },
    		  {
    		    field: 'supplierOrderMakeDate',
    		    title: '订货日期'
    		  },
    		  {
      		    field: 'supplierOrderFinishDate',
      		    title: '交货日期'
      		  },
      		  {
      		    field: 'supplierOrderAddress',
      		    //type:'date',
      		    title: '交货地点'
      		  },
      		  {
      		    field: 'supplierOrderCount',
      		    title: '订货项数'
      		  },
      		  {
    			  title:"操作",
    			  formatter:function(value,row,index){
    				  var updateValue =' <button  onclick="updateFun('+row.supplierID+','+row.drugOrderID+')" type="button" class="btn btn-default">修改</button>';
    				  var deleteValue =' <button  onclick="deleteFun('+row.supplierID+','+row.drugOrderID+')" type="button" class="btn btn-default">删除</button>';
    				  
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
    	
    	 //下拉数据加载  
    	 //加载部门
        $.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/supplier?method=selectByCondition",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	//alert("部门");
                var select = $("#supplierIDSearch");
                var select2 = $("#supplierIDUpdate");
                var select3 = $("#supplierIDAdd");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].supplierID+ "'>"  
                            + datas[i].supplierAddress + "</option>");  
                }
                for (var i = 0; i < datas.length; i++) { 
                	select2.append("<option value='" +datas[i].supplierID+ "'>"  
                            + datas[i].supplierAddress + "</option>");  
                } 
                for (var i = 0; i < datas.length; i++) { 
                	select3.append("<option value='" +datas[i].supplierID+ "'>"  
                            + datas[i].supplierAddress + "</option>");  
                } 
              
            } 
            
        }); 
    	//加载职位
    	$.ajax({  
            type : 'get',  
            url : "${pageContext.request.contextPath}/drugOrder?method=queryByCondition",  
            dataType : 'json',      
            success : function(datas) {//返回list数据并循环获取  
            	
                var select = $("#drugOrderIDSearch");
                var select2 = $("#drugOrderIDUpdate");
                var select3 = $("#drugOrderIDAdd");
                
            	//alert("获取职位信息！");
                for (var i = 0; i < datas.length; i++) { 
                	select.append("<option value='" +datas[i].drugOrderID+ "'>"  
                            + datas[i].drugOrderID + "</option>");  
                }
                for (var i = 0; i < datas.length; i++) { 
                	select2.append("<option value='" +datas[i].drugOrderID+ "'>"  
                            + datas[i].drugOrderID + "</option>");  
                }
                for (var i = 0; i < datas.length; i++) { 
                	select3.append("<option value='" +datas[i].drugOrderID+ "'>"  
                            + datas[i].drugOrderID + "</option>");  
                }

            } 
            
        }); 
    	
    })
 </script>
 
<!--  增删改查 -->
 <script type="text/javascript">
  $(function(){
	  <!--搜索条件-->
  	//条件搜索
		$("#btn_query").click(function() {
	                
					//获取表单中的数据
				     var searchUser = $("#mySearchForm").serializeArray();
	              
	                $.ajax({
	                     type: "post",//请求的方式
	                     url: "${pageContext.request.contextPath}/supplierDrugOrder?method=queryByCondition",
	                     data: searchUser, //查询条件
	                     dataType:"json",//返回的数据类型为json
	                     success : function(json) {
	                        $("#table").bootstrapTable('load', json);//主要是要这种写法
	                    }
	                });

	    });
  		$("#btn_add").click(function() {
     		
			$('#myAddModal').modal().on('shown.bs.modal');
			//alert(1);
		});
  		//对话框：======================================
  		$("#btnUpadte").click(function(){
  		  
  		    alert("开始更新");
  		    //获取表单中的数据
  		     var user = $("#myUpdateForm").serializeArray();
  		    $.ajax({
  		    	 type:"post",//提交方式
  		    	 url:"${pageContext.request.contextPath}/supplierDrugOrder?method=update",
  		    	 data:user,//数据
  		    	 dataType:"json",//返回的数据类型为json
  		    	 success:function(json){
  		    		 
  		    		 if(json ==1){
  		    			 
  		    			 $("#myUpdateModal").modal('hide');  //手动关闭
  		    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
  		    			 
  		    			 
  		    		 }
  		    	 }
  		    })
  	  })
  	  $("#btnAdd").click(function(){
  		  
  		    //获取表单中的数据
  		     var user = $("#myAddForm").serializeArray();
  		    
  		    $.ajax({
  		    	 type:"post",//提交方式
  		    	 url:"${pageContext.request.contextPath}/supplierDrugOrder?method=add",
  		    	 data:user,//数据
  		    	 dataType:"json",//返回的数据类型为json
  		    	 success:function(json){
  		    		 
  		    		 if(json ==1){
  		    			 alert("添加成功");
  		    			 $("#myAddModal").modal('hide');  //手动关闭
  		    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
  		 
  		    		 }
  		    		 else
  		    			 {
  		    			alert("因为添加了重复主键，添加失败");
 		    			 $("#myAddModal").modal('hide');  //手动关闭
 		    			 $("#table").bootstrapTable("refresh");//刷新表格中的数据
  		    			 }
  		    	 }
  		    })
  	  })

  		
  		
  		
  })
  
   //修改
   function updateFun(supplierID,drugOrderID){
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/supplierDrugOrder?method=sendUpdate&drugOrderID="+drugOrderID,
		    data:{supplierID:supplierID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	  //弹出修改窗体
		    	 $('#myUpdateModal').modal().on('shown.bs.modal',function() {
		    		 //alert(data);
		    			//alert(data.supplierID);
		    		   $("#supplierIDUpdate").val(data.supplierID);
		    		   $("#drugOrderIDUpdate").val(data.drugOrderID);
		    		   $("#supplierOrderMakeDateUpdate").val(data.supplierOrderMakeDate);
		    		   $("#supplierOrderFinishDateUpdate").val(data.supplierOrderFinishDate);
		    		   $("#supplierOrderAddressUpdate").val(data.supplierOrderAddress);
		    		   $("#supplierOrderCountUpdate").val(data.supplierOrderCount);
		    	})
		    }
	  })
  }
//删除
  function deleteFun(supplierID,drugOrderID){
    if(window.confirm("请仔细核对无误，删除本数据后不能恢复。")){
      if(window.confirm("请再次确认你真的需要删除本数据吗？")){

	  //alert("删除开始");
	  $.ajax({
		    type:"post",//提交方式
		    url:"${pageContext.request.contextPath}/supplierDrugOrder?method=delete",
		    data:{supplierID:supplierID,drugOrderID:drugOrderID},//传主键值
// 		    data:{supplierID:supplierID},//传主键值
		    dataType:"json",//返回的数据类型为json
		    success:function(data){
		    	
		    	 alert("删除成功");
		    	 $("#table").bootstrapTable("refresh");//刷新表格中的数据
		    }
	  })
  }
  }
 }
 </script>
<!--  对话框内按键 -->
 <script type="text/javascript">
  

</script>
 
<!-- 修改页面窗体  修改科室信息 -->
<!-- 模态框（Modal） -->
<form id="myUpdateForm" method="post">


<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改订单与供应商相联系的信息</h4>
            </div>
            <div class="modal-body">
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">订货日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="supplierOrderMakeDate" class="form-control" id="supplierOrderMakeDateUpdate" placeholder="订货日期:">
					    </div>
				 	</div>
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">交货日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="supplierOrderFinishDate" class="form-control" id="supplierOrderFinishDateUpdate" placeholder="交货日期:">
					    </div>
				 	</div>
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">交货地点:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierOrderAddress" class="form-control" id="supplierOrderAddressUpdate" placeholder="交货地点:">
					    </div>
				 </div>
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">交货数目:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierOrderCount" class="form-control" id="supplierOrderCountUpdate" placeholder="交货数目:">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">供应商:</label>
					    <div class="col-sm-10">
					    	<select name="supplierID" id="supplierIDUpdate">
					    		<option value="1">请选择</option>
				    		</select>
					    </div>
				 </div>
				 <div class="form-group">
				    <label for="exampleInputEmail2">订单细则:</label>
				    <select name="drugOrderID" id="drugOrderIDUpdate">
				        <option value="1">请选择</option>
				    </select>
			 	 </div>
				 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnUpadte" class="btn btn-primary">更改</button>
            </div>
        </div>/.modal-content
    </div>/.modal
</div>
</form>

<!-- 增加数据页面窗体 -->
<!-- 模态框（Modal） -->
<form id="myAddForm" method="post">
<div class="modal fade" id="myAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">增加信息</h4>
            </div>
            <div class="modal-body">
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">订货日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="supplierOrderMakeDate" class="form-control" id="supplierOrderMakeDateAdd" placeholder="订货日期:">
					    </div>
				 	</div>
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">交货日期:</label>
					    <div class="col-sm-10">
					      <input type="date" name="supplierOrderFinishDate" class="form-control" id="supplierOrderFinishDateAdd" placeholder="交货日期:">
					    </div>
				 	</div>
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">交货地点:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierOrderAddress" class="form-control" id="supplierOrderAddressAdd" placeholder="交货地点:">
					    </div>
				 </div>
                   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">交货数目:</label>
					    <div class="col-sm-10">
					      <input type="text" name="supplierOrderCount" class="form-control" id="supplierOrderCountAdd" placeholder="交货数目:">
					    </div>
				 </div>
				 <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">供应商:</label>
					    <div class="col-sm-10">
					    	<select name="supplierID" id="supplierIDAdd">
					    		<option value="1">请选择</option>
				    		</select>
					    </div>
				 </div>
				 <div class="form-group">
				    <label for="exampleInputEmail2">订单细则:</label>
				    <select name="drugOrderID" id="drugOrderIDAdd">
				        <option value="1">请选择</option>
				    </select>
			 	 </div>
				 
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="btnAdd" class="btn btn-primary">增加</button>
            </div>
        </div>/.modal-content
    </div>/.modal
</div>
</form>

</body>
</html>