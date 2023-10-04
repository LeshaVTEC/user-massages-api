package by.it_academy.team1.usermessages.endpoints.html.memory;

import by.it_academy.team1.usermessages.dao.api.IMessageDao;
import by.it_academy.team1.usermessages.dao.api.IUserDao;
import by.it_academy.team1.usermessages.dao.memory.factory.MemoryMessageDaoFactory;
import by.it_academy.team1.usermessages.dao.memory.factory.MemoryUserDaoFactory;
import by.it_academy.team1.usermessages.listeners.ActiveSessionUsersListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/admin/statistics")
public class MemoryStatisticsServlet extends HttpServlet {

    private IUserDao userDao = MemoryUserDaoFactory.getInstance();
    private IMessageDao messageDao = MemoryMessageDaoFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("amountActiveUsers", req.getServletContext().getAttribute("totalusers"));
        req.setAttribute("amountUsers", userDao.getRegistrationUsers().size());
        req.setAttribute("amountMessages", messageDao.get().size());

        getServletContext().getRequestDispatcher("/template/ui/admin/statistics/index.jsp").forward(req, resp);
    }
}
