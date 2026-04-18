<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body.dark {
            background-color: #121212 !important;
            color: white !important;
        }

        body.dark .card {
            background-color: #1e1e1e !important;
            color: white !important;
        }

        body.dark .btn {
            border-color: #555;
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

<body class="bg-light">

<div class="container text-center mt-5">
    <h1 class="mb-4">📚 Library Dashboard</h1>

    <div class="row">
        <div class="col-md-4">
            <div class="card p-4 shadow">
                <h4>👤 Users</h4>
                <a href="addUser.jsp" class="btn btn-primary m-2">Add User</a>
                <a href="viewUsers" class="btn btn-success m-2">View Users</a>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 shadow">
                <h4>📚 Books</h4>
                <a href="addBook.jsp" class="btn btn-primary m-2">Add Book</a>
                <a href="viewBooks" class="btn btn-success m-2">View Books</a>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card p-4 shadow">
                <h4>⚙️ Settings</h4>
                <button onclick="toggleDark()" class="btn btn-dark w-100">🌙 Dark Mode</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>