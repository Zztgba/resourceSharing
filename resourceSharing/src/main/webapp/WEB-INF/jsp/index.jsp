<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<title>首页</title>
</head>
<body>
 <!-- 登录弹出层 -->
    <div class="cvs" style="display:none" id="cvs2_logon">
        <div class="newModWin">
            <div class="title">登录</div>
            <div class="close" id="cvs2_close" onclick="close_win()">X</div>
            <div class="logWin">
                <form action="${pageContext.request.contextPath }/UserController/login.action" method="post">
                    <input type="text" id="username" class="inp user" name="name" placeholder="请输入用户名" />
                    <input type="password" id="password" class="inp pass" name="password" placeholder="请输入密码" />
                    <b id="err" style="position: absolute;left: 30px;color: red">${mes }</b>
                    <a href="findpass.html" class="find_pass">忘记密码，立即找回</a>
                    <input type="submit" class="su_btn" value="登录" />
                    <a href="${pageContext.request.contextPath }/ForwordController/register.action" class="reg">注册</a>
                </form>
            </div>
        </div>
    </div>
	
	<jsp:include page="header.jsp"></jsp:include>

    <!-- 网站头信息-->
    <div id="nav">
        <div id="search">
            <input type="text" name="name" />
            <a class="btn" >搜索</a>
        </div>

        <div id="logon">
            <div class="cons">
                欢迎光临！
            </div>
            <div class="opers">
				<a class="btn" href="${pageContext.request.contextPath }/ForwordController/upload.action">上传资料</a>
            </div>
        </div>

        
        	<c:if test="${user==null }">
        		<a id="login" href="javascript:void(0)" onclick="showWin()">点击登录</a>
        	</c:if>
            <c:if test="${user!=null }">
            	<img id="login" alt="" src="/headImage/${user.image }">
            </c:if>
            
    </div>

    <!-- 网站主体 -->
    <div id="main">
        <!-- 定义一个条目-->
		<c:forEach items="${resourceList }" var="list">
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
					<div class="down">上传者：${list.userName } 上传时间：<fmt:formatDate value="${list.uploadtime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></div>
				</div>
				<div class="arr">
					积分：<span>${list.score }</span>
				</div>
			</div>
		</c:forEach>


		<div class="panigation">
			<a href="${pageContext.request.contextPath }/ResourceController/queryResource.action?currentPage=1">首页</a>
			<c:forEach begin="1" end="${page.totalPage}" varStatus="loop">
                <a href="${pageContext.request.contextPath }/ResourceController/queryResource.action?currentPage=${loop.index}">${loop.index}</a>
            </c:forEach>
			<a href="${pageContext.request.contextPath }/ResourceController/queryResource.action?currentPage=${page.totalPage}">尾页</a>
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
    <c:if test="${flag=='success' }">
		<script type="text/javascript">
			$(function(){
				$("#cvs2_logon").css('display','block');
			});
		</script>
	</c:if>
</body>
</html>