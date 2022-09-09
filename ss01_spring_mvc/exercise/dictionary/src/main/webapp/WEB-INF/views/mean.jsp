<%--
  Created by IntelliJ IDEA.
  User: SON NGUYEN
  Date: 10/31/2018
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meaning</title>
</head>
<body>
<h1>English-Vietnamese Dictionary</h1>
<form method="post" action="/result">
    <label>
        <input type="search" name="keyword">
    </label>
    <input type="submit" value="Search">
</form>
<h1>${key}----------- Meaning:</h1>
<h1>${word}</h1>
</body>
</html>