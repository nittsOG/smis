<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Post</title>
<script>
	// Function to convert the image file to base64
	function convertImageToBase64() {
		const fileInput = document.getElementById('attachment');
		const reader = new FileReader();

		reader.onload = function(e) {
			document.getElementById('photoBase64').value = e.target.result
					.split(',')[1]; // Extract base64 part
		};

		if (fileInput.files.length > 0) {
			reader.readAsDataURL(fileInput.files[0]);
		}
	}
</script>
</head>
<body>
	<h1>Create a New Post in ${community.name}</h1>

	<form
		action="${pageContext.request.contextPath}/faculty/community/post"
		method="post">
		<input type="hidden" name="communityId"
			value="${community.communityId}" />

		<div>
			<label for="content">Post Content:</label>
			<textarea id="content" name="content" rows="4" cols="50" required></textarea>
		</div>

		<div>
			<label for="attachment">Upload Image:</label> <input type="file"
				id="attachment" name="attachment" accept="image/*"
				onchange="convertImageToBase64()" />
		</div>

		<input type="hidden" id="photoBase64" name="photoBase64" value="" />

		<div>
			<button type="submit">Submit Post</button>
		</div>
	</form>
</body>
</html>
