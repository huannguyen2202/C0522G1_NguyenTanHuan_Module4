<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL 5540
  Date: 8/28/2022
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
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
            /*background-color: white;*/
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
        <h2 style="font-family: 'UTM Flamenco';font-size: 60px;color:white" class="text-center fw-bold">DANH SÁCH KHÁCH HÀNG</h2>
        <table class="table table-striped table-bordered ">
            <tr style="background-color: #4043FF;" class="text-center text-white">
                <th class="text-light my-auto">STT</th>
                <th style="color: white">ID</th>
                <th style="color: white">Name</th>
                <th style="color: white">Address</th>
            </tr>
            <c:forEach varStatus="status" var="customers" items="${customerList}">
                <tr text-light>
                    <td style="color: white" class="text-center">${status.count}</td>
                    <td style="color: white" >${customers.name}</td>
                    <td style="color: white" >${customers.email}</td>
                    <td style="color: white" >${customers.address}</td>
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
