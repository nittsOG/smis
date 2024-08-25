<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Session</title>
</head>
<body>
    <h1>New Session</h1>
    <form action="${pageContext.request.contextPath}/admin/sessions/new" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required /><br>
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required /><br>
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required /><br>
        <button type="submit">Save Session</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/sessions">Back to List</a>
</body>
</html>
