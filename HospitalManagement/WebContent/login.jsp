<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/css/form-elements.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugin/css/style.css">



<%@include file="common/commonjs.jsp"%>




</head>
<body>
	<div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>医院管理系统登录</strong> </h1>
                            <div class="description">
                            	
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录到您的账户</h3>
                            		<p>输入用户名和密码登录:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" form method="post" action="${pageContext.request.contextPath}/user?method=login" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="userName" placeholder="用户名..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="userPassword" placeholder="密码..." class="form-password form-control" id="form-password">
			                        </div>
			                        
			                        <div class="form-group">
			                        	<img id="imgObj" alt="" src="${pageContext.request.contextPath}/kaptcha.do" title="看不清，点击刷新">
										<input name="code" style="width:300px;" placeholder="验证码" required="" type="text">			                        
			                        </div>
			                        <button  type="submit"  class="btn">登录!</button>
			                      </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>...其他方式登录:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-2" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


   



	<script type="text/javascript">
   $(function(){
	   $("#imgObj").click(function(){
		   $(this).attr("src","${pageContext.request.contextPath}/kaptcha.do");
		   var index = parent.layer.load(0, {shade: false});
	   })
	   
   })
	</script>

<script src="${pageContext.request.contextPath}/plugin/js/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}/plugin/js/scripts.js"></script>
</body>
</html>