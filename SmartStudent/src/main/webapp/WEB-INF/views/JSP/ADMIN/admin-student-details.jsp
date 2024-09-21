<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin - Student Details</title>
<style>
/* Styling for the image */
.student-photo {
	width: 150px; /* Set the width of the image */
	height: auto; /* Maintain aspect ratio */
	display: block; /* Make the image a block element */
	margin: 10px auto; /* Center the image */
}
</style>
</head>
<body>
	<h1>Student Details</h1>
	<p>Username: ${student.username}</p>
	<p>Email: ${student.email}</p>
	<p>Division: ${student.division.name}</p>
	<p>Email: ${student.email}</p>
	<p>dateOfBirth: ${student.dateOfBirth}</p>
	<p>contactNumber: ${student.contactNumber}</p>
	<p>guardianName: ${student.guardianName}</p>
	<p>guardianContact: ${student.guardianContact}</p>
	<p>enrollmentDate: ${student.enrollmentDate}</p>
	<p>nationality: ${student.nationality}</p>
	<p>enrollmentDate: ${student.enrollmentDate}</p>
	<p>status: ${student.status}</p>
	<!-- Check if photoBase64 is present, otherwise show an alternative -->
	<c:choose>
		<c:when test="${student.photoBase64 != null}">
			<p>
				Photo: <img src="data:image/jpeg;base64,${student.photoBase64}"
					alt="Student Photo" class="student-photo" />
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Photo: <img
					src="${pageContext.request.contextPath}/resources/images/default-photo.jpg"
					alt="Default Student Photo" class="student-photo" />
			</p>
		</c:otherwise>
	</c:choose>

	<h1>Adress</h1>
	<p>Street : ${studentAddress.street}</p>
	<p>City : ${studentAddress.city }</p>
	<p>State : ${studentAddress.state }</p>
	<p>Country : ${studentAddress.country }</p>
	<p>ZipCode : ${studentAddress.zipCode }</p>

	<p>
		<a href="${pageContext.request.contextPath}/admin/students">Back
			to Students List</a>
	</p>
</body>
</html>
