<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Division</title>
</head>
<body>
    <h1>New Division</h1>
    <form action="${pageContext.request.contextPath}/admin/divisions/new" method="post">
        <p>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required/>
        </p>
        <p>
            <label for="department">Department:</label>
            <select id="department" name="departmentId" required>
                <option value="">Select Department</option>
                <c:forEach var="department" items="${departments}">
                    <option value="${department.departmentId}">${department.name}</option>
                </c:forEach>
            </select>
        </p>
        <button type="submit">Save</button>
        <a href="${pageContext.request.contextPath}/admin/divisions">Cancel</a>
    </form>
</body>
</html>
