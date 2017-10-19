<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\10\12 0012
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>
</script>
<head>
    <title>Title</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/Desk/Emplogin" method="post">
        <table align="center" border="2" cellpadding="0" cellspacing="0">
            <tr>
                <td>用户ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr><td colspan="2" align="center"><input type="submit" value="登录!"></td></tr>
        </table>
    </form>
    <hr/>
    <div align="center"><a href="${pageContext.request.contextPath}/addEmp.jsp">欢迎注册!</a></div>
</body>
</html>
