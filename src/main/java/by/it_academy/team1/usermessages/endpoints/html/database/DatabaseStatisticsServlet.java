package by.it_academy.team1.usermessages.endpoints.html.database;

import by.it_academy.team1.usermessages.dao.api.IMessageDao;
import by.it_academy.team1.usermessages.dao.api.IUserDao;
import by.it_academy.team1.usermessages.dao.database.factory.DatabaseMessageDaoFactory;
import by.it_academy.team1.usermessages.dao.database.factory.DatabaseUserDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/database/api/admin/statistics")
public class DatabaseStatisticsServlet extends HttpServlet {

        private IUserDao userDao = DatabaseUserDaoFactory.getInstance();
        private IMessageDao messageDao = DatabaseMessageDaoFactory.getInstance();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            req.setAttribute("amountActiveUsers", req.getServletContext().getAttribute("totalusers"));
            req.setAttribute("amountUsers", userDao.getRegistrationUsers().size());
            req.setAttribute("amountMessages", messageDao.get().size());

            getServletContext().getRequestDispatcher("/template/database/admin/statistics/index.jsp").forward(req, resp);
        }
    }
