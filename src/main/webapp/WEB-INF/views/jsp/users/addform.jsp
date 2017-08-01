<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<body>

    <jsp:include page="../parts/header.jsp" />

    <div class="container">
        <h2>User Form</h2>

        <form:form class="form-horizontal" method = "POST" action="/users" modelAttribute="userForm" >

            <form:hidden path="id" />

            <div class="form-group">
                <label>Firstname:</label>
                <form:input type="text" path="firstname" id="firstname" class="form-control" />
            </div>

            <div class="form-group">
                <label>Lastname:</label>
                <form:input type="text" path="lastname" id="lastname" class="form-control" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-success">Add</button>
            </div>

        </form:form>
    </div>

    <jsp:include page="../parts/footer.jsp" />

</body>
</html>
