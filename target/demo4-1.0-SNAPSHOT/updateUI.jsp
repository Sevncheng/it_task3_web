<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\13 0013
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">更新用户界面</h1>
<form action="${pageContext.request.contextPath}/Desk/Emp/Update" method="post">
    <table align="center" border="2" cellpadding="0" cellspacing="0">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name" value="${emp.name}"></td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="更新!"></td></tr>
        <tr><td><input type="hidden" name="id" value="${emp.id}"></td></tr>
    </table>
</form>
</body>
</html>
