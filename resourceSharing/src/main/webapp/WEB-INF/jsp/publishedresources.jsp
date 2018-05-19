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

    <title>已发布的资源</title>
</head>
<body>
<div class="page_nav">
    <p>当前位置：<span>资源管理</span>/<span>已发布的资源</span></p>
</div>

<div class="page_tb">
    <table>
        <thead>
        <tr>
            <%--<th><input type="checkbox" value="all" /></th>--%>
            <th width="50px">序号</th>
            <th width="150px">资源名</th>
            <th width="350px">资源描述</th>
            <th width="100px">上传者</th>
            <th width="80px">资源分数</th>
            <th width="150px">上传时间</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <%--<tbody>
        <tr>
            <td><input type="checkbox" value="1" /></td>
            <td>1</td>
            <td>2</td>
            <td>a</td>
            <td>4</td>
            <td>5</td>
            <td>5</td>
            <td><a href="">审核</a>&nbsp;|&nbsp;<a href="">撤销</a></td>
        </tr>
        <tr>
            <td><input type="checkbox" value="2" /></td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>5</td>
            <td><a href="">审核</a>&nbsp;|&nbsp;<a href="">撤销</a></td>
        </tr>
        </tbody>--%>
        <thead>
        <c:forEach items="${list}" var="resourceVo" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${resourceVo.name}</td>
                <td title="${resourceVo.description}">${resourceVo.description}</td>
                <td>${resourceVo.uploadname}</td>
                <td>${resourceVo.score}</td>
                <td><fmt:formatDate value="${resourceVo.uploadtime}" pattern="yyyy-MM-dd hh:mm"/></td>
                <td><a href="${pageContext.request.contextPath}/ResourceManager/updateResourceState/2.action?id=${resourceVo.id}&&index=2">撤销</a></td>
            </tr>
        </c:forEach>
        </thead>
    </table>
</div>
</body>
</html>
