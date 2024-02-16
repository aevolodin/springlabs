<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
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
    </style>
</head>
<body>
<h1>${user.hello}</h1>
<form method="POST" action="hello">
    <fieldset>
        <div>
            <label>Ваше имя: </label>
            <input type="text" name="userName" value="${user.userName}">
        </div>
        <div>
            <input type="submit" value="Привет!">
        </div>
    </fieldset>

</form>
</body>
</html>