<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/meal-list-styles.css">
    <style>
        .green {
            color: green
        }

        .red {
            color: red
        }
    </style>
    <title>Список приема пищи</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Дата/Время</th>
            <th>Описание</th>
            <th>Калории</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        <jsp:useBean id="meals" scope="request" type="java.util.List"/>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr style="background-color:${meal.exceed ? 'green' : 'red'}">
                <td>
                    <fmt:parseDate value="${meal.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="myDate"/>
                    <fmt:formatDate value="${myDate}" pattern="yyyy.MM.dd HH:mm"/>
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="action=delete"><img src="img/delete.png"></a></td>
                <td><a href="action=edit"><img src="img/pencil.png"></a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="/footer.jsp"/>
</body>
</html>