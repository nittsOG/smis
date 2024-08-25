<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payments List</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Payments List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Student ID</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="payment" items="${payments}">
                <tr>
                    <td>${payment.id}</td>
                    <td>${payment.amount}</td>
                    <td>${payment.date}</td>
                    <td>${payment.studentId}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/payments/${payment.id}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/payments/${payment.id}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/payments/${payment.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/admin/payments/new">Add New Payment</a>
</body>
</html>
