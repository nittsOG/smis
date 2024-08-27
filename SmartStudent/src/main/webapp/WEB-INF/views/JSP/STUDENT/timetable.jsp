<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Your Timetable</h2>

<table border="1">
    <thead>
        <tr>
            <th>Day</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Subject</th>
            <th>Faculty</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="timetable" items="${timetable}">
            <tr>
                <td>${timetable.dayOfWeek}</td>
                <td>${timetable.startTime}</td>
                <td>${timetable.endTime}</td>
                <td>${timetable.subject.name}</td>
                <td>${timetable.faculty.username}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
