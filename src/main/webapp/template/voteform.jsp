<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Музыкальное голосование</title>
</head>
<body>

<form action="vote" method="POST">
    <p><span style='color: red; font-size: 22px;'>Музыкальное голосование</span></p>
    <p><b>Какой исполнитель нравится вам больше всего?</b></p>
    <p>Выберите один вариант:</p>
    <c:forEach items="${artistsList}" var="item">
        <p><input type="radio" name="artist" value="${item}">${item}</p>
    </c:forEach>

    <p><b>Выберите любимые жанры в музыке</b></p>
    <p>Не менее трёх вариантов:</p>
    <c:forEach items="${genresList}" var="item">
        <p><input type="checkbox" name="genre" value="${item}">${item}</p>
    </c:forEach>

    <p><b>И пару строк о себе:</b></p>
    <textarea name="about"></textarea>
    <p><input type="submit" value="Отправить!"></p>
</form>

</body>
</html>