<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Subject Form</title>
</head>
<body>
    <h1>Subject Form</h1>
    <form action="${pageContext.request.contextPath}/admin/subject/saveSubject" method="post">
        <input type="hidden" name="id" value="${subject.id}" />
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${subject.name}" required /><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description">${subject.description}</textarea><br>
        
        <button type="submit">Save Subject</button>
    </form>
    
    <a href="${pageContext.request.contextPath}/admin/subject/list">Back to List</a>
</body>
</html>
