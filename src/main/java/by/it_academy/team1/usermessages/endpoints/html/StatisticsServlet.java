package by.it_academy.team1.usermessages.endpoints.html;

import by.it_academy.team1.usermessages.dao.factory.MessageDaoFactory;
import by.it_academy.team1.usermessages.dao.factory.UserDaoFactory;
import by.it_academy.team1.usermessages.dao.api.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.it_academy.team1.usermessages.listeners.ActiveSessionListener.TOTAL_USERS_SESSION_KEY;
import static by.it_academy.team1.usermessages.listeners.ActiveSessionUsersListener.TOTAL_USERS_SESSION_ATTRIBUTE_KEY;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private IUserDao userDao = UserDaoFactory.getInstance();
    private IMessageDao messageDao = MessageDaoFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("amountActiveUsers", req.getServletContext().getAttribute(TOTAL_USERS_SESSION_KEY));
        req.setAttribute("amountActiveUsers_attribute", req.getServletContext().getAttribute(TOTAL_USERS_SESSION_ATTRIBUTE_KEY));
        req.setAttribute("amountUsers", userDao.getRegistrationUsers().size());
        req.setAttribute("amountMessages", messageDao.get().size());

        req.getRequestDispatcher("/template/ui/admin/statistics/index.jsp").forward(req, resp);
    }
}
