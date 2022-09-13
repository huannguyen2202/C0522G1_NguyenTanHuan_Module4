
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/save">
  <table>
    <tr>
      <td><form:hidden path="id"/></td>
    </tr>

    <tr>
      <td>Languages</td>
      <td><form:select path="languages" items="${languageList}"/>
    </tr>

    <tr>
      <td>Page size</td>
      <td>
        <form:select path="pageSize" items="${pageSizeList}" />
      </td>
    </tr>

    <tr>
      <td>Spams filter</td>
      <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
    </tr>
    <tr>
      <td>Signature</td>
      <td><form:textarea path="signature"/></td>
    </tr>
    <tr>
      <td><form:button>Update</form:button></td>
    </tr>
  </table>
</form:form>

</body>
</html>
