<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
    <title>密码找回</title>
</head>
<body>
   <jsp:include page="header.jsp"></jsp:include>

    <!-- 网站主体 -->
    <div id="main">
        <!-- 上传表单-->
        <div class="upload">
            <p>密码找回</p>
            <hr />
            <form action="" method="post" enctype="multipart/form-data">
                <span>
                    <label>找回方式：</label>
                    <select class="upt">
                        <option>电话找回</option>
                        <option>邮件找回</option>
                    </select>
                </span>
                <span>
                    <label>输入电话/邮件：</label>
                    <input class="upt" type="text" name="" value="" />
                </span>
                <span>
                    <label>新密码：</label>
                    <input class="upt" type="password" name="" value="" />
                    <b>密码长度为6-20位</b>
                </span>
                <span>
                    <label>确认密码：</label>
                    <input class="upt" type="password" name="" value="" />
                    <b>两次输入的密码必须保持一致</b>
                </span>

                <span><label class="btn"><input type="button" value="确认找回" /></label></span>
            </form>
        </div>

    </div>

</body>
</html>