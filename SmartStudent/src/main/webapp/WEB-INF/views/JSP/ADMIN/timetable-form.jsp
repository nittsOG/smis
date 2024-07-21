<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Timetable Form</title>
</head>
<body>
    <h1>Timetable Form</h1>
    <form action="${pageContext.request.contextPath}/admin/timetable/saveTimetable" method="post">
        <input type="hidden" name="id" value="${timetable.id}" />
        
        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" value="${timetable.subject}" required /><br>
        
        <label for="day">Day:</label>
        <input type="text" id="day" name="day" value="${timetable.day}" required /><br>
        
        <label for="time">Time:</label>
        <input type="text" id="time" name="time" value="${timetable.time}" required /><br>
        
        <button type="submit">Save Timetable</button>
    </form>
    
    <a href="${pageContext.request.contextPath}/admin/timetable/list">Back to List</a>
</body>
</html>
