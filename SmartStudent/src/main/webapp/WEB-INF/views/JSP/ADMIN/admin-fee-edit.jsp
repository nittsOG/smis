<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Fee</title>
    <script>
        <c:if test="${not empty alert}">
            alert("${alert}");
        </c:if>
    </script>
</head>
<body>
    <h1>Edit Fee</h1>
    <form action="${pageContext.request.contextPath}/admin/fees/${fee.id}/edit" method="post">
        <input type="hidden" name="id" value="${fee.id}" />
        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" value="${fee.amount}" required /><br>
        <label for="dueDate">Due Date:</label>
        <input type="date" id="dueDate" name="dueDate" value="${fee.dueDate}" required /><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" value="${fee.status}" required /><br>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/fees">Back to List</a>
</body>
</html>
