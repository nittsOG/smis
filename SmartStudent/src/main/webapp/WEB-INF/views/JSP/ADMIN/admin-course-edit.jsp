<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>
    <h1>Edit Course</h1>
    <form action="${pageContext.request.contextPath}/admin/courses/${course.courseId}/edit" method="post">
       <%--  <input type="hidden" name="id" value="${course.courseId}" /> --%>
       <p> ID : ${course.courseId} </p>

        <!-- Course Name -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${course.name}" required /><br>
        
        <!-- Course Name -->
        <label for="specialization">Specialization:</label>
        <input type="text" id="specialization" name="specialization" value="${course.specialization}" required /><br>

        <!-- Course Description -->
        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${course.description}</textarea><br>

        <!-- Department Dropdown -->
        <label for="department">Department:</label>
        <select id="department" name="department.departmentId" required>
            <option value="">-- Select Department --</option>
            <c:forEach var="department" items="${departments}">
                <option value="${department.departmentId}" <c:if test="${course.department != null && course.department.departmentId == department.departmentId}">selected</c:if>>
                    ${department.name}
                </option>
            </c:forEach>
        </select><br>

        <button type="submit">Update</button>
    </form>
    <a href="${pageContext.request.contextPath}/admin/courses">Back to List</a>
</body>
</html>
