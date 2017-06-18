<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
    <body>
        <form:form method = "POST" action="/users" modelAttribute="userForm" >
            <form:hidden path="id" />
            Firstname: <form:input type="text" path="firstname" id="firstname"/>
            Lastname: <form:input type="text" path="lastname" id="lastname" />
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
