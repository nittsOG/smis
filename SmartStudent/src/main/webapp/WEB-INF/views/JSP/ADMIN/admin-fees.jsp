<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fees List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Fees List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Amount</th>
                <th>Due Date</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="fee" items="${fees}">
                <tr>
                    <td>${fee.id}</td>
                    <td>${fee.amount}</td>
                    <td>${fee.dueDate}</td>
                    <td>${fee.status}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/fees/${fee.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/admin/fees/${fee.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/fees/${fee.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/fees/new">Add New Fee</a>
</body>
</html>
