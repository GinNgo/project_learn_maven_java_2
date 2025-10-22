<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

    <style>
        body {
            margin: 0;
            padding: 0;
            overflow-x: hidden;
        }

        /* ===== HEADER ===== */
        #header {
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            height: 56px;
            background-color: #343a40;
            color: white;
            z-index: 1030;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 1rem;
        }

        /* ===== SIDEBAR ===== */
        #sidebar {
            position: fixed;
            top: 56px; /* dưới header */
            left: 0;
            width: 250px;
            height: calc(100vh - 56px);
            background-color: #212529;
            color: white;
            padding: 1rem;
            transition: width 0.3s ease;
            overflow: hidden;
        }

        #sidebar.collapsed {
            width: 70px;
        }

        #sidebar .nav-link {
            color: white;
            transition: 0.3s;
            display: flex;
            align-items: center;
        }

        #sidebar .nav-link:hover {
            background-color: #343a40;
        }

        #sidebar .menu-text {
            margin-left: 10px;
            white-space: nowrap;
        }

        #sidebar.collapsed .menu-text {
            display: none;
        }

        #toggleSidebar {
            background: none;
            border: none;
            color: white;
            font-size: 1.2rem;
        }

        /* ===== CONTENT ===== */
        #content {
            margin-top: 56px; /* tránh đè header */
            margin-left: 250px;
            padding: 2rem;
            transition: margin-left 0.3s ease;
        }

        #sidebar.collapsed + #content {
            margin-left: 70px;
        }
    </style>
</head>
<body>

    <!-- HEADER -->
    <div id="header">
      <div class="d-flex align-items-center justify-content-between w-100">
    <!-- Nút toggle + tiêu đề -->
    <div class="d-flex align-items-center">
        <button id="toggleSidebar" class="btn btn-sm btn-outline-light me-3">
            <i class="fa fa-bars"></i>
        </button>
        <h5 class="mb-0 text-white">Admin Panel</h5>
    </div>

    <!-- Tài khoản (phải) -->
    <div class="d-flex align-items-center">
        <i class="fa fa-user me-2"></i>
        <span class="me-3">${sessionScope.account.fullName}</span>
        <a href="${pageContext.request.contextPath}/member/myaccount" class="btn btn-sm btn-outline-light me-2">
            Tài khoản
        </a>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-sm btn-danger">
            Đăng xuất
        </a>
    </div>
</div>

    </div>

    <!-- SIDEBAR -->
    <div id="sidebar">
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/home" class="nav-link">
                    <i class="fa fa-house"></i><span class="menu-text">Trang chủ</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-category" class="nav-link">
                    <i class="fa fa-folder-open"></i><span class="menu-text">Quản lý Category</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/admin-video" class="nav-link">
                    <i class="fa fa-video-camera"></i><span class="menu-text">Quản lý Video</span>
                </a>
            </li>
        </ul>
    </div>

    <!-- CONTENT -->
    <div id="content">
        <sitemesh:write property="body"/>
    </div>

    <!-- FOOTER -->
    <%@ include file="/common/footer.jsp" %>

    <script>
        const sidebar = document.getElementById('sidebar');
        const content = document.getElementById('content');
        const toggle = document.getElementById('toggleSidebar');

        toggle.addEventListener('click', () => {
            sidebar.classList.toggle('collapsed');
            // toggle class margin cho content
            if (sidebar.classList.contains('collapsed')) {
                content.style.marginLeft = '70px';
            } else {
                content.style.marginLeft = '250px';
            }
        });
    </script>

    <!-- Bootstrap Bundle JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
