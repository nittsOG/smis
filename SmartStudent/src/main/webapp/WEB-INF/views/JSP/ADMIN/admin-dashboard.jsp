<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Dashboard</title>
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
      }

      .navbar h2 {
        font-size: 1.5rem;
        margin: 0;
      }

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
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
      }

      .container:after {
        content: "";
        flex: 1 1 calc(50% - 40px);
        /* occupies half width like other sections */
        min-width: calc(50% - 40px);
        /* ensures it’s always half width */
      }

      .section {
        flex: 1 1 calc(50% - 40px);
        background: #ffffff;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
      }

      .section:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
      }

      /* Section Heading */
      .section h2 {
        font-size: 1.6rem;
        color: #ffffff;
        background: #6c5ce7;
        padding: 15px;
        margin: 0;
        border-radius: 8px 8px 0 0;
        display: flex;
        align-items: center;
      }

      /* Icon styling inside h2 */
      .section h2 i {
        margin-right: 10px;
      }

      .section ul {
        list-style: none;
        padding: 0;
        margin: 0;
      }

      .section li {
        background: #f0f0f0;
        margin: 8px 15px;
        padding: 12px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        transition: background-color 0.3s ease, transform 0.2s ease;
      }

      .section li:hover {
        background: #dfe6e9;
        transform: translateX(5px);
      }

      .section a {
        text-decoration: none;
        color: #0984e3;
        font-weight: bold;
        display: block;
      }

      .section li i {
        margin-right: 10px;
      }

      .section a.active {
        color: #6c5ce7;
        border-left: 3px solid #6c5ce7;
        padding-left: 12px;
      }



      /* Adjust font size for smaller screens */
      @media (max-width: 768px) {
        .navbar h2 {
          font-size: 1.2rem;
        }

        .logout-button {
          padding: 6px 10px;
          font-size: 0.9rem;
        }

        .section h2 {
          font-size: 1.3rem;
          padding: 12px;
        }

        .section li {
          padding: 10px;
          margin: 5px 10px;
        }

        .section a {
          font-size: 0.9rem;
        }

        .section li i {
          margin-right: 8px;
        }

        .container {
          flex-direction: column;
        }

        .section {
          flex: 1 1 100%;
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

        .section h2 {
          font-size: 1.1rem;
        }

        .section li {
          padding: 8px;
          margin: 4px 8px;
        }

        .section a {
          font-size: 0.8rem;
        }
      }
    </style>
  </head>

  <body>
    <!-- Navbar -->
    <div class="navbar">
      <h2><i class="fas fa-user-tie"></i> Welcome, ${admin.username}!</h2> <!-- Icon added -->
      <a href="${pageContext.request.contextPath}/admin/logout" class="logout-button">
        <i class="fas fa-sign-out-alt"></i> Logout
      </a>
    </div>

    <!-- Main Content -->
    <div class="container">
      <!-- Student Management -->
      <div class="section">
        <h2><i class="fas fa-users"></i> Student Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-users"></i>
            <a href="${pageContext.request.contextPath}/admin/students">Student List</a>
          </li>
          <li>
            <i class="fas fa-book"></i>
            <a href="${pageContext.request.contextPath}/admin/student-semesters">Student Semesters</a>
          </li>
          <li>
            <i class="fas fa-chalkboard-teacher"></i>
            <a href="${pageContext.request.contextPath}/admin/student-semester-subjects">Student Semester Subjects</a>
          </li>
          <li>
            <i class="fas fa-exclamation-triangle"></i>
            <a href="${pageContext.request.contextPath}/admin/backlogs">Backlogs</a>
          </li>
        </ul>
      </div>

      <!-- Course Management -->
      <div class="section">
        <h2><i class="fas fa-book-open"></i> Course Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-book-open"></i>
            <a href="${pageContext.request.contextPath}/admin/courses">Courses</a>
          </li>
          <li>
            <i class="fas fa-layer-group"></i>
            <a href="${pageContext.request.contextPath}/admin/semester-subjects">Semester Subjects</a>
          </li>
          <li>
            <i class="fas fa-list"></i>
            <a href="${pageContext.request.contextPath}/admin/subjects">Subjects List</a>
          </li>
        </ul>
      </div>

      <!-- Faculty Management -->
      <div class="section">
        <h2><i class="fas fa-chalkboard"></i> Faculty Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-chalkboard"></i>
            <a href="${pageContext.request.contextPath}/admin/faculty">Faculty List</a>
          </li>
          <li>
            <i class="fas fa-users-cog"></i>
            <a href="${pageContext.request.contextPath}/admin/facultyDivisions">Faculty Divisions</a>
          </li>
          <li>
            <i class="fas fa-book-reader"></i>
            <a href="${pageContext.request.contextPath}/admin/facultySubjects">Faculty Subjects</a>
          </li>
        </ul>
      </div>

      <!-- Department and Division Management -->
      <div class="section">
        <h2><i class="fas fa-building"></i> Department and Division Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-building"></i>
            <a href="${pageContext.request.contextPath}/admin/departments">Departments</a>
          </li>
          <li>
            <i class="fas fa-code-branch"></i>
            <a href="${pageContext.request.contextPath}/admin/divisions">Divisions List</a>
          </li>
        </ul>
      </div>

      <div class="section">
        <h2><i class="fas fa-calendar-check"></i> Attendance and Fees Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-calendar-alt"></i>
            <a href="${pageContext.request.contextPath}/admin/attendances">Attendances</a>
          </li>
          <li>
            <i class="fas fa-dollar-sign"></i>
            <a href="${pageContext.request.contextPath}/admin/fees">Fees</a>
          </li>
        </ul>
      </div>

      <!-- Timetable and Sessions Management -->
      <div class="section">
        <h2><i class="fas fa-clock"></i> Timetable and Sessions Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-calendar"></i>
            <a href="${pageContext.request.contextPath}/admin/timetables">Timetables</a>
          </li>
          <li>
            <i class="fas fa-users"></i>
            <a href="${pageContext.request.contextPath}/admin/sessions">Sessions</a>
          </li>
        </ul>
      </div>

      <!-- Semester and Results Management -->
      <div class="section ">
        <h2><i class="fas fa-graduation-cap"></i> Semester and Results Management</h2> <!-- Icon added -->
        <ul>
          <li>
            <i class="fas fa-calendar-alt"></i>
            <a href="${pageContext.request.contextPath}/admin/semesters">Semesters</a>
          </li>
          <li>
            <i class="fas fa-clipboard-list"></i>
            <a href="${pageContext.request.contextPath}/admin/semester-summaries">Semester Summaries</a>
          </li>
          <li>
            <i class="fas fa-chart-line"></i>
            <a href="${pageContext.request.contextPath}/admin/semester-results">Semester Results</a>
          </li>
        </ul>
      </div>


  </body>

  </html>
