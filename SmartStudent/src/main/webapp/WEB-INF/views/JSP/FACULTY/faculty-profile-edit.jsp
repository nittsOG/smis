<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Faculty Profile</title>
    <style>
        body {
            background: linear-gradient(to right, #1a1a2e, #16213e); /* Darker gradient */
            font-family: 'Segoe UI', sans-serif;
            color: white;
            margin: 0;
            padding: 20px; /* Padding around the body */
        }

        h2 {
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

        .container {
            max-width: 800px; /* Max width for the container */
            margin: 0 auto; /* Center the container */
            background-color: rgba(0, 0, 0, 0.3); /* Semi-transparent background */
            padding: 30px; /* Padding inside the container */
            border-radius: 8px; /* Rounded corners */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3); /* Shadow for depth */
        }

        .photo-preview {
            width: 150px; /* Fixed width for the photo preview */
            height: auto;
            display: block;
            margin: 10px auto; /* Center the photo preview */
            border-radius: 50%; /* Circular profile photo */
            border: 2px solid #007bff; /* Border around the photo */
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 22px); /* Full width minus padding */
            padding: 10px; /* Padding for input fields */
            margin: 10px 0; /* Space above and below inputs */
            border-radius: 4px; /* Rounded corners */
            border: 1px solid #007bff; /* Border color */
            background-color: #fff; /* White background for inputs */
            color: #000; /* Black text color */
        }

        button {
            background-color: #007bff; /* Button color */
            color: white; /* White text color */
            padding: 10px 15px; /* Padding for button */
            border-radius: 4px; /* Rounded corners */
            border: none; /* Remove border */
            cursor: pointer; /* Pointer cursor on hover */
            transition: background-color 0.3s; /* Transition for hover effect */
            display: block; /* Center button */
            margin: 20px auto; /* Center button with margin */
        }

        button:hover {
            background-color: #2a3e50; /* Darker shade on hover */
        }

        a {
            color: red; /* Highlight color for links */
            text-decoration: none; /* No underline */
            display:flex; /* Inline block for better spacing */
            margin: 10px auto; /* Space between links */
            text-align: center; /* Center text in links */
            align-items: center;
            justify-content: center;
        }

        a:hover {
            color: #ffc107; /* Underline on hover */
        }

        .success-message {
            color: white; /* Success message color */
            text-align: center; /* Centered success message */
            margin-top: 20px; /* Space above message*/
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
    <div class="container">
        <h2>Edit Profile Information</h2>
        <hr>
        <form action="${pageContext.request.contextPath}/faculty/profile/update" method="POST">
            <p>ID: ${faculty.facultyId}</p>
            <p>
                Username: <input type="text" name="username" value="${faculty.username}" required />
            </p>
            <p>
                Password: <input type="password" name="password" value="${faculty.password}" required />
            </p>
            <p>
                Email: <input type="email" name="email" value="${faculty.email}" required />
            </p>
            <p>Department: ${faculty.department.name}</p>
            <p>Position: ${faculty.position}</p>
            <p>Gender: ${faculty.gender}</p>
            <p>Nationality: ${faculty.nationality}</p>

            <p>
                Photo: <input type="file" id="photo" onchange="encodeImageFileAsBase64()" accept="image/*" />
            </p>
            <input type="hidden" id="photoBase64" name="photoBase64" />
            <!-- Preview Image -->
            <img id="photoPreview" src="#" alt="Photo Preview" class="photo-preview" />

            <h3>Address Information</h3>
            <label for="street">Street:</label>
            <input type="text" id="street" name="street" value="${faculty.facultyAddress.street}" required>

            <label for="city">City:</label>
            <input type="text" id="city" name="city" value="${faculty.facultyAddress.city}" required>

            <label for="state">State:</label>
            <input type="text" id="state" name="state" value="${faculty.facultyAddress.state}" required>

            <label for="country">Country:</label>
            <input type="text" id="country" name="country" value="${faculty.facultyAddress.country}" required>

            <label for="zipCode">Zip Code:</label>
            <input type="text" id="zipCode" name="zipCode" value="${faculty.facultyAddress.zipCode}" required>

            <button type="submit">Update Profile</button>
        </form>

        <a href="${pageContext.request.contextPath}/faculty/profile">Cancel</a>

        <c:if test="${not empty message}">
            <div class="success-message">${message}</div>
        </c:if>
    </div>
</body>
</html>
