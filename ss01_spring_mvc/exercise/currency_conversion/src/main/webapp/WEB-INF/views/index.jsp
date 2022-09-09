
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/usd">
    <label>HỆ SỐ QUY ĐỔI: </label>
    <input style="margin-left: 168px" type="text" name="rate" placeholder="Rate" value="24000"><br><br>
    <label>NHẬP SỐ TIỀN USD CẦN CHUYỂN ĐỔI: </label>
    <input type="text" name="usd" placeholder="USD" value="0"><br><br>
    <input type="submit" id="submit" value="Converter">
</form>
<b>Số tiền chuyển đổi từ USD sang VNĐ là: </b>
<a>${result1}</a><a>VNĐ</a>
</body>
</html>
