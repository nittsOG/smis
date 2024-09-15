<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Faculty Profile</title>
</head>
<body>
    <h2>Edit Profile Information</h2>
    <form action="${pageContext.request.contextPath}/faculty/profile/update" method="POST">
        <label for="username">Name:</label>
        <input type="text" id="username" name="username" value="${faculty.username}" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${faculty.email}" required>
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${faculty.phone}" required>

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
</body>
</html>
