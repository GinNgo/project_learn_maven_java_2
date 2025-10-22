package vn.iotstar.filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.*;

@WebFilter(urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        // Các trang public không cần login
        boolean isLoginRequest = uri.endsWith("/login") || uri.endsWith("/register");
        boolean isStaticResource = uri.contains("/assets/") || uri.contains("/uploads/");

        if (isLoginRequest || isStaticResource) {
            chain.doFilter(request, response);
            return;
        }

        // Lấy account từ session
        User account = (session != null) ? (User) session.getAttribute("account") : null;

        // Chưa login → redirect login
        if (account == null) {
            resp.sendRedirect(contextPath + "/login");
            return;
        }

        // Nếu truy cập root context → redirect theo role
        if (uri.equals(contextPath) || uri.equals(contextPath + "/")) {
            if (account.getRoleid() == 1) { // admin
                resp.sendRedirect(contextPath + "/admin/home");
            } else { // user bình thường
                resp.sendRedirect(contextPath + "/home");
            }
            return;
        }

        // Nếu là trang admin → check role
        if (uri.startsWith(contextPath + "/admin")) {
            if (account.getRoleid() != 1) {
                // Không có quyền → forward 403
            	resp.sendRedirect(contextPath + "/views/error/403.jsp");
                return;
            }
        }

        // Cho đi tiếp
        chain.doFilter(request, response);
    }
}
