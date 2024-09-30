<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Faculty Details</title>
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

	<!-- Faculty Photo -->
	<c:choose>
		<c:when test="${faculty.photoBase64 != null}">
			<p>
				Photo: <img src="data:image/jpeg;base64,${faculty.photoBase64}"
					alt="Faculty Photo" class="profile-photo" />
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Photo: <img
					src="${pageContext.request.contextPath}/resources/images/default-photo.jpg"
					alt="Default Faculty Photo" class="faculty-photo" />
			</p>
		</c:otherwise>
	</c:choose>

	<h2>Address</h2>
	<p>Street: ${faculty.facultyAddress.street}</p>
	<p>City: ${faculty.facultyAddress.city}</p>
	<p>State: ${faculty.facultyAddress.state}</p>
	<p>Country: ${faculty.facultyAddress.country}</p>
	<p>Zip Code: ${faculty.facultyAddress.zipCode}</p>

	<p>
		<a href="${pageContext.request.contextPath}/manager/faculty">Back to
			Faculty List</a>
	</p>
</body>
</html>
