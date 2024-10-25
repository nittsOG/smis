<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Faculty Subjects</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            body {
                font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
                margin: 0;
                padding: 0;
                color: #333;
                background: linear-gradient(to right, #f5f5f5, #dfe6e9);
            }

            /* Navbar styling */
            .navbar {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 15px 25px;
                background: #5a1fa7;
                color: white;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                position: sticky;
                top: 0;
                z-index: 1000;
            }

            .navbar h2 {
                font-size: 1.5rem;
                margin: 0;
            }

            .navbar i {
                margin-right: 5px;
            }

            /* Logout button styling */
            .logout-button {
                display: flex;
                align-items: center;
                background: #d63031;
                padding: 8px 15px;
                border-radius: 5px;
                color: white;
                text-decoration: none;
                transition: background 0.3s ease, transform 0.3s ease;
            }

            .logout-button:hover {
                background: #e17055;
                transform: translateY(-2px) scale(1.05);
            }

            .logout-button i {
                margin-right: 5px;
            }

            .container {
                padding: 20px;
            }

            /* Form styling */
            form {
                background: #ffffff;
                padding: 15px;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
                align-items: center;
            }

            form label {
                flex: 0 0 170px;
                font-weight: bold;
                margin-bottom: 2px;
                font-size: 1rem;
            }

            form select,
            form button {
                flex: 1;
                min-width: 100px;
                max-width: 150px;
                padding: 8px;
                border: 1px solid #ddd;
                border-radius: 5px;
                font-size: 0.9rem;
            }

            form button,
            form a {
                background: #6154c4;

                color: white;
                cursor: pointer;
                padding: 8px 16px;
                border: none;
                border-radius: 5px;
                text-decoration: none;
                transition: background 0.3s ease, transform 0.3s ease;
                margin-left: 5px;
                width: 80px;
                text-align: center;
                font-size: 0.9rem;
            }

            form button:hover,
            form a:hover {
                background: #5a1fa7;
                transform: translateY(-2px);
            }

            /* Table styling */
            .table-container {
                overflow-x: auto;
                position: relative;
                margin-top: 20px;
                /* Optional: space above the table */
                -ms-overflow-style: none;
                /* Hide scrollbar for Internet Explorer and Edge */
                scrollbar-width: none;
                /* Hide scrollbar for Firefox */
            }

            .table-container::-webkit-scrollbar {
                display: none;
                /* Hide scrollbar for Chrome, Safari, and other WebKit browsers */
            }

            table {
                width: 100%;
                min-width: 600px;
                /* Minimum width for the table */
                border-collapse: collapse;
                background: #ffffff;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                position: relative;
                /* For responsive positioning */
            }

            table th,
            table td {
                padding: 10px;
                border: 1px solid #ddd;
                text-align: center;
                font-size: 1rem;
            }

            table th {
                background: #6c5ce7;
                color: #ffffff;
                font-size: 1.2rem;
            }

            table tbody tr:nth-child(even) {
                background-color: #f0f0f0;
            }

            /* Action Buttons */
            .action-links {
                display: flex;
                justify-content: center;
                gap: 10px;
                /* Adds space between the buttons */
                flex-wrap: nowrap;
                /* Prevents the buttons from wrapping */
            }

            .action-links a {
                display: inline-flex;
                /* Aligns icon and text side by side */
                align-items: center;
                /* Vertically centers the content */
                padding: 5px 10px;
                border-radius: 5px;
                font-weight: bold;
                text-decoration: none;
                color: white;
                transition: transform 0.3s ease, background-color 0.3s ease;
                background-color: #6c5ce7;
                /* Default background for all buttons */
            }

            .action-links .view-btn {
                background-color: #6c5ce7;
            }

            .action-links .edit-btn {
                background-color: #00b894;
            }

            .action-links .delete-btn {
                background-color: #b33636;
            }

            .action-links a:hover {
                transform: translateY(-3px);
            }

            .action-links .view-btn:hover {
                background-color: #5a1fa7;
            }

            .action-links .edit-btn:hover {
                background-color: #006d50;
            }

            .action-links .delete-btn:hover {
                background-color: #d11b1b;
            }

            /* Add new course link styling */
            .add-link {
                background: #6154c4;

                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                text-decoration: none;
                display: inline-block;
                margin-top: 20px;
                transition: background 0.3s ease, transform 0.3s ease;
            }

            .add-link:hover {
                background: #5a1fa7;
                transform: translateY(-2px);
            }

            /* Media Queries for Responsive Design */
            @media (max-width: 768px) {
                .navbar h2 {
                    font-size: 1.2rem;
                }

                .logout-button {
                    padding: 6px 10px;
                    font-size: 0.85rem;
                }

                form label {
                    flex: 0 0 120px;
                    font-size: 0.85rem;
                }

                form select,
                form button {
                    font-size: 0.85rem;
                    padding: 5px;
                }

                table th,
                table td {
                    font-size: 0.9rem;
                }
            }

            @media (max-width: 480px) {
                .navbar h2 {
                    font-size: 1rem;
                }

                .logout-button {
                    padding: 5px 8px;
                    font-size: 0.8rem;
                }

                form label {
                    flex: 0 0 100px;
                    font-size: 0.8rem;
                }

                form select,
                form button {
                    font-size: 0.8rem;
                    padding: 4px;
                }

                table th,
                table td {
                    font-size: 0.85rem;
                }
            }
        </style>
    </head>

    <body>

        <div class="navbar">
            <h2><i class="bx bx-book"></i> Faculty Subjects</h2>


            <a href="${pageContext.request.contextPath}/admin/logout" class="logout-button">
                <i class="fas fa-sign-out-alt"></i> Logout
            </a>
        </div>

        <div class="container">
            <form action="${pageContext.request.contextPath}/admin/facultySubjects" method="get">
                <label for="facultyId">Filter by Faculty ID:</label> <input type="text" id="facultyId" name="facultyId"
                    value="${param.facultyId}">
                <button type="submit">Filter</button>
                <a href="${pageContext.request.contextPath}/admin/facultySubjects">Clear
                    Filter</a>
            </form>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Faculty Subject ID</th>
                            <th>Faculty ID</th>
                            <th>Faculty Name</th>
                            <th>Subject Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="facultySubject" items="${facultySubjects}">
                            <tr>
                                <td>${facultySubject.facultySubjectId}</td>
                                <td>${facultySubject.faculty.facultyId}</td>
                                <td>${facultySubject.faculty.username}</td>
                                <td>${facultySubject.subject.name}</td>
                                <td class="action-links"><a
                                        href="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.facultySubjectId}"
                                        class="view-btn">
                                        <i class="fas fa-eye"></i> View</a>
                                    <a href="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.facultySubjectId}/edit"
                                        class="edit-btn">
                                        <i class="fas fa-edit"></i> Edit
                                    </a></a>
                                    <a href="${pageContext.request.contextPath}/admin/facultySubjects/${facultySubject.facultySubjectId}/delete"
                                        onclick="return confirm('Are you sure, you want to delete?')"
                                        class="delete-btn">
                                        <i class="fas fa-trash-alt"></i> Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <a href="${pageContext.request.contextPath}/admin/facultySubjects/new" class="add-link">
                <i class="fas fa-plus-circle"></i> Add New Faculty Division</a>
        </div>
    </body>

    </html>
