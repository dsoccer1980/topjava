<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Meal create</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meal create</h2>



<form action="meals?action=update" method="post">
    <input type="text" name="description" value="${meal.description}"> <br>
    <input type="datetime-local" name="datetime" value="${meal.dateTime}"> <br>
    <input type="text" name="calories" value="${meal.calories}"> <br>
    <input type="hidden" name="id" value="${meal.id}"> <br>
    <input type="submit" name="Update">

</form>


</body>
</html>