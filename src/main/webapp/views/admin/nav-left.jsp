<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
    /* Sidebar style */
    #sidebar {
        width: 250px;
        transition: all 0.3s ease;
        background-color: #212529;
        color: white;
        height: 100vh;
        position: fixed;
        top: 0;
        left: 0;
        padding: 1rem;
        overflow: hidden;
        margin-top:56px;
    }

    #sidebar.collapsed {
        width: 60px;
        padding: 1rem 0.5rem;
    }

    /* Ẩn nội dung khi collapsed */
    #sidebar.collapsed .menu-text {
        display: none;
    }

    /* Giữ icon căn giữa */
    #sidebar .nav-link i {
        font-size: 1.2rem;
        width: 30px;
        text-align: center;
    }

    /* Toggle button */
    #toggleSidebar {
        position: absolute;
        top: 10px;
        right: 10px;
        background: transparent;
        border: none;
        color: white;
        font-size: 1.3rem;
    }

    /* Khi sidebar thu gọn, nút vẫn hiện ở góc trái */
    #sidebar.collapsed #toggleSidebar {
        right: auto;
        left: 10px;
    }

    /* Hover link */
    #sidebar .nav-link {
        color: white;
        transition: 0.3s;
    }
    #sidebar .nav-link:hover {
        background-color: #343a40;
    }
</style>

<div id="sidebar" class="d-flex flex-column vh-100">
    <!-- Nút toggle -->
    <button id="toggleSidebar">
        <i class="fa fa-bars"></i>
    </button>

    <!-- Logo -->
    <a href="${pageContext.request.contextPath}/admin/home"
       class="d-flex align-items-center mb-3 mt-4 text-white text-decoration-none">
        <i class="fa fa-gauge-high me-2"></i>
        <span class="menu-text fs-5 fw-semibold">Admin Panel</span>
    </a>

    <hr class="text-secondary">

    <!-- Menu -->
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/home" class="nav-link text-white">
                <i class="fa fa-house"></i>
                <span class="menu-text ms-2">Trang chủ</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin-category" class="nav-link text-white">
                <i class="fa fa-folder-open"></i>
                <span class="menu-text ms-2">Quản lý Category</span>
            </a>
        </li>
         <li>
        <a href="${pageContext.request.contextPath}/admin-video" class="nav-link text-white">
            <i class="fa fa-video-camera"></i>
            <span class="menu-text ms-2">Quản lý Video</span>
        </a>
    	</li>
    </ul>
</div>

<!-- Script -->
<script>
    const sidebar = document.getElementById('sidebar');
    const toggle = document.getElementById('toggleSidebar');

    toggle.addEventListener('click', () => {
        sidebar.classList.toggle('collapsed');
    });
</script>
