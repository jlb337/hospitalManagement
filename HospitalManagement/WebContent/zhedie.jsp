<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
		#container {
			margin: 0 auto;
			width: 600px;
			border: 1px solid #3bb2d0;
		}
		
		#wrap {
			position: relative;
			padding: 10px;
			overflow: hidden;
		}
		
		#read-more {
			padding: 5px;
			background: #fff;
			color: #333;
		}
		
		#read-more a {
			padding-right: 22px;
			no-repeat 100% 50%;
			font-weight: bold;
			text-decoration: none;
		}
		
		#read-more a: hover {
			color: #000;
		}
	</style>
	<script type="text/javascript" src="http://www.codefans.net/ajaxjs/jquery-1.6.2.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var slideHeight = 45; // px 定义折叠的最小高度
			var defHeight = $('#wrap').height();
			if(defHeight >= slideHeight) {
				$('#wrap').css('height', slideHeight + 'px');
				$('#read-more').append('<a href="#">更多</a>');
				$('#read-more a').click(function() {
					var curHeight = $('#wrap').height();
					if(curHeight == slideHeight) {
						$('#wrap').animate({
							height: defHeight
						}, "normal");
						$('#read-more a').html('折叠');
					} else {
						$('#wrap').animate({
							height: slideHeight
						}, "normal");
						$('#read-more a').html('更多');
					}
					return false;
				});
			}
		});
	</script>
</head>
<body>
<div id="container">

		<div id="wrap">
			<div>
				<h1>这一段文字是可以折叠展开的，点击下面的“更多”就可以展开，点击下面的“折叠”就可以折叠</h1>
			</div>
		</div>
		<div id="read-more"></div>
	</div>
</body>
</html>