<%--
  Created by IntelliJ IDEA.
  User: LamNT
  Date: 12/19/2023
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chosen Condiments: </h1>
<c:forEach items="${condiments}" var="e" varStatus="loop">
    ${e}
    <br>
</c:forEach>
</body>
</html>
