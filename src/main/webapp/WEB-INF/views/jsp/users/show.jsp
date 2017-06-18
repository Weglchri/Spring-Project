<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
</head>
		<body>
			<div class="container">
				<div class="row">
					<label>UserID</label>
					<div>${user.id}</div>
				</div>

				<div class="row">
					<label>Firstname</label>
					<div>${user.firstname}</div>
				</div>

				<div class="row">
					<label>Lastname</label>
					<div>${user.lastname}</div>
				</div>
			</div>
		</body>
</html>