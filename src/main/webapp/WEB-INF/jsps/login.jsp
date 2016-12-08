<%--
  Created by IntelliJ IDEA.
  User: knight
  Date: 16/12/8
  Time: 下午4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>This is Login</h1>


    <form action="/common/login" method="post">
        <input name="userName" type="text">
        <input name="passWord" type="text">

       <button type="submit">Submit</button>
    </form>
</body>
</html>
