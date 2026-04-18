<%--
  Created by IntelliJ IDEA.
  User: maneesha
  Date: 2026-04-14
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body.dark {
            background-color: #121212 !important;
            color: white !important;
        }

        body.dark .table {
            color: white;
        }

        body.dark .table thead {
            background-color: #333 !important;
        }

        body.dark .table tbody tr {
            background-color: #1e1e1e;
        }

        body.dark .card {
            background-color: #1e1e1e;
            color: white;
        }

        body.dark .navbar {
            background-color: #000 !important;
        }

        /* smooth transition */
        body, .card, .table, .navbar {
            transition: all 0.4s ease;
        }

        /* Smooth theme transition */
        body {
            transition: background-color 0.4s ease, color 0.4s ease;
        }

        /* Fade animation */
        .fade-out {
            opacity: 0;
            transition: opacity 0.3s ease;
        }

        /* Start hidden for fade-in */
        body {
            opacity: 0;
        }

        body.loaded {
            opacity: 1;
            transition: opacity 0.4s ease;
        }
    </style>
</head>


<body class="bg-light">

<div class="container mt-3">
    <button onclick="toggleDark()" class="btn btn-dark mb-3">🌙 Toggle Dark Mode</button>
</div>

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <span class="navbar-brand">📚 Library System</span>
        <div>
            <a href="index.jsp" class="btn btn-outline-light btn-sm">Home</a>
            <a href="viewUsers" class="btn btn-outline-light btn-sm">Users</a>
            <a href="viewBooks" class="btn btn-outline-light btn-sm">Books</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <div class="card p-4 shadow">
        <h2 class="text-center mb-4">Add New User</h2>

        <form action="addUser" method="post">
            <div class="mb-3">
                Name: <br>
                <input type="text" name="name" class="form-control" required><br><br>
            </div>
            <div class="mb-3">
                Email: <br>
                <input type="text" name="email" class="form-control" required><br><br>
            </div>

            <button class="btn btn-primary w-100">Add User</button>
        </form>

        <a href="index.jsp" class="btn btn-link mt-3">Back to Home</a>
    </div>

</div>

<script>
    function toggleDark() {
        document.body.classList.toggle("dark");

        let theme = document.body.classList.contains("dark") ? "dark" : "light";
        localStorage.setItem("theme", theme);

        updateButton();
    }

    function updateButton() {
        let btn = document.querySelector(".btn-dark");
        let theme = localStorage.getItem("theme");

        if (theme === "dark") {
            btn.innerText = "☀️ Light Mode";
        } else {
            btn.innerText = "🌙 Dark Mode";
        }
    }

    window.onload = function () {
        document.body.classList.add("loaded");

        // Apply dark mode if saved
        let theme = localStorage.getItem("theme");
        if (theme === "dark") {
            document.body.classList.add("dark");
        }

        updateButton();
    };
</script>

</body>
</html>
