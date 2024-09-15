<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Faculty Profile</title>
</head>
<body>
    <h2>Profile Information</h2>
    
    <!-- Display faculty photo if available -->
    <c:if test="${not empty photoBase64}">
        <img src="data:image/jpeg;base64,${photoBase64}" alt="Faculty Photo" style="max-width: 200px;">
    </c:if>

    <p><strong>Name:</strong> ${faculty.username}</p>
    <p><strong>Email:</strong> ${faculty.email}</p>
    <p><strong>Phone:</strong> ${faculty.phone}</p>

    <h3>Address Information</h3>
    <p><strong>Street:</strong> ${faculty.facultyAddress.street}</p>
    <p><strong>City:</strong> ${faculty.facultyAddress.city}</p>
    <p><strong>State:</strong> ${faculty.facultyAddress.state}</p>
    <p><strong>Country:</strong> ${faculty.facultyAddress.country}</p>
    <p><strong>Zip Code:</strong> ${faculty.facultyAddress.zipCode}</p>

    <a href="${pageContext.request.contextPath}/faculty/profile/edit">Edit Profile</a>
    <a href="${pageContext.request.contextPath}/faculty/dashboard">Back TO Dashboard</a>
</body>
</html>
