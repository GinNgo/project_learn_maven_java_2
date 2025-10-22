package vn.iotstar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iotstar.controller.BaseController;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.service.ICategoryService;
import vn.iotstar.service.IVideoService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.VideoServiceImpl;
import vn.iotstar.utils.Constant;
import vn.iotstar.utils.UploadUtils;

@MultipartConfig
@WebServlet(urlPatterns = { 
    "/admin-video", 
    "/admin-video/create", 
    "/admin-video/update",
    "/admin-video/edit", 
    "/admin-video/delete", 
    "/admin-video/reset" 
})
public class VideoController extends BaseController {

    private static final long serialVersionUID = 1L;
    private IVideoService videoService = new VideoServiceImpl();
    private ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        Video video = null;

        if (url.contains("create")) {
            request.getRequestDispatcher("/views/admin/video/add.jsp").forward(request, response);
        } else if (url.contains("edit")) {
            edit(request, response);
        } else if (url.contains("delete")) {
            delete(request, response);
            video = new Video();
            request.setAttribute("video", video);
        } else if (url.contains("reset")) {
            video = new Video();
            request.setAttribute("video", video);
        }

        findAll(request, response);
        request.setAttribute("tag", "video");
        request.getRequestDispatcher("/views/admin/video/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getRequestURL().toString();

        if (url.contains("create")) {
            insert(request, response);
        } else if (url.contains("update")) {
            update(request, response);
        } else if (url.contains("delete")) {
            delete(request, response);
        } else if (url.contains("reset")) {
            request.setAttribute("video", new Video());
        }

        findAll(request, response);
        request.getRequestDispatcher("/views/admin/video/list.jsp").forward(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Video> videos = videoService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("videos", videos);
        request.setAttribute("categories", categories);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Video video = new Video();
            BeanUtils.populate(video, request.getParameterMap());

            String fileName = video.getVideoId() + System.currentTimeMillis();
            video.setPoster(UploadUtils.processUpload("poster", request, Constant.DIR + "\\video\\", fileName));
            String catIdStr = request.getParameter("categoryId");
            int categoryId = 1;
            if (catIdStr != null && !catIdStr.isEmpty()) {
                categoryId = Integer.parseInt(catIdStr);
            }
            Category cate = categoryService.findById(categoryId);
            video.setCategory(cate);
            videoService.insert(video);
            request.setAttribute("message", "Đã thêm video thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi thêm video: " + e.getMessage());
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            
            Video video = videoService.findById(id);
            String catIdStr = request.getParameter("categoryId");
            int categoryId = 1;
            if (catIdStr != null && !catIdStr.isEmpty()) {
                categoryId = Integer.parseInt(catIdStr);
            }
            Category cate = categoryService.findById(categoryId);
            video.setCategory(cate);
            request.setAttribute("video", video);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi: " + e.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Video video = new Video();
            BeanUtils.populate(video, request.getParameterMap());

            Video old = videoService.findById(video.getVideoId());
            if (request.getPart("poster").getSize() == 0) {
                video.setPoster(old.getPoster());
            } else {
                if (old.getPoster() != null) {
                    File oldFile = new File(Constant.DIR + "\\video\\" + old.getPoster());
                    oldFile.delete();
                }
                String fileName = video.getVideoId() + System.currentTimeMillis();
                video.setPoster(UploadUtils.processUpload("poster", request, Constant.DIR + "\\video\\", fileName));
            }

            videoService.update(video);
            request.setAttribute("video", video);
            request.setAttribute("message", "Cập nhật thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi cập nhật: " + e.getMessage());
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            videoService.delete(id);
            request.setAttribute("message", "Đã xóa video thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi xóa: " + e.getMessage());
        }
    }
}
