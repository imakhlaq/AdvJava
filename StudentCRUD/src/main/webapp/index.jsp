<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student App</title>
</head>
<body style="display: flex; justify-content: center; align-content: center">
<div style="display: flex;gap: 10rem; margin-top: 10vh">
    <div style="display: flex;gap: 3rem; flex-direction: column">
        <a href="${pageContext.request.contextPath}/add">Add</a>
        <a href="${pageContext.request.contextPath}/search">Search</a>
        <a href="${pageContext.request.contextPath}/update">Update</a>
        <a href="${pageContext.request.contextPath}/delete">Delete</a>
    </div>
    <div style="margin-top: 7rem">
        Welcome to Live College
    </div>
</div>

</body>
</html>
