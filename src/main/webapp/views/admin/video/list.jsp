<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="page-content-wrapper">
    <div class="page-content">

        <h3 class="mb-3"><i class="fa fa-video"></i> Quản lý Video</h3>

        <!-- Hiển thị thông báo -->
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>

        <div class="row">
            <div class="col-md-4">
                <form action="#" method="post" enctype="multipart/form-data" class="border p-3 rounded bg-light">
                    <div class="mb-3">
                        <label>Mã Video:</label>
                        <input type="text" name="videoId" class="form-control" value="${video.videoId}" required />
                    </div>
                    <div class="mb-3">
                        <label>Tiêu đề:</label>
                        <input type="text" name="title" class="form-control" value="${video.title}" required />
                    </div>
                    <div class="mb-3">
                        <label>Mô tả:</label>
                        <textarea name="description" class="form-control" rows="3">${video.description}</textarea>
                    </div>
                    <div class="mb-3">
                        <label>Views:</label>
                        <input type="number" name="views" class="form-control" value="${video.views}" />
                    </div>
                    <div class="mb-3">
                        <label>Poster:</label>
                        <input type="file" name="poster" class="form-control" />
                        <c:if test="${not empty video.poster}">
                            <img src="<c:url value='/image?fname=video/${video.poster}'/>" width="100" class="mt-2 rounded"/>
                        </c:if>
                    </div>
                    <div class="mb-3">
					    <label>Danh mục:</label>
					    <select name="categoryId" class="form-select" required>
					        <option value="">-- Chọn danh mục --</option>
					        <c:forEach var="cate" items="${categories}">
					            <option value="${cate.id}"
					                <c:if test="${video.category != null && video.category.id == cate.id}">selected</c:if>>
					                ${cate.name}
					            </option>
					        </c:forEach>
					    </select>
					</div>
                    <div class="form-check mb-3">
                        <input class="form-check-input" type="checkbox" name="active" ${video.active ? 'checked' : ''} />
                        <label class="form-check-label">Kích hoạt</label>
                    </div>
                    <div class="d-flex gap-2">
                        <button class="btn btn-success" formaction="<c:url value='/admin-video/create'/>">
                            <i class="fa fa-plus"></i> Thêm
                        </button>
                        <button class="btn btn-warning" formaction="<c:url value='/admin-video/update'/>">
                            <i class="fa fa-edit"></i> Sửa
                        </button>
                        <button class="btn btn-danger" formaction="<c:url value='/admin-video/delete'/>">
                            <i class="fa fa-trash"></i> Xóa
                        </button>
                        <button class="btn btn-secondary" formaction="<c:url value='/admin-video/reset'/>">
                            <i class="fa fa-undo"></i> Reset
                        </button>
                    </div>
                </form>
            </div>

            <div class="col-md-8">
                <table class="table table-bordered table-hover mt-3">
                    <thead class="table-dark">
                        <tr>
                            <th>Poster</th>
                            <th>Tiêu đề</th>
                            <th>Mô tả</th>
                            <th>Lượt xem</th>
                            <th>Trạng thái</th>
                            <th>Hành động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${videos}">
                            <tr>
                                <td><img src="<c:url value='/image?fname=video/${item.poster}'/>" width="60"/></td>
                                <td>${item.title}</td>
                                <td>${item.description}</td>
                                <td>${item.views}</td>
                                <td>
                                    <c:if test="${item.active}">
                                        <span class="badge bg-success">Active</span>
                                    </c:if>
                                    <c:if test="${!item.active}">
                                        <span class="badge bg-secondary">Inactive</span>
                                    </c:if>
                                </td>
                                <td>
                                    <a href="<c:url value='/admin-video/edit?id=${item.videoId}'/>" class="btn btn-sm btn-primary">
                                        <i class="fa fa-pen"></i>
                                    </a>
                                    <a href="<c:url value='/admin-video/delete?id=${item.videoId}'/>" class="btn btn-sm btn-danger">
                                        <i class="fa fa-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
