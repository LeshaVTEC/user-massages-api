<%--
  Created by IntelliJ IDEA.
  User: antonmakatrau
  Date: 25.09.23
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Отправить сообщение</title>
</head>
<body>
    <h1>Отправить сообщение</h1>
    <form action="${pageContext.request.contextPath}/api/message" method="POST">
        <label for="recipient">Логин кому:</label>
        <input type="text" id="recipient" name="recipient" required><br>

        <label for="messageText">Текст сообщения:</label>
        <textarea id="messageText" name="messageText" rows="4" cols="50" required></textarea><br>

        <input type="submit" value="Отправить">
    </form>
</body>
</html>
