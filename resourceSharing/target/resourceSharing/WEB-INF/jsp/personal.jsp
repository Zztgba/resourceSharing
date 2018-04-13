<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
    <title>论坛</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 网站主体 -->
    <div id="main">
        <div class="personal">
			<div class="lf">
				<img src="/headImage/${map.image }"alt="用户头像"/>
			</div>
			
			<div class="rf">
				<div>
					<span>${map.name }</span>
					<span><b>${map.nickname }</b> | <b>${map.sex }</b> |  <b>${map.birth }</b></span>
				</div>
				
				<div>
					<span><b>${map.score }</b>积分</span>
				</div>
			</div>
		</div>
		
    </div>

</body>
</html>