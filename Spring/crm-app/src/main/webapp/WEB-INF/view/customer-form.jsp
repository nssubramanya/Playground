<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark"
		style="background-color: green;">
		<a class="navbar-brand" href="#">CRM - Customer Relationship
			Manager</a>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-12">
				<h2>Save Customer</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form:form action="saveCustomer" modelAttribute="customer"
					method="POST">
					
					<form:hidden path="id" />
					
					<div class="form-group">
						<label for="first-name">First Name</label>
						<form:input id="first-name" class="form-control"
							placeholder="Enter First Name" path="firstName" />
					</div>

					<div class="form-group">
						<label for="last-name">Last Name</label>
						<form:input id="last-name" class="form-control"
							placeholder="Enter Last Name" path="lastName" />
					</div>

					<div class="form-group">
						<label for="email">E Mail</label>
						<form:input id="email" class="form-control"
							placeholder="Enter email" path="email" />
					</div>

					<input class="btn btn-primary" type="submit" value="Save" />
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col">
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>