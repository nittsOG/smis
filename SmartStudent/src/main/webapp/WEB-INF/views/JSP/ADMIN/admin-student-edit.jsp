<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Edit Student</title>
    <style>
        /* Styling for the image preview */
        .photo-preview {
            width: 150px;  /* Set the width of the image */
            height: auto;  /* Maintain aspect ratio */
            display: block;  /* Make the image a block element */
            margin: 10px auto;  /* Center the image */
        }
    </style>
    <script type="text/javascript">
        function encodeImageFileAsBase64() {
            var file = document.getElementById("photo").files[0];
            var reader = new FileReader();
            
            reader.onloadend = function() {
                document.getElementById("photoBase64").value = reader.result;
                // Display the preview image
                document.getElementById("photoPreview").src = reader.result;
            }
            
            if (file) {
                reader.readAsDataURL(file);
            }
        }
    </script>
</head>
<body>
    <h1>Edit Student</h1>
    <form action="${pageContext.request.contextPath}/admin/students/${student.studentId}/edit" method="post">
        <p>Username: <input type="text" name="username" value="${student.username}" required /></p>
        <p>Password: <input type="password" name="password" value="${student.password}" required /></p>
        <p>Email: <input type="email" name="email" value="${student.email}" required /></p>

        <h2>Address Information</h2>
        <p>Street: <input type="text" name="address.street" value="${address.street}" required /></p>
        <p>City: <input type="text" name="address.city" value="${address.city}" required /></p>
        <p>State: <input type="text" name="address.state" value="${address.state}" required /></p>
        <p>Country: <input type="text" name="address.country" value="${address.country}" required /></p>
        <p>Zip Code: <input type="text" name="address.zipCode" value="${address.zipCode}" required /></p>

        <h2>Division Information</h2>
        <p>Division: 
            <select name="division.divisionId" required>
                <c:forEach var="division" items="${divisions}">
                    <option value="${division.divisionId}" ${division.divisionId == student.division.divisionId ? 'selected' : ''}>${division.name}</option>
                </c:forEach>
            </select>
        </p>

        <!-- Additional Student Details -->
        <h2>Additional Student Information</h2>
        <p>Date of Birth: <input type="date" name="dateOfBirth" value="${student.dateOfBirth}" required /></p>
        <p>Contact Number: <input type="text" name="contactNumber" value="${student.contactNumber}" required /></p>
        <p>Guardian Name: <input type="text" name="guardianName" value="${student.guardianName}" required /></p>
        <p>Guardian Contact: <input type="text" name="guardianContact" value="${student.guardianContact}" required /></p>
        <p>Nationality: <input type="text" name="nationality" value="${student.nationality}" required /></p>
        <p>Enrollment Date: <input type="date" name="enrollmentDate" value="${student.enrollmentDate}" required /></p>
        <p>Status: 
            <select name="status" required>
                <option value="Active" ${student.status == 'Active' ? 'selected' : ''}>Active</option>
                <option value="Inactive" ${student.status == 'Inactive' ? 'selected' : ''}>Inactive</option>
            </select>
        </p>

        <!-- File input for image, not using multipart -->
        <h2>Photo</h2>
        <p>Photo: <input type="file" id="photo" onchange="encodeImageFileAsBase64()" accept="image/*" /></p>
        <input type="hidden" id="photoBase64" name="photoBase64" />
        <!-- Preview Image -->
        <img id="photoPreview" src="#" alt="Photo Preview" class="photo-preview" />

        <button type="submit">Update</button>
    </form>
</body>
</html>
