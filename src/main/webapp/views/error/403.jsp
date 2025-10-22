<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>403 - Forbidden</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center" style="height:100vh;">

    <div class="text-center">
        <h1 class="display-3 text-danger">403</h1>
        <h3 class="mb-3">Bạn không có quyền truy cập trang này.</h3>
        <a href="javascript:history.back()" class="btn btn-primary">
            ⬅ Quay lại
        </a>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">
            🏠 Về trang chủ
        </a>
    </div>

</body>
</html>
