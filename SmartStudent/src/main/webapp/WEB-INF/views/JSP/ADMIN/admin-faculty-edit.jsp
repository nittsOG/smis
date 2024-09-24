<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Faculty</title>
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
	<h1>Edit Faculty</h1>
	<form
		action="${pageContext.request.contextPath}/admin/faculty/${faculty.facultyId}/edit"
		method="post">
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
		<p>
			Department: <select name="department.departmentId" required>
				<c:forEach var="department" items="${departments}">
					<option value="${department.departmentId}"
						${department.departmentId == faculty.department.departmentId ? 'selected' : ''}>${department.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Positio: <input type="text" name="position"
				value="${faculty.position}" required />
		</p>
		<h2>Address Information</h2>
		<p>
			Street: <input type="text" name="street"
				value="${faculty.facultyAddress.street}" required />
		</p>
		<p>
			City: <input type="text" name="city"
				value="${faculty.facultyAddress.city}" required />
		</p>
		<p>
			State: <input type="text" name="state"
				value="${faculty.facultyAddress.state}" required />
		</p>
		<p>
			Country: <input type="text" name="country"
				value="${faculty.facultyAddress.country}" required />
		</p>
		<p>
			Zip Code: <input type="text" name="zipCode"
				value="${faculty.facultyAddress.zipCode}" required />
		</p>

		<h2>Additional Faculty Information</h2>
		<p>
			Date of Birth: <input type="date" name="dateOfBirth"
				value="<fmt:formatDate value='${faculty.dateOfBirth}' pattern='yyyy-MM-dd' />"
				required />
		</p>
		<p>
			Gender: <select name="gender" required>
				<option value="Male" ${faculty.gender == 'Male' ? 'selected' : ''}>Male</option>
				<option value="Female"
					${faculty.gender == 'Female' ? 'selected' : ''}>Female</option>
				<option value="Other" ${faculty.gender == 'Other' ? 'selected' : ''}>Other</option>
			</select>
		</p>
		<p>
			Contact Number: <input type="text" name="contactNumber"
				value="${faculty.phone}" required />
		</p>
		<p>
			Nationality: <input type="text" name="nationality"
				value="${faculty.nationality}" required />
		</p>

		<h2>Photo</h2>
		<p>
			Photo: <input type="file" id="photo"
				onchange="encodeImageFileAsBase64()" accept="image/*" />
		</p>
		<input type="hidden" id="photoBase64" name="photoBase64" />
		<!-- Preview Image -->
		<img id="photoPreview" src="#" alt="Photo Preview"
			class="photo-preview" />

		<button type="submit">Save Changes</button>
		<p>
			<a href="${pageContext.request.contextPath}/admin/faculty">Back
				to Faculty List</a>
		</p>
	</form>
</body>
</html>
