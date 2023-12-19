<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 19/12/2023
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate">
    <label>
        Input your english word
        <input type="text" name="word">
    </label>
    <button type="submit">Translate</button>
</form>
Result: ${result}
</body>
</html>
