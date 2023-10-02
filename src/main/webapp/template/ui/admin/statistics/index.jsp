<%@ page language="java" contentType="text/html" %>

<!doctype html>
    <html>
        <head><title>Statistics</title></head>
    <body>
        <h1>Hello! This is statistics!</h1>
        <h2>Number of active users</h2>
        <%= request.getAttribute("amountActiveUsers") %>
        <h2>Number of registered users</h2>
        <%= request.getAttribute("amountUsers") %>
        <h2>Number of user messages:</h2>
        <%= request.getAttribute("amountMessages") %>
    </body>
</html>