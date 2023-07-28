<%--
  Created by IntelliJ IDEA.
  User: imakhlaq
  Date: 7/28/2023
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body style="display: flex;justify-content: center;margin-top: 20vh">
<form action="${pageContext.request.contextPath}/addStudent" method="post"
      style="display: flex; flex-direction: column;gap: 6rem">

    <label>Name
        <input type="text" name="name">
    </label>
    <label>Email
        <input type="email" name="email">
    </label>

    <label>Age
        <input type="number" name="age">
    </label>

    <label>Country
        <input type="text" name="country">
    </label>

</form>


</body>
</html>
