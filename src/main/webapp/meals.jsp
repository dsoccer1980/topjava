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
            <td>
                <c:if test = "${meal.exceed == true}">
                <span style="color: red; "> ${meal.exceed} </span>
                </c:if>
                <c:if test = "${meal.exceed != true}">
                    <span style="color: black; "> ${meal.exceed} </span>
                </c:if>
            </td>
            <td><a href="meals?action=delete&id=<c:out value="${meal.id}"/>">delete</a></td>
            <td><a href="meals?action=update&id=<c:out value="${meal.id}"/>">update</a></td>
        </tr>

    </c:forEach>


</table>

<br><br><br>
<form action="meals?action=add" method="post">
    <input type="text" name="description"> <br>
    <input type="datetime-local" name="datetime"> <br>
    <input type="text" name="calories"> <br>
    <input type="submit" name="Add">

</form>

</body>
</html>