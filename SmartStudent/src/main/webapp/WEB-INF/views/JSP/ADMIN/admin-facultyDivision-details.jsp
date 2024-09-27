<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Faculty Division Details</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<h2>Faculty Division Details</h2>

	<!-- Faculty Division ID -->
	<p>
		<strong>Faculty Division ID:</strong>
		${facultyDivision.facultyDivisionId}
	</p>

	<!-- Faculty Details -->
	<h3>Faculty Information</h3>
	<p>
		<strong>Username:</strong> ${facultyDivision.faculty.username}
	</p>
	<p>
		<strong>Email:</strong> ${facultyDivision.faculty.email}
	</p>
	<p>
		<strong>Phone:</strong> ${facultyDivision.faculty.phone}
	</p>
	<p>
		<strong>Position:</strong> ${facultyDivision.faculty.position}
	</p>
	<p>
		<strong>Department:</strong>
		${facultyDivision.faculty.department.name}
	</p>

	<!-- Division Details -->
	<h3>Division Information</h3>
	<p>
		<strong>Division Name:</strong> ${facultyDivision.division.name}
	</p>
	<p>
		<strong>Department:</strong>
		${facultyDivision.division.department.name}
	</p>

	<!-- isFr Status -->
	<p>
		<strong>isFr Status:</strong> ${facultyDivision.fr ? "Yes" : "No"}
	</p>



	<!-- Links to go back or edit -->
	<a href="${pageContext.request.contextPath}/admin/facultyDivisions">Back
		to List</a> |
	<a
		href="${pageContext.request.contextPath}/admin/facultyDivisions/${facultyDivision.facultyDivisionId}/edit">Edit</a>

</body>
</html>
