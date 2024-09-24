<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Faculty Profile</title>
<style>
/* Styling for the profile photo */
.profile-photo {
	width: 150px;
	height: auto;
	display: block;
	margin: 10px auto;
}
</style>
</head>
<body>
	<h2>Profile Information</h2>

	<!-- Display faculty photo if available -->
	<c:if test="${not empty photoBase64}">
		<img src="data:image/jpeg;base64,${photoBase64}" alt="Faculty Photo"
			class="profile-photo">
	</c:if>

	<h1>Faculty Details</h1>
	<p>ID: ${faculty.facultyId}</p>
	<p>Username: ${faculty.username}</p>
	<p>Email: ${faculty.email}</p>
	<p>Department: ${faculty.department.name}</p>
	<p>Position: ${faculty.position}</p>
	<p>
		Date of Birth:
		<fmt:formatDate value="${faculty.dateOfBirth}" pattern="yyyy-MM-dd" />
	</p>
	<p>Gender: ${faculty.gender}</p>
	<p>Contact Number: ${faculty.phone}</p>
	<p>Nationality: ${faculty.nationality}</p>

	<h3>Address Information</h3>
	<p>
		<strong>Street:</strong> ${faculty.facultyAddress.street}
	</p>
	<p>
		<strong>City:</strong> ${faculty.facultyAddress.city}
	</p>
	<p>
		<strong>State:</strong> ${faculty.facultyAddress.state}
	</p>
	<p>
		<strong>Country:</strong> ${faculty.facultyAddress.country}
	</p>
	<p>
		<strong>Zip Code:</strong> ${faculty.facultyAddress.zipCode}
	</p>

	<a href="${pageContext.request.contextPath}/faculty/profile/edit">Edit
		Profile</a>
	<a href="${pageContext.request.contextPath}/faculty/dashboard">Back
		TO Dashboard</a>
</body>
</html>
