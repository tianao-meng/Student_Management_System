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
			
			<!-- <a class="navbar-brand text-light">Waterloo Student ManageMent App</a> -->

			<a href="<%=request.getContextPath()%>/list" class="navbar-brand text-light">Waterloo Student ManageMent App</a>

<%-- 		<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students</a></li>
			</ul> --%>

		</nav>
	</header>
	<br>

	<div class="container col-md-5">

		<div class="card">


			<div class="card-body">
				<c:if test="${student!=null }">
					<form action="update" method="post">
				</c:if>

				<c:if test="${student==null }">
					<form action="insert" method="post">
				</c:if>

				<div class="text-center">
					<c:if test="${student!=null }">
						Edit Student
					</c:if>

					<c:if test="${student==null }">
						Add New Student
					</c:if>
				</div>


				<c:if test="${student!=null }">
					<input type="hidden" name="id"
						value="<c:out value='${student.id }'/>" />
				</c:if>

				<fieldset class="form-group">

					<label>Student First Name</label> <input type="text"
						value="<c:out value='${student.firstName }'/>"
						class="form-control" name="first_name" required="required" />

				</fieldset>

				<fieldset class="form-group">

					<label>Student Last Name</label> <input type="text"
						value="<c:out value='${student.lastName }'/>" class="form-control"
						name="last_name" required="required" />

				</fieldset>

				<fieldset class="form-group">

					<label>Student Email</label> <input type="text"
						value="<c:out value='${student.emailId }'/>" class="form-control"
						name="email_id" required="required" />

				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<a href="<%=request.getContextPath()%>" class="btn btn-danger">Cancel</a>
				</form>
			</div>

		</div>

	</div>
	
</body>

</html>