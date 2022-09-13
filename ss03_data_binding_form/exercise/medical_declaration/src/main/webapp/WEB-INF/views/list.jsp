<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
  <title>Home</title>
  <title>Title</title>
  <style>
    table {
      border: solid 3px;
    }

    a {
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div style="background-image: url(https://mega.com.vn/media/news/2306_hinh-nen-4k34.jpg); height: 750px">
  <div class="p-3">
    <h2 style="font-family: 'UTM Flamenco';font-size: 60px;color:white" class="text-center fw-bold">DANH SÁCH</h2>
    <table class="table table-striped table-bordered ">
      <tr style="background-color: #4043FF;" class="text-center text-white">
        <th class="text-light my-auto">STT</th>
        <th style="color: white">Họ tên</th>
        <th style="color: white">Năm sinh</th>
        <th style="color: white">Giới tính</th>
        <th style="color: white">Quốc tịch</th>
        <th style="color: white">Số hộ chiếu</th>
        <th style="color: white">Thông tin đi lại</th>
        <th style="color: white">Số hiệu phương tiện</th>
        <th style="color: white">Số ghế</th>
        <th style="color: white">Ngày khởi hành</th>
        <th style="color: white">Ngày kết thúc</th>
        <th style="color: white">Lịch sử đi lại</th>
      </tr>
      <c:forEach varStatus="status" var="declaration" items="${declarationList}">
        <tr text-light>
          <td style="color: white" class="text-center">${status.count}</td>
          <td style="color: white">${declaration.name}</td>
          <td style="color: white" class="text-center">${declaration.birthday}</td>
          <td style="color: white" class="text-center">${declaration.gender}</td>
          <td style="color: white" class="text-center">${declaration.nationality}</td>
          <td style="color: white">${declaration.idCard}</td>
          <td style="color: white">${declaration.travelInformation}</td>
          <td style="color: white">${declaration.vehicleNumber}</td>
          <td style="color: white">${declaration.seats}</td>
          <td style="color: white">${declaration.startDay}</td>
          <td style="color: white">${declaration.endDay}</td>
          <td style="color: white">${declaration.travelHistory}</td>
        </tr>
      </c:forEach>
    </table>
  </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>

</body>
</html>
