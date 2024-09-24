<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Faculty Profile</title>
<style>
.photo-preview {
	width: 150px;
	height: auto;
	display: block;
	margin: 10px auto;
}
</style>
<script type="text/javascript">
	function encodeImageFileAsBase64() {
		var file = document.getElementById("photo").files[0];
		var reader = new FileReader();

		reader.onloadend = function() {
			document.getElementById("photoBase64").value = reader.result;
			document.getElementById("photoPreview").src = reader.result;
		}

		if (file) {
			reader.readAsDataURL(file);
		}
	}
</script>
</head>
<body>
	<h2>Edit Profile Information</h2>
	<form
		action="${pageContext.request.contextPath}/faculty/profile/update"
		method="POST">
		<p>ID: ${faculty.facultyId}</p>
		<p>
			Username: <input type="text" name="username"
				value="${faculty.username}" required />
		</p>
		<p>
			Password: <input type="password" name="password"
				value="${faculty.password}" required />
		</p>
		<p>
			Email: <input type="email" name="email" value="${faculty.email}"
				required />
		</p>
		<p>Department: ${faculty.department.name}</p>
		<p>Position: ${faculty.position} /></p>
		<p>Gender: ${faculty.gender} /></p>
		<p>Gender: ${faculty.nationality} /></p>

		<p>
			Photo: <input type="file" id="photo"
				onchange="encodeImageFileAsBase64()" accept="image/*" />
		</p>
		<input type="hidden" id="photoBase64" name="photoBase64" />
		<!-- Preview Image -->
		<img id="photoPreview" src="#" alt="Photo Preview"
			class="photo-preview" />

		<h3>Address Information</h3>
		<label for="street">Street:</label> <input type="text" id="street"
			name="street" value="${faculty.facultyAddress.street}" required>

		<label for="city">City:</label> <input type="text" id="city"
			name="city" value="${faculty.facultyAddress.city}" required>

		<label for="state">State:</label> <input type="text" id="state"
			name="state" value="${faculty.facultyAddress.state}" required>

		<label for="country">Country:</label> <input type="text" id="country"
			name="country" value="${faculty.facultyAddress.country}" required>

		<label for="zipCode">Zip Code:</label> <input type="text" id="zipCode"
			name="zipCode" value="${faculty.facultyAddress.zipCode}" required>

		<button type="submit">Update Profile</button>
	</form>

	<a href="${pageContext.request.contextPath}/faculty/profile">Cancel</a>

	<c:if test="${not empty message}">
		<div class="success-message">${message}</div>
	</c:if>
</body>
</html>
