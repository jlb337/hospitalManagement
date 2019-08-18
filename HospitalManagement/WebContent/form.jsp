<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/plugin/css/bootstrap.3.3.7.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/plugin/bootstrap-theme.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/plugin/css/bootstrap-table.css" rel="stylesheet">

<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/js/bootstrap3.3.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/js/jquery-1.11.1.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/js/bootstrap-table.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/js/tableExport/tableExport.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/js/export/bootstrap-table-export.min.js"></script>

</head>
<body>
	<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control " id="exampleInputEmail1" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  
  <table data-toggle="table">
  <thead>
    <tr>
      <th>Item ID</th>
      <th>Item Name</th>
      <th>Item Price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Item 1</td>
      <td>$1</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Item 2</td>
      <td>$2</td>
    </tr>
  </tbody>
</table>
  <button type="submit" class="btn btn-default">Submit</button>
</form>


	
<table data-toggle="table" data-url="${pageContext.request.contextPath}/data1.json" data-pagination="true" data-search="true">
  <thead>
    <tr>
      <th data-field="id">Item ID</th>
      <th data-field="name">Item Name</th>
      <th data-field="price">Item Price</th>
    </tr>
  </thead>
</table>


<table id="table"> </table>
<script type="text/javascript">
$('#table').bootstrapTable({
	  url:'data1.json',
	  pagination:true,
	  pageSize:3,
	  pageList:[3,5,7,9],
	  //search:true,
	  showColumns:true,
	  striped:true,
	  showRefresh:true,
	  showExport:true,
	  exportDataType:true,
	  exportTypes:['pdf','xlsx'],
	  
	  columns: [{
		    field: 'deptId',
		    title: '部门编号'
		  }, {
		    field: 'deptName',
		    title: '部门名字'
		  }, {
		    field: 'deptAddress',
		    title: '部门地址'
		  }]
	
// 	  data: [{
// 	    id: 1,
// 	    name: 'Item 1',
// 	    price: '$1'
// 	  }, {
// 	    id: 2,
// 	    name: 'Item 2',
// 	    price: '$2'
// 	  }]

	})
	
	
</script>
</body>
</html>