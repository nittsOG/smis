<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Faculty Details</title>
    <style>
        /* Styling for the image */
        .faculty-photo {
            width: 150px; /* Set the width of the image */
            height: auto; /* Maintain aspect ratio */
            display: block; /* Make the image a block element */
            margin: 10px auto; /* Center the image */
        }
    </style>
</head>
<body>
    <h1>Faculty Details</h1>
    <p>ID: ${faculty.facultyId}</p>
    <p>Username: ${faculty.username}</p>
    <p>Email: ${faculty.email}</p>
    <p>Phone: ${faculty.phone}</p>
    <p>Department: ${faculty.department.name}</p>
    <p>Position: ${faculty.position}</p>
    <p>Date of Birth: ${faculty.dateOfBirth}</p>
    <p>Gender: ${faculty.gender}</p>
    <p>Nationality: ${faculty.nationality}</p>
    
    <!-- Check if photoBase64 is present, otherwise show an alternative -->
    <c:choose>
        <c:when test="${faculty.photo != null}">
            <p>
                Photo: <img src="data:image/jpeg;base64,${faculty.photo}" alt="Faculty Photo" class="faculty-photo" />
            </p>
        </c:when>
        <c:otherwise>
            <p>
                Photo: <img src="${pageContext.request.contextPath}/resources/images/default-photo.jpg" alt="Default Faculty Photo" class="student-photo" />
            </p>
        </c:otherwise>
    </c:choose>

    <h2>Address</h2>
    <p>Street: ${faculty.facultyAddress.street}</p>
    <p>City: ${faculty.facultyAddress.city}</p>
    <p>State: ${faculty.facultyAddress.state}</p>
    <p>Country: ${faculty.facultyAddress.country}</p>
    <p>Zip Code: ${faculty.facultyAddress.zipCode}</p>

    <p>
        <a href="${pageContext.request.contextPath}/admin/faculty">Back to Faculty List</a>
    </p>
</body>
</html>
