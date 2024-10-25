<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create Post</title>

<style>
    /* General reset */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Segoe UI', Arial, sans-serif;
    }

    body {
        background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
        background-attachment: fixed;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background-size: cover;
    }

    h1 {
        font-family: 'Segoe UI', sans-serif;
        color: white;
        margin: 0;
        font-size: 2.2rem;/* Larger font size for better visibility */
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        margin-bottom: 20px; /* Space below the header */
        text-align: center; /* Centered title */
    }

    form {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        width: 100%;
        max-width: 500px;
    }

    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #333;
        font-size: 1rem;
    }

    textarea, input[type="file"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border-radius: 8px;
        border: 1px solid #ccc;
        font-size: 15px;
        transition: all 0.3s ease;
    }

    textarea:focus, input[type="file"]:focus {
        border-color: #007bff;
        outline: none;
        box-shadow: 0 0 10px rgba(0, 123, 255, 0.5);
    }

    button {
        width: 100%;
        background-color: #1a1a2e;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 8px;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.3s;
    }

    button:hover {
        background-color: #2c3e50;
        transform: translateY(-2px);
    }

    button:focus {
        background-color: #004085;
        outline: none;
        box-shadow: 0 0 10px rgba(0, 64, 133, 0.5);
    }

    /* Mobile Responsive */
    @media (max-width: 768px) {
        form {
            padding: 20px;
        }

        h1 {
            font-size: 2rem;
        }

        textarea, input[type="file"], button {
            font-size: 1rem;
        }
    }
</style>

<script>
	function convertImageToBase64() {
		const fileInput = document.getElementById('attachment');
		const reader = new FileReader();

		reader.onload = function(e) {
			document.getElementById('photoBase64').value = e.target.result
					.split(',')[1];
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
		action="${pageContext.request.contextPath}/student/community/createPost"
		method="post">
		<input type="hidden" name="communityId" value="${community.communityId}" />

		<div>
			<label for="content">Post Content:</label>
			<textarea id="content" name="content" rows="4" cols="50" required></textarea>
		</div>

		<div>
			<label for="attachment">Upload Image:</label> 
			<input type="file" id="attachment" name="attachment" accept="image/*"
				onchange="convertImageToBase64()" />
		</div>

		<input type="hidden" id="photoBase64" name="photoBase64" value="" />

		<div>
			<button type="submit">Submit Post</button>
		</div>
	</form>
</body>
</html>
