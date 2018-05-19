<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath }/css/index.css" rel="stylesheet" type="text/css" />
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        table{
            table-layout: fixed;
        }
        td{
            white-space:nowrap;overflow:hidden;text-overflow:ellipsis;
        }
    </style>
    <title>帖子审核</title>
</head>
<body>
<div class="page_nav">
    <p>当前位置：<span>帖子管理</span>/<span>帖子审核</span></p>
</div>

<div class="page_tb">
    <table>
        <thead>
        <tr>
            <th style="width: 50px">序号</th>
            <th style="width: 150px">帖子专题</th>
            <th style="width: 150px">帖子名字</th>
            <th style="width: 350px">帖子内容</th>
            <th style="width: 80px">发帖人</th>
            <th style="width: 150px">发帖时间</th>
            <th style="width: 100px">操作</th>
        </tr>
        </thead>
        <thead>
        <c:forEach items="${list}" var="bbsVo" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${bbsVo.notesort}</td>
                <td title="${bbsVo.notename}">${bbsVo.notename}</td>
                <td title="${bbsVo.notecontent}">${bbsVo.notecontent}</td>
                <td>${bbsVo.name}</td>
                <td><fmt:formatDate value="${bbsVo.notetime}" pattern="yyyy-MM-dd hh:mm"/></td>
                <td><a href="${pageContext.request.contextPath}/BbsManager/updateBbsState/1.action?id=${bbsVo.id}&&index=0">审核</a>&nbsp;|&nbsp;<a href="${pageContext.request.contextPath}/BbsManager/updateBbsState/2.action?id=${bbsVo.id}&&index=0">撤销</a></td>
            </tr>
        </c:forEach>
        </thead>
    </table>
</div>
</body>
</html>
