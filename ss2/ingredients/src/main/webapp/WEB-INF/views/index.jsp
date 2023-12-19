<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <label>Lettuce
        <input type="checkbox" name="condiments" value="lettuce">
    </label>
    <label>Tomato
        <input type="checkbox" name="condiments" value="tomato">
    </label>
    <label>Mustard
        <input type="checkbox" name="condiments" value="mustard">
    </label>
    <label>Sprouts
        <input type="checkbox" name="condiments" value="sprouts">
    </label>
    <button type="submit">Save</button>
</form>
</body>
</html>