<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Semester Subjects</title>
</head>
<body>
    <h2>Semester Subjects List</h2>

    <!-- Filter Form -->
    <form action="${pageContext.request.contextPath}/admin/semester-subjects" method="get">
        <label for="subjectFilter">Filter by Subject:</label>
        <select id="subjectFilter" name="subjectId">
            <option value="">All Subjects</option>
            <c:forEach items="${subjects}" var="subject">
                <option value="${subject.subjectId}" ${param.subjectId == subject.subjectId ? 'selected' : ''}>
                    ${subject.name}
                </option>
            </c:forEach>
        </select>
        <button type="submit">Filter</button>
    </form>

    <!-- Semester Subjects List -->
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>SemesterID</th>
                <th>Semester</th>
                <th>Subject</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${semesterSubjects}" var="semesterSubject">
                <tr>
                    <td>${semesterSubject.semesterSubjectId}</td>
                    <td>${semesterSubject.semester.semesterId}</td>
                    <td>${semesterSubject.semester.name}</td>
                    <td>${semesterSubject.subject.name}</td>
                    <td>
                    <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.semesterSubjectId}">View</a>
                        <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.semesterSubjectId}/edit">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/semester-subjects/${semesterSubject.semesterSubjectId}/delete" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
     <a href="${pageContext.request.contextPath}/admin/semester-subjects/new">Add New</a>
</body>
</html>
