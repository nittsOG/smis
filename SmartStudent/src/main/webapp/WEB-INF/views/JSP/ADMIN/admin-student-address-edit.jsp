<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Edit Student Address</title>
</head>
<body>
    <h1>Edit Student Address</h1>
    <form action="${pageContext.request.contextPath}/admin/students/${student.studentId}/address/edit" method="post">
        <p>Address Line 1: <input type="text" name="addressLine1" value="${studentAddress.addressLine1}" required /></p>
        <p>Address Line 2: <input type="text" name="addressLine2" value="${studentAddress.addressLine2}" /></p>
        <p>City: <input type="text" name="city" value="${studentAddress.city}" required /></p>
        <p>State: <input type="text" name="state" value="${studentAddress.state}" required /></p>
        <p>Country: <input type="text" name="country" value="${studentAddress.country}" required /></p>
        <p>Postal Code: <input type="text" name="postalCode" value="${studentAddress.postalCode}" required /></p>
        <p><input type="submit" value="Save" /></p>
    </form>
    <p><a href="${pageContext.request.contextPath}/admin/students">Back to Students List</a></p>
</body>
</html>
