<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    <!-- Navbar Bootstrap -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <!-- Logo -->
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">My Website</a>

            <!-- Nút toggle khi thu nhỏ màn hình -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav"
                    aria-controls="mainNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Menu -->
            <div class="collapse navbar-collapse" id="mainNav">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

                    <!-- Quản lý Category (admin link) -->
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin-category">Quản lý Category</a>
                    </li>

                    <!-- Tài khoản -->
                    <c:choose>
                        <c:when test="${sessionScope.account == null}">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath }/login">Đăng nhập</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath }/register">Đăng ký</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath }/member/myaccount">
                                    ${sessionScope.account.fullName}
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath }/logout">Đăng Xuất</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <!-- Search icon -->
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="fa fa-search"></i></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

