<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
    <title>首页</title>
</head>
<body>
    
	<jsp:include page="header.jsp"></jsp:include>
    <!-- 网站主体 -->
    <div id="main">
        <!-- 定义一个条目-->
        <c:forEach items="${collectList }" var="list">
        <div class="pro">
           <div class="img">
           		<c:if test="${list.type==1 }">
           			<img src="../images/txt.svg" />
				</c:if>
				<c:if test="${list.type==2 }">
					<img src="../images/pdf.svg" />
				</c:if>
				<c:if test="${list.type==3 }">
						<img src="../images/rar.svg" />
				</c:if>
			</div>
            <div class="cs">
                <div class="up">
                    <a href="${pageContext.request.contextPath }/ResourceController/resourceDetail.action?resourceId=${list.id }">${list.resourceName }</a>
                </div>
                <div class="down">
                    上传者：${list.userName }  上传时间：<fmt:formatDate value="${list.uploadtime }" pattern="yyyy-MM-dd hh:mm:ss"/> 收藏时间：<fmt:formatDate value="${list.collecttime }" pattern="yyyy-MM-dd hh:mm:ss"/>
                </div>
            </div>
            <div class="arr">
                积分：<span>${list.score }</span>
            </div>
        </div>
	</c:forEach>

        <div class="panigation">
            <a href="${pageContext.request.contextPath }/CollectController/queryCollectList.action?currentPage=1">首页</a>
            <c:forEach begin="1" end="${page.totalPage}" varStatus="loop">
                <a href="${pageContext.request.contextPath }/CollectController/queryCollectList.action?currentPage=${loop.index}">${loop.index}</a>
            </c:forEach>
            <a href="${pageContext.request.contextPath }/CollectController/queryCollectList.action?currentPage=${page.totalPage}">尾页</a>
        </div>
    </div>


    <script>
        function showWin(){
            //获取对应的DIV元素
            var div = document.getElementById("cvs2_logon");
            div.style = 'display:block' ;
        }

        function close_win(){
            var div = document.getElementById("cvs2_logon");
            div.style = 'display:none' ;
        }
    </script>

</body>
</html>