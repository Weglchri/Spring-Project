<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
		<h1>All Users</h1>
		<table>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>User ID</td>
					<td>Firstname</td>
					<td>Lastname</td>
				</tr>

				<tr>
					<td>${user.id}</td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>
						<button onclick="location.href='/users/${user.id}'">Show</button>
						<button onclick="location.href='/users/${user.id}/update'">Change</button>
						<button formmethod="post" onclick="location.href='/users/${user.id}/delete'">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>

</body>
</html>