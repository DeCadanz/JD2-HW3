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

<form action="/Mk-JD2-111-25-0.1.4-SNAPSHOT/vote">
    <p><span style='color: red; font-size: 22px;'>Результаты голосования</span></p>
    <table border = '0' cellpadding = '5' width = '400'>
    <tr><td><b>Исполнители</b></td></tr>
		<c:forEach items="${artistsStats}" var="item">
        <tr><td>${item.key}</td><td>${item.value}</td></tr>
		</c:forEach>
    <tr><td><b>Жанры</b></td></tr>
    	<c:forEach items="${genresStats}" var="item">
        <tr><td>${item.key}</td><td>${item.value}</td></tr>
		</c:forEach>
    </table>
    <table border = '0' cellpadding = '5' width = '400'>
    <tr><td><b>Комментарии:</b></td></tr>
		<c:forEach items="${aboutsStats}" var="item">
        <tr><td>${item}</td></tr>
        <%--<tr><td><span style='color: gray; font-size: 12px;'>"добавлено" + ${item.value}</span></td></tr>--%>
		</c:forEach>
    <tr><td></td></tr>
    <tr><td><button>На главную</button></td></tr>
    </table>

</form>

</body>
</html>