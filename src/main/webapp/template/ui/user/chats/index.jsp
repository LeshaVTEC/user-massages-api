<%--
  Created by IntelliJ IDEA.
  User: antonmakatrau
  Date: 25.09.23
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Чаты</title>
</head>
<body>
<h1>Чаты</h1>
<table>
    <tr>
        <th>Дата/время отправки</th>
        <th>От кого</th>
        <th>Текст</th>
    </tr>
    <c:forEach var="message" items="${messages}">
        <tr>
            <td>${message.sentDate}</td>
            <td>${message.usernameFrom}</td>
            <td>${message.text}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
