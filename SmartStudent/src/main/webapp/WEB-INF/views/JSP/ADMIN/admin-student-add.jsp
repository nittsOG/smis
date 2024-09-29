<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Student</title>
<link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" />
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
	<h2>Create Student</h2>
	<form action="${pageContext.request.contextPath}/admin/students/add"
		method="post">
		<fieldset>
			<legend>Student Details</legend>

			<!-- Username -->
			<div>
				<label for="username">Username:</label> <input type="text"
					id="username" name="username" />
			</div>

			<!-- Password -->
			<div>
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" />
			</div>

			<!-- Email -->
			<div>
				<label for="email">Email:</label> <input type="text" id="email"
					name="email" />
			</div>

			<!-- Date of Birth -->
			<div>
				<label for="dateOfBirth">Date of Birth:</label> <input type="date"
					id="dateOfBirth" name="dateOfBirth" />
			</div>
			<div>
				<label for="gender">Gender:</label> <select id="gender"
					name="gender" required>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Other">Other</option>
				</select>
			</div>

			<!-- Division (Dropdown) -->
			<div>
				<label for="divisionId">Division:</label> <select id="divisionId"
					name="divisionId">
					<c:forEach items="${divisions}" var="division">
						<option value="${division.divisionId}">${division.name}</option>
					</c:forEach>
				</select>
			</div>

			<!-- Photo (File Upload) -->
			<div>
				<p>
					Photo: <input type="file" id="photo"
						onchange="encodeImageFileAsBase64()" accept="image/*" />
				</p>
				<input type="hidden" id="photoBase64" name="photoBase64" /> <img
					id="photoPreview" src="#" alt="Photo Preview" class="photo-preview" />
			</div>

			<!--*************************************  -->
			<div>
				<label for="contactNumber">Contact Number:</label> <input
					type="text" id="contactNumber" name="contactNumber" required />
			</div>

			<div>
				<label for="guardianName">Guardian Name:</label> <input type="text"
					id="guardianName" name="guardianName" required />
			</div>

			<div>
				<label for="guardianContact">Guardian Contact:</label> <input
					type="text" id="guardianContact" name="guardianContact" required />
			</div>

			<div>
				<label for="nationality">Nationality:</label> <input type="text"
					id="nationality" name="nationality" required />
			</div>

			<div>
				<label for="enrollmentDate">Enrollment Date:</label> <input
					type="date" id="enrollmentDate" name="enrollmentDate" required />
			</div>

			<div>
				<label for="status">Status:</label> <input type="text" id="status"
					name="status" required />
			</div>

		</fieldset>

		<fieldset>
			<legend>Address Details</legend>

			<div>
				<label for="street">Street:</label> <input type="text" id="street"
					name="street" required />
			</div>

			<div>
				<label for="city">City:</label> <input type="text" id="city"
					name="city" required />
			</div>

			<div>
				<label for="state">State:</label> <input type="text" id="state"
					name="state" required />
			</div>

			<div>
				<label for="country">Country:</label> <input type="text"
					id="country" name="country" required />
			</div>

			<div>
				<label for="zipcode">Zip Code:</label> <input type="text"
					id="zipcode" name="zipCode" required />
			</div>
		</fieldset>

		<div>
			<button type="submit">Create Student</button>
		</div>
	</form>
</body>
</html>
