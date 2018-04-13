<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class="lf">
			<a href="${pageContext.request.contextPath }/ResourceController/queryResource.action?currentPage=1">首页</a>
			<a href="${pageContext.request.contextPath }/BbsController/queryBbsList.action?currentPage=1">论坛</a>
			<a href="${pageContext.request.contextPath }/ForwordController/upload.action">上传资料</a>
		</div>
		
		<div class="rf">
			<a href="${pageContext.request.contextPath }/UserController/queryMyself.action?userid=${user.id}">个人信息</a>
			<a href="${pageContext.request.contextPath }/CollectController/queryCollectList.action">我的收藏</a>
			<a href="${pageContext.request.contextPath }/ScoreController/queryScoreByUserid.action?userid=${user.id}">积分</a>
			<a href="${pageContext.request.contextPath }/UserController/logout.action">退出登录</a>
		</div>
	</div>
</body>
</html>