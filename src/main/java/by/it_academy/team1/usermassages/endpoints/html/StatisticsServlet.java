package by.it_academy.team1.usermassages.endpoints.html;

import by.it_academy.team1.usermassages.dao.api.IMessageDao;
import by.it_academy.team1.usermassages.dao.api.IUserDao;
import by.it_academy.team1.usermassages.dao.factory.MessageDaoFactory;
import by.it_academy.team1.usermassages.dao.factory.UserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private IUserDao userDao = UserDaoFactory.getInstance();
    private IMessageDao messageDao = MessageDaoFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        req.setAttribute("amountActiveUsers", req.getServletContext().getAttribute("totalusers"));
        req.setAttribute("amountUsers", userDao.getRegistrationUsers().size());
        req.setAttribute("amountMessages", messageDao.get().size());
    }
}
