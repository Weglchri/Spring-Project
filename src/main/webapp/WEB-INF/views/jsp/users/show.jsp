<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<body>

		<jsp:include page="../parts/header.jsp" />
        <div class="container">
            <h2>User ${user.firstname}</h2>

        <table class="table table-striped">

				<tr>
                    <td>
                        <label>UserID</label>
                        <div>${user.id}</div>
                    </td>
                </tr>
				<tr>
                    <td>
                        <label>Firstname</label>
                        <div>${user.firstname}</div>
                    </td>
                </tr>

				<tr>
                    <td>
                        <label>Lastname</label>
					    <div>${user.lastname}</div>
                    </td>
                </tr>
        </table>
        </div>
		<jsp:include page="../parts/footer.jsp" />

</body>
</html>