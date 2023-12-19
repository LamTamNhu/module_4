<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<form action="/calculate">
  <input type="number" name="first">
  <select name="operator">
    <option name="operator" value="+">+</option>
    <option name="operator" value="-">-</option>
    <option name="operator" value="*">*</option>
    <option name="operator" value="/">/</option>
  </select>
  <input type="number" name="second">
  <button type="submit">Calculate</button>
</form>
${result}
</body>
</html>