<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
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
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>医院管理系统登录</h3>
						<form  role="form"  action="${pageContext.request.contextPath}/user?method=login"  method="post" class="login-form">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="userName" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户：">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="userPassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码：">
							</div>
							<div >
			                    <img id="imgObj" alt="" src="${pageContext.request.contextPath}/kaptcha.do" style="width:200px;" title="看不清，点击刷新">
			                </div>
			                <div class="input_outer">
			                    <span class="us_uer"></span>
								<input name="code" class="text" style="color: #FFFFFF !important; position:absolute; "  type="text" placeholder="请输入验证码：">			                        
			                </div>
<%-- 							<div class="mb2"><a class="act-but submit"  style="color: #FFFFFF" href="${pageContext.request.contextPath}/user?method=login">登录</a></div> --%>
							<div class="mb2"><button class="act-but submit"  style="color: #FFFFFF; width:330px" >登录</button></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
	<script type="text/javascript">
	   $(function(){
		   $("#imgObj").click(function(){
			   $(this).attr("src","${pageContext.request.contextPath}/kaptcha.do");
			   var index = parent.layer.load(0, {shade: false});
		   })
		   
	   })
	</script>
		
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
		<script src="${pageContext.request.contextPath}/plugin/js/jquery.backstretch.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugin/js/scripts.js"></script>
		<div style="text-align:center;">
</div>
	</body>
</html>




