<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Waterloo Student ManageMent App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<header>
		<nav class="navbar navbar-dark bg-dark">
			
			<a href="<%=request.getContextPath()%>/list" class="navbar-brand text-light">Waterloo Student ManageMent App</a>

		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">

			<h3 class="text-center">List of Students</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-dark">Add
					New Student</a>

			</div>
			<br>
			<table class="table table-boarded">
				<thead>

					<tr>
						<th>ID</th>
						<th>Student First Name</th>
						<th>Student Last Name</th>
						<th>Student Email Id</th>
						<th>Actions</th>
					</tr>

				</thead>

				<tbody>
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.firstName}" /></td>
							<td><c:out value="${student.lastName}" /></td>
							<td><c:out value="${student.emailId}" /></td>

							<td><a href="edit?id=<c:out value='${student.id }'/>"  class="btn btn-info">Edit</a>

								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id }'/>" class="btn btn-danger">Delete</a></td>

						</tr>

					</c:forEach>


				</tbody>



			</table>

		</div>

	</div>


</body>

</html>