<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Курс</title>
    <style>
        form fieldset {
            width: 40%;
        }

        form fieldset label {
            display: block;
            /*width : 50%;
            float :left;*/
        }

        form fieldset input, form fieldset textarea {
            width: 100%;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1><spring:message code="header_course"/></h1>
<c:if test="${not empty error}">
    <h2 class="error">${error}</h2>
</c:if>
<form method="POST">
    <fieldset>
        <div>
            <label>Название: </label>
            <input type="text" name="title" value="${course.title}">
        </div>
        <div>
            <label>Длительность: </label>
            <input type="number" name="length" value="${course.length}">
        </div>
        <div>
            <label>Описание: </label>
            <textarea name="description" rows="7">${course.description}</textarea>
        </div>
        <div>
            <s:authorize access="hasRole('ROLE_USER')">
                <input type="submit" value="Сохранить">
            </s:authorize>
        </div>
    </fieldset>

</form>

</body>
</html>