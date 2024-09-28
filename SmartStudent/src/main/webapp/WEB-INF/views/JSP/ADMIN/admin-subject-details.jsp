<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject Details</title>
   <%--  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/admin.css' />"> --%>
</head>
<body>

    <!-- Navigation or breadcrumb -->
    <div class="breadcrumb">
        <a href="<c:url value='/admin/dashboard'/>">Dashboard</a> &gt;
        <a href="<c:url value='/admin/subjects'/>">Subjects</a> &gt;
        Subject Details
    </div>

    <div class="container">
        <h1>Subject Details</h1>

        <!-- Subject details -->
        <div class="subject-details">
            <table class="details-table">
                <tr>
                    <th>Subject ID:</th>
                    <td>${subject.subjectId}</td>
                </tr>
                <tr>
                    <th>Name:</th>
                    <td>${subject.name}</td>
                </tr>
                <tr>
                    <th>Code:</th>
                    <td>${subject.code}</td>
                </tr>
                <tr>
                    <th>Description:</th>
                    <td>${subject.description}</td>
                </tr>
                <tr>
                    <th>Course:</th>
                    <td>${subject.course.name}</td>
                </tr>
                <tr>
                    <th>Specialization:</th>
                    <td>${subject.course.specialization}</td>
                </tr>
            </table>
        </div>

        <!-- Action buttons -->
        <div class="actions">
            <a href="<c:url value='/admin/subjects/${subject.subjectId}/edit' />" class="btn btn-primary">Edit</a>
            <a href="<c:url value='/admin/subjects/${subject.subjectId}/delete' />" 
               class="btn btn-danger" 
               onclick="return confirm('Are you sure you want to delete this subject?');">Delete</a>
            <a href="<c:url value='/admin/subjects' />" class="btn btn-secondary">Back to List</a>
        </div>
    </div>

</body>
</html>
