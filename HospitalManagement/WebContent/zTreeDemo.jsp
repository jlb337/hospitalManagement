<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="common/commoncss.jsp"%>
<%@include file="common/commonjs.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/layui-v2.5.4/layui-v2.5.4/layui/css/layui.css">
<link href="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.css" rel="stylesheet">
</head>

<body>
<h2>TreeView Checkable</h2>
<div id="treeview-checkable" style="width:15%;"></div>

<div class="col-sm-4">
  <h2>Custom Icons</h2>
  <div id="treeview5" class=""></div>
</div>
        
        

<script src="https://libs.baidu.com/jquery/1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plugin/layui-v2.5.4/layui-v2.5.4/layui/layui.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-treeview/1.2.0/bootstrap-treeview.min.js"></script>

<script>
function getTvStateData() {
	   var defaultData = [
	    {
	     text: 'Parent 1',
	     href: '#parent1',
	     tags: ['4'],
	     state: {
	      checked: true
	     },
	     nodes: [
	      {
	       text: 'Child 1',
	       href: '#child1',
	       tags: ['2'],
	       nodes: [
	        {
	         text: 'Grandchild 1',
	         href: '#grandchild1',
	         tags: ['0']
	        },
	        {
	         text: 'Grandchild 2',
	         href: '#grandchild2',
	         tags: ['0']
	        }
	       ]
	      },
	      {
	       text: 'Child 2',
	       href: '#child2',
	       tags: ['0']
	      }
	     ]
	    },
	    {
	     text: 'Parent 2',
	     href: '#parent2',
	     tags: ['0'],
	     nodes: [
	      {
	       text: 'Child 1',
	       href: '#child1',
	       tags: ['2'],
	       nodes: [
	        {
	         text: 'Grandchild 1',
	         href: '#grandchild1',
	         tags: ['0']
	        },
	        {
	         text: 'Grandchild 2',
	         href: '#grandchild2',
	         tags: ['0']
	        }
	       ]
	      },
	      {
	       text: 'Child 2',
	       href: '#child2',
	       tags: ['0']
	      }
	     ]
	    },
	    {
	     text: 'Parent 3',
	     href: '#parent3'
	    },
	    {
	     text: 'Parent 4',
	     href: '#parent4',
	     tags: ['0']
	    },
	    {
	     text: 'Parent 5',
	     href: '#parent5',
	     tags: ['0']
	    }
	   ];

	   return defaultData;
	  }
	  

$('#treeview5').treeview({
    color: "#428bca",
    expandIcon: 'glyphicon glyphicon-chevron-right',
    collapseIcon: 'glyphicon glyphicon-chevron-down',
    nodeIcon: 'glyphicon glyphicon-bookmark',
    data: getTvStateData()
  });


$(function() {
	 var $checkableTree = $('#treeview-checkable').treeview({
	     data: getTvStateData(), //数据
	     showIcon: false,
	     showCheckbox: true,
	     levels: 1,
	     onNodeChecked: function(event, node) { //选中节点
	      var selectNodes = getChildNodeIdArr(node); //获取所有子节点
	      if (selectNodes) { //子节点不为空，则选中所有子节点
	       $('#treeview-checkable').treeview('checkNode', [selectNodes, { silent: true }]);
	      }
	      var parentNode = $("#treeview-checkable").treeview("getNode", node.parentId);
	      setParentNodeCheck(node);
	     },
	     onNodeUnchecked: function(event, node) { //取消选中节点
	      var selectNodes = getChildNodeIdArr(node); //获取所有子节点
	      if (selectNodes) { //子节点不为空，则取消选中所有子节点
	       $('#treeview-checkable').treeview('uncheckNode', [selectNodes, { silent: true }]);
	      }
	     },
	     onNodeExpanded:
	      function(event, data) {
	       if (data.nodes === undefined || data.nodes === null) {

	       } else if (data.tags[0] === "2") {
	        //alert("Tags 2");
	       } else {
	        //alert("1111");
	       }
	      }
	    });
	 });
	 
	 
	 
function getChildNodeIdArr(node) {
	   var ts = [];
	   if (node.nodes) {
	    for (x in node.nodes) {
	     ts.push(node.nodes[x].nodeId);
	     if (node.nodes[x].nodes) {
	      var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
	      for (j in getNodeDieDai) {
	       ts.push(getNodeDieDai[j]);
	      }
	     }
	    }
	   } else {
	    ts.push(node.nodeId);
	   }
	   return ts;
	  }

	  function setParentNodeCheck(node) {
	   var parentNode = $("#treeview-checkable").treeview("getNode", node.parentId);
	   if (parentNode.nodes) {
	    var checkedCount = 0;
	    for (x in parentNode.nodes) {
	     if (parentNode.nodes[x].state.checked) {
	      checkedCount ++;
	     } else {
	      break;
	     }
	    }
	    if (checkedCount === parentNode.nodes.length) {
	     $("#treeview-checkable").treeview("checkNode", parentNode.nodeId);
	     setParentNodeCheck(parentNode);
	    }
	   }
	  }
	  
	  

</script> 



</body>
</html>