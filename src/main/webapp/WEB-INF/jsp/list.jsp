<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/tag.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>学生列表</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>学生列表</h2>
        </div>
        <div class="panel-body">
            <a href="/seckill/add" class="btn btn-info">增加</a>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>创建时间</th>
                    <th>详情页</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="sk">
                    <tr>
                        <td>${sk.userId}</td>
                        <td>${sk.userName}</td>
                        <td>${sk.userEmail}</td>
                        <td>
                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td><a class="btn btn-info" href="/user/${sk.userId}/detail">详情</a></td>
                        <td><a class="btn btn-warning" href="/user/${sk.userId}/update">修改</a></td>
                        <td><a class="btn btn-danger" href="/user/${sk.userId}/delete">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>