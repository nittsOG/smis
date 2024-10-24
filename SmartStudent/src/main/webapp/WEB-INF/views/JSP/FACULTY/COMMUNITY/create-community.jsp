<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Community</title>
    <style>
        body {
            font-family: Arial, sans-serif; /* Set a clean and readable font */
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */ /* Light background */
            color: white;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.3); /* White background for the container */
            max-width: 700px; /* Set a max-width to center the form */
            margin: 20px auto; /* Center the container */
            padding: 20px; /* Add padding inside the container */
            border-radius: 10px; /* Rounded corners */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
        }

        h1 {
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            font-size: 2.2rem;/* Larger font size for better visibility */
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
            display: block; /* Display label as block */
            font-weight: bold; /* Bold labels */
            margin-bottom: 5px; /* Space below label */
            
        }

        input[type="text"], textarea {
            width: 100%; /* Full width input and textarea */
            padding: 10px;
            margin-bottom: 15px; /* Space below inputs */
            border: 1px solid #ccc; /* Light border */
            border-radius: 5px; /* Rounded corners */
            box-sizing: border-box; /* Ensure padding is included in width */
            font-size: 14px;
        }

        textarea {
            height: 100px; /* Set a default height for the textarea */
            resize: vertical; /* Allow vertical resizing */
        }

        button {
            width: 100%; /* Full width button */
            background-color: #007bff; /* Blue background */
            color: white; /* White text */
            padding: 10px;
            border: none; /* Remove border */
            border-radius: 5px; /* Rounded button */
            font-size: 16px; /* Larger button text */
            cursor: pointer; /* Pointer cursor on hover */
        }

        button:hover {
            background-color: #2a3e50; /* Darker blue on hover */
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Create New Community</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/faculty/community/create" method="post">
            <!-- Community Name -->
            <label for="name">Community Name:</label>
            <input type="text" name="name" id="name" required>

            <!-- Description -->
            <label for="description">Description:</label>
            <textarea name="description" id="description" required></textarea>

            <!-- Submit Button -->
            <button type="submit">Create Community</button>
        </form>
    </div>

</body>
</html>
