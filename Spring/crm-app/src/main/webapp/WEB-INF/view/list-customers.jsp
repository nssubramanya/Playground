<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<title>CRM</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Montserrat|Roboto"
	rel="stylesheet">
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"> --%>
	
	<script>
		
	</script>
</head>

<body>
	<nav class="navbar navbar-expand-sm navbar-dark"
		style="background-color: green;">
		<a class="navbar-brand" href="#">CRM - Customer Relationship
			Manager</a>
	</nav>

	<div class="container-fluid"></div>
	<div class="row">
		<div class="col">
			<input class="btn btn-primary btn-lg mt-3 mx-3" type="button"
				value="Add Customer"
				onclick="window.location.href='showFormForAdd';return false;">
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-striped w-75 m-3">
				<thead class="thead-dark">
					<tr>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">E-Mail</th>
						<th scope="col">Operations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempCustomer" items="${customers}">
						<!--  Construct Update Link -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>


						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a class="btn btn-primary btn-sm" href="${updateLink}">Edit</a>
								<a class="btn btn-primary btn-sm" href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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