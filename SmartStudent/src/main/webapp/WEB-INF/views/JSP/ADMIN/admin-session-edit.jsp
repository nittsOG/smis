<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Session</title>
</head>
<body>
    <h1>Edit Session</h1>
    <form action="${pageContext.request.contextPath}/admin/sessions/${session.id}/edit" method="post">
        <input type="hidden" name="id" value="${session.id}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${session.name}" required /><br>
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" value="${session.startDate}" required /><br>
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" value="${session.endDate}" required /><br>
        <button type="submit">Update Session</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/sessions">Back to List</a>
</body>
</html>
