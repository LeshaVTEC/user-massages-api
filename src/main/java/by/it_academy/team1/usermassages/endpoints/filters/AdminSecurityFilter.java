package by.it_academy.team1.usermassages.endpoints.filters;

import by.it_academy.team1.usermassages.core.entity.User;
import by.it_academy.team1.usermassages.core.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"ui/admin/*","api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();

        if ((session != null) && (session.getAttribute("user") != null)) {

            User user = (User) session.getAttribute("user");

            if (user.getRole() == UserRole.ADMIN) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(contextPath + "/");
            }

        } else {
            resp.sendRedirect(contextPath + "/");
        }
    }
}
