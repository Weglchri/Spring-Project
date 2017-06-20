<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<body>

        <jsp:include page="../parts/header.jsp" />

		<div class="container">
		<h1>All Users</h1>

			<table class="table table-striped">
				<c:forEach var="user" items="${users}">
					<tr>
						<td>User ID</td>
						<td>Firstname</td>
						<td>Lastname</td>
						<td>Options</td>
					</tr>

					<tr>
						<td>${user.id}</td>
						<td>${user.firstname}</td>
						<td>${user.lastname}</td>
						<td>
                            <div class="form-inline">
								<button class="btn btn-success" onclick="location.href='/users/${user.id}'">Show</button>
								<button class="btn btn-success" onclick="location.href='/users/${user.id}/update'">Change</button>
                                <form class="form-group" id="delete" method="POST" action="/users/${user.id}/delete">
                                    <button class="form-control" class="btn btn-default" type="submit" >delete</button>
                                </form>
                            </div>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<jsp:include page="../parts/footer.jsp" />

</body>
</html>