<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome (icon) -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
    <!-- Nội dung -->
<div class="container mt-4">
<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="card shadow p-4" style="width: 400px;">
        <form action="login" method="post" class="form-login">
            <h2 class="text-center mb-4">Đăng nhập</h2>

            <!-- Thông báo lỗi -->
            <c:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>

            <!-- Username -->
            <div class="form-group mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                    <input type="text" name="username" placeholder="Tài khoản" class="form-control" required>
                </div>
            </div>

            <!-- Password -->
            <div class="form-group mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
                    <input type="password" name="password" placeholder="Mật khẩu" class="form-control" required>
                </div>
            </div>

            <!-- Submit -->
            <div class="form-group mb-3">
                <input type="submit" value="Đăng nhập" class="btn btn-primary w-100">
            </div>

            <!-- Link chuyển sang đăng ký -->
            <div class="form-group text-center">
                <p>Chưa có tài khoản?
                    <a href="${pageContext.request.contextPath}/register" class="btn btn-link">Đăng ký ngay</a>
                </p>
            </div>
        </form>
    </div>
</div>
<%@ include file="/common/footer.jsp" %>
