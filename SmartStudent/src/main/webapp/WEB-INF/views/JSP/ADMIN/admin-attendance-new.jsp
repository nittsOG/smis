<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin - New Attendance</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            /* General styling */
            body {
                font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
                margin: 0;
                padding: 0;
                background: linear-gradient(to right, #f5f5f5, #dfe6e9);
                color: #333;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }

            h2 {
                text-align: center;
                color: #6c5ce7;
                margin-top: 10px;
                font-size: 2rem;
            }

            .container {

                max-width: 600px;
                width: 100%;
                /* Ensures full width */
                min-width: 200px;
                padding: 25px;
                background: #ffffff;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                transition: transform 0.3s ease;
            }

            .container:hover {
                transform: translateY(-5px);
                box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
            }

            /* Table-like layout for form fields */
            .row {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 15px;
                font-size: 1.1rem;
                padding: 10px;
                border: 1px solid #e0e0e0;
                border-radius: 5px;
                background-color: #f9f9f9;
            }

            .label {
                width: 30%;
                font-weight: bold;
                display: flex;
                align-items: center;
                color: #444;
            }

            .label i {
                margin-right: 8px;
                color: #6c5ce7;
                font-size: 1.2rem;
            }

            .value {
                width: 70%;
                font-size: 1rem;
            }

            .value input,
            .value select {
                width: 90%;
                padding: 10px;
                border: 1px solid #e0e0e0;
                border-radius: 5px;
            }

            /* Button styling */
            .status {
                display: flex;
                justify-content: space-between;
            }

            .select {
                width: 70%;
                font-size: 1rem;
            }

            .select select {
                width: 30%;
                /* Increased width of the select box */
                padding: 8px;
                border: 1px solid #e0e0e0;
                border-radius: 5px;
                font-size: 1rem;
            }

            button,
            .link {
                display: inline-flex;
                align-items: center;
                justify-content: center;
                padding: 10px 20px;
                margin: 10px 5px;
                background-color: #6c5ce7;
                color: white;
                border: none;
                text-decoration: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 1rem;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            button:hover,
            .link:hover {
                background-color: #5a1fa7;
                transform: translateY(-2px);
            }

            button i,
            .link i {
                margin-right: 8px;
            }

            .link {
                background-color: #e17055;
            }

            .link:hover {
                background-color: #d63031;
            }


            /* Responsive styling */
            @media (max-width: 768px) {
                .container {
                    width: 90%;
                    margin: 30px auto;
                    padding: 20px;
                }

                h2 {
                    font-size: 1.6rem;
                }

                .row {
                    flex-direction: column;
                    align-items: flex-start;
                }

                .label,
                .value {
                    width: 100%;
                    margin-bottom: 5px;
                }

                button {
                    padding: 8px 15px;
                    font-size: 0.9rem;
                }
            }

            @media (max-width: 576px) {
                h2 {
                    font-size: 1.4rem;
                }

                button {
                    padding: 6px 12px;
                    font-size: 0.85rem;
                }
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h2><i class="fas fa-plus-circle"></i> New Attendance</h2>
            <form action="${pageContext.request.contextPath}/admin/attendances/new" method="post">
                <div class="row">
                    <div class="label">
                        <i class="fas fa-id-card"></i> Session ID:
                    </div>
                    <div class="value">
                        <input type="text" id="session" name="session.sessionId" />
                    </div>
                </div>

                <div class="row">
                    <div class="label">
                        <i class="fas fa-user"></i> Student ID:
                    </div>
                    <div class="value">
                        <input type="text" id="student" name="student.studentId" />
                    </div>
                </div>

                <div class="row">
                    <div class="label">
                        <i class="fas fa-check-circle"></i> Status:
                    </div>
                    <div class="select">
                        <select id="status" name="status">
                            <option value="PRESENT">Present</option>
                            <option value="ABSENT">Absent</option>
                            <option value="EXCUSED">Excused</option>
                        </select>
                    </div>
                </div>
            </form>

            <div class="status">
                <button type="submit"><i class="fas fa-save"></i> Save</button>
                <a class="link" href="${pageContext.request.contextPath}/admin/attendances"><i
                        class="fas fa-arrow-left"></i> Back </a>
            </div>
        </div>
    </body>

    </html>
