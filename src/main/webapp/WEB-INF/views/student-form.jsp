<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>

<!-- <meta charset="UTF-8"> -->
<meta charset="ISO-8859-1">
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

			<a href="<%=request.getContextPath()%>/student/list"
				class="navbar-brand text-light">Waterloo Student ManageMent App</a>

		</nav>
	</header>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<div class="text-center">Add Student</div>

				<form:form action="saveStudent" cssClass="form-horizontal"
					method="post" modelAttribute="student">

					<form:hidden path="id" />

					<div class="form-group">
						<label for="firstname" class="col-md-6 control-label">Student
							First Name</label>
						<div class="col-md-9">
							<form:input path="firstName" cssClass="form-control" />
						</div>

					</div>

					<div class="form-group">
						<label for="lastname" class="col-md-6 control-label">Student
							Last Name</label>
						<div class="col-md-9">
							<form:input path="lastName" cssClass="form-control" />
						</div>

					</div>

					<div class="form-group">
						<label for="email" class="col-md-6 control-label">Student
							Email</label>
						<div class="col-md-9">
							<form:input path="emailId" cssClass="form-control" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-md-offset-3 col-md-9">
							<form:button cssClass="btn btn-info">Submit</form:button>
						</div>
					</div>

				</form:form>

			</div>

		</div>
	</div>

</body>
</html>