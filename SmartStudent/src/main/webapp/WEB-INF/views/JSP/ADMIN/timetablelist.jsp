<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Timetable List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Timetable List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Subject</th>
                <th>Day</th>
                <th>Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="timetable" items="${timetables}">
                <tr>
                    <td>${timetable.id}</td>
                    <td>${timetable.subject}</td>
                    <td>${timetable.day}</td>
                    <td>${timetable.time}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/timetable/showFormForUpdate?timetableId=${timetable.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/timetable/delete?timetableId=${timetable.id}" onclick="return confirm('Are you sure you want to delete this timetable?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/timetable/showFormForAdd">Add New Timetable</a>
</body>
</html>
