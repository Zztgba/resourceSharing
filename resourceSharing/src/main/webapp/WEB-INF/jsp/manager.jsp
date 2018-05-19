<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" type="text/css" />
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <title>管理页面</title>
    <script>
        $(function(){

            $(".md").click(function(){
                var tag = $(this) ;
                var flag = tag.data('flag')!=null? $(this).data('flag'):true;
                $(this).parent().find("ul").slideToggle(200 , function(){
                    flag = !flag ;
                    if(flag) {
                        $(this).prev().find("b").html("···");
                    }else{
                        $(this).prev().find("b").html("&there4;");
                    }
                    tag.data('flag' , flag);
                });
            });

            $(".ml").eq(0).click(function () {
                $("iframe").attr("src","${pageContext.request.contextPath}/ResourceManager/queryResourcesByStatuState/0.action");
            });
            $(".ml").eq(1).click(function () {
                $("iframe").attr("src","${pageContext.request.contextPath}/ResourceManager/queryResourcesByStatuState/1.action");
            });
            $(".ml").eq(2).click(function () {
                $("iframe").attr("src","${pageContext.request.contextPath}/ResourceManager/queryResourcesByStatuState/2.action");
            });
            $(".ml").eq(3).click(function () {
                $("iframe").attr("src","${pageContext.request.contextPath}/BbsManager/queryBbsByStatuState/0.action");
            });
            $(".ml").eq(4).click(function () {
                $("iframe").attr("src","${pageContext.request.contextPath}/BbsManager/queryBbsByStatuState/1.action");
            });
            $(".ml").eq(5).click(function () {
                $("iframe").attr("src","${pageContext.request.contextPath}/BbsManager/queryBbsByStatuState/2.action");
            });
        });
    </script>
</head>
<body>
<!-- 登录弹出层 -->
<!-- <div class="cvs" style="display:none" id="cvs2_logon">
    <div class="newModWin">
        <div class="title">登录爱下下账号</div>
        <div class="close" id="cvs2_close" onclick="close_win()">X</div>

        <div class="logWin">
            <form action="" method="post">
                <input type="text" class="inp user" name="name" placeholder="请输入用户名" />
                <input type="password" class="inp pass" name="password" placeholder="请输入密码" />
                <a href="" class="find_pass">忘记密码，立即找回</a>
                <input type="submit" class="su_btn" value="登录" />
                <a href="register.html" class="reg">注册</a>
            </form>
        </div>
    </div>
</div> -->

<!-- 网站头信息-->
<div id="nav">
    <!-- <div id="logon">
        <div class="cons">
            欢迎光临爱下下！
        </div>
        <div class="opers">
            <input type="button" value="上传资料"/>
        </div>
    </div>

    <div id="login">
        <a href="javascript:void(0)" onclick="showWin()">点击登录</a>
    </div> -->
</div>

<!-- 网站主体 -->
<div id="admin">
    <div class="admin_lt">
        <ul>
            <li class="admin_mod">
                <span class="md"><a>资源管理</a><b>···</b></span>
                <ul>
                    <li class="ml"><a>资源审核</a></li>
                    <li class="ml"><a>已发布资源</a></li>
                    <li class="ml"><a>未通过资源</a></li>
                </ul>
            </li>
            <li class="admin_mod">
                <span class="md"><a>帖子管理</a><b>···</b></span>
                <ul>
                    <li class="ml"><a>帖子审核</a></li>
                    <li class="ml"><a>已审核帖子</a></li>
                    <li class="ml"><a>未通过帖子</a></li>
                </ul>
            </li>
            <%--<li class="admin_mod">
                <span class="md"><a>积分管理</a><b>···</b></span>
                <ul>
                    <li class="ml"><a>积分查询</a></li>
                </ul>
            </li>--%>
        </ul>
    </div>

    <div class="admin_rt">
        <iframe src="${pageContext.request.contextPath}/ResourceManager/queryResourcesByStatuState/0.action" scrolling="no"></iframe>
    </div>
</div>
</body>
</html>
