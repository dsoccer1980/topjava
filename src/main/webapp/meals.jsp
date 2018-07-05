<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <c:forEach items="${mealWithExceedList}" var="meal">

        <tr>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>${meal.dateTime}</td>
            <td>${meal.exceed}</td>
            <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">delete</a></td>
        </tr>

    </c:forEach>


</table>
</body>
</html>