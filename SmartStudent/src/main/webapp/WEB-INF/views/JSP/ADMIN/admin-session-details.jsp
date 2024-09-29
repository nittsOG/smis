<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Session Details</title>
</head>
<body>
    <h1>Session Details</h1>

    <p><strong>Date:</strong> ${session.sessionDate}</p>
    <p><strong>Type:</strong> ${session.sessionType}</p>
    <p><strong>Subject:</strong> ${session.subject.name}</p>
    <p><strong>Division ID:</strong> ${session.division_Id}</p>
    <p><strong>Faculty ID:</strong> ${session.faculty_Id}</p>
    <p><strong>Start Time:</strong> ${session.startTime}</p>
    <p><strong>End Time:</strong> ${session.endTime}</p>

    <a href="${pageContext.request.contextPath}/admin/sessions">Back to List</a>
</body>
</html>
