<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Post</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            color: white;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.3);
            max-width: 700px;
            margin: 20px auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2rem;/* Larger font size for better visibility */
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7), /* Main shadow */
                 0 0 25px rgba(255, 255, 255, 0.2); /* Glowing effect */
            margin-bottom: 20px; /* Space below the header */
            text-align: center; /* Centered title */
           
        }

        hr {
            border: none;
            height: 2px;
            background-color: white;
            width: 80%;
            margin: 20px auto;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            
        }

        textarea, input[type="file"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        button {
            width: 100%;
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2a3e50;
        }
    </style>
    <script>
        // Function to convert the image file to base64
        function convertImageToBase64() {
            const fileInput = document.getElementById('attachment');
            const reader = new FileReader();

            reader.onload = function(e) {
                document.getElementById('photoBase64').value = e.target.result.split(',')[1]; // Extract base64 part
            };

            if (fileInput.files.length > 0) {
                reader.readAsDataURL(fileInput.files[0]);
            }
        }
    </script>
</head>
<body>

    <div class="container">
        <h1>Create a New Post in ${community.name}</h1>
        <hr>

        <form action="${pageContext.request.contextPath}/faculty/community/post" method="post">
            <input type="hidden" name="communityId" value="${community.communityId}" />

            <div>
                <label for="content">Post Content:</label>
                <textarea id="content" name="content" rows="4" cols="50" required></textarea>
            </div>

            <div>
                <label for="attachment">Upload Image:</label>
                <input type="file" id="attachment" name="attachment" accept="image/*" onchange="convertImageToBase64()" />
            </div>

            <input type="hidden" id="photoBase64" name="photoBase64" value="" />

            <div>
                <button type="submit">Submit Post</button>
            </div>
        </form>
    </div>

</body>
</html>

