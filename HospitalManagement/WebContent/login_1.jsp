<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />

<%@ include file="common/commonjs.jsp" %>




 <title> Loading </title>
 
 <style>
 *{
	font-size:12px;
 }
/*loading*/
.loading_area
{
	z-index: 10000;
	position: absolute;
	top: 0px;
	left: 0px;
	right: 0px;
	bottom: 0px;
	opacity: 0.5;
	filter: alpha(opacity=50);
	background-color: rgb(204, 204, 204);
	width: 100%;
	height: 100%;
	display:none;
}

.loading_messagehtml
{
	z-index: 20000;
	background: url( 'img/loading.gif' ) no-repeat scroll 0px 0px #fff;
	padding-left:40px;
	padding-right:10px;
	border: 1px solid #34D2EC;
	border-radius: 2px 2px 2px 2px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	left: 50%;
	top: 50%;
	line-height: 32px;
	position: absolute;
	opacity: 1;
	margin: auto;
	height: 32px;
	display:none;

}

 </style>
	<script type="text/javascript">
	document.writeln("<div id='loading_area' class='loading_area'></div><div id='loading_messagehtml' class='loading_messagehtml'></div>");
	//加载完成关闭忙提示
	$(function() {
		loadingHide();
		try {
			window.parent.loadingHide();
		} catch (e) { }
	});
	//显示加载提示
	function showLoading(msg) {
		var dh = getDocHeight();
		var dw = getDocWidth();
		$("#loading_area").height(dh);
		$("#loading_area").width(dw);
		$("#loading_area").show();
		if(msg==undefined){
			msg="Please Waiiting......";
		}
		$("#loading_messagehtml").html(msg);
		$("#loading_messagehtml").css("left",(dw-$("#loading_messagehtml").width())/2+"px");
		$("#loading_messagehtml").show();
	}
	//隐藏加载提示
	function hideLoading() {
		$("#loading_area").hide();
		$("#loading_messagehtml").hide();
	}
	//获取页面显示区域高度
	function getDocHeight() {
		var D = document;
		return Math.max(
			Math.max(D.body.scrollHeight, D.documentElement.scrollHeight),
			Math.max(D.body.offsetHeight, D.documentElement.offsetHeight),
			Math.max(D.body.clientHeight, D.documentElement.clientHeight)
		);
	}
	//获取页面显示区域宽度
	function getDocWidth() {
		var D = document;
		return Math.max(
			Math.max(D.body.scrollWidth, D.documentElement.scrollWidth),
			Math.max(D.body.offsetWidth, D.documentElement.offsetWidth),
			Math.max(D.body.clientWidth, D.documentElement.clientWidth)
		);
	}
	</script>





</head>
<body>
    <form method="post" id="myLoginForm" action="${pageContext.request.contextPath}/user?method=login">
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>Welcome</h3>
						<form action="#" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input class="text" style="color: #FFFFFF" type="text" name="userName" required="" placeholder="Input Account:">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;
								"value="" type="password" name="userPassword"  required=""placeholder="PassWord:">
							</div>
							<div>
								<p style="text-align:center;"><img id="imgObj" alt="" src="${pageContext.request.contextPath}/kaptcha.do" title="Refresh">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="code" class="text" style="color: #FFFFFF" type="text" required="" placeholder="Input Code:">
							</div>
<!-- 							<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF">Log in</a> -->
							<div class="mb2"><button class="act-but submit" onclick="dengluClick();" href="javascript:;" style="color: #FFFFFF;width:330px;height:50px" id="btn_login">Log in</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</form>

		<!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<div style="text-align:center;">
		</div>

<script type="text/javascript">
   $(function(){
	   $("#imgObj").click(function(){
		   $(this).attr("src","${pageContext.request.contextPath}/kaptcha.do");
	   })
	   
	   /**
	   
	   **/
	   
// 	   $("#btn_login").click(function(){
// 		   var searchUser = $("#myLoginForm").serializeArray();
// 		   $.ajax({  
// 	           type : 'get',  
// 	           url : "${pageContext.request.contextPath}/user?method=login",  
// 	           dataType : 'json', 
// 	           data:searchUser,
// 	           success : function(flag) {//返回list数据并循环获取  
// 	           	//alert("部门");
	           		
//                     alert(flag);
	             
// 	           } 
	           
// 	       }); 
// 	   })
   })
   function  dengluClick(){
	   showLoading();
	   $.ajax({
           url:"${pageContext.request.contextPath}/user?method=login1",
           data:$('#myLoginForm').serializeArray(),
           dataType:"json",
           success:function(data){
              if(data == "1"){
            	  alert("验证码输入错误");
              }
              else if(data=="2")
            	  {
            	  	alert("用户名和密码输入错误");
            	  }
              
           }
       });
   }
   
</script>

	</body>
</html>