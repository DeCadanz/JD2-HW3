<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Результаты</title>
</head>
<body>

<form action="result" method="POST">
    <p><span style='color: red; font-size: 22px;'>Результаты голосования</span></p>
    <table border = '0' cellpadding = '5' width = '400'>
    <tr><td><b>Исполнители</b></td></tr>
		<c:forEach items="${artistsStats}" var="item">
        <tr><td>${item}</td></tr>
		</c:forEach>
    <tr><td><b>Жанры</b></td></tr>
    	<c:forEach items="${genresStats}" var="item">
        <tr><td>${item}</td></tr>
		</c:forEach>
    </table>
    <table border = '0' cellpadding = '5' width = '400'>
    <tr><td><b>Комментарии:</b></td></tr>
		<c:forEach items="${aboutsStats}" var="item">
        <tr><td>${item}</td></tr>
		</c:forEach>
    <tr><td></td></tr>
    </table>
</form>

</body>
</html>