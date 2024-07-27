<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
    <style>
        .scrollable-table {
            max-height: 400px;
            overflow-y: scroll;
        }
        th, td {
            padding: 8px 12px;
        }
    </style>
</head>
<body>
    <h1>Students</h1>
    <form method="GET" action="${pageContext.request.contextPath}/admin/students">
        <label for="studentId">Search by ID:</label>
        <input type="text" id="studentId" name="studentId" value="${param.studentId}" />
        
        <label for="division">Filter by Division:</label>
        <select id="division" name="division">
            <option value="">--All--</option>
            <c:forEach var="division" items="${divisions}">
                <option value="${division.name}" <c:if test="${division.name == param.division}">selected</c:if>>${division.name}</option>
            </c:forEach>
        </select>

        <label for="department">Filter by Department:</label>
        <select id="department" name="department">
            <option value="">--All--</option>
            <c:forEach var="department" items="${departments}">
                <option value="${department.name}" <c:if test="${department.name == param.department}">selected</c:if>>${department.name}</option>
            </c:forEach>
        </select>
        
        <button type="submit">Search</button>
    </form>
    <div class="scrollable-table">
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Division</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.username}</td>
                        <td>${student.email}</td>
                        <td>${student.division.name}</td>
                        <td>${student.division.department.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/students/${student.studentId}">Details</a>
                            <a href="${pageContext.request.contextPath}/admin/students/${student.studentId}/edit">Edit</a>
                            <a href="${pageContext.request.contextPath}/admin/students/${student.studentId}/delete" onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
