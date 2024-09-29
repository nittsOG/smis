<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faculty Subject Details</title>
</head>
<body>
    <h1>Faculty Subject Details</h1>

    <div class="faculty-subject-details">
        <h2>Faculty Details</h2>
        <p><strong>Faculty Name:</strong> ${facultySubject.faculty.username}</p>
        <p><strong>Email:</strong> ${facultySubject.faculty.email}</p>
        <p><strong>Phone:</strong> ${facultySubject.faculty.phone}</p>
        <p><strong>Position:</strong> ${facultySubject.faculty.position}</p>
        <p><strong>Department:</strong> ${facultySubject.faculty.department.name}</p>
        
        <h2>Subject Details</h2>
        <p><strong>Subject Name:</strong> ${facultySubject.subject.name}</p>
        <p><strong>Subject Code:</strong> ${facultySubject.subject.code}</p>
        <p><strong>Description:</strong> ${facultySubject.subject.description}</p>
    </div>

    <a href="${pageContext.request.contextPath}/admin/facultySubjects">Back to Faculty Subjects List</a>
</body>
</html>
