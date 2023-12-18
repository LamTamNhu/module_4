<%--
  Created by IntelliJ IDEA.
  User: LamNT
  Date: 12/18/2023
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="convert">
    <label>
        Amount
        <input type="number" name="amount">
    </label>
    <select>
        <option name="type" value="USD_to_VND">USD to VND</option>
        <option name="type" value="VND_to_USD">VND to USD</option>
    </select>
    <button type="submit">Convert</button>
</form>
</body>
</html>
