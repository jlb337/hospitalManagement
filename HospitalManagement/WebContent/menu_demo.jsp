<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>Bob Hospital</title>

   
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<script>
// $(function(){
	
// 	$.ajax({
//         type: "post",//请求的方式
//         url: "${pageContext.request.contextPath}/user?method=queryPositionAndDepartmentByCondition",
//         data: searchUser, //查询条件
//         dataType:"json",//返回的数据类型为json
//         success : function(data) {
        	
//            //$("#table").bootstrapTable('load', json);//主要是要这种写法
// 		   var pictureUrl = data.url;//后台传入的图片路径，url指的是数据库中图片的路径
// 		   document.getElementById("userPhoto").src = pictureUrl;
//        }
//    });
	
// })
</script>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">


    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav nav-list" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" style='width: 50px;height: 50px;' class="img-circle" src='<%=request.getAttribute("userPhoto")  %>' id="userPhoto"/></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold"><%=request.getAttribute("userName") %></strong></span>
                                <span class="text-muted text-xs block"><%=request.getAttribute("userSex") %>><b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                                </li>
                                <li><a class="J_menuItem" href="profile.html">个人资料</a>
                                </li>
                                <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                                </li>
                                <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="login.html">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">H+
                        </div>
                    </li>
                    
                   
                    
                    
                    
                    
                    
                  
					


					<c:forEach items="${mymenuList}" var="one">
						<li>
							<a href="#" class="dropdown-toggle">
							 	<i class="fa fa-home"></i>
							<span class="menu-text">${one.menuName } </span> 
							<!-- 菜单下拉箭头图标 fa arrow-->
							<span class="glyphicon glyphicon-triangle-right"></span>
							</a>
							<ul class="submenu">
								<c:forEach items="${one.childMenu}" var="two">
									<li>
										<a class="dropdown-toggle" dataUrl="${pageContext.request.contextPath }/${two.menuUrl}">
<!-- 											<i class="fa fa fa-bar-chart-o"></i>    fa fa-desktop-->
												<i class="glyphicon glyphicon-plus-sign"></i>
											<span class="menu-text">${two.menuName}  </span>
											
											<!-- 菜单下拉箭头图标  fa arrow-->
											<span class="glyphicon glyphicon-chevron-down"></span>
									    </a>
										<ul class="submenu">
											<c:forEach items="${two.childMenu}" var="three">
												<li><a dataUrl="${pageContext.request.contextPath }/${three.menuUrl}">
													 ${three.menuName}
												</a>
												
												</li>
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
							
						</li>
					</c:forEach>
				


                   
                 
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
        	<div class="main-content">
				<div class="page-content">
					<iframe id="menuFrame" name="menuFrame"
						src="${pageContext.request.contextPath }/backGround.jsp"
						style="overflow: visible;" scrolling="yes" frameborder="no"
						width="100%" height="800"> </iframe>
					
				</div>
			</div>
        
        
        </div>
        	
	
	
	
	
	

    </div>


            
            
            
            






    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="js/hplus.js?v=4.1.0"></script>
    <script type="text/javascript" src="js/contabs.js"></script>

    <!-- 第三方插件 -->
    <script src="js/plugins/pace/pace.min.js"></script>
	
	
	<script type="text/javascript">
		//菜单点击事件
		$(function() {
			$(".nav-list .submenu ul a").click(function() {
				alert("开始跳转！");
				var menuUrl = $(this).attr("dataUrl");
				$("#menuFrame").attr("src", menuUrl);
			});
		});
	</script>
	
	
</body>

</html>
