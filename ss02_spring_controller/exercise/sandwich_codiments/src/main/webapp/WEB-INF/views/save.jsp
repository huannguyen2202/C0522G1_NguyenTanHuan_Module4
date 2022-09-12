<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="save">
    <table>
        <tr>
            <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
            <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
            <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
            <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
        </tr>
        <tr>
            <td><input type="submit" value="save"/></td>
        </tr>
    </table>
</form>

<h2>LIST SANDWICH CONDIMENTS</h2>
<c:forEach items="${condiment}" var="food">
    <p>${food}</p>
</c:forEach>
</body>
</html>
