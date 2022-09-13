<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 9/13/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>$Title$</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form:form action="/save" method="post" modelAttribute="declaration">
  <h4 style="text-align: center">TỜ KHAI Y TẾ</h4>
  <p style="text-align: center"><b>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG CHỐNG
    DỊCH BỆNH TRUYỀN NHIỄM</b></p>
  <p style="text-align: center; color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự.</p>

  <div class="mb-3">
    <label><b>Họ tên(ghi chữ IN HOA)</b><b style="color: red">(*)</b></label>
    <form:input path="name" class="form-control"/>
  </div>
  <div class="row">
    <div class="col">
      <label><b>Năm sinh</b><b style="color: red">(*)</b></label>
    </div>
    <div class="col">
      <label><b>Giới tính</b><b style="color: red">(*)</b></label>
    </div>
    <div class="col">
      <label><b>Quốc tịch</b><b style="color: red">(*)</b></label>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <form:input path="birthday" class="form-control"/>
    </div>
    <div class="col">
      <form:select path="gender" class="form-control">
        <form:option value="1" label="Nam"/>
        <form:option value="0" label="Nữ"/>
      </form:select>
    </div>
    <div class="col">
      <form:input path="nationality" class="form-control"/>
    </div>
  </div>
  <div class="mb-3">
    <label><b>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</b><b style="color: red">(*)</b></label>
    <form:input path="idCard" class="form-control"/>
  </div>
  <div class="mb-3">
    <label><b>Thông tin đi lại</b><b style="color: red">(*)</b></label><br>
    <form:radiobutton path="travelInformation" value="1" label="Tàu bay"/>
    <form:radiobutton path="travelInformation" value="2" label="Tàu thuyền"/>
    <form:radiobutton path="travelInformation" value="3" label="Ôtô"/>
    <form:radiobutton path="travelInformation" value="4" label="Khác"/>
  </div>
  <div class="row">
    <div class="col">
      <label><b>Số hiệu phương tiện</b><b style="color: red">(*)</b></label>
    </div>
    <div class="col">
      <label><b>Số ghế</b><b style="color: red">(*)</b></label>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <form:input path="vehicleNumber" class="form-control"/>
    </div>
    <div class="col">
      <form:input path="seats" class="form-control"/>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <label><b>Ngày khởi hành</b><b style="color: red">(*)</b></label>
    </div>
    <div class="col">
      <label><b>Ngày kết thúc</b><b style="color: red">(*)</b></label>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <form:input path="startDay" class="form-control"/>
    </div>
    <div class="col">
      <form:input path="endDay" class="form-control"/>
    </div>
  </div>
  <div class="mb-3">
    <label><b>Trong vòng 14 ngày qua. Anh chị có đến tĩnh thành phố nào?</b><b style="color: red">(*)</b></label>
    <form:textarea path="travelHistory" class="form-control"/>
  </div>

  <div>
    <button type="submit">save</button>
  </div>

</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>