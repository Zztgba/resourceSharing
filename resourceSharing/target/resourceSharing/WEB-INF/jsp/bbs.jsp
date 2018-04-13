<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script src="${pageContext.request.contextPath }/js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
    <title>论坛</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 网站主体 -->
    <div id="main">
        <div class="bbs">
			<a class="btn" href="#tiezi">发帖</a>
			<hr />
			<c:forEach items="${list}" var="bbs" >
				<div class="tz">
					<div class="lf">
						<span>${bbs.notesort}</span>
						<a href="${pageContext.request.contextPath}/BbsController/bbsDetail.action?id=${bbs.id}">${bbs.notename}</a>
					</div>
					<div class="rf">
						<div>
							<span>${bbs.name}</span>
							<span><fmt:formatDate value="${bbs.notetime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></span>
						</div>
					</div>
				</div>
			</c:forEach>

			<div class="panigation">
				<a href="${pageContext.request.contextPath }/BbsController/queryBbsList.action?currentPage=1">首页</a>
				<c:forEach begin="1" end="${page.totalPage}" varStatus="loop">
					<a href="${pageContext.request.contextPath }/BbsController/queryBbsList.action?currentPage=${loop.index}">${loop.index}</a>
				</c:forEach>
				<a href="${pageContext.request.contextPath }/BbsController/queryBbsList.action?currentPage=${page.totalPage}">尾页</a>
			</div>
			
			
			
			<%--<a class="btn" href="#tiezi">发帖</a>
			<hr />--%>
			
			<!-- 开始发帖-->
			<!-- 上传表单-->
			<div class="bbs_tz" id="tiezi">
				<p>快速发帖</p>
				<hr />
				<form action="${pageContext.request.contextPath}/BbsController/saveBbs.action" method="post" name="tieziForm">
					<span>
						<select name="notesort">
							<option>技术专题</option>
							<option>闲聊专题</option>
						</select>
						<input id="notename" type="text" class="upt" placeholder="请输入帖子标题" name="notename"/>
					</span>
					<span>
						<textarea  id="notecontent" class="area" name="notecontent"></textarea>
					</span>
					<span><a class="btn" id="sbm">发表帖子</a></span>
				</form>
			</div>
			
		</div>
		
    </div>
<script type="application/javascript">
	$("#sbm").click(function () {
	    var notenameVal=$("#notename").val();
	    var notecontentVal=$("#notecontent").val();
	    var nameFlag=false;
	    var contentFlag=false;
	    if(notenameVal==null||notenameVal==""){
            window.wxc.xcConfirm("帖子标题不能为空!", window.wxc.xcConfirm.typeEnum.error);
            return false;
		}else {
	        nameFlag=true;
		}
		if(notecontentVal==null||notecontentVal==""){
            window.wxc.xcConfirm("帖子内容不能为空!", window.wxc.xcConfirm.typeEnum.error);
            return false;
		}else {
	        contentFlag=true;
		}
        if(nameFlag&&contentFlag){
            tieziForm.submit();
		}
    });
</script>
    
</body>
</html>