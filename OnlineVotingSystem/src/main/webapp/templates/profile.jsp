<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>Welcome, <%= request.getAttribute("name") != null ? request.getAttribute("name") : "User" %></h1>
</body>
</html>
