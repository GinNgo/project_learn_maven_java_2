<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page Not Found</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="text-center p-5">
    <h1 class="display-3 text-danger">404</h1>
    <p class="lead">Trang bạn tìm không tồn tại</p>
    <a href="${pageContext.request.contextPath}/home" class="btn btn-primary">Về trang chủ</a>
</body>
</html>
