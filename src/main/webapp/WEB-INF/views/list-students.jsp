
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<head><%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
			
			<a href="<%=request.getContextPath()%>/student/list" class="navbar-brand text-light">Waterloo Student ManageMent App</a>

		</nav>
	</header>
	
	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<!-- <h2>Waterloo Student ManageMent App</h2> -->

			<hr />

			<input type="button" value="Add Student"
				onclick="window.location.href='showForm'; return false"
				class="btn btn-primary" /> <br />
			<br />

			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Student List</div>

				</div>

				<div class="panel-body">
					<table class="table table-striped table-boardered">
						<tr>
							<th>ID</th>
							<th>Student First Name</th>
							<th>Student Last Name</th>
							<th>Student Email Id</th>
							<th>Actions</th>
						</tr>

						<c:forEach var="tempStudent" items="${students }">
							<c:url var="updateLink" value="/student/updateForm">
								<c:param name="studentId" value="${tempStudent.id }" />
							</c:url>

							<c:url var="deleteLink" value="/student/delete">
								<c:param name="studentId" value="${tempStudent.id }" />
							</c:url>

							<tr>
								<th>${tempStudent.id}</th>
								<th>${tempStudent.firstName}</th>
								<th>${tempStudent.lastName}</th>
								<th>${tempStudent.emailId}</th>
								<th><a href="${updateLink}" class="btn btn-info">Update</a>  <a
									href="${deleteLink}" class="btn btn-danger"
									onclick="if (! (confirm('Are you sure you want to delete this student'))) return false">Delete</a>

								</th>
							</tr>

						</c:forEach>


					</table>

				</div>
			</div>

		</div>
	</div>

</body>
</html>