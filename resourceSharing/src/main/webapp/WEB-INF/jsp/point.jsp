<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
    <title>资源上传</title>
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	
	<script>
		$(function(){
			$("#sp").text($("#hid").val());
		});
	</script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
	
	<div class="page_nav">
        <p>当前积分：<span id="sp"></span></p>
    </div>

        <!-- 上传表单-->
	<div class="page_tb">
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>积分</th>
					<th>时间</th>
					<th>来源</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="sum" value="0"/>
				<c:forEach items="${scoreList }" var="list" varStatus="ind">
					<tr>
						<td>${ind.index+1 }</td>
						<td>${list.score }</td>
						<td><fmt:formatDate value="${list.scoredate }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
						<td>${list.scoresource }注册</td>
						<c:set var="sum" value="${sum+list.score }"></c:set>
					</tr>
				</c:forEach>
				<input type="hidden" id="hid" value="${sum }"/>
			</tbody>
		</table>
		
		<%--<div class="panigation">
			<a>上一页</a>
			<a>1</a>
			<a>2</a>
			<a class="act">3</a>
			<a>4</a>
			<a>5</a>
			<a>下一页></a>
		</div>--%>
	</div>
</body>
</html>