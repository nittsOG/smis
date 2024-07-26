<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>${faculty.facultyId == null ? "New Faculty" : "Edit Faculty"}</title>
</head>
<body>
    <h1>${faculty.facultyId == null ? "New Faculty" : "Edit Faculty"}</h1>
    <form action="${pageContext.request.contextPath}/admin/faculty/${faculty.facultyId == null ? "save" : "update"}" method="post">
        <input type="hidden" name="facultyId" value="${faculty.facultyId}"/>
        <p>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${faculty.username}" required/>
        </p>
        <p>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${faculty.password}" required/>
        </p>
        <p>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${faculty.email}" required/>
        </p>
        <p>
            <label for="department">Department:</label>
            <select id="department" name="department.id">
                <c:forEach var="dept" items="${departments}">
                    <option value="${dept.departmentId}" ${dept.departmentId == faculty.department.departmentId ? "selected" : ""}>${dept.name}</option>
                </c:forEach>
            </select>
        </p>
        <button type="submit">${faculty.facultyId == null ? "Save" : "Update"}</button>
        <a href="${pageContext.request.contextPath}/admin/faculty/list">Cancel</a>
    </form>
</body>
</html>
