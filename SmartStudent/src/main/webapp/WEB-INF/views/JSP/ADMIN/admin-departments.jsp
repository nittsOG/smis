<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Departments</title>
</head>
<body>
    <h2>Departments</h2>
    
    <!-- Filter Form -->
    <form action="<c:url value='/admin/departments'/>" method="get">
        <label for="departmentFilter">Filter by Department:</label>
        <select id="departmentFilter" name="search">
            <option value="">-- Select Department --</option>
            <c:forEach var="departmentOption" items="${departments}">
                <option value="${departmentOption.name}" <c:if test="${param.search == departmentOption.name}">selected</c:if>>${departmentOption.name}</option>
            </c:forEach>
        </select>
        
        <label for="fieldFilter">Filter by Field:</label>
        <select id="fieldFilter" name="field">
            <option value="">-- Select Field --</option>
            <c:forEach var="fieldOption" items="${fields}">
                <option value="${fieldOption}" <c:if test="${param.field == fieldOption}">selected</c:if>>${fieldOption}</option>
            </c:forEach>
        </select>
        
        <button type="submit">Filter</button>
    </form>
    
    <a href="<c:url value='/admin/departments/new'/>">Add New Department</a>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Field</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="department" items="${departments}">
                <tr>
                    <td>${department.departmentId}</td>
                    <td>${department.name}</td>
                    <td>${department.description}</td>
                    <td>${department.field}</td>
                    <td>
                        <a href="<c:url value='/admin/departments/${department.departmentId}'/>">View</a> | 
                        <a href="<c:url value='/admin/departments/${department.departmentId}/edit'/>">Edit</a> | 
                        <a href="<c:url value='/admin/departments/${department.departmentId}/delete'/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
