<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Timetable Details</title>
</head>
<body>
    <h1>Timetable Details</h1>

    <p><strong>Subject:</strong> ${timetable.subject.name}</p>
    <p><strong>Faculty:</strong> ${timetable.faculty.username}</p>
    <p><strong>Division:</strong> ${timetable.division.name}</p>
    <p><strong>Day of Week:</strong> ${timetable.dayOfWeek}</p>
    <p><strong>Start Time:</strong> ${timetable.startTime}</p>
    <p><strong>End Time:</strong> ${timetable.endTime}</p>

    <a href="${pageContext.request.contextPath}/manager/timetables">Back to Timetable List</a>
</body>
</html>
