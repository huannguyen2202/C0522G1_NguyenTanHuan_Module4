<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculate" method="post">
<table>
    <tr>
        <p>Nhập số thứ 1:</p>
        <input type="text" name="number1" >
    </tr>
    <tr>
        <p>Nhập số thứ 2:</p>
        <input type="text" name="number2">
    </tr><br><br>
    <tr>
        <button type="submit" name="calculator" value="Addition(+)">Addition(+) </button>
        <button type="submit" name="calculator" value="Subtraction(-)">Subtraction(-) </button>
        <button type="submit" name="calculator" value="Multiplication(x)">Multiplication(x) </button>
        <button type="submit" name="calculator" value="Division(/)">Division(/) </button>
    </tr>
</table>
</form>
<h2>Result : ${result}</h2>
</body>
</html>
