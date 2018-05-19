<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css" />
<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>

<title>详情</title>
	
	<script>
		$(function(){
		
			$("div.star span").mouseover(function(){
				$(this).addClass('act1').prevAll("span").addClass("act1");
				$(this).nextAll("span").removeClass("act1");
			});
			
			$(".rf a:first").removeAttr('href');
			
			//资源id
			var resourceId=$("#resourceId").val();
			$("#download").click(function(){
				//window.location.href="${pageContext.request.contextPath}/ResourceController/downloadResource.action?resourceid="+resourceId;
				$.ajax({
					url:"${pageContext.request.contextPath}/ScoreController/regScore.action",
					type:"post",
					data:"resourceid="+resourceId,
					dataType:"json",
					success:function(data){
						if(data.flag==true){
                            window.location.href="${pageContext.request.contextPath}/ResourceController/downloadResource.action?resourceid="+resourceId
                        }else{
                            window.wxc.xcConfirm(data.mes, window.wxc.xcConfirm.typeEnum.error);
                        }
					}
				})
			});
			
			$("#collect").click(function(){
				$.ajax({
					url:"${pageContext.request.contextPath}/CollectController/saveCollect.action",
					type:"post",
					data:"resourceid="+resourceId,
					dataType:"json",
					success:function(data){
						if(data.flag==true){
							window.wxc.xcConfirm(data.mes, window.wxc.xcConfirm.typeEnum.success);
						}else{
							window.wxc.xcConfirm(data.mes, window.wxc.xcConfirm.typeEnum.error);
						}
					}
				})
			});
			
			$("#advice").click(function(){
				var star=$(".act1").length;
				var advice=$("#myAdvice").val();
				var username=$("#username").val();
				var userimage=$("#userimage").val();
				if(star==0){
					window.wxc.xcConfirm("请选择星级！", window.wxc.xcConfirm.typeEnum.error);
					return false;
				}
				if(advice==null||advice==""){
					window.wxc.xcConfirm("请填写评论！", window.wxc.xcConfirm.typeEnum.error);
					return false;
				}
				$.ajax({
					url:"${pageContext.request.contextPath}/CommentController/saveComment.action",
					type:"post",
					data:"star="+star+"&advice="+advice+"&resourceId="+resourceId,
					dataType:"json",
					success:function(data){
						if(data.flag==true){
							var str="";
							str+="<div class='cons'>";
							str+="<div class='img'>";
							str+="<img src='"+"/headImage/"+userimage+"'/>";
							str+="</div>";
							str+="<div class='cmt'>";
							str+="<div>";
							str+="<span class='author'>"+username+"</span>";
							str+="<span class='timer'>"+"刚刚"+"</span>";
							str+="<span class='star'>";
							if(star>=1){
								str+="<span class='act'>★</span>";
							}else{
								str+="<span>★</span>";
							}
							if(star>=2){
								str+="<span class='act'>★</span>";
							}else{
								str+="<span>★</span>";
							}
							if(star>=3){
								str+="<span class='act'>★</span>";
							}else{
								str+="<span>★</span>";
							}
							if(star>=4){
								str+="<span class='act'>★</span>";
							}else{
								str+="<span>★</span>";
							}
							if(star>4){
								str+="<span class='act'>★</span>";
							}else{
								str+="<span>★</span>";
							}
							str+="</span>";
							str+="</div>";
							str+="<div class='msg'>";
							str+="<b>"+advice+"</b>";
							str+="</div>";
							str+="</div>";
							str+="</div>";
							$("#comment").append(str);
							window.wxc.xcConfirm("评论添加成功！", window.wxc.xcConfirm.typeEnum.success);
						}else{
							window.wxc.xcConfirm(data.mes, window.wxc.xcConfirm.typeEnum.error);
						}
					}
				})
			});
			
		});
		
		
		
		
	</script>
</head>
<body>
    
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 网站主体 -->
    <div id="main">
        <!-- 定义详细目录-->
        <div id="detail">
            <div class="title"> <!-- 主信息-->
            	<input id="resourceId" type="hidden" value="${resource.id }">
            	<input id="username" type="hidden" value="${user.name }">
            	<input id="userimage" type="hidden" value="${user.image }">
               <div class="img">
					<c:if test="${resource.type==1 }">
						<img src="../images/txt.svg" />
					</c:if>
					<c:if test="${resource.type==2 }">
						<img src="../images/pdf.svg" />
					</c:if>
					<c:if test="${resource.type==3 }">
						<img src="../images/rar.svg" />
					</c:if>
				</div>
                <div class="cons">
                    <div>
                        <label>${resource.name }</label>
                    </div>
                    <div>
                        <label><fmt:formatDate value="${resource.uploadtime }" pattern="yyyy-MM-dd hh:mm:ss"/>  上传大小：${resource.size }</label>
                        <c:forEach items="${keywords }" var="arr">
                        	<span>${arr }</span>
                        </c:forEach>
                        <!-- <span>clound</span>
                        <span>demo</span> -->
                    </div>
                </div>
            </div>
            <div class="desc"> <!-- 信息描述-->
                ${resource.description }
            </div>
            <div class="msg"> <!-- 评价信息-->
                <span <c:if test="${star>=1}">class="act"</c:if>>★</span>
                <span <c:if test="${star>=2}">class="act"</c:if>>★</span>
                <span <c:if test="${star>=3}">class="act"</c:if>>★</span>
                <span <c:if test="${star>=4}">class="act"</c:if>>★</span>
                <span <c:if test="${star>=5}">class="act"</c:if>>★</span>
            </div>
            <div class="oper"> <!-- 下载操作-->
                <span>所需积分：<b>${resource.score }</b></span>
                <span>下载次数：<b>${resource.downloadTimes }</b></span>
                <span>
                    <a id="download" class="btn">下载</a>
					<a id="collect" class="btn">收藏</a>
                </span>
            </div>
        </div>
        <div id="comment">
            <div class="title">
                评论：<span>共有${fn:length(commentsList) }条</span>
                <hr/>
            </div>
            <!--每一条评论 -->
            <c:forEach items="${commentsList }" var="comment" varStatus="index">
            	<div class="cons">
                <div class="img">
                    <img src="/headImage/${comment.image }"/>
                </div>
                <div class="cmt">
                    <div>
                        <span class="author">${comment.name }</span>
                        <span class="timer"><fmt:formatDate value="${comment.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/></span>
                        <span class="star">
                            <span <c:if test="${comment.star>=1 }">class="act"</c:if>>★</span>
                            <span <c:if test="${comment.star>=2 }">class="act"</c:if>>★</span>
                            <span <c:if test="${comment.star>=3 }">class="act"</c:if>>★</span>
                            <span <c:if test="${comment.star>=4 }">class="act"</c:if>>★</span>
                            <span <c:if test="${comment.star>4 }">class="act"</c:if>>★</span>
                        </span>
                    </div>

                    <div class="msg">
                        <b>${comment.content }</b>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>

        <!-- 开始评论-->
        <div id="mycomments">
            <div>
                <span>我的评论</span>
                <hr/>
                <textarea id="myAdvice" placeholder="可以留下您的宝贵意见哟"></textarea>
                <div class="star"> <!-- 评价信息-->
                    <span>★</span>
                    <span>★</span>
                    <span>★</span>
                    <span>★</span>
                    <span>★</span>
                </div>
                <a id="advice" class="btn">评论</a>
            </div>


        </div>
    </div>

</body>
</html>